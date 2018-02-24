package com.mocott.smp.order.service;
import com.mocott.smp.base.entity.FrontVerifyCodeEntity;
import com.mocott.smp.order.entity.OrderDrawInfoEntity;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface OrderDrawInfoServiceI extends CommonService{
	
 	public void delete(OrderDrawInfoEntity entity) throws Exception;
 	
 	public Serializable save(OrderDrawInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(OrderDrawInfoEntity entity) throws Exception;

	public List<OrderDrawInfoEntity> getUndoneList(String userName) throws Exception;

	public void doSaveOutOrder(OrderDrawInfoEntity orderDrawInfo, FrontUserMemberEntity userMember, FrontVerifyCodeEntity verifyCode) throws Exception;

}
