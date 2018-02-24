<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>金润智能理财用户密码找回</title>
    <%--<t:base type="jquery,easyui,tools,DatePicker"></t:base>--%>
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/bootstrap3/validate/css/bootstrapValidator.min.css" rel="stylesheet">
    <link href="plug-in/webfront/css/common.css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <script src="plug-in/bootstrap3/validate/js/bootstrapValidator.js"></script>
    <script src="plug-in/bootstrap3/validate/js/language/zh_CN.js"></script>
    <script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>

    <style>
        body {
            background: white;
            padding: 0px;
        }
    </style>
</head>
<body>
    <div class="header">
        <div class="navbar navbar-inverse">
            <div class="container col-lg-4 col-lg-offset-4">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#" style="color: white"><strong>找回密码</strong></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <form class="form-horizontal required-validate form-signin"
              onsubmit="return validateCallback(this)" id="forgetform">
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="phoneno">手机号:</label>
                <div class="col-lg-4">
                    <input id="phoneno" name="phoneno" type="text" class="form-control" ignore="ignore" placeholder="手机号"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="validCode">验证码:</label>
                <div class="col-lg-4">
                    <input id="validCode" name="validCode" type="text"  class="form-control" ignore="ignore" style="width: 60%;display:inline;"/>
                    <img id="codeImg" alt="看不清?点击切换" src="randCodeImage" class="pull-right" style="width: 32%;display:inline; height: 32px;">
                </div>
            </div>

            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="phoneValidCode">手机验证码:</label>
                <div class="col-lg-4">
                    <input id="phoneValidCode" name="phoneValidCode" type="text"  class="form-control" ignore="ignore" style="width: 60%;display:inline;"/>
                    <input type="button" value="获取手机验证码" name="getValidCode" id="getValidCode" onclick="generalValidCode(this);" class="btn btn-success  pull-right" style="width: 32%;display:inline;">
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-4 col-lg-4">
                    <button type="submit" class="btn btn-success btn-lg btn-block">找回密码</button>
                </div>
            </div>
        </form>
    </div>


</body>
<script src="webpage/smp/user/frontUserRegister.js"></script>
<script src="plug-in/webfront/js/address/distpicker.data.js"></script>
<script src="plug-in/webfront/js/address/distpicker.js"></script>
<script src="plug-in/webfront/js/address/main.js"></script>
<script>
    $(function() {
        // validate form
        $("form.required-validate").each(function() {
            var $form = $(this);
            $form.bootstrapValidator({
                live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                message: '通用的验证失败消息',//好像从来没出现过
                fields: {
                    phoneno: {
                        validators: {
                            notEmpty: {
                                message: '手机号必须输入'
                            },
                            stringLength: {
                                min: 11,
                                max: 11,
                                message: '请输入11位手机号码'
                            },
                            regexp: {
                                regexp: /^[1][3,4,5,7,8][0-9]{9}$/,
                                message: '请输入正确的手机号码'
                            }
                        }
                    },
                    validCode: {
                        validators: {
                            notEmpty: {
                                message: '验证码不能为空'
                            }
                        }
                    },
                    phoneValidCode: {
                        validators: {
                            notEmpty: {
                                message: '手机验证码不能为空'
                            }
                        }
                    }
                }
            });

            // 修复bootstrap validator重复向服务端提交bug
            $form.on('success.form.bv', function(e) {
                // Prevent form submission
                e.preventDefault();
            });
        });
    });

    function validateCallback(form, callback, confirmMsg) {
        var $form = $(form);
        var data = $form.data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
            // 提交信息
            var url="frontUserRegisterController.do?doResetPwd";
            var fromData = $('#forgetform').serialize();
            $.ajax({
                cache: false,
                async : false,
                type : 'POST',
                url : url,// 请求的action路径
                data : fromData,
                error : function() {// 请求失败处理函数
                    alert("error");
                },
                success : function(data) {
                    var d = $.parseJSON(data);
                    if (d.success) {
                        layer.alert(
                            d.msg,
                            {
                                closeBtn: 0
                            },
                            function(){
                                location.href="userLoginController.do?logout";
                            }
                        );
                    } else {
                        layer.alert(d.msg);
                    }
                }
            });
        }
        return false;
    }

    /**
     * 刷新验证码
     */
    $('#codeImg').click(function(){
        reloadRandCodeImage();
    });
    function reloadRandCodeImage() {
        var date = new Date();
        var img = document.getElementById("codeImg");
        img.src='randCodeImage?a=' + date.getTime();
    }

    /**
     * 获取短信验证码
     */
    function generalValidCode(thiz) {
        var phoneNo = $("#phoneno").val();
        var vfcode = $("#validCode").val();
        var url="frontVerifyCodeController.do?verifyCode&phoneNo=" + phoneNo + "&vfCode="+vfcode;
        $.ajax({cache : false,type : 'POST',url : url,
            error : function() {
                tip("系统错误!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    settime($("#getValidCode"));
                    layer.alert(d.msg);
                } else {
                    layer.alert(d.msg);
                }
            }
        });
    }

    //短信后倒计时
    var countdown=60;
    function settime(obj) {
        if (countdown == 0) {
            $(obj).attr("disabled",false);
            $(obj).attr("mark","1");
            $(obj).val("获取手机验证码");
            countdown = 60;
            return;
        } else {
            $(obj).attr("disabled", true);
            $(obj).attr("mark","0");
            $(obj).val("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
                    settime(obj) }
                ,1000)
    }


</script>
	