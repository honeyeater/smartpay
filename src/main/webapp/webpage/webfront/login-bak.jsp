<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.jeecgframework.core.util.SysThemesUtil,org.jeecgframework.core.enums.SysThemesEnum"%>
<%@include file="/context/mytags.jsp"%>
<%
    session.setAttribute("lang","zh-cn");
    SysThemesEnum sysTheme = SysThemesUtil.getSysTheme(request);
    String lhgdialogTheme = SysThemesUtil.getLhgdialogTheme(sysTheme);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title><t:mutiLang langKey="jeect.platform"/></title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="plug-in/ace/css/bootstrap.css" />
    <link rel="stylesheet" href="plug-in/ace/css/font-awesome.css" />
    <%--<link rel="stylesheet" type="text/css" href="plug-in/accordion/css/accordion.css">--%>
    <!-- text fonts -->
    <link rel="stylesheet" href="plug-in/ace/css/ace-fonts.css" />

    <link rel="stylesheet" href="plug-in/ace/css/jquery-ui.css" />
    <!-- ace styles -->
    <link rel="stylesheet" href="plug-in/ace/css/acefront.css" class="ace-main-stylesheet" id="main-ace-style" />
    <!--[if lte IE 9]>
    <link rel="stylesheet" href="plug-in/ace/css/ace-part2.css" class="ace-main-stylesheet" />
    <![endif]-->

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="plug-in/ace/css/ace-ie.css" />
    <![endif]-->
    <!-- ace settings handler -->
    <script src="plug-in/ace/js/ace-extra.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="plug-in/ace/js/html5shiv.js"></script>
    <script src="plug-in/ace/js/respond.js"></script>
    <![endif]-->

</head>
<body class="login-layout light-login">
<div class="main-container">
    <div class="main-content">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <div class="login-container top-content">
                    <div class="row">
                        <div class="text">
                            <h1><strong>金润智能理财系统</strong></h1>
                            <div class="description">
                                <p>
                                    您可以放心参与的智能理财社区
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="space-6"></div>
                    <div class="position-relative col-sm-6 col-sm-offset-3">
                        <div id="login-box" class="login-box visible widget-box no-border" >
                            <div class="widget-body">
                                <form id="loinForm" class="form-horizontal" method="post">
                                    <input type="hidden" id="ReturnURL"  name="ReturnURL" value="${ReturnURL }"/>
                                    <div class="widget-main">
                                        <div class="form-top">
                                            <div class="form-top-left">
                                                <h4 class="header white lighter bigger">
                                                    用户登录
                                                </h4>
                                            </div>
                                            <div class="form-top-right">
                                                <i class="fa fa-lock"></i>
                                            </div>
                                        </div>
                                        <div class="space-6"></div>
                                        <label class="block clearfix">
								<span class="block input-icon input-icon-right">
                                    <input type="text"  name="userName" iscookie="true" class="form-control" placeholder="请输入用户名"  id="userName" value=""/>
									<%--<i class="ace-icon fa fa-user"></i>--%>
								</span>
                                        </label>
                                        <label class="block clearfix">
								<span class="block input-icon input-icon-right">
									<input type="password" name="password" class="form-control " placeholder="请输入密码" id="password" value=""/>
									<%--<i class="ace-icon fa fa-lock"></i>--%>
								</span>
                                        </label>
                                        <label class="block clearfix">
                                            <div class="input-group">
                                                <input type="text" style="width: 98%;-moz-border-radius: 4px; -webkit-border-radius: 4px; border-radius: 4px;" name="randCode" class="form-control" placeholder="请输入验证码"  id="randCode"/>
                                                <span class="input-group-addon" style="padding: 0px;"><img id="randCodeImage" src="randCodeImage"  /></span>
                                            </div>
                                        </label>
                                        <div class="clearfix">
                                            <label class="inline">
                                                <input type="checkbox" class="ace" id="on_off"  name="remember" value="yes"/>
                                                <span class="lbl white">&nbsp;记住用户名</span>
                                            </label>
                                        </div>
                                        <div class="clearfix">
                                            <button type="button" id="but_login" style="width: 100%;" onclick="checkUser()" class="pull-right btn  btn-primary">
                                                <i class="ace-icon fa fa-key"></i>
                                                <span class="bigger-222" >登录</span>
                                            </button>
                                        </div>

                                        <div class="clearfix">
                                            <div style="float: right;margin-right: 10px;">
                                                <label class="inline">
                                <span class="lbl white">&nbsp; <a href="frontUserRegisterController.do?goForget" class="forgot-password-link">
                                忘记密码</a></span>

                                                </label>
                                                <i class="fa fa-question" style="color: white"></i>
                                            </div>
                                        </div>

                                        <div class="space-4"></div>
                                        <div class="align-center alert alert-danger alert-dismissible" role="alert" id="errMsgContiner">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <div id="showErrMsg"></div>
                                        </div>
                                    </div>

                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="plug-in/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="plug-in/jquery/jquery.cookie.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/en.js"></script>
<script type="text/javascript" src="plug-in/mutiLang/zh-cn.js"></script>
<script type="text/javascript" src="plug-in/login/js/jquery.tipsy.js"></script>
<script type="text/javascript" src="plug-in/login/js/iphone.check.js"></script>
<script type="text/javascript" src="plug-in/jquery-plugs/backstretch/jquery.backstretch.min.js"></script>
<!-- add-begin--Author:gengjiajia  Date:20160727 for:TASK #1217 【IE兼容】jeecg h+首页兼容性问题,不兼容的浏览器直接切换套shortcut风格 -->
<script type="text/javascript" src="webpage/webfront/js/login.js"></script>
<!-- add-end--Author:gengjiajia  Date:20160727 for:TASK #1217 【IE兼容】jeecg h+首页兼容性问题,不兼容的浏览器直接切换套shortcut风格 -->
<script type="text/javascript">
    $(function(){
        optErrMsg();
//        blurStyle();
        //设置背景
        $.backstretch("plug-in/assets/img/background.jpg");
    });
    $("#errMsgContiner").hide();
    function optErrMsg(){
        $("#showErrMsg").html('');
        $("#errMsgContiner").hide();
    }

    //输入验证码，回车登录
    $(document).keydown(function(e){
        if(e.keyCode == 13) {
            setTimeout("$('#but_login').click()","100");
        }
    });

    //验证用户信息
    function checkUser(){
        if(!validForm()){
            return false;
        }
        newLogin();
    }
    //表单验证
    function validForm(){
        if($.trim($("#userName").val()).length==0){
            showErrorMsg("请输入用户名");
            return false;
        }

        if($.trim($("#password").val()).length==0){
            showErrorMsg("请输入密码");
            return false;
        }

        if($.trim($("#randCode").val()).length==0){
            showErrorMsg("请输入验证码");
            return false;
        }
        return true;
    }

    //登录处理函数
    function newLogin(orgId) {
        setCookie();

        var actionurl="userLoginController.do?login";//提交路径
        var checkurl="userLoginController.do?checkuser";//验证路径

        var formData = new Object();
        var data=$(":input").each(function() {
            formData[this.name] =$("#"+this.name ).val();
        });
        formData['orgId'] = orgId ? orgId : "";
        //语言
        formData['langCode']=$("#langCode").val();
        formData['langCode'] = $("#langCode option:selected").val();
        $.ajax({
            async : false,
            cache : false,
            type : 'POST',
            url : checkurl,// 请求的action路径
            data : formData,
            error : function() {// 请求失败处理函数
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    if (d.attributes.orgNum > 1) {
                        //用户拥有多个部门，需选择部门进行登录
                        var title, okButton;
                        if($("#langCode").val() == 'en') {
                            title = "Please select Org";
                            okButton = "Ok";
                        } else {
                            title = "请选择组织机构";
                            okButton = "确定";
                        }
                        $.dialog({
                            id: 'LHG1976D',
                            title: title,
                            max: false,
                            min: false,
                            drag: false,
                            resize: false,
                            content: 'url:userController.do?userOrgSelect&userId=' + d.attributes.user.id,
                            lock:true,
                            button : [ {
                                name : okButton,
                                focus : true,
                                callback : function() {
                                    iframe = this.iframe.contentWindow;
                                    var orgId = $('#orgId', iframe.document).val();

                                    formData['orgId'] = orgId ? orgId : "";
                                    $.ajax({
                                        async : false,
                                        cache : false,
                                        type : 'POST',
                                        url : 'loginController.do?changeDefaultOrg',// 请求的action路径
                                        data : formData,
                                        error : function() {// 请求失败处理函数
                                        },
                                        success : function(data) {
                                            window.location.href = actionurl;
                                        }
                                    });

                                    this.close();
                                    return false;
                                }
                            }],
                            close: function(){
                                setTimeout("window.location.href='"+actionurl+"'", 10);
                            }
                        });
                    } else {
                        window.location.href = actionurl;
                    }
                } else {
                    showErrorMsg(d.msg);

                    if(d.msg === "用户名或密码错误" || d.msg === "验证码错误")
                        reloadRandCodeImage();

                }
            }
        });
    }
    //登录提示消息显示
    function showErrorMsg(msg){
        $("#errMsgContiner").show();
        $("#showErrMsg").html(msg);
        window.setTimeout(optErrMsg,3000);
    }
    /**
     * 刷新验证码
     */
    $('#randCodeImage').click(function(){
        reloadRandCodeImage();
    });
    function reloadRandCodeImage() {
        var date = new Date();
        var img = document.getElementById("randCodeImage");
        img.src='randCodeImage?a=' + date.getTime();
    }

    //设置cookie
    function setCookie()
    {

        if ($('#on_off').attr("checked")) {

            $("input[iscookie='true']").each(function() {
                $.cookie(this.name, $("#"+this.name).val(), "/",24);
                $.cookie("COOKIE_NAME","true", "/",24);
            });
        } else {
            $("input[iscookie='true']").each(function() {
                $.cookie(this.name,null);
                $.cookie("COOKIE_NAME",null);
            });
        }
    }
    //读取cookie
    function getCookie()
    {
        var COOKIE_NAME=$.cookie("COOKIE_NAME");
        if (COOKIE_NAME !=null) {
            $("input[iscookie='true']").each(function() {
                $($("#"+this.name).val( $.cookie(this.name)));
                if("admin" == $.cookie(this.name)) {
                    $("#randCode").focus();
                } else {
                    $("#password").val("");
                    $("#password").focus();
                }
            });
            $("#on_off").attr("checked", true);
            $("#on_off").val("1");
        }
        else
        {
            $("#on_off").attr("checked", false);
            $("#on_off").val("0");
            $("#randCode").focus();
        }
    }
</script>
</body>
</html>