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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
	@Override
	public void getIndexInfo(String userName, HttpServletRequest request) throws Exception {

		//获取用户基础信息
		this.getIndexBaseInfo(userName, request);
		//获取注入资金订单列表信息
		List<OrderInjectInfoEntity> orderInjectList = orderInjectInfoServiceI.getUndoneList(userName);
		//获取提取资金订单列表信息
		List<OrderDrawInfoEntity> orderDrawList = orderDrawInfoServiceI.getUndoneList(userName);

		request.setAttribute("inlist", orderInjectList);
		request.setAttribute("outlist", orderDrawList);

		request.setAttribute("baseTimes", this.getBaseTimes());
		request.setAttribute("baseLimit", this.getBaseLimit());
	}

	@Override
	public String getBaseTimes() throws Exception{
		String baseTimes = "1000.00";
		TSConfigcodeEntity tsConfigcodeEntity = tsConfigcodeServiceI.getConfigValue(OrderConstant.Sys_Base_Times);

		if(tsConfigcodeEntity != null) {
			baseTimes = tsConfigcodeEntity.getConfigValue();
		}
		return baseTimes;
	}

	@Override
	public String getBaseLimit() throws Exception{
		String baseLimit = "1000000.00";
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