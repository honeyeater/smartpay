package com.mocott.smp.order.service.impl;
import com.mocott.smp .order.service.OrderInjectInfoServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.util.OrderConstant;
import org.hibernate.Query;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import org.jeecgframework.core.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.io.Serializable;

import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("orderInjectInfoService")
@Transactional
public class OrderInjectInfoServiceImpl extends CommonServiceImpl implements OrderInjectInfoServiceI {

	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;

 	public void delete(OrderInjectInfoEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(OrderInjectInfoEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}

	/**
	 * 批量定时任务更新订单的状态
	 */
	@Override
	public void changeOrderStauts() throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('03')";
		Query queryObject = getSession().createQuery(query);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		Date now = new Date();
		if(orderInjectInfoEntityList != null && orderInjectInfoEntityList.size()>0) {
			for (int i=0; i<orderInjectInfoEntityList.size(); i++) {
				OrderInjectInfoEntity orderInjectInfoEntity = orderInjectInfoEntityList.get(i);
				int saveI = (orderInjectInfoEntity.getSaveInternal() != null ? Integer.parseInt(orderInjectInfoEntity.getSaveInternal()) : 360);
				int diffD = DateUtils.dateDiffForDate('h', now, orderInjectInfoEntity.getWaitEndTime());
				if(diffD > saveI || diffD == saveI) {
					orderInjectInfoEntity.setOrderStatus(OrderConstant.Order_Period_Finish);
					this.saveOrUpdate(orderInjectInfoEntity);
				}
			}
		}

	}

	@Override
	public void doSaveInWallet(OrderInjectInfoEntity orderInject, FrontUserMemberEntity userMember) throws Exception {
		String orderType = orderInject.getVfield1();
		if("1".equals(orderType)) {
			orderInject.setDfield1(new Date()); //设置提现时间
			orderInject.setOrderStatus(OrderConstant.Order_Done);
			// 计算首付款时间与周期结束时间 + 保存期时间
			int diff = DateUtils.dateDiffForDate('d', orderInject.getWaitEndTime(), orderInject.getFirstPayTime()) +
					(Integer.parseInt(orderInject.getSaveInternal())/24);
			orderInject.setInterestReal(orderInject.getRestRate() * orderInject.getOrderMoney() * diff /100);
			this.saveOrUpdate(orderInject); //保存
			//提取到订单金额待返钱包中
			userMember.setBackWallet(orderInject.getOrderMoney());
			//提取到利息到本息钱包中
			userMember.setCouponWallet((orderInject.getInterestReal()==null?0.00:orderInject.getInterestReal())+
					(userMember.getCouponWallet()==null?0.00:userMember.getCouponWallet()));

			userMember.setSumAmount(userMember.getSumAmount() + orderInject.getOrderMoney() + orderInject.getInterestReal());

			frontUserMemberServiceI.saveOrUpdate(userMember);
		}
		if("2".equals(orderType)) {
			orderInject.setDfield1(new Date()); //设置提现时间
			orderInject.setOrderStatus(OrderConstant.Order_Done);
			// 计算首付款时间与周期结束时间 + 保存期时间
			int diff = DateUtils.dateDiffForDate('d', orderInject.getWaitEndTime(), orderInject.getFirstPayTime()) +
					(Integer.parseInt(orderInject.getSaveInternal())/24);
			orderInject.setInterestReal(orderInject.getRestRate() * orderInject.getOrderMoney() * diff/100); //计算利息
			this.saveOrUpdate(orderInject); //保存
			//提取到订单金额\利息到本息钱包中
			userMember.setCouponWallet(orderInject.getOrderMoney()+
					(orderInject.getInterestReal()==null?0.00:orderInject.getInterestReal())+
					(userMember.getCouponWallet()==null?0.00:userMember.getCouponWallet()));

			userMember.setSumAmount(userMember.getSumAmount()+orderInject.getOrderMoney()+
							(orderInject.getInterestReal()==null?0.00:orderInject.getInterestReal()));

			frontUserMemberServiceI.saveOrUpdate(userMember);
		}
	}

	public void saveOrUpdate(OrderInjectInfoEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}

	/**
	 * 获取未完成的订单信息
	 * @return
	 * @throws Exception
     */
	@Override
	public List<OrderInjectInfoEntity> getUndoneList(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02','03','04') and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取订单列表信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUsers(String users) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.username in ("+users+")";
		Query queryObject = getSession().createQuery(query);
//		queryObject.setParameter("userName", users);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取订单列表信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUser(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的待返钱包订单
	 * @return
	 * @throws Exception
     */
	@Override
	public List<OrderInjectInfoEntity> getListByUndoneBack(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02','03','04') and o.vfield1 = '1' and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的待返钱包订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUndoneATBack(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('02','03','04') and o.vfield1 = '1' and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的资金注入的订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUndonePay(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02')  and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取保存期的订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUndoneSave(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('03')  and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取是否有注入第一单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByFirst(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.vfield2 ='1'  and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的待返钱包订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByDoneBack(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('05') and o.vfield1 = '1' and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的本息钱包订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUndoneCoupon(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02','03','04') and o.vfield1 = '2' and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 获取未完成的本息钱包订单
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByUndoneATCoupon(String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('02','03','04') and o.vfield1 = '2' and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}



	/**
	 * 通过订单号获取订单信息
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<OrderInjectInfoEntity> getListByOrderCode(String orderCode, String userName) throws Exception {
		String query = " from OrderInjectInfoEntity o where o.orderCode = :orderCode and o.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		queryObject.setParameter("orderCode", orderCode);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList = queryObject.list();
		return orderInjectInfoEntityList;
	}

	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(OrderInjectInfoEntity t) throws Exception{
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
	private void doUpdateBus(OrderInjectInfoEntity t) throws Exception{
		//-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	/**
	 * 删除操作增强业务
	 * @param id
	 * @return
	 */
	private void doDelBus(OrderInjectInfoEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(OrderInjectInfoEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("username", t.getUsername());
		map.put("order_code", t.getOrderCode());
		map.put("order_money", t.getOrderMoney());
		map.put("order_status", t.getOrderStatus());
		map.put("order_time", t.getOrderTime());
		map.put("interest", t.getInterest());
		map.put("first_pay", t.getFirstPay());
		map.put("first_pay_time", t.getFirstPayTime());
		map.put("end_pay", t.getEndPay());
		map.put("end_pay_time", t.getEndPayTime());
		map.put("first_end_internal", t.getFirstEndInternal());
		map.put("save_internal", t.getSaveInternal());
		map.put("rest_rate", t.getRestRate());
		map.put("service_charge", t.getServiceCharge());
		map.put("interest_real", t.getInterestReal());
		map.put("wait_start_time", t.getWaitStartTime());
		map.put("wait_internal", t.getWaitInternal());
		map.put("wait_end_time", t.getWaitEndTime());
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
 	public String replaceVal(String sql,OrderInjectInfoEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{username}",String.valueOf(t.getUsername()));
 		sql  = sql.replace("#{order_code}",String.valueOf(t.getOrderCode()));
 		sql  = sql.replace("#{order_money}",String.valueOf(t.getOrderMoney()));
 		sql  = sql.replace("#{order_status}",String.valueOf(t.getOrderStatus()));
 		sql  = sql.replace("#{order_time}",String.valueOf(t.getOrderTime()));
 		sql  = sql.replace("#{interest}",String.valueOf(t.getInterest()));
 		sql  = sql.replace("#{first_pay}",String.valueOf(t.getFirstPay()));
 		sql  = sql.replace("#{first_pay_time}",String.valueOf(t.getFirstPayTime()));
 		sql  = sql.replace("#{end_pay}",String.valueOf(t.getEndPay()));
 		sql  = sql.replace("#{end_pay_time}",String.valueOf(t.getEndPayTime()));
 		sql  = sql.replace("#{first_end_internal}",String.valueOf(t.getFirstEndInternal()));
 		sql  = sql.replace("#{save_internal}",String.valueOf(t.getSaveInternal()));
 		sql  = sql.replace("#{rest_rate}",String.valueOf(t.getRestRate()));
 		sql  = sql.replace("#{service_charge}",String.valueOf(t.getServiceCharge()));
 		sql  = sql.replace("#{interest_real}",String.valueOf(t.getInterestReal()));
 		sql  = sql.replace("#{wait_start_time}",String.valueOf(t.getWaitStartTime()));
 		sql  = sql.replace("#{wait_internal}",String.valueOf(t.getWaitInternal()));
 		sql  = sql.replace("#{wait_end_time}",String.valueOf(t.getWaitEndTime()));
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
					javaInter.execute("order_inject_info",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}