package com.mocott.smp.user.service;
import com.mocott.smp.user.entity.FrontStorageActivatecodeEntity;
import com.mocott.smp.user.entity.FrontUserActivatecodeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface FrontUserActivatecodeServiceI extends CommonService{
	
 	public void delete(FrontUserActivatecodeEntity entity) throws Exception;
 	
 	public Serializable save(FrontUserActivatecodeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FrontUserActivatecodeEntity entity) throws Exception;

	public List<FrontUserActivatecodeEntity> getByActivateCode(String activatecode) throws Exception;

	public List<FrontUserActivatecodeEntity> getByUserName(String userName) throws Exception;

	public void doSave(List<FrontStorageActivatecodeEntity> storageActivateCodes, String userName, String activatecode) throws Exception;
}
