package com.mocott.smp.base.service;
import org.jeecgframework.core.common.service.CommonService;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public interface TSIndexServiceI extends CommonService{
	

	public void getIndexInfo(String userName, HttpServletRequest request) throws Exception;

	public void getIndexBaseInfo(String userName, HttpServletRequest request) throws Exception;

	/**
	 * 注入资金限额
	 * @return
	 * @throws Exception
     */
	public String getBaseLimit() throws Exception;

	/**
	 * 注入资金基础倍数
	 * @return
	 * @throws Exception
     */
	public String getBaseTimes() throws Exception;

}
