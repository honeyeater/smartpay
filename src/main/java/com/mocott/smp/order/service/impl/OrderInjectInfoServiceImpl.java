package com.mocott.smp.order.service.impl;

import com.mocott.smp.log.entity.LogTradeInfoEntity;
import com.mocott.smp.log.service.LogTradeInfoServiceI;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.service.OrderInjectInfoServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import com.mocott.smp.util.OrderConstant;
import com.mocott.smp.util.SmsSendUtil;
import org.hibernate.Query;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.DateUtils;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.*;

@Service("orderInjectInfoService")
@Transactional
public class OrderInjectInfoServiceImpl extends CommonServiceImpl implements OrderInjectInfoServiceI {

	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;
	@Autowired
    private LogTradeInfoServiceI logTradeInfoServiceI;
	@Autowired
    private FrontUserRegisterServiceI frontUserRegisterServiceI;

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
        Date now = new Date();
        String query01 = " from OrderInjectInfoEntity o where o.orderStatus in ('01')"; //01 待支付首付款
        Query queryObject01 = getSession().createQuery(query01);
        List<OrderInjectInfoEntity> orderInjectInfoEntityList01 = queryObject01.list();
        if(orderInjectInfoEntityList01 != null && orderInjectInfoEntityList01.size()>0) {
            for (int i=0; i<orderInjectInfoEntityList01.size(); i++) {
                OrderInjectInfoEntity orderInjectInfoEntity = orderInjectInfoEntityList01.get(i);
                int firstI = (orderInjectInfoEntity.getFirstEndInternal() != null ? Integer.parseInt(orderInjectInfoEntity.getFirstEndInternal()) : 8);
                int diffD = DateUtils.dateDiffForDate('h', now, orderInjectInfoEntity.getOrderTime());
                if(diffD >= firstI) {
                    FrontUserRegisterEntity frontUserRegisterEntity = frontUserRegisterServiceI.queryEntityByUserName(orderInjectInfoEntity.getUsername());
                    frontUserRegisterEntity.setValidFlag("0");
                    frontUserRegisterEntity.setVfield5("1"); //首付款未支付被冻结
                    frontUserRegisterServiceI.saveOrUpdate(frontUserRegisterEntity);
                }
            }
        }

		String query02 = " from OrderInjectInfoEntity o where o.orderStatus in ('02')"; //02 尾款未支付
		Query queryObject02 = getSession().createQuery(query02);
		List<OrderInjectInfoEntity> orderInjectInfoEntityList02 = queryObject02.list();
		if(orderInjectInfoEntityList02 != null && orderInjectInfoEntityList02.size()>0) {
			for (int i=0; i<orderInjectInfoEntityList02.size(); i++) {
				OrderInjectInfoEntity orderInjectInfoEntity = orderInjectInfoEntityList02.get(i);
				int finalI = (orderInjectInfoEntity.getVfield6() != null ? Integer.parseInt(orderInjectInfoEntity.getVfield6()) : 12);
				int diffD = DateUtils.dateDiffForDate('h', now, orderInjectInfoEntity.getWaitEndTime());
                if(diffD >= finalI) {
                    FrontUserRegisterEntity frontUserRegisterEntity = frontUserRegisterServiceI.queryEntityByUserName(orderInjectInfoEntity.getUsername());
                    frontUserRegisterEntity.setValidFlag("0");
                    frontUserRegisterEntity.setVfield5("2"); //尾款未支付被冻结
                    frontUserRegisterServiceI.saveOrUpdate(frontUserRegisterEntity);
                }
			}
		}

        String query04 = " from OrderInjectInfoEntity o where o.orderStatus in ('04')"; //04 周期
        Query queryObject04 = getSession().createQuery(query04);
        List<OrderInjectInfoEntity> orderInjectInfoEntityList04 = queryObject04.list();
        if(orderInjectInfoEntityList04 != null && orderInjectInfoEntityList04.size()>0) {
            for (int i=0; i<orderInjectInfoEntityList04.size(); i++) {
                OrderInjectInfoEntity orderInjectInfoEntity = orderInjectInfoEntityList04.get(i);
                int waitI = (orderInjectInfoEntity.getWaitInternal() != null ? Integer.parseInt(orderInjectInfoEntity.getWaitInternal()) : 480);
                int diffD = DateUtils.dateDiffForDate('h', now, orderInjectInfoEntity.getWaitStartTime());
                if(diffD >= waitI) {
                    orderInjectInfoEntity.setOrderStatus(OrderConstant.Order_Final_Pay);
                    this.saveOrUpdate(orderInjectInfoEntity);
                    // 发送短信
                    try {
                        FrontUserRegisterEntity userRegisterEntity = frontUserRegisterServiceI.queryEntityByUserName(orderInjectInfoEntity.getUsername());
                        if (userRegisterEntity != null) {
                            String sendContent = "JR尾款支付提醒：您有一笔订单尾款需要支付，请登陆JR查询，并在24小时内支付尾款。";
                            String phoneNo = userRegisterEntity.getPhoneno();
                            String result = SmsSendUtil.send(sendContent, phoneNo);
                            System.out.println("-----尾款支付短信提醒-----"+result);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        // 判断保存期内，如果没有新订单注入时，则进行封号处理
        String query03 = " from OrderInjectInfoEntity o where o.orderStatus in ('03')"; //03 保存期
        Query queryObject03 = getSession().createQuery(query03);
        List<OrderInjectInfoEntity> orderInjectInfoEntityList03 = queryObject03.list();
        if(orderInjectInfoEntityList03 != null && orderInjectInfoEntityList03.size()>0) {
            for (int i=0; i<orderInjectInfoEntityList03.size(); i++) {
                OrderInjectInfoEntity orderInjectInfoEntity = orderInjectInfoEntityList03.get(i);
                int saveI = (orderInjectInfoEntity.getSaveInternal() != null ? Integer.parseInt(orderInjectInfoEntity.getSaveInternal()) : 360);
                int diffD = DateUtils.dateDiffForDate('h', now, orderInjectInfoEntity.getEndPayTime());
                if(diffD >= saveI) {
                    List<OrderInjectInfoEntity> orderInjectInfoEntityListnew = this.getUndoneList(orderInjectInfoEntity.getUsername());
                    if(orderInjectInfoEntityListnew == null || orderInjectInfoEntityListnew.size()==0 || orderInjectInfoEntityListnew.size()==1) {
                        FrontUserRegisterEntity frontUserRegisterEntity = frontUserRegisterServiceI.queryEntityByUserName(orderInjectInfoEntity.getUsername());
                        frontUserRegisterEntity.setValidFlag("0");
                        frontUserRegisterEntity.setVfield5("3"); //没有新订单被冻结
                        frontUserRegisterServiceI.saveOrUpdate(frontUserRegisterEntity);
                    }
                    boolean hasCh = true;
                    if(orderInjectInfoEntityListnew != null && orderInjectInfoEntityListnew.size()>1) { //所有保存期的订单都超时了
                        for(int j=0;j<orderInjectInfoEntityListnew.size(); j++) {
                            OrderInjectInfoEntity orderInjectInfoEntitynew = orderInjectInfoEntityListnew.get(j);
                            if("03".equals(orderInjectInfoEntitynew.getOrderStatus()) && hasChaoshi(orderInjectInfoEntitynew.getSaveInternal(), now,
                                    orderInjectInfoEntitynew.getEndPayTime())) {
                                hasCh = true;
                            } else {
                                hasCh = false;
                                break;
                            }
                        }
                    }
                    if(hasCh) {
                        FrontUserRegisterEntity frontUserRegisterEntity = frontUserRegisterServiceI.queryEntityByUserName(orderInjectInfoEntity.getUsername());
                        frontUserRegisterEntity.setValidFlag("0");
                        frontUserRegisterEntity.setVfield5("3"); //没有新订单被冻结
                        frontUserRegisterServiceI.saveOrUpdate(frontUserRegisterEntity);
                    }
                }
            }
        }
	}

	private boolean hasChaoshi(String saveInterNa, Date now, Date endPayTime) {
        int saveI = (saveInterNa != null ? Integer.parseInt(saveInterNa) : 360);
        int diffD = DateUtils.dateDiffForDate('h', now, endPayTime);
        if(diffD > saveI) {
            return true;
        } else {
            return false;
        }
    }


	public void saveOrUpdate(OrderInjectInfoEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}

	/**
	 * 获取未完成的订单信息(首付款未支付01\尾款未支付02\保存期内03)
	 * @return
	 * @throws Exception
     */
	@Override
	public List<OrderInjectInfoEntity> getUndoneList(String userName) throws Exception {
//		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02','03','04') and o.username = :userName";
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
		String query = " from OrderInjectInfoEntity o where o.username = :userName order by orderTime desc";
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
		String query = " from OrderInjectInfoEntity o where o.orderStatus in ('01','02','04')  and o.username = :userName";
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