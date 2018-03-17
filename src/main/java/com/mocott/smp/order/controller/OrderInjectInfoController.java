package com.mocott.smp.order.controller;
import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.base.service.TSIndexServiceI;
import com.mocott.smp.log.entity.LogPayInfoEntity;
import com.mocott.smp.log.entity.LogTradeInfoEntity;
import com.mocott.smp.log.service.LogPayInfoServiceI;
import com.mocott.smp.log.service.LogTradeInfoServiceI;
import com.mocott.smp.order.entity.OrderInjectInfoEntity;
import com.mocott.smp.order.model.OrderInInfo;
import com.mocott.smp.order.service.OrderInjectInfoServiceI;

import java.math.BigDecimal;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.order.service.OrderInjectServiceI;
import com.mocott.smp.trade.entity.UsdtPriceEntity;
import com.mocott.smp.trade.entity.UserUsdtInfoEntity;
import com.mocott.smp.trade.service.UsdtPriceServiceI;
import com.mocott.smp.trade.service.UserUsdtInfoServiceI;
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

	@Autowired
	private OrderInjectServiceI orderInjectService;
	@Autowired
    private UserUsdtInfoServiceI userUsdtInfoService;
	@Autowired
    private UsdtPriceServiceI usdtPriceService;
	@Autowired
    private LogPayInfoServiceI logPayInfoService;

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
        //会员列表
        HttpSession session = ContextHolderUtils.getSession();
        FrontUserRegisterEntity user = (FrontUserRegisterEntity)session.getAttribute("currentUser");
        List<OrderInjectInfoEntity> inlistAll = null;
        try {
            inlistAll = orderInjectInfoService.getListByUser(user.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("inlistAll", inlistAll);
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
		String price = request.getParameter("price"); //注入金额
		String randCode = request.getParameter("code"); //验证码
		String safePwd = request.getParameter("threePwin"); //安全密码
		String userName = request.getParameter("inUserName"); //用户名
		FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();

		HttpSession session = ContextHolderUtils.getSession();
		if(StringUtil.isNotEmpty(price)) {
			priceD = Double.parseDouble(price);
		}
		try{
			String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
			FrontUserRegisterEntity userRegister = frontUserRegisterServiceI.queryEntityByUserName(userName);
			FrontUserMemberEntity userMemberEntity = frontUserMemberServiceI.queryEntityByUserName(userName);

			String baseLimit = tsIndexServiceI.getBaseLimit(); //限额
			String baseTimes = tsIndexServiceI.getBaseTimes(); //基础倍数
			double baseLimitD = Double.parseDouble(baseLimit);
			double baseTimesD = Double.parseDouble(baseTimes);
			double baseValue = userMemberEntity.getNfield1(); //第一次注入金额

            double sumLimit = userMemberEntity.getSumLimit(); //总限额
            double useLimit = userMemberEntity.getUseLimit(); //已使用限额

			//用户订单列表
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

			//是否有未提取的订单
			String walletType = orderInjectService.getOrderWallet(userName);
			//上一张订单的类型(0-没有订单或上一次是第一张注入订单,1-注入订单,2-提取订单)
			String lastOrderType = orderInjectService.getLastOrderType(userName);
			boolean hasTQ = false;
			if("1".equals(lastOrderType)) { //有钱包金额未提取
				hasTQ = true;
			}
			if(frontUser == null || !frontUser.getUserName().equals(userName)) {
				j.setMsg("登录用户信息异常,请重新登录!");
				j.setSuccess(false);
			} else if(unPayList != null && unPayList.size()>0) {
				j.setMsg("有首付款或尾款未支付完成的订单,请等待完成后再注入资金!");
				j.setSuccess(false);
			} else if(hasTQ) {
				j.setMsg("有钱包金额未提取,请先提取后再进行注入资金!");
				j.setSuccess(false);
			} else if (StringUtils.isEmpty(randCode)) {
				j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
				j.setSuccess(false);
			} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
				j.setMsg(mutiLangService.getLang("common.verifycode.error"));
				j.setSuccess(false);
			} else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
				j.setMsg("您输入的安全密码错误,请确认!");
				j.setSuccess(false);
			} else if(priceD%baseTimesD >0 || priceD == 0){
				j.setMsg("注入资金必须是"+baseTimes+"的倍数");
				j.setSuccess(false);
			} else if(priceD>baseLimitD){
				j.setMsg("注入资金不能超过"+baseLimit+"的限额");
				j.setSuccess(false);
			} else if(baseValue >0 && baseValue != priceD) {
				j.setMsg("再次注入金额必须与第一笔订单保持一致,请确认!");
				j.setSuccess(false);
			} else if((sumLimit-useLimit)<priceD) {
                j.setMsg("您的账户的限额已不足,请联系客服购买激活码!");
                j.setSuccess(false);
            } else {
				// 生成订单
				OrderInInfo orderInInfo = new OrderInInfo();
				orderInInfo.setUsername(userName);
				orderInInfo.setOrderMoney(priceD);
				orderInjectService.generateOrder(orderInInfo);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				j.setSuccess(true);
			}

		}catch (Exception e) {
			e.printStackTrace();
			message = "注入资金订单添加失败";
			j.setMsg(message);
			j.setSuccess(false);
		}

		return j;
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
                UserUsdtInfoEntity userUsdtInfoEntity=  userUsdtInfoService.queryUserUsdtByUserName(userName);
                UsdtPriceEntity usdtPrice = usdtPriceService.getNewPrice();
                double num = 0;
                double price = 0;
                double payNum = 0;
                if(userUsdtInfoEntity != null) {
                    num = userUsdtInfoEntity.getNum();
                }
                if(usdtPrice != null) {
                    price = usdtPrice.getPrice();
                }
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
                            double f1 = getPayNum(orderInject.getFirstPay(), price);
                            Map<String, Object> attrs = new HashMap<String, Object>();
                            attrs.put("payNum", f1);
                            attrs.put("price", price);
                            attrs.put("myNum", num);
						    j.setMsg(message);
							j.setObj(orderInject.getFirstPay());
							j.setAttributes(attrs);
							j.setSuccess(true);
						}
					} else if("2".equals(orderType)) {
						if(StringUtil.isNotEmpty(orderInject.getEndPayTime())) { //支付尾款
							message = "订单尾款已支付,请刷新页面查看";
							j.setMsg(message);
							j.setSuccess(false);
						} else {
                            double f1 = getPayNum(orderInject.getEndPay(), price);
                            Map<String, Object> attrs = new HashMap<String, Object>();
                            attrs.put("payNum", f1);
                            attrs.put("price", price);
                            attrs.put("myNum", num);
							j.setMsg(message);
							j.setObj(orderInject.getEndPay());
                            j.setAttributes(attrs);
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

	private double getPayNum(double payPrice, double price) {
        double payNum = payPrice/price;
        BigDecimal b = new BigDecimal(payNum);
        double f1 = b.setScale(3, BigDecimal.ROUND_UP).doubleValue();
        return f1;
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
			String payUsdtNum = request.getParameter("payUsdtNum");
			String payUsdtPrice = request.getParameter("payUsdtPrice");
			String myUsdtNum = request.getParameter("myUsdtNum");

			String userName = frontUser.getUserName();
			List<OrderInjectInfoEntity>  orderInList = orderInjectInfoService.getListByOrderCode(orderCode, userName);
			FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
			FrontUserMemberEntity userMemberParent = frontUserMemberServiceI.queryEntityByUserName(frontUser.getIntroducer());
            UserUsdtInfoEntity userUsdtInfoEntity=  userUsdtInfoService.queryUserUsdtByUserName(userName);
            UsdtPriceEntity usdtPrice = usdtPriceService.getNewPrice();
            double price = usdtPrice.getPrice();
            double mynum = userUsdtInfoEntity.getNum();

			OrderInjectInfoEntity orderInject = null;
			if(orderInList != null && orderInList.size()>0) {
				orderInject = orderInList.get(0);
			}
			if(orderInject == null) {
				message = "订单信息无效,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else if(StringUtil.isEmpty(payUsdtPrice) || Double.parseDouble(payUsdtPrice)!=price) {
                message = "USDT价格与最新USDT价格不一致，请刷新页面重试!";
                j.setMsg(message);
                j.setSuccess(false);
            } else {
				if("1".equals(orderType)) {
				    double f1 = getPayNum(orderInject.getFirstPay(), price);
				    if(mynum<f1) {
                        message = "您的USDT数量不足,请于交易中心买入!";
                        j.setMsg(message);
                        j.setSuccess(false);
                    } else if(StringUtil.isNotEmpty(orderInject.getFirstPayTime())) { //支付首付款
						message = "订单首付款已支付,请刷新页面查看!";
						j.setMsg(message);
                        j.setSuccess(false);
					} else {
						orderInject.setFirstPayTime(new Date());
						//更新周期时间
                        orderInject.setWaitStartTime(new Date()); //周期开始时间
                        String inter = tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Cycle) != null ?
                                tSConfigcodeServiceI.getConfigValue(OrderConstant.Period_Cycle).getConfigValue():"480";
                        orderInject.setWaitInternal(inter); //周期时间
                        if(inter != null) {
                            orderInject.setWaitEndTime(DateUtils.getDateAdd(Integer.parseInt(inter),orderInject.getWaitStartTime()));
                        }
						orderInject.setOrderStatus(OrderConstant.Order_Period_Finish); //进入周期中
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

                        userMember.setVfield2("1"); //可提取
                        frontUserMemberServiceI.saveOrUpdate(userMember);

                        // 支付信息记录
                        LogPayInfoEntity logPayInfoEntity = new LogPayInfoEntity();
                        logPayInfoEntity.setUsername(userName);
                        logPayInfoEntity.setSerialno("1");
                        logPayInfoEntity.setOrderCode(orderInject.getOrderCode());
                        logPayInfoEntity.setPayTime(new Date());
                        logPayInfoEntity.setPayMoney(f1);
                        logPayInfoEntity.setDealMoney(price);
                        logPayInfoEntity.setNfield1(mynum);
                        logPayInfoService.save(logPayInfoEntity);

                        userUsdtInfoEntity.setNum(userUsdtInfoEntity.getNum()-f1);
                        userUsdtInfoService.saveOrUpdate(userUsdtInfoEntity);
						j.setMsg(message);
						j.setObj(orderInject.getFirstPay());
						j.setSuccess(true);
					}
				} else if("2".equals(orderType)) {
                    double f1 = getPayNum(orderInject.getEndPay(), price);
                    if(mynum<f1) {
                        message = "您的USDT数量不足,请于交易中心买入!";
                        j.setMsg(message);
                        j.setSuccess(false);
                    } else if(StringUtil.isNotEmpty(orderInject.getEndPayTime())) { //支付尾款
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

						// 支付信息记录
                        LogPayInfoEntity logPayInfoEntity = new LogPayInfoEntity();
						logPayInfoEntity.setUsername(userName);
                        logPayInfoEntity.setSerialno("1");
                        logPayInfoEntity.setOrderCode(orderInject.getOrderCode());
                        logPayInfoEntity.setPayTime(new Date());
                        logPayInfoEntity.setPayMoney(f1);
                        logPayInfoEntity.setDealMoney(price);
                        logPayInfoEntity.setNfield1(mynum);
                        logPayInfoService.save(logPayInfoEntity);

						userUsdtInfoEntity.setNum(userUsdtInfoEntity.getNum()-f1);
						userUsdtInfoService.saveOrUpdate(userUsdtInfoEntity);
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
		try {
			FrontUserMemberEntity userMember = frontUserMemberServiceI.queryEntityByUserName(userName);
			if(userMember == null) {
				message = "用户状态异常,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
				return j;
			}
			String orderCode = request.getParameter("payOrderCode");
			String orderType = null;
			List<OrderInjectInfoEntity> undoneList = orderInjectInfoService.getUndoneList(userName);
            boolean hasUndoneOrder = false;
			if(undoneList != null && undoneList.size()>0) {
                if(undoneList.size() ==1 && undoneList.get(0).getOrderCode().equals(orderCode)) {
                } else {
                    hasUndoneOrder = true;
                }
            }

			List<OrderInjectInfoEntity>  orderInList = orderInjectInfoService.getListByOrderCode(orderCode, userName);
			OrderInjectInfoEntity orderInject = null;
			if(orderInList != null && orderInList.size()>0) {
				orderInject = orderInList.get(0);
			}
			if(orderInject == null) {
				message = "订单信息无效,请联系管理员!";
				j.setMsg(message);
				j.setSuccess(false);
			} else if(!hasUndoneOrder){
				message = "订单在保存期请先注入资金，否则会被封号!";
				j.setMsg(message);
				j.setSuccess(false);
			} else {
				if(StringUtil.isNotEmpty(orderInject.getDfield1())) { //提现时间
					message = "订单已转入到钱包,请刷新页面查看!";
					j.setMsg(message);
					j.setSuccess(false);
				} else {
					orderInjectService.doSaveInWallet(orderInject, userMember);
					j.setMsg(message);
					j.setSuccess(true);
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
