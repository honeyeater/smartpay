package com.mocott.smp.log.service;
import com.mocott.smp.log.entity.LogTradeInfoEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface LogTradeInfoServiceI extends CommonService{
	
 	public void delete(LogTradeInfoEntity entity) throws Exception;
 	
 	public Serializable save(LogTradeInfoEntity entity) throws Exception;
 	
 	public void saveOrUpdate(LogTradeInfoEntity entity) throws Exception;

    public List<LogTradeInfoEntity> getTradesByUserName(String userName, String bDate, String eDate);
}
