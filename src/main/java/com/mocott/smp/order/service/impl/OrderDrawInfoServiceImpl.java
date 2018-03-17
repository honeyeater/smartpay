package com.mocott.smp.order.service.impl;
import com.mocott.smp.base.entity.FrontVerifyCodeEntity;
import com.mocott.smp.base.service.FrontVerifyCodeServiceI;
import com.mocott.smp.log.entity.LogOrderInfoEntity;
import com.mocott.smp.log.entity.LogPayInfoEntity;
import com.mocott.smp.log.entity.LogTradeInfoEntity;
import com.mocott.smp.log.service.LogOrderInfoServiceI;
import com.mocott.smp.log.service.LogPayInfoServiceI;
import com.mocott.smp.log.service.LogTradeInfoServiceI;
import com.mocott.smp.order.service.OrderDrawInfoServiceI;
import com.mocott.smp.trade.entity.UsdtPriceEntity;
import com.mocott.smp.trade.entity.UserUsdtInfoEntity;
import com.mocott.smp.trade.service.UsdtPriceServiceI;
import com.mocott.smp.trade.service.UserUsdtInfoServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.util.MakeOrderNum;
import com.mocott.smp.util.OrderConstant;
import org.hibernate.Query;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.mocott.smp.order.entity.OrderDrawInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("orderDrawInfoService")
@Transactional
public class OrderDrawInfoServiceImpl extends CommonServiceImpl implements OrderDrawInfoServiceI {

	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;
	@Autowired
	private FrontVerifyCodeServiceI frontVerifyCodeServiceI;
	@Autowired
    private LogTradeInfoServiceI logTradeInfoServiceI;
	@Autowired
    private LogOrderInfoServiceI logOrderInfoServiceI;
	@Autowired
    private UsdtPriceServiceI usdtPriceServiceI;
	@Autowired
    private UserUsdtInfoServiceI userUsdtInfoServiceI;
	@Autowired
    private LogPayInfoServiceI logPayInfoService;

 	public void delete(OrderDrawInfoEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(OrderDrawInfoEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(OrderDrawInfoEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}

	/**
	 * 获取未完成的提取资金列表
	 * @param userName
	 * @return
	 * @throws Exception
     */
	@Override
	public List<OrderDrawInfoEntity> getUndoneList(String userName) throws Exception {
        String query = " from OrderDrawInfoEntity o where o.orderStatus in ('01','02') and o.username = :userName";
        Query queryObject = getSession().createQuery(query);
        queryObject.setParameter("userName", userName);
        List<OrderDrawInfoEntity> orderDrawInfoList = queryObject.list();
        return orderDrawInfoList;
    }

    @Override
    public List<OrderDrawInfoEntity> getListByUserName(String userName) throws Exception {
        String query = " from OrderDrawInfoEntity o where o.username = :userName order by orderTime desc";
        Query queryObject = getSession().createQuery(query);
        queryObject.setParameter("userName", userName);
        List<OrderDrawInfoEntity> orderDrawInfoList = queryObject.list();
        return orderDrawInfoList;
    }
	/**
	 * 生产待提出的订单
	 * @param orderDrawInfo
	 * @param userMember
	 * @throws Exception
     */
	@Override
	public void doSaveOutOrder(OrderDrawInfoEntity orderDrawInfo, FrontUserMemberEntity userMember, FrontVerifyCodeEntity verifyCode) throws Exception {
		this.save(orderDrawInfo);
		frontUserMemberServiceI.saveOrUpdate(userMember);
		if(verifyCode != null) {
            frontVerifyCodeServiceI.saveOrUpdate(verifyCode);
        }
	}


    /**
     * 生产待提出的订单
     * @param orderDrawInfo
     * @param userMember
     * @throws Exception
     */
    @Override
    public void doSaveDrawOutOrder(OrderDrawInfoEntity orderDrawInfo, FrontUserMemberEntity userMember, Double priceD, Double priceBXD, Double priceZTD) throws Exception {
        String drawType = orderDrawInfo.getDrawWallet(); //提取钱包
        String userName = userMember.getUsername();
        //更新钱包
        // 1.生成财务交易信息
        LogTradeInfoEntity logTradeInfo = new LogTradeInfoEntity();
        logTradeInfo.setUsername(userName);
        logTradeInfo.setSerialno("1");
        logTradeInfo.setOrderCode(orderDrawInfo.getOrderCode());
        logTradeInfo.setStaticMoney(0.00); //注入支付金额
        logTradeInfo.setDynMoney(0.00); // 利息金额
        logTradeInfo.setBackMoney(0.00);  // 提出金额
        logTradeInfo.setReleaseMoney(0.00); // 直推金额
        logTradeInfo.setTradeTime(new Date());
        if("1".equals(drawType)) {
            logTradeInfo.setNfield1(priceD); // 提出金额
            logTradeInfo.setReason("1-提取R钱包");
        } else {
            logTradeInfo.setNfield1(priceBXD); // 提出金额
            logTradeInfo.setReason("2-提取PI钱包");
        }
        logTradeInfo.setRemark("");
        logTradeInfo.setInputtime(new Date());
        logTradeInfo.setInserttimeforhis(new Date());
        logTradeInfo.setOperatetimeforhis(new Date());
        logTradeInfoServiceI.save(logTradeInfo);
        if("2".equals(drawType) && priceZTD>0) { //直推钱包
            LogTradeInfoEntity logTradeInfo2 = new LogTradeInfoEntity();
            logTradeInfo2.setUsername(userName);
            logTradeInfo2.setSerialno("1");
            logTradeInfo2.setOrderCode(orderDrawInfo.getOrderCode());
            logTradeInfo2.setStaticMoney(0.00); //注入支付金额
            logTradeInfo2.setDynMoney(0.00); // 利息金额
            logTradeInfo2.setBackMoney(0.00);  // 返到钱包金额
            logTradeInfo2.setReleaseMoney(0.00); // 直推金额
            logTradeInfo2.setTradeTime(new Date());
            logTradeInfo2.setNfield1(priceZTD);
            if("1".equals(drawType)) {
                logTradeInfo2.setReason("1-提取R钱包");
            } else {
                logTradeInfo2.setReason("2-提取直推钱包");
            }
            logTradeInfo2.setRemark("");
            logTradeInfo2.setInputtime(new Date());
            logTradeInfo2.setInserttimeforhis(new Date());
            logTradeInfo2.setOperatetimeforhis(new Date());
            logTradeInfoServiceI.save(logTradeInfo2);
        }

        // 2.订单日志信息
        LogOrderInfoEntity logOrderInfoEntity = new LogOrderInfoEntity();
        logOrderInfoEntity.setUsername(userName);
        logOrderInfoEntity.setSerialno("1");
        logOrderInfoEntity.setOrderCode(orderDrawInfo.getOrderCode());
        logOrderInfoEntity.setOrderMoney(orderDrawInfo.getOrderMoney());
        logOrderInfoEntity.setOrderTime(orderDrawInfo.getOrderTime());
        logOrderInfoEntity.setOrderType("2"); //订单类型
        logOrderInfoEntity.setInputtime(orderDrawInfo.getInputtime());
        logOrderInfoEntity.setInserttimeforhis(orderDrawInfo.getInputtime());
        logOrderInfoEntity.setInserttimeforhis(orderDrawInfo.getInputtime());
        logOrderInfoServiceI.save(logOrderInfoEntity);
        // 3.更新会员信息
        frontUserMemberServiceI.saveOrUpdate(userMember);
        // 4.保存提出订单
        this.save(orderDrawInfo); //保存订单
        // 5.转到USDT账户
        UserUsdtInfoEntity userUsdtInfoEntity=  userUsdtInfoServiceI.queryUserUsdtByUserName(userName);
        UsdtPriceEntity usdtPrice = usdtPriceServiceI.getNewPrice();
        double price = usdtPrice.getPrice();
        double mynum = userUsdtInfoEntity.getNum();
        double f1 = getPayNum(orderDrawInfo.getOrderMoney(), price);
        userUsdtInfoEntity.setNum(userUsdtInfoEntity.getNum()+f1);
        userUsdtInfoServiceI.saveOrUpdate(userUsdtInfoEntity);
        // 6.支付信息记录
        LogPayInfoEntity logPayInfoEntity = new LogPayInfoEntity();
        logPayInfoEntity.setUsername(userName);
        logPayInfoEntity.setSerialno("1");
        logPayInfoEntity.setOrderCode(orderDrawInfo.getOrderCode());
        logPayInfoEntity.setPayTime(new Date());
        logPayInfoEntity.setPayMoney(f1);
        logPayInfoEntity.setDealMoney(price);
        logPayInfoEntity.setNfield1(mynum);
        logPayInfoEntity.setVfield1("2");
        logPayInfoService.save(logPayInfoEntity);

    }

    private double getPayNum(double payPrice, double price) {
        double payNum = payPrice/price;
        BigDecimal b = new BigDecimal(payNum);
        double f1 = b.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();
        return f1;
    }

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(OrderDrawInfoEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 更新操作增强业务
	 * @param t
	 * @return
	 */
	private void doUpdateBus(OrderDrawInfoEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @return
	 */
	private void doDelBus(OrderDrawInfoEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(OrderDrawInfoEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("username", t.getUsername());
		map.put("order_code", t.getOrderCode());
		map.put("order_money", t.getOrderMoney());
		map.put("order_status", t.getOrderStatus());
		map.put("order_time", t.getOrderTime());
		map.put("draw_wallet", t.getDrawWallet());
		map.put("draw_money", t.getDrawMoney());
		map.put("draw_desc", t.getDrawDesc());
		map.put("draw_start_time", t.getDrawStartTime());
		map.put("draw_end_time", t.getDrawEndTime());
		map.put("draw_internal", t.getDrawInternal());
		map.put("pay_start_time", t.getPayStartTime());
		map.put("confirm_pay_time", t.getConfirmPayTime());
		map.put("pay_username", t.getPayUsername());
		map.put("order_progress", t.getOrderProgress());
		map.put("reason", t.getReason());
		map.put("order_total_money", t.getOrderTotalMoney());
		map.put("inputtime", t.getInputtime());
		map.put("inserttimeforhis", t.getInserttimeforhis());
		map.put("operatetimeforhis", t.getOperatetimeforhis());
		map.put("vfield1", t.getVfield1());
		map.put("vfield2", t.getVfield2());
		map.put("vfield3", t.getVfield3());
		map.put("vfield4", t.getVfield4());
		map.put("vfield5", t.getVfield5());
		map.put("vfield6", t.getVfield6());
		map.put("nfield1", t.getNfield1());
		map.put("nfield2", t.getNfield2());
		map.put("nfield3", t.getNfield3());
		map.put("nfield4", t.getNfield4());
		map.put("dfield1", t.getDfield1());
		map.put("dfield2", t.getDfield2());
		map.put("dfield3", t.getDfield3());
		map.put("dfield4", t.getDfield4());
		return map;
	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @param t
	 * @return
	 */
 	public String replaceVal(String sql,OrderDrawInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{username}",String.valueOf(t.getUsername()));
 		sql  = sql.replace("#{order_code}",String.valueOf(t.getOrderCode()));
 		sql  = sql.replace("#{order_money}",String.valueOf(t.getOrderMoney()));
 		sql  = sql.replace("#{order_status}",String.valueOf(t.getOrderStatus()));
 		sql  = sql.replace("#{order_time}",String.valueOf(t.getOrderTime()));
 		sql  = sql.replace("#{draw_wallet}",String.valueOf(t.getDrawWallet()));
 		sql  = sql.replace("#{draw_money}",String.valueOf(t.getDrawMoney()));
 		sql  = sql.replace("#{draw_desc}",String.valueOf(t.getDrawDesc()));
 		sql  = sql.replace("#{draw_start_time}",String.valueOf(t.getDrawStartTime()));
 		sql  = sql.replace("#{draw_end_time}",String.valueOf(t.getDrawEndTime()));
 		sql  = sql.replace("#{draw_internal}",String.valueOf(t.getDrawInternal()));
 		sql  = sql.replace("#{pay_start_time}",String.valueOf(t.getPayStartTime()));
 		sql  = sql.replace("#{confirm_pay_time}",String.valueOf(t.getConfirmPayTime()));
 		sql  = sql.replace("#{pay_username}",String.valueOf(t.getPayUsername()));
 		sql  = sql.replace("#{order_progress}",String.valueOf(t.getOrderProgress()));
 		sql  = sql.replace("#{reason}",String.valueOf(t.getReason()));
 		sql  = sql.replace("#{order_total_money}",String.valueOf(t.getOrderTotalMoney()));
 		sql  = sql.replace("#{inputtime}",String.valueOf(t.getInputtime()));
 		sql  = sql.replace("#{inserttimeforhis}",String.valueOf(t.getInserttimeforhis()));
 		sql  = sql.replace("#{operatetimeforhis}",String.valueOf(t.getOperatetimeforhis()));
 		sql  = sql.replace("#{vfield1}",String.valueOf(t.getVfield1()));
 		sql  = sql.replace("#{vfield2}",String.valueOf(t.getVfield2()));
 		sql  = sql.replace("#{vfield3}",String.valueOf(t.getVfield3()));
 		sql  = sql.replace("#{vfield4}",String.valueOf(t.getVfield4()));
 		sql  = sql.replace("#{vfield5}",String.valueOf(t.getVfield5()));
 		sql  = sql.replace("#{vfield6}",String.valueOf(t.getVfield6()));
 		sql  = sql.replace("#{nfield1}",String.valueOf(t.getNfield1()));
 		sql  = sql.replace("#{nfield2}",String.valueOf(t.getNfield2()));
 		sql  = sql.replace("#{nfield3}",String.valueOf(t.getNfield3()));
 		sql  = sql.replace("#{nfield4}",String.valueOf(t.getNfield4()));
 		sql  = sql.replace("#{dfield1}",String.valueOf(t.getDfield1()));
 		sql  = sql.replace("#{dfield2}",String.valueOf(t.getDfield2()));
 		sql  = sql.replace("#{dfield3}",String.valueOf(t.getDfield3()));
 		sql  = sql.replace("#{dfield4}",String.valueOf(t.getDfield4()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
 	
 	/**
	 * 执行JAVA增强
	 */
 	private void executeJavaExtend(String cgJavaType,String cgJavaValue,Map<String,Object> data) throws Exception {
 		if(StringUtil.isNotEmpty(cgJavaValue)){
			Object obj = null;
			try {
				if("class".equals(cgJavaType)){
					//因新增时已经校验了实例化是否可以成功，所以这块就不需要再做一次判断
					obj = MyClassLoader.getClassByScn(cgJavaValue).newInstance();
				}else if("spring".equals(cgJavaType)){
					obj = ApplicationContextUtil.getContext().getBean(cgJavaValue);
				}
				if(obj instanceof CgformEnhanceJavaInter){
					CgformEnhanceJavaInter javaInter = (CgformEnhanceJavaInter) obj;
					javaInter.execute("order_draw_info",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}