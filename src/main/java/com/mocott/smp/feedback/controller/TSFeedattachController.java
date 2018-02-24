package com.mocott.smp.feedback.controller;
import com.mocott.smp.feedback.entity.TSFeedattachEntity;
import com.mocott.smp.feedback.service.TSFeedattachServiceI;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller  
 * @Description: 系统意见留言附件表
 * @author onlineGenerator
 * @date 2018-01-23 11:01:47
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/tSFeedattachController")
public class TSFeedattachController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TSFeedattachController.class);

	@Autowired
	private TSFeedattachServiceI tSFeedattachService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;


	/**
	 * 文件上传
	 * @param myfile 前台就要用<input type="file" name="img_1"/>
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
     */
	@RequestMapping(params="fileUpload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson fileUpload(@RequestParam(value = "img_1")MultipartFile myfile,
						  HttpServletRequest request, HttpServletResponse response){
		AjaxJson j = new AjaxJson();
		String message = null;
		//可以在上传文件的同时接收其它参数
		String realPath = request.getSession().getServletContext().getRealPath("/upload");
		//上传文件的原名(即上传前的文件名字)
		String originalFilename = null;
		//如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
		//如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
		//上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
		if(myfile.isEmpty()){
			message = "请选择文件后上传";
		}else{
			originalFilename = myfile.getOriginalFilename();
			System.out.println("文件原名: " + originalFilename);
			System.out.println("文件名称: " + myfile.getName());
			System.out.println("文件长度: " + myfile.getSize());
			System.out.println("文件类型: " + myfile.getContentType());
			System.out.println("========================================");
			try{
				//这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
				FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, originalFilename));
				String resPath = request.getContextPath() + "/upload/" + originalFilename;
				message = "文件上传成功!";
				j.setObj(resPath);
			}catch(Exception e){
				System.out.println("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
				e.printStackTrace();
				message = "文件上传失败";
				throw new BusinessException(e.getMessage());
			}
			j.setMsg(message);
		}

		return j;
	}


	/**
	 * 系统意见留言附件表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("/feedback/tSFeedattachList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(TSFeedattachEntity tSFeedattach,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(TSFeedattachEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSFeedattach, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.tSFeedattachService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除系统意见留言附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(TSFeedattachEntity tSFeedattach, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		tSFeedattach = systemService.getEntity(TSFeedattachEntity.class, tSFeedattach.getId());
		message = "系统意见留言附件表删除成功";
		try{
			tSFeedattachService.delete(tSFeedattach);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统意见留言附件表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除系统意见留言附件表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统意见留言附件表删除成功";
		try{
			for(String id:ids.split(",")){
				TSFeedattachEntity tSFeedattach = systemService.getEntity(TSFeedattachEntity.class, 
				id
				);
				tSFeedattachService.delete(tSFeedattach);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "系统意见留言附件表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加系统意见留言附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(TSFeedattachEntity tSFeedattach, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统意见留言附件表添加成功";
		try{
			tSFeedattachService.save(tSFeedattach);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "系统意见留言附件表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新系统意见留言附件表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(TSFeedattachEntity tSFeedattach, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "系统意见留言附件表更新成功";
		TSFeedattachEntity t = tSFeedattachService.get(TSFeedattachEntity.class, tSFeedattach.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(tSFeedattach, t);
			tSFeedattachService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "系统意见留言附件表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 系统意见留言附件表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(TSFeedattachEntity tSFeedattach, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeedattach.getId())) {
			tSFeedattach = tSFeedattachService.getEntity(TSFeedattachEntity.class, tSFeedattach.getId());
			req.setAttribute("tSFeedattachPage", tSFeedattach);
		}
		return new ModelAndView("/feedback/tSFeedattach-add");
	}
	/**
	 * 系统意见留言附件表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(TSFeedattachEntity tSFeedattach, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(tSFeedattach.getId())) {
			tSFeedattach = tSFeedattachService.getEntity(TSFeedattachEntity.class, tSFeedattach.getId());
			req.setAttribute("tSFeedattachPage", tSFeedattach);
		}
		return new ModelAndView("/feedback/tSFeedattach-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","tSFeedattachController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(TSFeedattachEntity tSFeedattach,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(TSFeedattachEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tSFeedattach, request.getParameterMap());
		List<TSFeedattachEntity> tSFeedattachs = this.tSFeedattachService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"系统意见留言附件表");
		modelMap.put(NormalExcelConstants.CLASS,TSFeedattachEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统意见留言附件表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,tSFeedattachs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(TSFeedattachEntity tSFeedattach,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"系统意见留言附件表");
    	modelMap.put(NormalExcelConstants.CLASS,TSFeedattachEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("系统意见留言附件表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<TSFeedattachEntity> listTSFeedattachEntitys = ExcelImportUtil.importExcel(file.getInputStream(),TSFeedattachEntity.class,params);
				for (TSFeedattachEntity tSFeedattach : listTSFeedattachEntitys) {
					tSFeedattachService.save(tSFeedattach);
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
	public List<TSFeedattachEntity> list() {
		List<TSFeedattachEntity> listTSFeedattachs=tSFeedattachService.getList(TSFeedattachEntity.class);
		return listTSFeedattachs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		TSFeedattachEntity task = tSFeedattachService.get(TSFeedattachEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody TSFeedattachEntity tSFeedattach, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSFeedattachEntity>> failures = validator.validate(tSFeedattach);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tSFeedattachService.save(tSFeedattach);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = tSFeedattach.getId();
		URI uri = uriBuilder.path("/rest/tSFeedattachController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody TSFeedattachEntity tSFeedattach) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<TSFeedattachEntity>> failures = validator.validate(tSFeedattach);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			tSFeedattachService.saveOrUpdate(tSFeedattach);
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
		tSFeedattachService.deleteEntityById(TSFeedattachEntity.class, id);
	}
}
