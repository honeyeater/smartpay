package com.mocott.smp.user.service.impl;
import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.user.entity.FrontStorageActivatecodeEntity;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.service.FrontStorageActivatecodeServiceI;
import com.mocott.smp.user.service.FrontUserActivatecodeServiceI;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.util.OrderConstant;
import org.hibernate.Query;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.mocott.smp.user.entity.FrontUserActivatecodeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

@Service("frontUserActivatecodeService")
@Transactional
public class FrontUserActivatecodeServiceImpl extends CommonServiceImpl implements FrontUserActivatecodeServiceI {

	@Autowired
	private FrontStorageActivatecodeServiceI frontStorageActivatecodeService;
	@Autowired
	private TSConfigcodeServiceI tsConfigcodeService;
	@Autowired
	private FrontUserMemberServiceI frontUserMemberService;
	
 	public void delete(FrontUserActivatecodeEntity entity) throws Exception{
 		super.delete(entity);
 		//执行删除操作增强业务
		this.doDelBus(entity);
 	}
 	
 	public Serializable save(FrontUserActivatecodeEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		//执行新增操作增强业务
 		this.doAddBus(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(FrontUserActivatecodeEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 		//执行更新操作增强业务
 		this.doUpdateBus(entity);
 	}

	/**
	 * 根据激活码查询激活码信息
	 * @param activatecode
	 * @return
	 * @throws Exception
     */
	public List<FrontUserActivatecodeEntity> getByActivateCode(String activatecode) throws Exception {
		String query = " from FrontUserActivatecodeEntity u where u.activieCode = :activieCode and u.validstatus = '1'";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("activieCode", activatecode);
		return queryObject.list();
	}

	/**
	 * 根据用户名查询激活码信息
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public List<FrontUserActivatecodeEntity> getByUserName(String userName) throws Exception {
		String query = " from FrontUserActivatecodeEntity u where u.username = :userName";
		Query queryObject = getSession().createQuery(query);
		queryObject.setParameter("userName", userName);
		return queryObject.list();
	}

	/**
	 * 保存激活码
	 * @param userName
	 * @param activatecode
	 * @throws Exception
     */
	public void doSave(List<FrontStorageActivatecodeEntity> storageActivateCodes, String userName, String activatecode) throws Exception {
		Date now = new Date();
		FrontStorageActivatecodeEntity frontStorageActivatecode = storageActivateCodes.get(0);
		FrontUserActivatecodeEntity userActivatecode = new FrontUserActivatecodeEntity();
		userActivatecode.setUsername(userName);
		userActivatecode.setActivieCode(activatecode);
		userActivatecode.setUseTime(now);
		userActivatecode.setUserUsername(userName);
		userActivatecode.setIsuse("1");
		userActivatecode.setValidstatus("1");
		userActivatecode.setActivieType(frontStorageActivatecode.getActivieType());
		userActivatecode.setInputtime(now);
		userActivatecode.setInserttimeforhis(now);
		userActivatecode.setOperatetimeforhis(now);

		frontStorageActivatecode.setUserUsername(userName);
		frontStorageActivatecode.setIsuse("1");
		frontStorageActivatecode.setUseTime(now);
		frontStorageActivatecode.setOperatetimeforhis(now);

		FrontUserMemberEntity userMember = frontUserMemberService.queryEntityByUserName(userName);
		String activieType = frontStorageActivatecode.getActivieType();
		if("1".equals(activieType) || "2".equals(activieType)) { //100元类别 500类别
			TSConfigcodeEntity tsConfigcodeEntity = null;
			if("1".equals(activieType)) {
				tsConfigcodeEntity = tsConfigcodeService.getConfigValue(OrderConstant.ActcodeLow);
			}
			if("2".equals(activieType)) {
				tsConfigcodeEntity = tsConfigcodeService.getConfigValue(OrderConstant.ActcodeMed);
			}
			if(tsConfigcodeEntity != null) {
				Double limit = Double.parseDouble(tsConfigcodeEntity.getConfigValue());
				userMember.setSumLimit(userMember.getSumLimit() + limit);
				frontUserMemberService.saveOrUpdate(userMember);
			}
		}


		this.save(userActivatecode);
		frontStorageActivatecodeService.saveOrUpdate(frontStorageActivatecode);
	}


	/**
	 * 新增操作增强业务
	 * @param t
	 * @return
	 */
	private void doAddBus(FrontUserActivatecodeEntity t) throws Exception{
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
	private void doUpdateBus(FrontUserActivatecodeEntity t) throws Exception{
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
	private void doDelBus(FrontUserActivatecodeEntity t) throws Exception{
	    //-----------------sql增强 start----------------------------
	 	//-----------------sql增强 end------------------------------
	 	
	 	//-----------------java增强 start---------------------------
	 	//-----------------java增强 end-----------------------------
 	}
 	
 	private Map<String,Object> populationMap(FrontUserActivatecodeEntity t){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", t.getId());
		map.put("username", t.getUsername());
		map.put("activie_code", t.getActivieCode());
		map.put("buy_time", t.getBuyTime());
		map.put("use_time", t.getUseTime());
		map.put("user_username", t.getUserUsername());
		map.put("isuse", t.getIsuse());
		map.put("validstatus", t.getValidstatus());
		map.put("activie_type", t.getActivieType());
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
 	public String replaceVal(String sql,FrontUserActivatecodeEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{username}",String.valueOf(t.getUsername()));
 		sql  = sql.replace("#{activie_code}",String.valueOf(t.getActivieCode()));
 		sql  = sql.replace("#{buy_time}",String.valueOf(t.getBuyTime()));
 		sql  = sql.replace("#{use_time}",String.valueOf(t.getUseTime()));
 		sql  = sql.replace("#{user_username}",String.valueOf(t.getUserUsername()));
 		sql  = sql.replace("#{isuse}",String.valueOf(t.getIsuse()));
 		sql  = sql.replace("#{validstatus}",String.valueOf(t.getValidstatus()));
 		sql  = sql.replace("#{activie_type}",String.valueOf(t.getActivieType()));
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
					javaInter.execute("front_user_activatecode",data);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("执行JAVA增强出现异常！");
			} 
		}
 	}
}