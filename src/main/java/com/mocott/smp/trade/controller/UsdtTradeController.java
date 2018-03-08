package com.mocott.smp.trade.controller;

import com.mocott.smp.trade.entity.UsdtTradeEntity;
import com.mocott.smp.trade.model.UsdtTradeInfo;
import com.mocott.smp.trade.service.UsdtTradeServiceI;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.*;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller  
 * @Description: USDT交易信息
 * @author onlineGenerator
 * @date 2018-03-08 00:52:14
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/usdtTradeController")
public class UsdtTradeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UsdtTradeController.class);

	@Autowired
	private UsdtTradeServiceI usdtTradeService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
    @Autowired
    private FrontUserRegisterServiceI frontUserRegisterService;

	/**
	 * USDT交易 页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "toTrade")
	public ModelAndView toTrade(HttpServletRequest request) {
		return new ModelAndView("smp/trade/tradeCenterMain");
	}


    /**
     * 买入usdt
     *
     * @return
     */
    @RequestMapping(params = "doBuy")
    @ResponseBody
    public AjaxJson doBuy(UsdtTradeInfo usdtTradeInfo, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "USDT买入成功";
        try{
            String safePwd = request.getParameter("buysafepwd"); //安全密码
            String buyprice = request.getParameter("buyprice"); //买入价格
            String buynum = request.getParameter("buynum"); //买入数量
            String buyfee = request.getParameter("buyfee"); //买入费用
            String buyfeerate = request.getParameter("buyfeerate"); //买入费用比例
            String buysumamount = request.getParameter("buysumamount"); //买入总金额
            String buyalipay = request.getParameter("buyalipay"); //买入支付宝账号
            String buybankcard = request.getParameter("buybankcard"); //买入银行卡账户

            FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();
            String userName = frontUser.getUserName();
            String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
            FrontUserRegisterEntity userRegister = frontUserRegisterService.queryEntityByUserName(userName);
            // 买入校验
            if(StringUtil.isEmpty(safePwd)) {
                message = "安全密码为空，请确认!";
                j.setSuccess(false);
            } else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
                j.setMsg("您输入的安全密码错误,请确认!");
                j.setSuccess(false);
            } else if(StringUtil.isNotEmpty(buynum) && Double.parseDouble(buynum)<= 0) {
                message = "买入数量为空或为零，请确认!";
                j.setSuccess(false);
            } else if(StringUtil.isNotEmpty(buyprice)) {
                message = "买入价格为空，请确认!";
                j.setSuccess(false);
            } else{
                usdtTradeService.saveBuy(usdtTradeInfo);
                j.setSuccess(true);
            }

            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        }catch(Exception e){
            e.printStackTrace();
            message = "USDT买入成功";
            j.setSuccess(false);
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

    /**
     * 卖出usdt
     *
     * @return
     */
    @RequestMapping(params = "doSale")
    @ResponseBody
    public AjaxJson doSale(UsdtTradeInfo usdtTradeInfo, HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        message = "USDT卖出申请成功，请等待处理";
        try{
            String safePwd = request.getParameter("salesafepwd"); //安全密码
            String saleprice = request.getParameter("saleprice"); //卖出价格
            String salenum = request.getParameter("salenum"); //卖出数量
            String salefee = request.getParameter("salefee"); //卖出费用
            String salefeerate = request.getParameter("salefeerate"); //卖出费用比例
            String salesumamount = request.getParameter("salesumamount"); //卖出总金额
            String saledrawurl = request.getParameter(""); //提出地址

            FrontUserRegisterEntity frontUser = ResourceUtil.getSessionFrontUser();
            String userName = frontUser.getUserName();
            String pSaftString = PasswordUtil.encrypt(userName, safePwd, PasswordUtil.getStaticSalt());
            FrontUserRegisterEntity userRegister = frontUserRegisterService.queryEntityByUserName(userName);
            // 买入校验
            if(StringUtil.isEmpty(safePwd)) {
                message = "安全密码为空，请确认!";
                j.setSuccess(false);
            } else if (userRegister != null && !pSaftString.equals(userRegister.getSafePassword())) {
                j.setMsg("您输入的安全密码错误,请确认!");
                j.setSuccess(false);
            } else if(StringUtil.isNotEmpty(salenum) && Double.parseDouble(salenum)<= 0) {
                message = "买入数量为空或为零，请确认!";
                j.setSuccess(false);
            } else if(StringUtil.isNotEmpty(saleprice)) {
                message = "买入价格为空，请确认!";
                j.setSuccess(false);
            } else{
                usdtTradeService.saveBuy(usdtTradeInfo);
                j.setSuccess(true);
            }

            systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
        }catch(Exception e){
            e.printStackTrace();
            message = "USDT卖出申请失败，请稍后重试或联系客服!";
            j.setSuccess(false);
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }

	/**
	 * USDT交易信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("/smp/usdtTradeList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(UsdtTradeEntity usdtTrade, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(UsdtTradeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, usdtTrade, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.usdtTradeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除USDT交易信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(UsdtTradeEntity usdtTrade, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		usdtTrade = systemService.getEntity(UsdtTradeEntity.class, usdtTrade.getId());
		message = "USDT交易信息删除成功";
		try{
			usdtTradeService.delete(usdtTrade);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "USDT交易信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除USDT交易信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "USDT交易信息删除成功";
		try{
			for(String id:ids.split(",")){
				UsdtTradeEntity usdtTrade = systemService.getEntity(UsdtTradeEntity.class, 
				id
				);
				usdtTradeService.delete(usdtTrade);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "USDT交易信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加USDT交易信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(UsdtTradeEntity usdtTrade, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "USDT交易信息添加成功";
		try{
			usdtTradeService.save(usdtTrade);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "USDT交易信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新USDT交易信息
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(UsdtTradeEntity usdtTrade, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "USDT交易信息更新成功";
		UsdtTradeEntity t = usdtTradeService.get(UsdtTradeEntity.class, usdtTrade.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(usdtTrade, t);
			usdtTradeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "USDT交易信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * USDT交易信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(UsdtTradeEntity usdtTrade, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(usdtTrade.getId())) {
			usdtTrade = usdtTradeService.getEntity(UsdtTradeEntity.class, usdtTrade.getId());
			req.setAttribute("usdtTradePage", usdtTrade);
		}
		return new ModelAndView("/smp/usdtTrade-add");
	}
	/**
	 * USDT交易信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(UsdtTradeEntity usdtTrade, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(usdtTrade.getId())) {
			usdtTrade = usdtTradeService.getEntity(UsdtTradeEntity.class, usdtTrade.getId());
			req.setAttribute("usdtTradePage", usdtTrade);
		}
		return new ModelAndView("/smp/usdtTrade-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","usdtTradeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(UsdtTradeEntity usdtTrade,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(UsdtTradeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, usdtTrade, request.getParameterMap());
		List<UsdtTradeEntity> usdtTrades = this.usdtTradeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"USDT交易信息");
		modelMap.put(NormalExcelConstants.CLASS,UsdtTradeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("USDT交易信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,usdtTrades);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(UsdtTradeEntity usdtTrade,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"USDT交易信息");
    	modelMap.put(NormalExcelConstants.CLASS,UsdtTradeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("USDT交易信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<UsdtTradeEntity> listUsdtTradeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),UsdtTradeEntity.class,params);
				for (UsdtTradeEntity usdtTrade : listUsdtTradeEntitys) {
					usdtTradeService.save(usdtTrade);
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
	public List<UsdtTradeEntity> list() {
		List<UsdtTradeEntity> listUsdtTrades=usdtTradeService.getList(UsdtTradeEntity.class);
		return listUsdtTrades;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		UsdtTradeEntity task = usdtTradeService.get(UsdtTradeEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody UsdtTradeEntity usdtTrade, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UsdtTradeEntity>> failures = validator.validate(usdtTrade);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			usdtTradeService.save(usdtTrade);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = usdtTrade.getId();
		URI uri = uriBuilder.path("/rest/usdtTradeController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody UsdtTradeEntity usdtTrade) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UsdtTradeEntity>> failures = validator.validate(usdtTrade);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			usdtTradeService.saveOrUpdate(usdtTrade);
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
		usdtTradeService.deleteEntityById(UsdtTradeEntity.class, id);
	}
}
