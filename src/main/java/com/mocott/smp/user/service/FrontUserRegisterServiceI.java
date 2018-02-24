package com.mocott.smp.user.service;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;

public interface FrontUserRegisterServiceI extends CommonService{
	
 	public void delete(FrontUserRegisterEntity entity) throws Exception;
 	
 	public Serializable save(FrontUserRegisterEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FrontUserRegisterEntity entity) throws Exception;

    public FrontUserRegisterEntity checkUserExits(FrontUserRegisterEntity user);

    public FrontUserRegisterEntity queryEntityByUserName(String userName);

	public List<FrontUserRegisterEntity> getChildUserByIntro(String introducer);


	public List<FrontUserRegisterEntity> queryEntityByIdNo(String idNo) throws Exception;

	public FrontUserRegisterEntity queryEntityByPhoneNo(String phoneNo) throws Exception;

	public List<FrontUserRegisterEntity> queryParentEntity(String userName) throws Exception;


}
