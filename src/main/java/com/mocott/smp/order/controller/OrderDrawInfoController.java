package com.mocott.smp.order.controller;
import com.mocott.smp.base.entity.FrontVerifyCodeEntity;
import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.FrontVerifyCodeServiceI;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.order.entity.OrderDrawInfoEntity;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.service.OrderDrawInfoServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.order.service.OrderInjectInfoServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import com.mocott.smp.util.MakeOrderNum;
import com.mocott.smp.util.OrderConstant;
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
 * @Description: 提出资金订单表
 * @author onlineGenerator
 * @date 2018-01-23 11:02:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/orderDrawInfoController")
public class OrderDrawInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderDrawInfoController.class);

	@Autowired
	private OrderDrawInfoServiceI orderDrawInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private FrontVerifyCodeServiceI frontVerifyCodeService;
	@Autowired
	private FrontUserRegisterServiceI frontUserRegisterServiceI;
	@Autowired
	private TSConfigcodeServiceI tSConfigcodeServiceI;
	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;
	@Autowired
	private OrderInjectInfoServiceI orderInjectInfoServiceI;


	/**
	 * 提出资金订单表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "toDrawList")
	public ModelAndView toDrawList(HttpServletRequest request) {
		return new ModelAndView("smp/order/drawListMain");
	}


	/**
	 * 生成提出订单
	 *
	 * @return
	 */
	@RequestMapping(params = "generalOutOrder")
	@ResponseBody
	public AjaxJson generalOutOrder(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提出资金订单添加成功";
		double priceD = 0.0; //提取金额
		double priceBXD = 0.0; //本息金额
		double priceZTD = 0.0; //直推钱包
		String smsCode = request.getParameter("smscode");
		String safePwd = request.getParameter("threePwOut");
		String userName = request.getParameter("inUserName");
		String drawType = request.getParameter("drawType"); //提取类型
		String price = request.getParameter("aaPrice"); //提取金额
		String priceBX = request.getParameter("aabPrice"); //提取本息金额
		String priceZT = request.getParameter("aabbPrice"); //提取直推金额

		FrontUserRegisterEntity user = ResourceUtil.getSessionFrontUser();
		if(StringUtil.isEmpty(userName)) {
			userName = user.getUserName();
		}
		if(StringUtil.isNotEmpty(price)) {
			priceD = Double.parseDouble(price);
		}
		if(StringUtil.isNotEmpty(priceBX)) {
			priceBXD = Double.parseDouble(priceBX);
		}
		if(StringUtil.isNotEmpty(priceZT)) {
			priceZTD = Double.parseDouble(priceZT);
		}
		try {
			String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
			FrontUserRegisterEntity userRegister = frontUserRegisterServiceI.queryEntityByUserName(userName);
			FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
			String phoneNo = userRegister.getPhoneno();
			FrontVerifyCodeEntity fvc = getHasValid(smsCode, "2", phoneNo);
			double firstPayRatio = 100.00;
			double baseTimes = 1.2;
			//配置的提取基础比例
			TSConfigcodeEntity tsConfigcodeEntity = tSConfigcodeServiceI.getConfigValue(OrderConstant.Sys_Base_UpTimes);
			if (tsConfigcodeEntity != null) {
				String firstPayRatioS = tsConfigcodeEntity.getConfigValue();
				if (StringUtil.isNotEmpty(firstPayRatioS)) {
					firstPayRatio = Double.parseDouble(firstPayRatioS);
				}
			}
			if (userMember == null) {
				message = "用户状态异常,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else if (StringUtil.isEmpty(smsCode)) {
				j.setMsg("短信验证码为空,请确认!");
				j.setSuccess(false);
			} else if (fvc == null) {
				j.setMsg("短信验证码错误或已失效,请稍后重试!");
				j.setSuccess(false);
			} else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
				j.setMsg("安全密码错误,请确认!");
				j.setSuccess(false);
			} else if (priceD <= 0) {
				j.setMsg("提取资金必须大于0,请确认!");
				j.setSuccess(false);
			} else if (!"1".equals(drawType) && !"2".equals(drawType) && !"3".equals(drawType) && !"4".equals(drawType)) {
				j.setMsg("请勾选待提取钱包,请确认");
				j.setSuccess(false);
			} else if ((priceD % firstPayRatio) > 0 && "1".equals(drawType)) { //待返钱包
				j.setMsg("提取金额必须是" + firstPayRatio + "的倍数,请确认!");
				j.setSuccess(false);
			} else if ((priceBXD % firstPayRatio) > 0 && (priceBXD % baseTimes) > 0 && "2".equals(drawType)) { //本息钱包
				j.setMsg("提取本息金额必须是" + firstPayRatio + "和1.2的倍数,请确认!");
				j.setSuccess(false);
			} else if ((priceBXD % firstPayRatio) > 0 && (priceBXD % baseTimes) > 0 && "4".equals(drawType)) { //本息钱包
				j.setMsg("提取本息金额必须是" + firstPayRatio + "和1.2的倍数,请确认!");
				j.setSuccess(false);
			} else if (userMember.getBackWallet() < priceD && "1".equals(drawType)) {
				j.setMsg("待返钱包金额小于提取金额,请确认!");
				j.setSuccess(false);
			} else if ((userMember.getCouponWallet()+userMember.getIntroWallet()) < priceD && "2".equals(drawType)) {
				j.setMsg("本息钱包金额小于提取金额,请确认!");
				j.setSuccess(false);
			} else if (userMember.getIntroWallet() < priceD && "3".equals(drawType)) {
				j.setMsg("直推钱包金额小于提取金额,请确认!");
				j.setSuccess(false);
			} else if ((userMember.getIntroWallet() < priceZTD || userMember.getCouponWallet() < priceBXD) && "4".equals(drawType)) {
				j.setMsg("直推与本息钱包金额小于提取金额,请确认!");
				j.setSuccess(false);
			} else{
				//产生提出订单
				MakeOrderNum orderNum = new MakeOrderNum();
				OrderDrawInfoEntity orderDrawInfo = new OrderDrawInfoEntity();
				orderDrawInfo.setUsername(userName);
				orderDrawInfo.setOrderCode(orderNum.makeOrderNum("G"));
				orderDrawInfo.setOrderMoney(priceD);
				orderDrawInfo.setOrderStatus(OrderConstant.Order_Out_Init); //产生订单,等待初始化,等待处理
				orderDrawInfo.setOrderTime(new Date());

				orderDrawInfo.setDrawWallet(drawType); //提取钱包
				orderDrawInfo.setDrawMoney(priceD);
				orderDrawInfo.setDrawStartTime(new Date());
				if ("4".equals(drawType)) { //直推钱包与本息钱包一起提取时
					orderDrawInfo.setNfield1(priceZTD);
				}
				//更新钱包
				userMember.setVfield1(drawType);//上次提取的金额
				if ("1".equals(drawType)) { //待返钱包
					userMember.setBackWallet(userMember.getBackWallet() - priceD);
				} else if ("2".equals(drawType)) { //本息钱包
//					userMember.setCouponWallet(userMember.getCouponWallet() - priceD);
					userMember.setCouponWallet(userMember.getCouponWallet() - priceBXD);
					userMember.setIntroWallet(userMember.getIntroWallet() - priceZTD);
				} else if ("3".equals(drawType)) { //直推钱包
					userMember.setIntroWallet(userMember.getIntroWallet() - priceD);
				} else if ("4".equals(drawType)) { //本息和直推钱包
					userMember.setCouponWallet(userMember.getCouponWallet() - priceBXD);
					userMember.setIntroWallet(userMember.getIntroWallet() - priceZTD);
				}
				//更新短信验证
				fvc.setIsuse("1");
				fvc.setUserTime(new Date());

				orderDrawInfoService.doSaveOutOrder(orderDrawInfo, userMember, fvc);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				j.setSuccess(true);
			}
		}catch (Exception e) {
			e.printStackTrace();
			message = "提出资金订单添加失败,请稍后重试或联系管理员";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}

		return j;
	}

	/**
	 * 校验提取数据
	 *
	 * @return
	 */
	@RequestMapping(params = "checkDrawOrder")
	@ResponseBody
	public AjaxJson checkDrawOrder(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提出资金订单校验成功";
		try {
			String drawType = request.getParameter("drawType");
			FrontUserRegisterEntity user = ResourceUtil.getSessionFrontUser();
			String userName = user.getUserName();
			FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
			if(userMember == null) {
				message = "用户状态异常,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else {
				String canDraw = this.canDraw(userName, drawType, userMember);
				j.setMsg(message);
				j.setSuccess(true);
				Map<String, Object> attr = new HashMap<>();
				attr.put("canDraw", canDraw);
				attr.put("userMem", userMember);
				j.setAttributes(attr);
			}
		}catch (Exception e) {
			e.printStackTrace();
			message = "提出资金订单校验失败,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return  j;
	}


	/**
	 * 判断是否能够提取
	 * @param userName
	 * @param drawType
	 * @param userMember
     * @return
     */
	private String canDraw(String userName, String drawType, FrontUserMemberEntity userMember) throws Exception{
		boolean hasCouponOrder = false;
		boolean hasBackOrder = false;
		boolean hasDoneBackOrder = false;
		// 获取已经支付首付款\已支付尾款\保存期的未完成订单
		List<OrderInjectInfoEntity> couponList = orderInjectInfoServiceI.getListByUndoneATCoupon(userName);
		List<OrderInjectInfoEntity> backList = orderInjectInfoServiceI.getListByUndoneATBack(userName);
		List<OrderInjectInfoEntity> backDoneList = orderInjectInfoServiceI.getListByDoneBack(userName);
		if(couponList != null && couponList.size()>0) {
			hasCouponOrder = true;
		}
		if(backList != null && backList.size()>0) {
			hasBackOrder = true;
		}
		if(backDoneList != null && backDoneList.size()>0) {
			hasDoneBackOrder = true;
		}
		String canDraw = "0";
		System.out.println("-----"+drawType);
		// 提取待返钱包
		if("1".equals(drawType)) {
			if(hasDoneBackOrder && hasCouponOrder && userMember.getBackWallet()>0 &&
					(StringUtil.isEmpty(userMember.getVfield1()) || !"1".equals(userMember.getVfield1()))) {
				canDraw = "1";
			}
		}
		// 提取本息钱包
		if("2".equals(drawType)) {
			if(hasBackOrder && userMember.getCouponWallet()>0 && !"2".equals(userMember.getVfield1()) && "1".equals(userMember.getVfield1())) {
				canDraw = "1";
			}
		}
		// 提取直推钱包
		if("3".equals(drawType)) {
			if(hasBackOrder && userMember.getIntroWallet()>0) {
				canDraw = "1";
			}
		}
		// 提取本息和直推钱包
		if("4".equals(drawType)) {
			if(hasBackOrder) {
				canDraw = "1";
			}
		}
		return canDraw;
	}

	/**
	 * 判断短信验证码是否有效
	 * @param
	 * @return
	 */
	private FrontVerifyCodeEntity getHasValid(String vfCode, String type, String phoneNo) {
		String beforeTime = DateUtils.getDateSub(10);

		String condition = " phoneno='"+phoneNo+"' and validCode ='" + vfCode+"' and createTime >  DATE_FORMAT('" + beforeTime + "','%Y-%m-%d %H:%i:%s') ";
		//and createTime > DATE_SUB(SYSDATE(),INTERVAL 10 MINUTE)
		try {
			List<FrontVerifyCodeEntity> vfs = frontVerifyCodeService.getVerfiyCodeByConditionType(condition, type);
			if(vfs != null && vfs.size()>0) {
				return vfs.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(OrderDrawInfoEntity orderDrawInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderDrawInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, orderDrawInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.orderDrawInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除提出资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OrderDrawInfoEntity orderDrawInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		orderDrawInfo = systemService.getEntity(OrderDrawInfoEntity.class, orderDrawInfo.getId());
		message = "提出资金订单表删除成功";
		try{
			orderDrawInfoService.delete(orderDrawInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提出资金订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除提出资金订单表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提出资金订单表删除成功";
		try{
			for(String id:ids.split(",")){
				OrderDrawInfoEntity orderDrawInfo = systemService.getEntity(OrderDrawInfoEntity.class, 
				id
				);
				orderDrawInfoService.delete(orderDrawInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "提出资金订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加提出资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OrderDrawInfoEntity orderDrawInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提出资金订单表添加成功";
		try{
			orderDrawInfoService.save(orderDrawInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "提出资金订单表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新提出资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OrderDrawInfoEntity orderDrawInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "提出资金订单表更新成功";
		OrderDrawInfoEntity t = orderDrawInfoService.get(OrderDrawInfoEntity.class, orderDrawInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(orderDrawInfo, t);
			orderDrawInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "提出资金订单表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 提出资金订单表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OrderDrawInfoEntity orderDrawInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(orderDrawInfo.getId())) {
			orderDrawInfo = orderDrawInfoService.getEntity(OrderDrawInfoEntity.class, orderDrawInfo.getId());
			req.setAttribute("orderDrawInfoPage", orderDrawInfo);
		}
		return new ModelAndView("/order/orderDrawInfo-add");
	}
	/**
	 * 提出资金订单表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OrderDrawInfoEntity orderDrawInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(orderDrawInfo.getId())) {
			orderDrawInfo = orderDrawInfoService.getEntity(OrderDrawInfoEntity.class, orderDrawInfo.getId());
			req.setAttribute("orderDrawInfoPage", orderDrawInfo);
		}
		return new ModelAndView("/order/orderDrawInfo-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","orderDrawInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(OrderDrawInfoEntity orderDrawInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(OrderDrawInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, orderDrawInfo, request.getParameterMap());
		List<OrderDrawInfoEntity> orderDrawInfos = this.orderDrawInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"提出资金订单表");
		modelMap.put(NormalExcelConstants.CLASS,OrderDrawInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提出资金订单表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,orderDrawInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(OrderDrawInfoEntity orderDrawInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"提出资金订单表");
    	modelMap.put(NormalExcelConstants.CLASS,OrderDrawInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("提出资金订单表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<OrderDrawInfoEntity> listOrderDrawInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),OrderDrawInfoEntity.class,params);
				for (OrderDrawInfoEntity orderDrawInfo : listOrderDrawInfoEntitys) {
					orderDrawInfoService.save(orderDrawInfo);
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
	public List<OrderDrawInfoEntity> list() {
		List<OrderDrawInfoEntity> listOrderDrawInfos=orderDrawInfoService.getList(OrderDrawInfoEntity.class);
		return listOrderDrawInfos;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		OrderDrawInfoEntity task = orderDrawInfoService.get(OrderDrawInfoEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody OrderDrawInfoEntity orderDrawInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderDrawInfoEntity>> failures = validator.validate(orderDrawInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			orderDrawInfoService.save(orderDrawInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = orderDrawInfo.getId();
		URI uri = uriBuilder.path("/rest/orderDrawInfoController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody OrderDrawInfoEntity orderDrawInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderDrawInfoEntity>> failures = validator.validate(orderDrawInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			orderDrawInfoService.saveOrUpdate(orderDrawInfo);
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
		orderDrawInfoService.deleteEntityById(OrderDrawInfoEntity.class, id);
	}
}
