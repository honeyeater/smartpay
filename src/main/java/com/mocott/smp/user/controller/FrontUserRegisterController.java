package com.mocott.smp.user.controller;
import com.mocott.smp.base.entity.FrontVerifyCodeEntity;
import com.mocott.smp.base.entity.TSConfigcodeEntity;
import com.mocott.smp.base.service.FrontVerifyCodeServiceI;
import com.mocott.smp.base.service.TSConfigcodeServiceI;
import com.mocott.smp.user.entity.FrontUserMemberEntity;
import com.mocott.smp.user.entity.FrontUserRegisterEntity;
import com.mocott.smp.user.service.FrontUserMemberServiceI;
import com.mocott.smp.user.service.FrontUserRegisterServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mocott.smp.util.OrderConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.jeecgframework.core.util.*;
import org.jeecgframework.web.system.manager.FrontClientManager;
import org.jeecgframework.web.system.pojo.base.FrontClient;
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
 * @Description: 注册用户信息表
 * @author onlineGenerator
 * @date 2018-01-23 11:02:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/frontUserRegisterController")
public class FrontUserRegisterController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(FrontUserRegisterController.class);

	@Autowired
	private FrontUserRegisterServiceI frontUserRegisterService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	private MutiLangServiceI mutiLangService;
	@Autowired
	private FrontVerifyCodeServiceI frontVerifyCodeService;
	@Autowired
	private TSConfigcodeServiceI tsConfigcodeServiceI;
	@Autowired
	private FrontUserMemberServiceI frontUserMemberServiceI;

    /**
     * 用户注册页面跳转
     *
     * @return
     */
    @RequestMapping(params = "register")
    public ModelAndView register(HttpServletRequest request) {
        String parentId = (String) request.getParameter("t");
        FrontUserRegisterEntity userRegisterEntity = null;
        if(StringUtil.isNotEmpty(parentId)) {
            userRegisterEntity = frontUserRegisterService.getEntity(FrontUserRegisterEntity.class, parentId);
        }
        if(userRegisterEntity == null) {
            return new ModelAndView("/smp/user/userNotExist");
        }
        request.setAttribute("userPage", userRegisterEntity);

        return new ModelAndView("/smp/user/frontUserRegister");
    }

    /**
     * 修改密码页面调整
     *
     * @return
     */
    @RequestMapping(params = "updatepwd")
    public ModelAndView updatepwd(HttpServletRequest request) {
        return new ModelAndView("smp/user/updatepwdMain");
    }



    /**
     * 推广链接页面
     *
     * @return
     */
    @RequestMapping(params = "tousergeneral")
    public ModelAndView tousergeneral(HttpServletRequest request) {
        // 获取推广的链接地址
        FrontClient client = FrontClientManager.getInstance().getClient();
        FrontUserRegisterEntity user = null;
        if(client != null) {
            user = client.getUser();
        }
        if(user != null) {
            String prefix = ResourceUtil.getConfigByName("commenturl.prefix");
            request.setAttribute("commentUrl", prefix + user.getId());
        }

        return new ModelAndView("smp/user/userRegisterMain");
    }

    /**
     * 会员信息表列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "gouserinfo")
    public ModelAndView gouserinfo(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		FrontUserRegisterEntity userInfo = (FrontUserRegisterEntity)session.getAttribute("currentUser");
		request.setAttribute("userinfo", userInfo);

        return new ModelAndView("smp/user/userInfoMain");
    }


    /**
	 * 注册用户信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("/user/frontUserRegisterList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */;

	@RequestMapping(params = "datagrid")
	public void datagrid(FrontUserRegisterEntity frontUserRegister,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(FrontUserRegisterEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, frontUserRegister, request.getParameterMap());
        try{
            //自定义追加查询条件
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.frontUserRegisterService.getDataGridReturn(cq, true);
        TagUtil.datagrid(response, dataGrid);
    }

    /**
     * 生成用户名
     *
     * @return
     */
    @RequestMapping(params = "generateUN")
    @ResponseBody
    public AjaxJson generateUN(HttpServletRequest request) {
        String message = null;
        AjaxJson j = new AjaxJson();
        try{
            String userNamePrefix = ResourceUtil.getConfigByName("username.prefix");
            int endTail = (int)(Math.random()*1000000000);
            String newUserName = userNamePrefix+endTail;
            while(hasExistUserName(newUserName)) {
                newUserName = userNamePrefix + (int)Math.random()*10;
            }
            j.setObj(newUserName);
            message = "生成新用户名成功";
            systemService.addLog(message, Globals.Log_Type_OTHER, Globals.Log_Leavel_INFO);
        }catch(Exception e){
            e.printStackTrace();
            message = "生成新用户名失败，请重试";
            throw new BusinessException(e.getMessage());
        }
        j.setMsg(message);
        return j;
    }


    /**
     * 用户名是否已存在
     * @param userName
     * @return
     */
    private boolean hasExistUserName(String userName) {
        FrontUserRegisterEntity userRegisterEntity = frontUserRegisterService.queryEntityByUserName(userName);
        if(userRegisterEntity != null )  {
            return true;
        }
        return false;
    }


    /**
	 * 删除注册用户信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(FrontUserRegisterEntity frontUserRegister, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		frontUserRegister = systemService.getEntity(FrontUserRegisterEntity.class, frontUserRegister.getId());
		message = "注册用户信息表删除成功";
		try{
			frontUserRegisterService.delete(frontUserRegister);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "注册用户信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除注册用户信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "注册用户信息表删除成功";
		try{
			for(String id:ids.split(",")){
				FrontUserRegisterEntity frontUserRegister = systemService.getEntity(FrontUserRegisterEntity.class, 
				id
				);
				frontUserRegisterService.delete(frontUserRegister);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "注册用户信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加注册用户信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(FrontUserRegisterEntity frontUserRegister, HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户注册成功请进行登录";
		try{
			String randCode = request.getParameter("validCode"); //验证码
			String phoneValidCode = request.getParameter("phoneValidCode"); //短信验证码
			String phoneNo = request.getParameter("phoneno"); //手机号
			String idNo = request.getParameter("identityNo"); //身份证号
			//验证码验证
			//短信验证码验证
			//身份证号验证
			FrontVerifyCodeEntity fvc = getHasValid(phoneValidCode, "1", phoneNo);
			FrontUserRegisterEntity user = frontUserRegisterService.queryEntityByUserName(frontUserRegister.getUserName());
			if (StringUtils.isEmpty(randCode)) {
				j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
				j.setSuccess(false);
			} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
				j.setMsg(mutiLangService.getLang("common.verifycode.error"));
				j.setSuccess(false);
			} else if (hasRegister(idNo)) {
				j.setMsg("此身份证号已注册,不能重复注册!");
				j.setSuccess(false);
			} else if (hasPhoneNoRegister(phoneNo)) {
				j.setMsg("此手机号已注册,不能重复注册!");
				j.setSuccess(false);
			} else if (fvc == null) {
				j.setMsg("短信验证码错误或已失效,请重试!");
				j.setSuccess(false);
			} else if(user != null) {
				j.setMsg("此用户名已存在,请重新生成!");
				j.setSuccess(false);
			} else {
				String pString = PasswordUtil.encrypt(frontUserRegister.getUserName(), frontUserRegister.getPassword(), PasswordUtil.getStaticSalt());
				String pSafeString = PasswordUtil.encrypt(frontUserRegister.getUserName(), frontUserRegister.getSafePassword(), PasswordUtil.getStaticSalt());
				frontUserRegister.setVfield1(frontUserRegister.getPassword());
				frontUserRegister.setVfield2(frontUserRegister.getSafePassword());
				frontUserRegister.setPassword(pString);
				frontUserRegister.setSafePassword(pSafeString);
				frontUserRegister.setRegisterTime(new Date()); //注册时间
				frontUserRegister.setRegisterIp(IpUtil.getIpAddr(request)); //注册IP地址
				frontUserRegister.setValidFlag("1");
				frontUserRegister.setUserLevel("1");
				Date now = new Date();
				frontUserRegister.setInputtime(now);
				frontUserRegister.setInserttimeforhis(now);
				frontUserRegister.setOperatetimeforhis(now);

				FrontUserMemberEntity frontUserMember = new FrontUserMemberEntity();
				frontUserMember.setUsername(frontUserRegister.getUserName());
				frontUserMember.setUserLevel(frontUserRegister.getUserLevel());
				frontUserMember.setSumAmount(0.00);
				frontUserMember.setIntroNums("0");
				frontUserMember.setTeamNums("0");
				frontUserMember.setCouponWallet(0.00);
				frontUserMember.setIntroWallet(0.00);
				frontUserMember.setBlockWallet(0.00);
				frontUserMember.setRedWallet(0.00);
				frontUserMember.setBackWallet(0.00);
				frontUserMember.setActiveCost(0.00);
				TSConfigcodeEntity tsConfigcode =  tsConfigcodeServiceI.getConfigValue(OrderConstant.Sum_Limit);
				String sumLimit = "10000000";
				if(tsConfigcode != null) {
					sumLimit = tsConfigcode.getConfigValue();
				}
				frontUserMember.setSumLimit(Double.parseDouble(sumLimit));
				frontUserMember.setUseLimit(0.00);
				frontUserMember.setInputtime(now);
				frontUserMember.setInserttimeforhis(now);
				frontUserMember.setOperatetimeforhis(now);
				frontUserMember.setNfield1(0.00); //第一次注入金额

				List<FrontUserRegisterEntity> parentUsers = frontUserRegisterService.queryParentEntity(frontUserRegister.getIntroducer());
				if(parentUsers != null && parentUsers.size()>0) {
					for (int i=0; i< parentUsers.size(); i++) {
						FrontUserRegisterEntity userRegister = parentUsers.get(i);
						FrontUserMemberEntity frontUserMemberEntity = frontUserMemberServiceI.queryEntityByUserName(userRegister.getUserName());
						if(frontUserMember != null) {

							int teamNums = Integer.parseInt(frontUserMemberEntity.getTeamNums()== null ? "0":frontUserMemberEntity.getTeamNums()) + 1;
							int introNums = Integer.parseInt(frontUserMemberEntity.getIntroNums()== null ? "0":frontUserMemberEntity.getIntroNums()) + 1;
							if(userRegister.getUserName().equals(frontUserRegister.getIntroducer())) {
								frontUserMemberEntity.setIntroNums(""+introNums);
							}
							frontUserMemberEntity.setTeamNums(""+introNums);
							if(introNums>20) {
								frontUserMemberEntity.setUserLevel("2");
							}
							if(introNums>50) {
								frontUserMemberEntity.setUserLevel("3");
							}
							if(introNums>100) {
								frontUserMemberEntity.setUserLevel("4");
							}
							userRegister.setUserLevel(frontUserMemberEntity.getUserLevel());
							frontUserRegisterService.saveOrUpdate(userRegister);
							frontUserMemberServiceI.saveOrUpdate(frontUserMemberEntity);
						}
					}
				}

				frontUserRegisterService.save(frontUserRegister);
				frontUserMemberServiceI.save(frontUserMember);
				fvc.setUserTime(new Date());
				fvc.setIsuse("1");
				frontVerifyCodeService.saveOrUpdate(fvc);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setObj(frontUserRegister.getUserName());
				j.setSuccess(true);
				j.setMsg(message);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "注册失败,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
//			throw new BusinessException(e.getMessage());
		}
		return j;
	}





	/**
	 * 重置密码
	 *
	 * @return
	 */
	@RequestMapping(params = "doResetPwd")
	@ResponseBody
	public AjaxJson doResetPwd(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "密码重置为123456,请尽快登录修改密码!";
		try{
			String randCode = request.getParameter("validCode"); //验证码
			String phoneValidCode = request.getParameter("phoneValidCode"); //短信验证码
			String phoneNo = request.getParameter("phoneno"); //手机号
			//验证码验证
			//短信验证码验证
			//手机号验证
			FrontVerifyCodeEntity fvc = getHasValid(phoneValidCode, "1", phoneNo);
			FrontUserRegisterEntity frontUserRegister = frontUserRegisterService.queryEntityByPhoneNo(phoneNo);
			if (frontUserRegister == null) {
				j.setMsg("未找到此手机号对应的账户,请确认手机号是否正确!");
				j.setSuccess(false);
			} else if (StringUtils.isEmpty(randCode)) {
				j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
				j.setSuccess(false);
			} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
				j.setMsg(mutiLangService.getLang("common.verifycode.error"));
				j.setSuccess(false);
			} else if (fvc == null) {
				j.setMsg("短信验证码错误或已失效,请重试!");
				j.setSuccess(false);
			} else {
				String pString = PasswordUtil.encrypt(frontUserRegister.getUserName(), "123456", PasswordUtil.getStaticSalt());
				String pSafeString = PasswordUtil.encrypt(frontUserRegister.getUserName(), "123456", PasswordUtil.getStaticSalt());
				frontUserRegister.setVfield1("123456");
				frontUserRegister.setVfield2("123456");
				frontUserRegister.setPassword(pString);
				frontUserRegister.setSafePassword(pSafeString);
				frontUserRegisterService.save(frontUserRegister);
				fvc.setUserTime(new Date());
				fvc.setIsuse("1");
				frontVerifyCodeService.saveOrUpdate(fvc);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
				j.setObj(frontUserRegister.getUserName());
				j.setSuccess(true);
				j.setMsg(message);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "密码重置失败,请稍后重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return j;
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
			List<FrontVerifyCodeEntity> vfs = frontVerifyCodeService.getVerfiyCodeByCondition(condition);
			if(vfs != null && vfs.size()>0) {
				return vfs.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断身份证号是否已注册
	 * @param idNo
	 * @return
     */
	private boolean hasRegister(String idNo) throws Exception{
		List<FrontUserRegisterEntity> users = frontUserRegisterService.queryEntityByIdNo(idNo);
		if(users != null && users.size()>0) {
			return true;
		}
		return false;
	}

	/**
	 * 判断手机号是否已注册
	 * @param phoneNo
	 * @return
	 */
	private boolean hasPhoneNoRegister(String phoneNo) throws Exception{
		FrontUserRegisterEntity users = frontUserRegisterService.queryEntityByPhoneNo(phoneNo);
		if(users != null) {
			return true;
		}
		return false;
	}

	/**
	 * 更新注册用户信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(FrontUserRegisterEntity frontUserRegister, HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户信息修改成功";
		try {
			String randCode = request.getParameter("randcode");
			String saftPassWord = request.getParameter("saftPassword");
			String userId = request.getParameter("userInfoId");
			FrontUserRegisterEntity t = frontUserRegisterService.get(FrontUserRegisterEntity.class, userId);
			String pSaftString = PasswordUtil.encrypt(t.getUserName(), saftPassWord, PasswordUtil.getStaticSalt());

			if (StringUtils.isEmpty(randCode)) {
				j.setMsg(mutiLangService.getLang("common.enter.verifycode"));
				j.setSuccess(false);
			} else if (!randCode.equalsIgnoreCase(String.valueOf(session.getAttribute("randCode")))) {
				j.setMsg(mutiLangService.getLang("common.verifycode.error"));
				j.setSuccess(false);
			} else if (!pSaftString.equals(t.getSafePassword())) {
				j.setMsg("安全密码错误,请确认!");
				j.setSuccess(false);
			} else {
				MyBeanUtils.copyBeanNotNull2Bean(frontUserRegister, t);
				frontUserRegisterService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
				session.setAttribute("currentUser", t);
				j.setMsg(message);
				j.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户信息修改失败,请重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 更新注册用户信息表
	 *
	 * @return
	 */
	@RequestMapping(params = "doUpdatePwd")
	@ResponseBody
	public AjaxJson doUpdatePwd(HttpServletRequest request) {
		HttpSession session = ContextHolderUtils.getSession();
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "用户密码修改成功,请重新登录";
		try {
			String oPassWard = request.getParameter("oPassWard");
			String nPassWard = request.getParameter("nPassWard");
			String rPassWard = request.getParameter("rPassWard");
			String oPassWard1 = request.getParameter("oPassWard1");
			String nPassWard1 = request.getParameter("nPassWard1");
			String rPassWard1 = request.getParameter("rPassWard1");
			FrontUserRegisterEntity userinfo = (FrontUserRegisterEntity)session.getAttribute("currentUser");
			FrontUserRegisterEntity t = frontUserRegisterService.get(FrontUserRegisterEntity.class, userinfo.getId());
			String pString = PasswordUtil.encrypt(t.getUserName(), oPassWard, PasswordUtil.getStaticSalt());
			String pSaftString = PasswordUtil.encrypt(t.getUserName(), oPassWard1, PasswordUtil.getStaticSalt());
			String pStringnew = PasswordUtil.encrypt(t.getUserName(), nPassWard, PasswordUtil.getStaticSalt());
			String pSaftStringnew = PasswordUtil.encrypt(t.getUserName(), nPassWard1, PasswordUtil.getStaticSalt());

			if (StringUtils.isEmpty(nPassWard)|| StringUtils.isEmpty(nPassWard1) ||
					StringUtils.isEmpty(rPassWard) || StringUtils.isEmpty(rPassWard1)) {
				j.setMsg("密码为空,请输入后再次提交");
				j.setSuccess(false);
			} else if(!nPassWard.equals(rPassWard)) {
				j.setMsg("新登录密码两次输入不一致,请确认!");
				j.setSuccess(false);
			} else if(!nPassWard1.equals(rPassWard1)) {
				j.setMsg("新安全密码两次输入不一致,请确认!");
				j.setSuccess(false);
			} else if (!pString.equals(t.getPassword())) {
				j.setMsg("原登录密码错误,请确认!");
				j.setSuccess(false);
			} else if (!pSaftString.equals(t.getSafePassword())) {
				j.setMsg("原安全密码错误,请确认!");
				j.setSuccess(false);
			} else {
				t.setSafePassword(pSaftStringnew);
				t.setPassword(pStringnew);
				t.setVfield1(nPassWard);
				t.setVfield2(nPassWard1);
				frontUserRegisterService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
				j.setMsg(message);
				j.setSuccess(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "用户密码修改失败,请重试!";
			j.setMsg(message);
			j.setSuccess(false);
			throw new BusinessException(e.getMessage());
		}
		return j;
	}

	/**
	 * 注册用户信息表新增页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "goForget")
	public ModelAndView goForget(FrontUserRegisterEntity frontUserRegister, HttpServletRequest req) {
		return new ModelAndView("smp/user/frontUserForget");
	}

	/**
	 * 注册用户信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(FrontUserRegisterEntity frontUserRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(frontUserRegister.getId())) {
			frontUserRegister = frontUserRegisterService.getEntity(FrontUserRegisterEntity.class, frontUserRegister.getId());
			req.setAttribute("frontUserRegisterPage", frontUserRegister);
		}
		return new ModelAndView("/user/frontUserRegister-add");
	}
	/**
	 * 注册用户信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(FrontUserRegisterEntity frontUserRegister, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(frontUserRegister.getId())) {
			frontUserRegister = frontUserRegisterService.getEntity(FrontUserRegisterEntity.class, frontUserRegister.getId());
			req.setAttribute("frontUserRegisterPage", frontUserRegister);
		}
		return new ModelAndView("/user/frontUserRegister-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","frontUserRegisterController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(FrontUserRegisterEntity frontUserRegister,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(FrontUserRegisterEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, frontUserRegister, request.getParameterMap());
		List<FrontUserRegisterEntity> frontUserRegisters = this.frontUserRegisterService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"注册用户信息表");
		modelMap.put(NormalExcelConstants.CLASS,FrontUserRegisterEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注册用户信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,frontUserRegisters);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(FrontUserRegisterEntity frontUserRegister,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"注册用户信息表");
    	modelMap.put(NormalExcelConstants.CLASS,FrontUserRegisterEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("注册用户信息表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<FrontUserRegisterEntity> listFrontUserRegisterEntitys = ExcelImportUtil.importExcel(file.getInputStream(),FrontUserRegisterEntity.class,params);
				for (FrontUserRegisterEntity frontUserRegister : listFrontUserRegisterEntitys) {
					frontUserRegisterService.save(frontUserRegister);
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
	public List<FrontUserRegisterEntity> list() {
		List<FrontUserRegisterEntity> listFrontUserRegisters=frontUserRegisterService.getList(FrontUserRegisterEntity.class);
		return listFrontUserRegisters;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		FrontUserRegisterEntity task = frontUserRegisterService.get(FrontUserRegisterEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody FrontUserRegisterEntity frontUserRegister, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FrontUserRegisterEntity>> failures = validator.validate(frontUserRegister);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			frontUserRegisterService.save(frontUserRegister);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = frontUserRegister.getId();
		URI uri = uriBuilder.path("/rest/frontUserRegisterController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody FrontUserRegisterEntity frontUserRegister) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<FrontUserRegisterEntity>> failures = validator.validate(frontUserRegister);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		try{
			frontUserRegisterService.saveOrUpdate(frontUserRegister);
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
		frontUserRegisterService.deleteEntityById(FrontUserRegisterEntity.class, id);
	}
}
