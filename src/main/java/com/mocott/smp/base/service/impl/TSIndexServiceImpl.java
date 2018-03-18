package com.mocott.smp.base.service.impl;

import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.base.service.TSIndexServiceI;
import com.mocott.smp.notice.entity.TSUsernoticeEntity;
import com.mocott.smp.notice.service.TSUsernoticeServiceI;
import com.mocott.smp.order.entity.OrderDrawInfoEntity;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.service.OrderDrawInfoServiceI;
import com.mocott.smp.order.service.OrderInjectInfoServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import com.mocott.smp.util.OrderConstant;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("tSIndexService")
@Transactional
public class TSIndexServiceImpl extends CommonServiceImpl implements TSIndexServiceI {

	@Autowired
	private OrderInjectInfoServiceI orderInjectInfoServiceI;
	@Autowired
	private OrderDrawInfoServiceI orderDrawInfoServiceI;
	@Autowired
	private FrontUserRegisterServiceI frontUserRegisterServiceI;
	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;
	@Autowired
	private TSUsernoticeServiceI tsUsernoticeServiceI;
	@Autowired
	private TSConfigcodeServiceI tsConfigcodeServiceI;

	/**
	 * 获取系统主页信息
	 * @param userName
	 * @throws Exception
     */
	public void getIndexInfo(String userName, HttpServletRequest request) throws Exception {

		//获取用户基础信息
		this.getIndexBaseInfo(userName, request);
		//获取注入资金订单列表信息
		List<OrderInjectInfoEntity> orderInjectList = orderInjectInfoServiceI.getUndoneList(userName);
		//获取提取资金订单列表信息
		List<OrderDrawInfoEntity> orderDrawList = orderDrawInfoServiceI.getListByUserName(userName);

        List<OrderDrawInfoEntity> orderDrawListNew = new ArrayList<OrderDrawInfoEntity>();
        if(orderDrawList != null && orderDrawList.size()>3) {
            for(int i=0; i<3; i++) {
                orderDrawListNew.add(orderDrawList.get(i));
            }
        }
        if(orderInjectList != null && orderInjectList.size()>0) {
            for(int j=0; j<orderInjectList.size(); j++) {
                OrderInjectInfoEntity orderInjectInfoEntity = orderInjectList.get(j);
                // 计算剩余时间的秒数
                double mills = 0.00;
                double interest = 0.00;
                if(OrderConstant.Order_First_Pay.equals(orderInjectInfoEntity.getOrderStatus())) { //等待支付首付款 01
                    String firstEnd = orderInjectInfoEntity.getFirstEndInternal(); // 首付款支付区间时间
                    Date firstEndTime = DateUtils.getDateAdd(Integer.parseInt(StringUtil.isNotEmpty(firstEnd)?firstEnd:"0"), orderInjectInfoEntity.getOrderTime());
                    mills = DateUtils.dateDiffForDate('s', firstEndTime, new Date());
                }
                if(OrderConstant.Order_Period_Finish.equals(orderInjectInfoEntity.getOrderStatus())) { // 04周期中
                    Date waitEndTime = orderInjectInfoEntity.getWaitEndTime(); // 首付款支付区间时间
                    mills = DateUtils.dateDiffForDate('s', waitEndTime, new Date());
                    double mills12 = DateUtils.dateDiffForDate('s', new Date(), orderInjectInfoEntity.getFirstPayTime());
                    orderInjectInfoEntity.setVfield5("1"); //不能操作
                    System.out.println((int)(mills12/60/60/24));
                    interest = ((int)(mills12/60/60/24))*orderInjectInfoEntity.getRestRate()*orderInjectInfoEntity.getOrderMoney()/100;
                }
                if(OrderConstant.Order_Final_Pay.equals(orderInjectInfoEntity.getOrderStatus())) { // 02 等待支付尾款
                    Date waitEndTime = orderInjectInfoEntity.getWaitEndTime(); // 首付款支付区间时间
                    String finalEnd = orderInjectInfoEntity.getVfield6(); // 尾款支付区间时间
                    Date finalEndTime = DateUtils.getDateAdd(Integer.parseInt(StringUtil.isNotEmpty(finalEnd)?finalEnd:"0"), waitEndTime);
                    mills = DateUtils.dateDiffForDate('s', finalEndTime, new Date());
                    String wait = orderInjectInfoEntity.getWaitInternal();
                    orderInjectInfoEntity.setVfield5("0");
                    double waitt = Double.parseDouble(StringUtil.isNotEmpty(wait)?wait:"20");
                    interest = orderInjectInfoEntity.getRestRate()*orderInjectInfoEntity.getOrderMoney()/100/24 * waitt;
                }
                if(OrderConstant.Order_Confirm_Period.equals(orderInjectInfoEntity.getOrderStatus())) { // 03 保存期
                    Date endPayTime = orderInjectInfoEntity.getEndPayTime(); // 首付款支付区间时间
                    String saveInter = orderInjectInfoEntity.getSaveInternal();
                    Date endSave = DateUtils.getDateAdd(Integer.parseInt(StringUtil.isNotEmpty(saveInter)?saveInter: "0"), endPayTime);
                    mills = DateUtils.dateDiffForDate('s', endSave, new Date());
                    String wait = orderInjectInfoEntity.getWaitInternal();
                    double waitt = Double.parseDouble(StringUtil.isNotEmpty(wait)?wait:"20");
                    interest = orderInjectInfoEntity.getRestRate()*orderInjectInfoEntity.getOrderMoney()/100/24 * waitt;
                }
                orderInjectInfoEntity.setInterest(interest);
                orderInjectInfoEntity.setNfield1(mills);
            }
        }

		request.setAttribute("inlist", orderInjectList);
		request.setAttribute("outlist", orderDrawListNew);

		request.setAttribute("baseTimes", this.getBaseTimes());
		request.setAttribute("baseLimit", this.getBaseLimit());
	}

	/**
	 * 获取注入资金基础倍数
	 * @return
	 * @throws Exception
     */
	@Override
	public String getBaseTimes() throws Exception{
		String baseTimes = "1000.00";
		TSConfigcodeEntity tsConfigcodeEntity = tsConfigcodeServiceI.getConfigValue(OrderConstant.Sys_Base_Times);

		if(tsConfigcodeEntity != null) {
			baseTimes = tsConfigcodeEntity.getConfigValue();
		}
		return baseTimes;
	}

	/**
	 * 获取注入资金限额
	 * @return
	 * @throws Exception
     */
	@Override
	public String getBaseLimit() throws Exception{
		String baseLimit = "10000.00"; //默认为1W
		TSConfigcodeEntity tsConfigcodeEntity2 = tsConfigcodeServiceI.getConfigValue(OrderConstant.Sys_Base_Limit);
		if(tsConfigcodeEntity2 != null) {
			baseLimit = tsConfigcodeEntity2.getConfigValue();
		}
		return baseLimit;
	}


	/**
	 * 获取系统公共信息
	 * @param userName
	 * @param request
	 * @throws Exception
     */
	public void getIndexBaseInfo(String userName, HttpServletRequest request) throws Exception {
		//获取用户信息
		FrontUserRegisterEntity frontUser = frontUserRegisterServiceI.queryEntityByUserName(userName);
		//获取会员信息
		FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
		//获取公告信息
		List<TSUsernoticeEntity> userNotices = tsUsernoticeServiceI.queryAllNotice();

		if(userNotices == null || userNotices.size()<5) {
			int size = userNotices.size();
			for (int i=0; i<(5-size); i++) {
				TSUsernoticeEntity tsUsernoticeEntity = new TSUsernoticeEntity();
				tsUsernoticeEntity.setNoticeTitle("暂无更多");
				userNotices.add(tsUsernoticeEntity);
			}
		}

		request.setAttribute("frontUser", frontUser);
		request.setAttribute("userMember", userMember);
		request.setAttribute("userNotices", userNotices);
	}

}