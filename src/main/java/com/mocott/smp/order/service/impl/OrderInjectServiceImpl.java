package com.mocott.smp.order.service.impl;

import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.log.entity.LogOrderInfoEntity;
import com.mocott.smp.log.entity.LogTradeInfoEntity;
import com.mocott.smp.log.service.LogOrderInfoServiceI;
import com.mocott.smp.log.service.LogTradeInfoServiceI;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.model.OrderInInfo;
import com.mocott.smp.order.service.OrderInjectInfoServiceI;
import com.mocott.smp.order.service.OrderInjectServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.util.MakeOrderNum;
import com.mocott.smp.util.OrderConstant;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by xulei on 2018/3/4.
 */
@Service("orderInjectService")
@Transactional
public class OrderInjectServiceImpl implements OrderInjectServiceI{

    @Autowired
    private TSConfigcodeServiceI tSConfigcodeService;

    @Autowired
    private OrderInjectInfoServiceI orderInjectInfoService;

    @Autowired
    private LogOrderInfoServiceI logOrderInfoService;

    @Autowired
    private FrontUserMemberServiceI frontUserMemberService;
    @Autowired
    private LogTradeInfoServiceI logTradeInfoService;

    /**
     * 注入订单生成
     * @throws Exception
     */
    @Override
    public void generateOrder(OrderInInfo orderInInfo) throws Exception {

        // 1.注入订单信息
        String userName = orderInInfo.getUsername(); //用户名
        double priceD = orderInInfo.getOrderMoney(); //订单金额
        double firstPay = 0.0;
        double firstPayRatio = 90;
        int firstInterDays = 12;
        int endInterDays = 12;
        //首付比例
        TSConfigcodeEntity tsConfigcodeEntity = tSConfigcodeService.getConfigValue(OrderConstant.Sys_First_PayRatio);
        if(tsConfigcodeEntity != null) {
            String firstPayRatioS = tsConfigcodeEntity.getConfigValue();
            if(StringUtil.isNotEmpty(firstPayRatioS)) {
                firstPayRatio = Double.parseDouble(firstPayRatioS);
            }
        }
        //计算首付比例
        firstPay = firstPayRatio * priceD / 100.00;
        Date now = new Date();
        MakeOrderNum orderNum = new MakeOrderNum();
        OrderInjectInfoEntity orderInjectInfo = new OrderInjectInfoEntity();
        orderInjectInfo.setUsername(userName);
        orderInjectInfo.setOrderCode(orderNum.makeOrderNum("P"));
        orderInjectInfo.setOrderMoney(priceD);
        orderInjectInfo.setOrderStatus(OrderConstant.Order_First_Pay); //产生订单,待支付首付款
        orderInjectInfo.setOrderTime(now);
        orderInjectInfo.setInterest(0.0); //应得利息
        orderInjectInfo.setFirstPay(firstPay); //首付款金额
        orderInjectInfo.setEndPay(priceD-firstPay);
        TSConfigcodeEntity tsConfigcodeEntityFirst = tSConfigcodeService.getConfigValue(OrderConstant.Period_First);
        TSConfigcodeEntity tsConfigcodeEntityFinal = tSConfigcodeService.getConfigValue(OrderConstant.Period_Final);
        if(tsConfigcodeEntityFirst != null) {
            firstInterDays = Integer.parseInt(tsConfigcodeEntityFirst.getConfigValue());
        }
        if(tsConfigcodeEntityFinal != null) {
            endInterDays = Integer.parseInt(tsConfigcodeEntityFinal.getConfigValue());
        }
        orderInjectInfo.setFirstEndInternal(firstInterDays+""); //首付款区间时间(小时)
        orderInjectInfo.setVfield6(endInterDays + ""); //尾款区间时间(小时)
        orderInjectInfo.setSaveInternal(
                tSConfigcodeService.getConfigValue(OrderConstant.Period_Save) != null ?
                        tSConfigcodeService.getConfigValue(OrderConstant.Period_Save).getConfigValue():"24*15"
        );
        //利息比例为1%
        orderInjectInfo.setRestRate(
                tSConfigcodeService.getConfigValue(OrderConstant.Rest_Rate) != null ?
                        Double.parseDouble(tSConfigcodeService.getConfigValue(OrderConstant.Rest_Rate).getConfigValue()): 1.0
        );
        orderInjectInfo.setWaitStartTime(DateUtils.getDateAdd(firstInterDays, now)); //周期开始时间
        String inter = tSConfigcodeService.getConfigValue(OrderConstant.Period_Cycle) != null ?
                tSConfigcodeService.getConfigValue(OrderConstant.Period_Cycle).getConfigValue():"480";
        orderInjectInfo.setWaitInternal(inter);
        if(inter != null) {
            orderInjectInfo.setWaitEndTime(DateUtils.getDateAdd(Integer.parseInt(inter),orderInjectInfo.getWaitStartTime()));
        }
        orderInjectInfo.setInputtime(now);
        orderInjectInfo.setInserttimeforhis(now);
        orderInjectInfo.setOperatetimeforhis(now);

        orderInjectInfo.setVfield1(getOrderWallet(userName));

        FrontUserMemberEntity frontUserMember = frontUserMemberService.queryEntityByUserName(userName);

        List<OrderInjectInfoEntity> injectInfos = orderInjectInfoService.getListByUser(userName);
        if(injectInfos == null || injectInfos.size()==0) {
            orderInjectInfo.setVfield2("1"); //第一次订单
            frontUserMember.setNfield1(orderInjectInfo.getOrderMoney()); //记录第一次订单金额
            frontUserMemberService.saveOrUpdate(frontUserMember);
        }

        // 2.订单日志信息
        LogOrderInfoEntity logOrderInfoEntity = new LogOrderInfoEntity();
        logOrderInfoEntity.setUsername(userName);
        logOrderInfoEntity.setSerialno("1");
        logOrderInfoEntity.setOrderCode(orderInjectInfo.getOrderCode());
        logOrderInfoEntity.setOrderMoney(orderInjectInfo.getOrderMoney());
        logOrderInfoEntity.setOrderTime(now);
        logOrderInfoEntity.setOrderType("1"); //订单类型
        logOrderInfoEntity.setInputtime(now);
        logOrderInfoEntity.setInserttimeforhis(now);
        logOrderInfoEntity.setInserttimeforhis(now);

        orderInjectInfoService.save(orderInjectInfo);

    }

    /**
     * 获取当前订单注入的钱包
     * @return
     */
    public String getOrderWallet(String userName) throws Exception{
        String walletType = "1"; //1-待返钱包 2-本息钱包
        //未完成的待返钱包
        List<OrderInjectInfoEntity> orderInBackList = orderInjectInfoService.getListByUndoneBack(userName);
        //未完成的本息钱包
        List<OrderInjectInfoEntity> orderInCouponList = orderInjectInfoService.getListByUndoneCoupon(userName);
        //有待返钱包未完成,再次注入时订单为本息钱包
        if(orderInBackList != null && orderInBackList.size()>0 && orderInCouponList != null &&
                orderInCouponList.size()>0) {
            return "0";
        }
        if(orderInBackList != null && orderInBackList.size()>0) {
            walletType = "2";
        } else if(orderInCouponList != null && orderInCouponList.size()>0) {
            walletType = "1";
        }
        return walletType;
    }

    /**
     * 获取上一订单的类型(如果要产生注入订单,则上一单需是提出订单,如果要产生提取订单,则需上一单是注入订单)
     * @param userName
     * @return
     * @throws Exception
     */
    public String getLastOrderType(String userName) throws Exception {
        String lastOrderType = "0";
        List<LogOrderInfoEntity>  logOrderInfos = logOrderInfoService.getOrderListDesc(userName);
        if(logOrderInfos != null) {
            int size = logOrderInfos.size();
            if(size == 0 || size ==1 ) {
                lastOrderType = "0"; //没有订单,或只有一个订单,则需要再次注入一个订单
            } else {
                lastOrderType = logOrderInfos.get(0).getOrderType(); //1-注入 2-提出
            }
        }

        return lastOrderType;
    }


    @Override
    public void doSaveInWallet(OrderInjectInfoEntity orderInject, FrontUserMemberEntity userMember) throws Exception {
        String orderType = orderInject.getVfield1();
        orderInject.setDfield1(new Date()); //设置提现时间
        orderInject.setOrderStatus(OrderConstant.Order_Done);
        //计算首付款时间与周期结束时间 + 保存期时间
//            int diff = DateUtils.dateDiffForDate('d', orderInject.getWaitEndTime(), orderInject.getFirstPayTime()) +
//                    (Integer.parseInt(orderInject.getSaveInternal())/24);
        int diff = DateUtils.dateDiffForDate('d', orderInject.getWaitEndTime(), orderInject.getWaitStartTime());
        orderInject.setInterestReal(orderInject.getRestRate() * orderInject.getOrderMoney() * diff /100);
        orderInjectInfoService.saveOrUpdate(orderInject); //保存

        //提取到订单金额待返钱包中
        userMember.setBackWallet(orderInject.getOrderMoney());
        //提取到本金\利息到本息钱包中
        userMember.setCouponWallet((orderInject.getInterestReal()==null?0.00:orderInject.getInterestReal())+
                (userMember.getCouponWallet()==null?0.00:userMember.getCouponWallet()) + orderInject.getOrderMoney());
        userMember.setSumAmount(userMember.getSumAmount() + orderInject.getOrderMoney() + orderInject.getInterestReal());
        frontUserMemberService.saveOrUpdate(userMember);

        // 生成财务交易信息
        LogTradeInfoEntity logTradeInfo = new LogTradeInfoEntity();
        logTradeInfo.setUsername(userMember.getUsername());
        logTradeInfo.setSerialno("1");
        logTradeInfo.setOrderCode(orderInject.getOrderCode());
        logTradeInfo.setStaticMoney(0.00); //注入支付金额
        logTradeInfo.setDynMoney(0.00); // 利息金额
        logTradeInfo.setBackMoney(orderInject.getOrderMoney());  // 返还到钱包金额
        logTradeInfo.setReleaseMoney(0.00); // 直推金额
        logTradeInfo.setTradeTime(new Date());
            logTradeInfo.setReason("1-金额到待返钱包");
        logTradeInfo.setRemark("");
        logTradeInfo.setInputtime(new Date());
        logTradeInfo.setInserttimeforhis(new Date());
        logTradeInfo.setOperatetimeforhis(new Date());
        logTradeInfoService.save(logTradeInfo);

        // 生成财务交易信息
        LogTradeInfoEntity logTradeInfo2 = new LogTradeInfoEntity();
        logTradeInfo2.setUsername(userMember.getUsername());
        logTradeInfo2.setSerialno("1");
        logTradeInfo2.setOrderCode(orderInject.getOrderCode());
        logTradeInfo2.setStaticMoney(0.00); //注入支付金额
        logTradeInfo2.setDynMoney(orderInject.getInterestReal()+orderInject.getOrderMoney()); // 本金利息金额
        logTradeInfo2.setBackMoney(0.00);  // 返还到钱包金额
        logTradeInfo2.setReleaseMoney(0.00); // 直推金额
        logTradeInfo2.setTradeTime(new Date());
        logTradeInfo2.setReason("1-本息金额-本息钱包");
        logTradeInfo2.setRemark("");
        logTradeInfo2.setInputtime(new Date());
        logTradeInfo2.setInserttimeforhis(new Date());
        logTradeInfo2.setOperatetimeforhis(new Date());
        logTradeInfoService.save(logTradeInfo2);

    }

}
