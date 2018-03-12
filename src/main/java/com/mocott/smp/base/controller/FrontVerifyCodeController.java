package com.mocott.smp.base.controller;
import com.mocott.smp.base.entity.FrontVerifyCodeEntity;
import com.mocott.smp.base.service.FrontVerifyCodeServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import com.mocott.smp.util.SmsSendUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.jeecgframework.web.system.service.MutiLangServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: 验证码信息表
 * @author onlineGenerator
 * @date 2018-01-23 11:02:23
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/frontVerifyCodeController")
public class FrontVerifyCodeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FrontVerifyCodeController.class);

	@Autowired
	private FrontVerifyCodeServiceI frontVerifyCodeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private MutiLangServiceI mutiLangService;
	@Autowired
	private FrontUserRegisterServiceI frontUserRegisterServiceI;

	/**
	 * 生成短信验证码
	 *
	 * @return
	 */
	@RequestMapping(params = "verifyCode")
	@ResponseBody
	public AjaxJson generalVerifyCode(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		try{
			String phoneNo = request.getParameter("phoneNo");
			String randCode = request.getParameter("vfCode");
			if(StringUtil.isNotEmpty(phoneNo)) {
				// 短信验证码
				int verifyCode = (int)(Math.random()*1000000);
				if (StringUtils.isEmpty(randCode)) {
					j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
					j.setSuccess(false);
				} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
					j.setMsg(mutiLangService.getLang("common.verifycode.error"));
					j.setSuccess(false);
				} else if (isInBlackList(IpUtil.getIpAddr(request))){
					j.setMsg(mutiLangService.getLang("common.blacklist.error"));
					j.setSuccess(false);
				}else if(hasThreeCount(phoneNo)) {
					j.setMsg("手机号获取短信验证码频繁,请稍后重试!");
					j.setSuccess(false);
				} else {
					//保存验证码
					FrontVerifyCodeEntity frontVerifyCodeEntity = new FrontVerifyCodeEntity();
					frontVerifyCodeEntity.setPhoneno(phoneNo);
					frontVerifyCodeEntity.setCreateTime(new Date());
					frontVerifyCodeEntity.setValidstatus("1");
					frontVerifyCodeEntity.setIsuse("0");
					frontVerifyCodeEntity.setValidCode(verifyCode+"");
					frontVerifyCodeEntity.setType("1"); //1-注册验证码
					String sendContent = "【JR平台】尊敬的客户，您的验证码:" + verifyCode + ",请于3分钟内正确输入";
					frontVerifyCodeEntity.setSendTime(new Date());
					frontVerifyCodeEntity.setSendContent(sendContent);
					//发送短信
                    //发送短信
                    String result = SmsSendUtil.send(sendContent, phoneNo);
                    if("0".equals(result)) {
                        frontVerifyCodeService.save(frontVerifyCodeEntity);
                        message = "短信发送成功";
                        j.setMsg(message);
                        j.setSuccess(true);
                    } else {
                        message = "短信发送失败，请稍后重试!";
                        j.setMsg(message);
                        j.setSuccess(false);
                    }
				}
			} else {
				j.setMsg("手机号码为空,请输入后重试");
				j.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "短信发送成功，请重试";
			j.setSuccess(false);
			j.setMsg(message);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 生成短信验证码
	 *
	 * @return
	 */
	@RequestMapping(params = "smsCode")
	@ResponseBody
	public AjaxJson generalSmsCode(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		try{
			String safePwd = request.getParameter("vfCode"); //安全密码
			FrontUserRegisterEntity user = ResourceUtil.getSessionFrontUser();
			String userName = user.getUserName();
			String phoneNo = user.getPhoneno();
			FrontUserRegisterEntity userRegister = frontUserRegisterServiceI.queryEntityByUserName(userName);
			String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
			if(StringUtil.isNotEmpty(phoneNo)) {
				// 短信验证码
				int verifyCode = (int)(Math.random()*1000000);
				if (StringUtil.isEmpty(safePwd)) {
					j.setMsg("安全密码为空,请确认!");
					j.setSuccess(false);
				} else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
					j.setMsg("安全密码错误,请确认!");
					j.setSuccess(false);
				} else if(hasThreeCount(phoneNo)) {
					j.setMsg("手机号获取短信验证码频繁,请稍后重试!");
					j.setSuccess(false);
				} else {
					//保存验证码
					FrontVerifyCodeEntity frontVerifyCodeEntity = new FrontVerifyCodeEntity();
					frontVerifyCodeEntity.setPhoneno(phoneNo);
					frontVerifyCodeEntity.setCreateTime(new Date());
					frontVerifyCodeEntity.setValidstatus("1");
					frontVerifyCodeEntity.setIsuse("0");
					frontVerifyCodeEntity.setValidCode(verifyCode+"");
					frontVerifyCodeEntity.setType("2"); //1-提取验证码
					String sendContent = "【JR平台】尊敬的客户，您的验证码:" + verifyCode + ",请于3分钟内正确输入";
					frontVerifyCodeEntity.setSendTime(new Date());
					frontVerifyCodeEntity.setSendContent(sendContent);
					//发送短信
                    String result = SmsSendUtil.send(sendContent, phoneNo);
                    if("0".equals(result)) {
                        frontVerifyCodeService.save(frontVerifyCodeEntity);
                        message = "短信发送成功";
                        j.setMsg(message);
                        j.setSuccess(true);
                    } else {
                        message = "短信发送失败，请稍后重试!";
                        j.setMsg(message);
                        j.setSuccess(false);
                    }
					systemService.addLog(message, Globals.Log_Type_OTHER, Globals.Log_Leavel_INFO);
				}
			} else {
				j.setMsg("手机号码为空,请输入后重试");
				j.setSuccess(false);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "短信发送成功，请重试";
			j.setSuccess(false);
			j.setMsg(message);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 判断同一个号码是否在1个小时内发送三次
	 * @param phoneNo
	 * @return
     */
	private boolean hasThreeCount(String phoneNo) {
		try {
			String beforeTime = DateUtils.getDateSub(60);
			String condition = " createTime > DATE_FORMAT('" + beforeTime + "','%Y-%m-%d %H:%i:%s') ";
			List<FrontVerifyCodeEntity> vfs = frontVerifyCodeService.getVerfiyCodeByConditionType(condition, "2");
			if(vfs != null && vfs.size()>3) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * IP地址黑名单校验
	 * @param ip
	 * @return
	 */
	private boolean isInBlackList(String ip){
		Long orgNum =systemService.getCountForJdbc("select count(*) from t_s_black_list where ip =  '" + ip + "'");
		return orgNum!=0?true:false;
	}

	/**
	 * 验证码信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("/smp/base/frontVerifyCodeList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(FrontVerifyCodeEntity frontVerifyCode,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(FrontVerifyCodeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, frontVerifyCode, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.frontVerifyCodeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除验证码信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(FrontVerifyCodeEntity frontVerifyCode, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		frontVerifyCode = systemService.getEntity(FrontVerifyCodeEntity.class, frontVerifyCode.getId());
		message = "验证码信息表删除成功";
		try{
			frontVerifyCodeService.delete(frontVerifyCode);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "验证码信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除验证码信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "验证码信息表删除成功";
		try{
			for(String id:ids.split(",")){
				FrontVerifyCodeEntity frontVerifyCode = systemService.getEntity(FrontVerifyCodeEntity.class, 
				id
				);
				frontVerifyCodeService.delete(frontVerifyCode);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "验证码信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加验证码信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(FrontVerifyCodeEntity frontVerifyCode, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "验证码信息表添加成功";
		try{
			frontVerifyCodeService.save(frontVerifyCode);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "验证码信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新验证码信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(FrontVerifyCodeEntity frontVerifyCode, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "验证码信息表更新成功";
		FrontVerifyCodeEntity t = frontVerifyCodeService.get(FrontVerifyCodeEntity.class, frontVerifyCode.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(frontVerifyCode, t);
			frontVerifyCodeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "验证码信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 验证码信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(FrontVerifyCodeEntity frontVerifyCode, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(frontVerifyCode.getId())) {
			frontVerifyCode = frontVerifyCodeService.getEntity(FrontVerifyCodeEntity.class, frontVerifyCode.getId());
			req.setAttribute("frontVerifyCodePage", frontVerifyCode);
		}
		return new ModelAndView("/smp/base/frontVerifyCode-add");
	}
	/**
	 * 验证码信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(FrontVerifyCodeEntity frontVerifyCode, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(frontVerifyCode.getId())) {
			frontVerifyCode = frontVerifyCodeService.getEntity(FrontVerifyCodeEntity.class, frontVerifyCode.getId());
			req.setAttribute("frontVerifyCodePage", frontVerifyCode);
		}
		return new ModelAndView("/smp/base/frontVerifyCode-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","frontVerifyCodeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(FrontVerifyCodeEntity frontVerifyCode,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(FrontVerifyCodeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, frontVerifyCode, request.getParameterMap());
		List<FrontVerifyCodeEntity> frontVerifyCodes = this.frontVerifyCodeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"验证码信息表");
		modelMap.put(NormalExcelConstants.CLASS,FrontVerifyCodeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("验证码信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,frontVerifyCodes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(FrontVerifyCodeEntity frontVerifyCode,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"验证码信息表");
    	modelMap.put(NormalExcelConstants.CLASS,FrontVerifyCodeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("验证码信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<FrontVerifyCodeEntity> listFrontVerifyCodeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),FrontVerifyCodeEntity.class,params);
				for (FrontVerifyCodeEntity frontVerifyCode : listFrontVerifyCodeEntitys) {
					frontVerifyCodeService.save(frontVerifyCode);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<FrontVerifyCodeEntity> list() {
		List<FrontVerifyCodeEntity> listFrontVerifyCodes=frontVerifyCodeService.getList(FrontVerifyCodeEntity.class);
		return listFrontVerifyCodes;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		FrontVerifyCodeEntity task = frontVerifyCodeService.get(FrontVerifyCodeEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody FrontVerifyCodeEntity frontVerifyCode, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FrontVerifyCodeEntity>> failures = validator.validate(frontVerifyCode);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			frontVerifyCodeService.save(frontVerifyCode);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = frontVerifyCode.getId();
		URI uri = uriBuilder.path("/rest/frontVerifyCodeController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody FrontVerifyCodeEntity frontVerifyCode) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FrontVerifyCodeEntity>> failures = validator.validate(frontVerifyCode);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			frontVerifyCodeService.saveOrUpdate(frontVerifyCode);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		frontVerifyCodeService.deleteEntityById(FrontVerifyCodeEntity.class, id);
	}
}
