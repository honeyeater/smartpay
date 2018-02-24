<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>金润智能理财用户注册</title>
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
                    <a class="navbar-brand" href="#" style="color: white"><strong>欢迎注册金润智能理财系统</strong></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <form class="form-horizontal required-validate form-signin"
              onsubmit="return validateCallback(this)" id="registform">
            <input id="id" name="id" type="hidden" value="${userPage.id }">
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="introducer">推荐人:</label>
                <div class="col-lg-4">
                    <input id="introducer" name="introducer" type="text" class="form-control" ignore="ignore" value="${userPage.userName}" readonly/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="userName">用户名:</label>
                <div class="col-lg-4">
                    <input id="userName" name="userName" type="text" class="form-control" ignore="ignore" style="width: 60%;display:inline;" readonly/>
                    <input type="button" value="更换" name="changeUserName" onclick="generalUserName();" class="btn btn-success form-control pull-right" style="width: 36%;display:inline;">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="phoneno">手机号:</label>
                <div class="col-lg-4">
                    <input id="phoneno" name="phoneno" type="text" class="form-control" ignore="ignore" placeholder="手机号"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="identityNo">身份证号:</label>
                <div class="col-lg-4">
                    <input id="identityNo" name="identityNo" type="text"  class="form-control" ignore="ignore" placeholder="身份证号"
                           required />
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="realname">真实姓名:</label>
                <div class="col-lg-4">
                    <input id="realname" name="realname" type="text"  class="form-control" ignore="ignore" placeholder="真实姓名"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div data-toggle="distpicker">
                <div class="form-group">
                    <label class="col-lg-2 col-lg-offset-2 control-label" for="province">银行省份:</label>
                    <div class="col-lg-4">
                        <%--<input id="province" name="province" type="text"  class="form-control" ignore="ignore"/>--%>
                        <%--<span class="Validform_checktip"></span>--%>
                        <select class="form-control" id="province" name="province">
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 col-lg-offset-2 control-label" for="city">银行城市:</label>
                    <div class="col-lg-4">
                        <%--<input id="city" name="city" type="text"  class="form-control" ignore="ignore"/>--%>
                        <%--<span class="Validform_checktip"></span>--%>
                        <select class="form-control" id="city" name="city">
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="bankCode">开户银行:</label>
                <div class="col-lg-4">
                    <select id="bankCode" name="bankCode" class="form-control">
                        <option></option>
                        <option value="中国人民银行">中国人民银行</option>
                        <option value="中国工商银行">中国工商银行</option>
                        <option value="中国工商银行">中国工商银行</option>
                        <option value="中国银行">中国银行</option>
                        <option value="中国建设银行">中国建设银行</option>
                        <option value="中国进出口银行">中国进出口银行</option>
                        <option value="交通银行">交通银行</option>
                        <option value="中信银行">中信银行</option>
                        <option value="中国光大银行">中国光大银行</option>
                        <option value="华夏银行">华夏银行</option>
                        <option value="中国民生银行">中国民生银行</option>
                        <option value="广东发展银行">广东发展银行</option>
                        <option value="深圳发展银行">深圳发展银行</option>
                        <option value="招商银行">招商银行</option>
                        <option value="兴业银行">兴业银行</option>
                        <option value="农村商业银行">农村商业</option>
                        <option value="恒丰银行">恒丰银行</option>
                        <option value="浙商银行">浙商银行</option>
                        <option value="农村合作银行">农村合作银行</option>
                        <option value="渤海银行">渤海银行</option>
                        <option value="徽商银行">徽商银行</option>
                        <option value="城市信用社">城市信用社</option>
                        <option value="农村信用联社">农村信用联社</option>
                        <option value="中国邮政储蓄银行">中国邮政储蓄银行</option>
                        <option value="恒生银行">恒生银行</option>
                        <option value="平安银行">平安银行</option>
                        <option value="华商银行">华商银行</option>
                        <option value="青岛国际银行">青岛国际银行</option>
                        <option value="华一银行">华一银行</option>
                        <option value="宁波银行">宁波银行</option>
                        <option value="杭州银行">杭州银行</option>
                        <option value="深圳农村银行">深圳农村银行</option>
                        <option value="南京银行">南京银行</option>
                        <option value="上海银行">上海银行</option>
                        <option value="北京银行">北京银行</option>
                        <option value="齐鲁银行">齐鲁银行</option>
                        <option value="成都银行">成都银行</option>
                        <option value="烟台银行">烟台银行</option>
                        <option value="河北银行">河北银行</option>
                        <option value="湖北银行">湖北银行</option>
                        <option value="天津银行">天津银行</option>
                        <option value="大连银行">大连银行</option>
                        <option value="重庆银行">重庆银行</option>
                        <option value="东莞银行">东莞银行</option>
                        <option value="哈尔滨银行">哈尔滨银行</option>
                        <option value="包商银行">包商银行</option>
                        <option value="南昌银行">南昌银行</option>
                        <option value="兰州银行">兰州银行</option>
                        <option value="青岛银行">青岛银行</option>
                        <option value="齐商银行">齐商银行</option>
                        <option value="温州银行">温州银行</option>
                        <option value="宁夏银行">宁夏银行</option>
                        <option value="临商银行">临商银行</option>
                        <option value="富滇银行">富滇银行</option>
                        <option value="长沙银行">长沙银行</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="bankCard">银行卡号:</label>
                <div class="col-lg-4">
                    <input id="bankCard" name="bankCard" type="text"  class="form-control" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="bankAddress">银行详细地址:</label>
                <div class="col-lg-4">
                    <input id="bankAddress" name="bankAddress" type="text"  class="form-control"
                           ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="password">登录密码:</label>
                <div class="col-lg-4">
                    <input id="password" name="password" type="password"  class="form-control" ignore="ignore"/>
                    <span class="Validform_checktip"></span>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-2 col-lg-offset-2 control-label" for="safePassword">安全密码:</label>
                <div class="col-lg-4">
                    <input id="safePassword" name="safePassword" type="password"  class="form-control"
                           ignore="ignore"/>
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
                    <button type="submit" class="btn btn-success btn-lg btn-block">注册</button>
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
//                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
                message: '通用的验证失败消息',//好像从来没出现过
//                feedbackIcons: {//根据验证结果显示的各种图标
//                    valid: 'glyphicon glyphicon-ok',
//                    invalid: 'glyphicon glyphicon-remove',
//                    validating: 'glyphicon glyphicon-refresh'
//                },
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
                    identityNo: {
                        validators: {
                            notEmpty: {
                                message: '身份证号码必须录入'
                            },
                            idnoCard: {
                                message: '身份证号码不合法'
                            }
                        }
                    },
                    realname: {
                        validators: {
                            notEmpty: {
                                message: '真实姓名不能为空'
                            },
                            regexp: {
                                regexp: /^[\u4e00-\u9fa5]+$/,
                                message: '只能输入中文'
                            },
                            stringLength: {//检测长度
                                min: 2,
                                max: 5,
                                message: '长度必须在2-5之间'
                            }
                        }
                    },
                    bankCard: {
                        validators: {
                            notEmpty: {
                                message: '银行卡号不能为空'
                            },
                            regexp: {
                                regexp: /^[0-9]+$/,
                                message: '只能输入数字'
                            }
                        }
                    },
                    bankAddress: {
                        validators: {
                            notEmpty: {
                                message: '银行详细地址不能为空'
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: {
                                message: '登录密码不能为空'
                            },
                            stringLength: {//检测长度
                                min: 6,
                                max: 30,
                                message: '长度必须在6-30之间'
                            },
                            regexp: {//正则验证
                                regexp: /^[a-zA-Z0-9_\.]+$/,
                                message: '只能输入字母、数字、下划线和点'
                            }
                        }
                    },
                    safePassword: {
                        validators: {
                            notEmpty: {
                                message: '登录密码不能为空'
                            },
                            stringLength: {//检测长度
                                min: 6,
                                max: 30,
                                message: '长度必须在6-30之间'
                            },
                            regexp: {//正则验证
                                regexp: /^[a-zA-Z0-9_\.]+$/,
                                message: '只能输入字母、数字、下划线和点'
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
                    },
                    province: {
                        validators: {
                            notEmpty: {
                                message: '银行省份不能为空'
                            }
                        }
                    },
                    bankCode: {
                        validators: {
                            notEmpty: {
                                message: '开户银行不能为空'
                            }
                        }
                    }
//                    text: {
//                        validators: {
//                            notEmpty: {//检测非空,radio也可用
//                                message: '文本框必须输入'
//                            },
//                            stringLength: {//检测长度
//                                min: 6,
//                                max: 30,
//                                message: '长度必须在6-30之间'
//                            },
//                            regexp: {//正则验证
//                                regexp: /^[a-zA-Z0-9_\.]+$/,
//                                message: '所输入的字符不符要求'
//                            },
//                            remote: {//将内容发送至指定页面验证，返回验证结果，比如查询用户名是否存在
//                                url: '指定页面',
//                                message: 'The username is not available'
//                            },
//                            different: {//与指定文本框比较内容相同
//                                field: '指定文本框name',
//                                message: '不能与指定文本框内容相同'
//                            },
//                            emailAddress: {//验证email地址
//                                message: '不是正确的email地址'
//                            },
//                            identical: {//与指定控件内容比较是否相同，比如两次密码不一致
//                                field: 'confirmPassword',//指定控件name
//                                message: '输入的内容不一致'
//                            },
//                            date: {//验证指定的日期格式
//                                format: 'YYYY/MM/DD',
//                                message: '日期格式不正确'
//                            },
//                            choice: {//check控件选择的数量
//                                min: 2,
//                                max: 4,
//                                message: '必须选择2-4个选项'
//                            }
//                        }
//                    }
                }
            });

            // 修复bootstrap validator重复向服务端提交bug
            $form.on('success.form.bv', function(e) {
                // Prevent form submission
                e.preventDefault();
            });
        });
        generalUserName();
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
            var url="frontUserRegisterController.do?doAdd";
            var fromData = $('#registform').serialize();
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
                        layer.alert(d.msg,
                                {
                                    closeBtn: 0
                                });
                    }
                }
            });
        }
        return false;
    }

    /**
     * 获取注册用户名
     */
    function generalUserName() {
        var url="frontUserRegisterController.do?generateUN";
        $.ajax({cache : false,type : 'POST',url : url,
            error : function() {
                tip("系统错误!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if(d.obj != null){
                    $("#userName").val(d.obj);
                }else{
                    layer.alert(d.msg);
                }
            }
        });
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
	