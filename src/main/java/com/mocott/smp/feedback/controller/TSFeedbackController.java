package com.mocott.smp.feedback.controller;
import com.mocott.smp.feedback.entity.TSFeedattachEntity;
import com.mocott.smp.feedback.entity.TSFeedbackEntity;
import com.mocott.smp.feedback.service.TSFeedattachServiceI;
import com.mocott.smp.feedback.service.TSFeedbackServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.util.MakeFeedbackNum;
import com.mocott.smp.util.MakeOrderNum;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
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
 * @Description: 系统意见留言信息表
 * @author onlineGenerator
 * @date 2018-01-23 11:01:11
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tSFeedbackController")
public class TSFeedbackController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSFeedbackController.class);

	@Autowired
	private TSFeedbackServiceI tSFeedbackService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private TSFeedattachServiceI tSFeedattachServiceI;


    /**
     * 系统意见留言信息录入 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "toFeedback")
    public ModelAndView toFeedback(HttpServletRequest request) {
        return new ModelAndView("smp/feedback/feedbackMain");
    }

	/**
	 * 系统意见留言信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("/feedback/tSFeedbackList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSFeedbackEntity tSFeedback,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSFeedbackEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSFeedback, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSFeedbackService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除系统意见留言信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSFeedbackEntity tSFeedback, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSFeedback = systemService.getEntity(TSFeedbackEntity.class, tSFeedback.getId());
		message = "系统意见留言信息表删除成功";
		try{
			tSFeedbackService.delete(tSFeedback);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统意见留言信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除系统意见留言信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统意见留言信息表删除成功";
		try{
			for(String id:ids.split(",")){
				TSFeedbackEntity tSFeedback = systemService.getEntity(TSFeedbackEntity.class, 
				id
				);
				tSFeedbackService.delete(tSFeedback);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "系统意见留言信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统意见留言信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSFeedbackEntity tSFeedback, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "意见留言信息反馈成功,敬请等待回复!";
		try{
			HttpSession session = ContextHolderUtils.getSession();
			FrontUserRegisterEntity user = (FrontUserRegisterEntity)session.getAttribute("currentUser");
			tSFeedback.setUsername(user.getUserName());
			tSFeedback.setFeedtime(new Date());
			MakeFeedbackNum mon = new MakeFeedbackNum();
			tSFeedback.setFeedbackid(mon.makeOrderNum("FB"));
			//存储关联的图片信息
			String filePaths = request.getParameter("img_1_d");
			if(StringUtil.isNotEmpty(filePaths)) {
				String[] files = filePaths.split(";");
				List<TSFeedattachEntity> feedbackList = new ArrayList<TSFeedattachEntity>();
				for(int i=0; i<files.length; i++) {
					TSFeedattachEntity feedAttachEntity = new TSFeedattachEntity();
					feedAttachEntity.setFeedbackid(tSFeedback.getFeedbackid());
					feedAttachEntity.setSerialno((i+1)+"");
					feedAttachEntity.setFilepath(files[i]);
					feedAttachEntity.setUploadtime(new Date());
					feedbackList.add(feedAttachEntity);
				}
				tSFeedattachServiceI.batchSave(feedbackList);
			}
			tSFeedbackService.save(tSFeedback);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "意见留言信息反馈失败,请稍后重试!";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新系统意见留言信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSFeedbackEntity tSFeedback, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统意见留言信息表更新成功";
		TSFeedbackEntity t = tSFeedbackService.get(TSFeedbackEntity.class, tSFeedback.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSFeedback, t);
			tSFeedbackService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "系统意见留言信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 系统意见留言信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSFeedbackEntity tSFeedback, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeedback.getId())) {
			tSFeedback = tSFeedbackService.getEntity(TSFeedbackEntity.class, tSFeedback.getId());
			req.setAttribute("tSFeedbackPage", tSFeedback);
		}
		return new ModelAndView("/feedback/tSFeedback-add");
	}
	/**
	 * 系统意见留言信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSFeedbackEntity tSFeedback, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeedback.getId())) {
			tSFeedback = tSFeedbackService.getEntity(TSFeedbackEntity.class, tSFeedback.getId());
			req.setAttribute("tSFeedbackPage", tSFeedback);
		}
		return new ModelAndView("/feedback/tSFeedback-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tSFeedbackController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSFeedbackEntity tSFeedback,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSFeedbackEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSFeedback, request.getParameterMap());
		List<TSFeedbackEntity> tSFeedbacks = this.tSFeedbackService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"系统意见留言信息表");
		modelMap.put(NormalExcelConstants.CLASS,TSFeedbackEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统意见留言信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tSFeedbacks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSFeedbackEntity tSFeedback,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"系统意见留言信息表");
    	modelMap.put(NormalExcelConstants.CLASS,TSFeedbackEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统意见留言信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TSFeedbackEntity> listTSFeedbackEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TSFeedbackEntity.class,params);
				for (TSFeedbackEntity tSFeedback : listTSFeedbackEntitys) {
					tSFeedbackService.save(tSFeedback);
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
	public List<TSFeedbackEntity> list() {
		List<TSFeedbackEntity> listTSFeedbacks=tSFeedbackService.getList(TSFeedbackEntity.class);
		return listTSFeedbacks;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TSFeedbackEntity task = tSFeedbackService.get(TSFeedbackEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TSFeedbackEntity tSFeedback, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSFeedbackEntity>> failures = validator.validate(tSFeedback);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tSFeedbackService.save(tSFeedback);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tSFeedback.getId();
		URI uri = uriBuilder.path("/rest/tSFeedbackController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TSFeedbackEntity tSFeedback) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSFeedbackEntity>> failures = validator.validate(tSFeedback);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tSFeedbackService.saveOrUpdate(tSFeedback);
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
		tSFeedbackService.deleteEntityById(TSFeedbackEntity.class, id);
	}
}
