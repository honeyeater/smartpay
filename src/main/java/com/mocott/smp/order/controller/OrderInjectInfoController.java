package com.mocott.smp.order.controller;
import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.base.service.TSIndexServiceI;
import com.mocott.smp.log.entity.LogTradeInfoEntity;
import com.mocott.smp.log.service.LogTradeInfoServiceI;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.service.OrderInjectInfoServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import com.mocott.smp.util.MakeOrderNum;
import com.mocott.smp.util.OrderConstant;
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
 * @Description: 注入资金订单表
 * @author onlineGenerator
 * @date 2018-01-23 11:02:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/orderInjectInfoController")
public class OrderInjectInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OrderInjectInfoController.class);

	@Autowired
	private OrderInjectInfoServiceI orderInjectInfoService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private TSConfigcodeServiceI tSConfigcodeServiceI;
	@Autowired
	private FrontUserRegisterServiceI frontUserRegisterServiceI;
	@Autowired
	private MutiLangServiceI mutiLangService;
	@Autowired
	private TSIndexServiceI tsIndexServiceI;
	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;
	@Autowired
    private LogTradeInfoServiceI logTradeInfoServiceI;

    /**
     * 财务明细列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "tofinancelist")
    public ModelAndView tofinancelist(HttpServletRequest request) {
        HttpSession session = ContextHolderUtils.getSession();
        FrontUserRegisterEntity user = (FrontUserRegisterEntity)session.getAttribute("currentUser");
        String userName = user.getUserName();
        if(StringUtil.isNotEmpty(userName)) {
          String bDate = request.getParameter("bTimeDate");
          String eDate = request.getParameter("eTimeDate");
          List<LogTradeInfoEntity> logTradeInfos = logTradeInfoServiceI.getTradesByUserName(userName, bDate, eDate);
          request.setAttribute("logTradeInfos", logTradeInfos);
        }

        return new ModelAndView("smp/order/tradeDetailMain");
    }

    /**
	 * 注入资金订单表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "toInjectList")
	public ModelAndView toInjectList(HttpServletRequest request) {
		return new ModelAndView("smp/order/injectListMain");
	}

    /**
     * 注入资金订单表列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "toTeamList")
    public ModelAndView toTeamList(HttpServletRequest request) {
		//会员列表
		HttpSession session = ContextHolderUtils.getSession();
		FrontUserRegisterEntity user = (FrontUserRegisterEntity)session.getAttribute("currentUser");
		List<FrontUserRegisterEntity> childUsers = frontUserRegisterServiceI.getChildUserByIntro(user.getUserName());
		StringBuffer us = new StringBuffer();
		StringBuffer usquery = new StringBuffer();
		us.append(user.getUserName() + ",");
		usquery.append("'" + user.getUserName() + "',");
		if(childUsers != null && childUsers.size()>0) {
			for (int i=0; i<childUsers.size(); i++) {
				FrontUserRegisterEntity userRegister = childUsers.get(i);
				us.append(userRegister.getUserName() + ",");
				usquery.append("'" +userRegister.getUserName() + "',");
			}
		}
		String users = us.toString();
		String usersquery = usquery.toString();
		if(StringUtil.isNotEmpty(users)) {
			users = users.substring(0, users.length()-1);
			usersquery = usersquery.substring(0, usersquery.length()-1);
		}
		String uname = (String)request.getParameter("un");
		//会员订单列表
		try {
			List<OrderInjectInfoEntity> orders = null;
			if(StringUtil.isNotEmpty(uname)) {
				orders = orderInjectInfoService.getListByUsers("'" + uname + "'");
			} else  {
				orders = orderInjectInfoService.getListByUsers(usersquery);
			}

			request.setAttribute("users", users);
			request.setAttribute("orders", orders);
		}catch (Exception e) {

		}

        return new ModelAndView("smp/order/teamListMain");
    }

	/**
	 * 生成订单
	 *
	 * @return
	 */
	@RequestMapping(params = "generalOrder")
	@ResponseBody
	public AjaxJson generalOrder(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注入资金订单添加成功";
		double priceD = 0.0;
		String price = request.getParameter("price");
		String randCode = request.getParameter("code");
		String safePwd = request.getParameter("threePwin");
		String userName = request.getParameter("inUserName");
		HttpSession session = ContextHolderUtils.getSession();

		if(StringUtil.isNotEmpty(price)) {
			priceD = Double.parseDouble(price);
		}
		try{
			String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
			FrontUserRegisterEntity userRegister = frontUserRegisterServiceI.queryEntityByUserName(userName);
			String baseLimit = tsIndexServiceI.getBaseLimit();
			String baseTimes = tsIndexServiceI.getBaseTimes();
			double baseLimitD = Double.parseDouble(baseLimit);
			double baseTimesD = Double.parseDouble(baseTimes);

			List<OrderInjectInfoEntity> injectInfos = orderInjectInfoService.getListByUser(userName);
			//有首付款\尾款未支付完成的订单,请完成后再次注入资金
			List<OrderInjectInfoEntity> unPayList = orderInjectInfoService.getListByUndonePay(userName);
			//在保存期内才可以注入资金
			List<OrderInjectInfoEntity> saveList = orderInjectInfoService.getListByUndoneSave(userName);
			//是否已注入第一单
			List<OrderInjectInfoEntity> firstList = orderInjectInfoService.getListByFirst(userName);
			boolean hasFirst = false;
			if(firstList != null && firstList.size()>0) {
				hasFirst = true;
			}
			FrontUserMemberEntity userMemberEntity = frontUserMemberServiceI.queryEntityByUserName(userName);

			//是否有未提取的订单
			String walletType = getOrderWallet(userName);
			boolean hasDF = false;
			boolean hasBX = false;
			if("1".equals(walletType) && hasFirst && !"1".equals(userMemberEntity.getVfield1())) { //待返钱包订单
				hasDF = true;
			}
			if("2".equals(walletType) && hasFirst && "1".equals(userMemberEntity.getVfield1())) { //本息钱包订单
				hasBX = true;
			}

			if(unPayList != null && unPayList.size()>0) {
				j.setMsg("有首付款或尾款未支付完成的订单,请完成后再注入资金!");
				j.setSuccess(false);
			} else if("0".equals(walletType)) {
				j.setMsg("有待返钱包和本息钱包的未完成的订单,请完成后再次注入资金!");
				j.setSuccess(false);
			} else if(hasDF) {
				j.setMsg("有待返钱包未提取,请先提取后再注入资金!");
				j.setSuccess(false);
			} else if(hasBX) {
				j.setMsg("有本息钱包或直推钱包未提取,请先提取后再注入资金!");
				j.setSuccess(false);
			} else if (StringUtils.isEmpty(randCode)) {
				j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
				j.setSuccess(false);
			} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
				j.setMsg(mutiLangService.getLang("common.verifycode.error"));
				j.setSuccess(false);
			} else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
				j.setMsg("安全密码错误,请确认!");
				j.setSuccess(false);
			} else if(priceD%baseTimesD >0 || priceD == 0){
				j.setMsg("注入资金必须是"+baseTimes+"的倍数");
				j.setSuccess(false);
			} else if(priceD>baseLimitD){
				j.setMsg("注入资金不能超过"+baseLimit+"的限额");
				j.setSuccess(false);
			} else {
				double firstPay = 0.0;
				double firstPayRatio = 90;
				//配置的首付比例
				TSConfigcodeEntity tsConfigcodeEntity = tSConfigcodeServiceI.getConfigValue(OrderConstant.Sys_First_PayRatio);
				if(tsConfigcodeEntity != null) {
					String firstPayRatioS = tsConfigcodeEntity.getConfigValue();
					if(StringUtil.isNotEmpty(firstPayRatioS)) {
						firstPayRatio = Double.parseDouble(firstPayRatioS);
					}
				}
				//计算首付比例
				firstPay = firstPayRatio * priceD / 100.00;
				Date now = new Date();
				MakeOrderNum orderNum = new MakeOrderNum();
				OrderInjectInfoEntity orderInjectInfo = new OrderInjectInfoEntity();
				orderInjectInfo.setUsername(userName);
				orderInjectInfo.setOrderCode(orderNum.makeOrderNum("P"));
				orderInjectInfo.setOrderMoney(priceD);
				orderInjectInfo.setOrderStatus(OrderConstant.Order_First_Pay); //产生订单,待支付首付款
				orderInjectInfo.setOrderTime(now);
				orderInjectInfo.setInterest(0.0); //应得利息
				orderInjectInfo.setFirstPay(firstPay); //首付款金额
				orderInjectInfo.setEndPay(priceD-firstPay);
				orderInjectInfo.setFirstEndInternal(tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_First) != null ?
						tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_First).getConfigValue():"5"); //收付款区间时间(小时)
				orderInjectInfo.setSaveInternal(
						tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Save) != null ?
								tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Save).getConfigValue():"5"
				);
				orderInjectInfo.setRestRate(
						tSConfigcodeServiceI.getConfigValue(OrderConstant.Rest_Rate) != null ?
								Double.parseDouble(tSConfigcodeServiceI.getConfigValue(OrderConstant.Rest_Rate).getConfigValue()): 1.0
						); //利息比例为1%
				orderInjectInfo.setWaitStartTime(now);
				String inter = tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Cycle) != null ?
						tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Cycle).getConfigValue():"480";
				orderInjectInfo.setWaitInternal(inter);
				if(inter != null) {

				}
				orderInjectInfo.setWaitEndTime(DateUtils.getDateAdd(Integer.parseInt(inter),now));
				orderInjectInfo.setInputtime(now);
				orderInjectInfo.setInserttimeforhis(now);
				orderInjectInfo.setOperatetimeforhis(now);

				orderInjectInfo.setVfield1(getOrderWallet(userName));
				if(injectInfos == null || injectInfos.size()==0) {
					orderInjectInfo.setVfield2("1"); //第一次订单
				}

				orderInjectInfoService.save(orderInjectInfo);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				j.setSuccess(true);
			}

		}catch (Exception e) {
			e.printStackTrace();
			message = "注入资金订单添加失败";
			j.setMsg(message);
			j.setSuccess(false);
//			throw new BusinessException(e.getMessage());
		}

		return j;
	}

	/**
	 * 获取当前订单注入的钱包
	 * @return
     */
	private String getOrderWallet(String userName) throws Exception{
		String walletType = "1"; //1-待返钱包 2-本息钱包
		//未完成的待返钱包
		List<OrderInjectInfoEntity> orderInBackList = orderInjectInfoService.getListByUndoneBack(userName);
		//未完成的本息钱包
		List<OrderInjectInfoEntity> orderInCouponList = orderInjectInfoService.getListByUndoneCoupon(userName);
		//有待返钱包未完成,再次注入时订单为本息钱包
		if(orderInBackList != null && orderInBackList.size()>0 && orderInCouponList != null &&
				orderInCouponList.size()>0) {
			return "0";
		}
		if(orderInBackList != null && orderInBackList.size()>0) {
			walletType = "2";
		} else if(orderInCouponList != null && orderInCouponList.size()>0) {
			walletType = "1";
		}
		return walletType;
	}

	/**
	 * 获取未完成的订单信息列表
	 *
	 * @return
	 */
	@RequestMapping(params = "getUdOrderList")
	@ResponseBody
	public AjaxJson getUnDoneOrderList(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		FrontUserRegisterEntity userRegisterEntity = ResourceUtil.getSessionFrontUser();
		try{
			if(userRegisterEntity == null) {
				throw new Exception("当前用户为空,请重新登录");
			}
			message = "获取订单列表成功";
			List<OrderInjectInfoEntity> orderInjectList = orderInjectInfoService.getUndoneList(userRegisterEntity.getUserName());
			j.setObj(orderInjectList);
			systemService.addLog(message, Globals.Log_Type_OTHER, Globals.Log_Leavel_INFO);
			j.setMsg(message);
		}catch (Exception e) {
			e.printStackTrace();
			message = "获取订单列表失败";
			throw new BusinessException(e.getMessage());
		}
		return j;
	}




	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(OrderInjectInfoEntity orderInjectInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OrderInjectInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, orderInjectInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.orderInjectInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除注入资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OrderInjectInfoEntity orderInjectInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		orderInjectInfo = systemService.getEntity(OrderInjectInfoEntity.class, orderInjectInfo.getId());
		message = "注入资金订单表删除成功";
		try{
			orderInjectInfoService.delete(orderInjectInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "注入资金订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除注入资金订单表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注入资金订单表删除成功";
		try{
			for(String id:ids.split(",")){
				OrderInjectInfoEntity orderInjectInfo = systemService.getEntity(OrderInjectInfoEntity.class, 
				id
				);
				orderInjectInfoService.delete(orderInjectInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "注入资金订单表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加注入资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OrderInjectInfoEntity orderInjectInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注入资金订单表添加成功";
		try{
			orderInjectInfoService.save(orderInjectInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "注入资金订单表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新注入资金订单表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OrderInjectInfoEntity orderInjectInfo, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注入资金订单表更新成功";
		OrderInjectInfoEntity t = orderInjectInfoService.get(OrderInjectInfoEntity.class, orderInjectInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(orderInjectInfo, t);
			orderInjectInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "注入资金订单表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 注入资金订单表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OrderInjectInfoEntity orderInjectInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(orderInjectInfo.getId())) {
			orderInjectInfo = orderInjectInfoService.getEntity(OrderInjectInfoEntity.class, orderInjectInfo.getId());
			req.setAttribute("orderInjectInfoPage", orderInjectInfo);
		}
		return new ModelAndView("/order/orderInjectInfo-add");
	}
	/**
	 * 注入资金订单表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OrderInjectInfoEntity orderInjectInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(orderInjectInfo.getId())) {
			orderInjectInfo = orderInjectInfoService.getEntity(OrderInjectInfoEntity.class, orderInjectInfo.getId());
			req.setAttribute("orderInjectInfoPage", orderInjectInfo);
		}
		return new ModelAndView("/order/orderInjectInfo-update");
	}

	/**
	 * 更新注入资金订单表
	 *
	 * @return
	 */
	@RequestMapping(params = "doCheckPay")
	@ResponseBody
	public AjaxJson doCheckPay( HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "支付款项前进行校验成功";
		try {
			String orderCode = request.getParameter("orderCode");
			String orderType = request.getParameter("orderType");
			FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();
			if(frontUser == null) {
				message = "用户登录超时,请重新登录!";
				j.setMsg(message);
				j.setSuccess(false);
			} else {
				String userName = frontUser.getUserName();
				List<OrderInjectInfoEntity>  orderInList = orderInjectInfoService.getListByOrderCode(orderCode, userName);
				OrderInjectInfoEntity orderInject = null;
				if(orderInList != null && orderInList.size()>0) {
					orderInject = orderInList.get(0);
				}
				if(orderInject == null) {
					message = "订单信息无效,请联系管理员!";
					j.setMsg(message);
					j.setSuccess(false);
				} else {
					if("1".equals(orderType)) {
						if(StringUtil.isNotEmpty(orderInject.getFirstPayTime())) { //支付首付款
							message = "订单首付款已支付,请刷新页面查看!";
							j.setMsg(message);
							j.setSuccess(false);
						} else {
							j.setMsg(message);
							j.setObj(orderInject.getFirstPay());
							j.setSuccess(true);
						}
					} else if("2".equals(orderType)) {
						if(StringUtil.isNotEmpty(orderInject.getEndPayTime())) { //支付尾款
							message = "订单尾款已支付,请刷新页面查看";
							j.setMsg(message);
							j.setSuccess(false);
						} else {
							j.setMsg(message);
							j.setObj(orderInject.getEndPay());
							j.setSuccess(true);
						}
					}
				}
			}
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "支付前校验异常,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 支付确认
	 *
	 * @return
	 */
	@RequestMapping(params = "doPayConfirm")
	@ResponseBody
	public AjaxJson doPayConfirm(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "订单支付成功";
		FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();
		if(frontUser == null) {
			message = "用户登录超时,请重新登录!";
			j.setMsg(message);
			j.setSuccess(false);
		}
		try {
			String orderCode = request.getParameter("payOrderCode");
			String orderType = request.getParameter("payOrderType");
			String userName = frontUser.getUserName();
			List<OrderInjectInfoEntity>  orderInList = orderInjectInfoService.getListByOrderCode(orderCode, userName);
			FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
			FrontUserMemberEntity userMemberParent = frontUserMemberServiceI.queryEntityByUserName(frontUser.getIntroducer());

			OrderInjectInfoEntity orderInject = null;
			if(orderInList != null && orderInList.size()>0) {
				orderInject = orderInList.get(0);
			}
			if(orderInject == null) {
				message = "订单信息无效,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else {
				if("1".equals(orderType)) {
					if(StringUtil.isNotEmpty(orderInject.getFirstPayTime())) { //支付首付款
						message = "订单首付款已支付,请刷新页面查看!";
						j.setMsg(message);
						j.setSuccess(false);
					} else {
						orderInject.setFirstPayTime(new Date());
						orderInject.setOrderStatus(OrderConstant.Order_Final_Pay);
						orderInjectInfoService.save(orderInject); //保存
                        // 生成财务交易信息
                        LogTradeInfoEntity logTradeInfo = new LogTradeInfoEntity();
                        logTradeInfo.setUsername(userName);
                        logTradeInfo.setSerialno("1");
                        logTradeInfo.setOrderCode(orderInject.getOrderCode());
                        logTradeInfo.setStaticMoney(orderInject.getFirstPay()); //注入支付金额
                        logTradeInfo.setDynMoney(0.00); // 利息金额
                        logTradeInfo.setBackMoney(0.00);  // 提出金额
                        logTradeInfo.setReleaseMoney(0.00); // 直推金额
                        logTradeInfo.setTradeTime(new Date());
                        if("1".equals(orderInject.getVfield1())) {
                            logTradeInfo.setReason("1-首付款支付");
                        } else {
                            logTradeInfo.setReason("2-首付款支付");
                        }
                        logTradeInfo.setRemark("");
                        logTradeInfo.setInputtime(new Date());
                        logTradeInfo.setInserttimeforhis(new Date());
                        logTradeInfo.setOperatetimeforhis(new Date());
                        logTradeInfoServiceI.save(logTradeInfo);

						j.setMsg(message);
						j.setObj(orderInject.getFirstPay());
						j.setSuccess(true);
					}
				} else if("2".equals(orderType)) {
					if(StringUtil.isNotEmpty(orderInject.getEndPayTime())) { //支付尾款
						message = "订单尾款已支付,请刷新页面查看";
						j.setMsg(message);
						j.setSuccess(false);
					} else {
						orderInject.setEndPayTime(new Date());
						orderInject.setOrderStatus(OrderConstant.Order_Confirm_Period);

                        // 生成财务交易信息
                        LogTradeInfoEntity logTradeInfo = new LogTradeInfoEntity();
                        logTradeInfo.setUsername(userName);
                        logTradeInfo.setSerialno("1");
                        logTradeInfo.setOrderCode(orderInject.getOrderCode());
                        logTradeInfo.setStaticMoney(orderInject.getEndPay()); //注入支付金额
                        logTradeInfo.setDynMoney(0.00); // 利息金额
                        logTradeInfo.setBackMoney(0.00);  // 提出金额
                        logTradeInfo.setReleaseMoney(0.00); // 直推金额
                        logTradeInfo.setTradeTime(new Date());
                        if("1".equals(orderInject.getVfield1())) {
                            logTradeInfo.setReason("1-尾款支付");
                        } else {
                            logTradeInfo.setReason("2-尾款支付");
                        }
                        logTradeInfo.setRemark("");
                        logTradeInfo.setInputtime(new Date());
                        logTradeInfo.setInserttimeforhis(new Date());
                        logTradeInfo.setOperatetimeforhis(new Date());
                        logTradeInfoServiceI.save(logTradeInfo);

						if(userMemberParent != null) {
							String userLevel = userMemberParent.getUserLevel();
							int tiquRate = 0;
							if("1".equals(userLevel)) {
								tiquRate = 1;
							}
							if("2".equals(userLevel)) {
								tiquRate = 3;
							}
							if("3".equals(userLevel)) {
								tiquRate = 5;
							}
							if("4".equals(userLevel)) {
								tiquRate = 8;
							}
							userMemberParent.setIntroWallet(userMemberParent.getIntroWallet() + (tiquRate * orderInject.getOrderMoney()/100));
							frontUserMemberServiceI.saveOrUpdate(userMemberParent);

                            // 生成财务交易信息
                            LogTradeInfoEntity logTradeInfo2 = new LogTradeInfoEntity();
                            logTradeInfo2.setUsername(userMemberParent.getUsername());
                            logTradeInfo2.setSerialno("1");
                            logTradeInfo2.setOrderCode(orderInject.getOrderCode());
                            logTradeInfo2.setStaticMoney(0.00); //注入支付金额
                            logTradeInfo2.setDynMoney(0.00); // 利息金额
                            logTradeInfo2.setBackMoney(0.00);  // 提出金额
                            logTradeInfo2.setReleaseMoney(tiquRate * orderInject.getOrderMoney()/100); // 直推金额
                            logTradeInfo2.setTradeTime(new Date());
                            if("1".equals(orderInject.getVfield1())) {
                                logTradeInfo2.setReason("1-直推提奖金额");
                            } else {
                                logTradeInfo2.setReason("2-直推提奖金额");
                            }
                            logTradeInfo2.setRemark("");
                            logTradeInfo2.setInputtime(new Date());
                            logTradeInfo2.setInserttimeforhis(new Date());
                            logTradeInfo2.setOperatetimeforhis(new Date());
                            logTradeInfoServiceI.save(logTradeInfo2);
						}

						orderInjectInfoService.save(orderInject); //保存
						j.setMsg(message);
						j.setObj(orderInject.getEndPay());
						j.setSuccess(true);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "支付系统出现异常,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}

		return j;
	}

	/**
	 * 转存到钱包中
	 *
	 * @return
	 */
	@RequestMapping(params = "saveInWl")
	@ResponseBody
	public AjaxJson saveInWallet(HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "转出到钱包完成";
		FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();
		if(frontUser == null) {
			message = "用户登录超时,请重新登录!";
			j.setMsg(message);
			j.setSuccess(false);
			return j;
		}
		String userName = frontUser.getUserName();
		FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
		if(userMember == null) {
			message = "用户状态异常,请联系管理员!";
			j.setMsg(message);
			j.setSuccess(false);
			return j;
		}
		try {
			String orderCode = request.getParameter("payOrderCode");
			String orderType = null;
			List<OrderInjectInfoEntity>  orderInList = orderInjectInfoService.getListByOrderCode(orderCode, userName);
			OrderInjectInfoEntity orderInject = null;
			if(orderInList != null && orderInList.size()>0) {
				orderInject = orderInList.get(0);
			}
			if(orderInject == null) {
				message = "订单信息无效,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else {
				orderType = orderInject.getVfield1();
				if("1".equals(orderType) || "2".equals(orderType)) {
					if(StringUtil.isNotEmpty(orderInject.getDfield1())) { //提现时间
						message = "订单已进行过提现,请刷新页面查看!";
						j.setMsg(message);
						j.setSuccess(false);
					} else {
						orderInjectInfoService.doSaveInWallet(orderInject, userMember);
						j.setMsg(message);
						j.setSuccess(true);
					}
				} else {
					message = "订单异常,请联系管理员!";
					j.setMsg(message);
					j.setSuccess(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "提现系统出现异常,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
			//throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","orderInjectInfoController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(OrderInjectInfoEntity orderInjectInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(OrderInjectInfoEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, orderInjectInfo, request.getParameterMap());
		List<OrderInjectInfoEntity> orderInjectInfos = this.orderInjectInfoService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"注入资金订单表");
		modelMap.put(NormalExcelConstants.CLASS,OrderInjectInfoEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注入资金订单表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,orderInjectInfos);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(OrderInjectInfoEntity orderInjectInfo,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"注入资金订单表");
    	modelMap.put(NormalExcelConstants.CLASS,OrderInjectInfoEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注入资金订单表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<OrderInjectInfoEntity> listOrderInjectInfoEntitys = ExcelImportUtil.importExcel(file.getInputStream(),OrderInjectInfoEntity.class,params);
				for (OrderInjectInfoEntity orderInjectInfo : listOrderInjectInfoEntitys) {
					orderInjectInfoService.save(orderInjectInfo);
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
	public List<OrderInjectInfoEntity> list() {
		List<OrderInjectInfoEntity> listOrderInjectInfos=orderInjectInfoService.getList(OrderInjectInfoEntity.class);
		return listOrderInjectInfos;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		OrderInjectInfoEntity task = orderInjectInfoService.get(OrderInjectInfoEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody OrderInjectInfoEntity orderInjectInfo, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderInjectInfoEntity>> failures = validator.validate(orderInjectInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			orderInjectInfoService.save(orderInjectInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = orderInjectInfo.getId();
		URI uri = uriBuilder.path("/rest/orderInjectInfoController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody OrderInjectInfoEntity orderInjectInfo) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<OrderInjectInfoEntity>> failures = validator.validate(orderInjectInfo);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			orderInjectInfoService.saveOrUpdate(orderInjectInfo);
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
		orderInjectInfoService.deleteEntityById(OrderInjectInfoEntity.class, id);
	}
}
