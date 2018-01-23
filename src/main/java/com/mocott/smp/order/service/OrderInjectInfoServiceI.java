package com.mocott.smp.order.service;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface OrderInjectInfoServiceI extends CommonService{
	
 	public void delete(OrderInjectInfoEntity entity) throws Exception;
 	
 	public Serializable save(OrderInjectInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(OrderInjectInfoEntity entity) throws Exception;
 	
}
