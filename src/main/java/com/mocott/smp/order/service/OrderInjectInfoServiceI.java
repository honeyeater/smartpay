package com.mocott.smp.order.service;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface OrderInjectInfoServiceI extends CommonService{
	
 	public void delete(OrderInjectInfoEntity entity) throws Exception;
 	
 	public Serializable save(OrderInjectInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(OrderInjectInfoEntity entity) throws Exception;

	public List<OrderInjectInfoEntity> getUndoneList(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUsers(String users) throws Exception;

	public List<OrderInjectInfoEntity> getListByUser(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndoneBack(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndonePay(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndoneSave(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByFirst(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndoneATBack(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByDoneBack(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndoneCoupon(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByUndoneATCoupon(String userName) throws Exception;

	public List<OrderInjectInfoEntity> getListByOrderCode(String orderCode, String userName) throws Exception;

	public void changeOrderStauts() throws Exception;

}
