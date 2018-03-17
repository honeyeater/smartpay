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
    <link href="plug-in/smp/css/style.css" type="text/css" rel="stylesheet">
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

<body>
<div class="lo_top weui-pt30 weui-pb30">
    <div class="container">
        <a href="#"><img src="plug-in/smp/images/logo1.png"></a>
    </div>
</div>
<div class="lo_bg">
    <div class="container">
        <div class="row">
            <div class="col-md-9 weui-white m_none">
                <h3 class="lo_txt weui-f_b">专业 合规 可信赖</h3>
                <p class="weui-dnb weui-bb weui-f24 weui-pb10 weui-pt20">精选金融资产 · 专业技术护航 · 严格合规运作</p>
            </div>
            <div class="col-md-3">
                <div class="weui-bgf weui-p20 weui-bod_r">
                    <h3 class="lo_title weui-f_b weui-bb weui-pl10"><span class="weui-dnb">账号登录</span></h3>
                    <form id="loinForm" method="post">
                    <input type="hidden" id="ReturnURL"  name="ReturnURL" value="${ReturnURL }"/>
                    <div class="weui-mt20">
                        <div class="input-group">
                            <span class="input-group-addon weui-bgf" id="sizing-addon3"><i class="glyphicon glyphicon-user weui-c_9"></i></span>
                            <input type="text" class="form-control" placeholder="用户名" aria-describedby="sizing-addon2" name="userName" iscookie="true" id="userName" value="">
                        </div>
                    </div>
                    <div class="weui-mt20">
                        <div class="input-group">
                            <span class="input-group-addon weui-bgf" id="sizing-addon4"><i class="glyphicon glyphicon-lock weui-c_9"></i></span>
                            <input type="password" name="password" class="form-control" placeholder="密码" aria-describedby="sizing-addon2" id="password" value="">
                        </div>
                    </div>
                    <div class="weui-mt20">
                        <div class="input-group weui-p_r">
                            <span class="input-group-addon weui-bgf" id="sizing-addon5"><i class="glyphicon glyphicon-saved weui-c_9"></i></span>
                            <input type="text" class="form-control" placeholder="验证码" aria-describedby="sizing-addon2" name="randCode" id="randCode">
                            <img id="randCodeImage" src="randCodeImage"  class="yzm">
                        </div>
                    </div>
                    <div class="clearfix weui-mt10 weui-f12">
                        <span class="weui-fl"><input type="checkbox" name="remember" value="yes"> 记住用户名</span>
                        <a href="frontUserRegisterController.do?goForget" class="weui-fr weui-orange">忘记密码？</a>
                    </div>
                    <div class=" weui-mt20 weui-pb20 weui-bb">
                        <input type="button" id="but_login" class="btn btn-block btn-warning weui-f20" onclick="checkUser();" value="登 录">
                    </div>
                    <div class="clearfix weui-mt10">
                        <span class="weui-fl weui-f12">还没有账号？ </span>
                        <a href="frontUserRegisterController.do?register&t=8a8bbf2a61211b560161211b56a30000" class="weui-fr weui-orange">立即注册 >>       </a>
                    </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-9 weui-white m_none">
            </div>
            <div class="col-md-3">
                <div class="align-center alert alert-danger alert-dismissible" role="alert" id="errMsgContiner">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <div id="showErrMsg"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="weui-t_c weui-pt30 weui-pb30 weui-c_9">JR智能理财有限公司版权所有</div>
<script src="plug-in/smp/js/jquery.min.js"></script>
<script src="plug-in/smp/js/menu.js"></script>

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