<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">修改密码</h3>
        <div class="p10 box_h">
            <div class="row">
                <form class="required-validate" method="post" onsubmit="return validateCallback(this);" id="updpwdForm">
                <div class="col-md-4 col-md-push-4 weui-pt30 weui-pb30">
                    <div class="weui-bod weui-mt30">
                        <ul id="myTab" class="nav nav-tabs nav-tabs1 weui-f16">
                            <li class="active"><a href="#home" data-toggle="tab">登录密码</a></li>
                            <li><a href="#ios" data-toggle="tab">安全密码</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade in active" id="home">
                                <div class=" pass_p">
                                    <table width="100%">
                                        <tr>
                                            <td class="weui-pb30" width="90">旧密码：</td>
                                            <td class="weui-pb30">
                                                <input type="password" class="form-control" id="oPassWard" name="oPassWard">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="weui-pb30">新密码：</td>
                                            <td class="weui-pb30">
                                                <input type="password" class="form-control" id="nPassWard" name="nPassWard">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>确认新密码：</td>
                                            <td>
                                                <input type="password" class="form-control" id="rPassWard" name="rPassWard">
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="ios">
                                <div class=" pass_p">
                                    <table width="100%">
                                        <tr>
                                            <td class="weui-pb30" width="90">旧密码：</td>
                                            <td class="weui-pb30">
                                                <input type="password" class="form-control" id="oPassWard1" name="oPassWard1">
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="weui-pb30">新密码：</td>
                                            <td class="weui-pb30">
                                                <input type="password" class="form-control" id="nPassWard1" name="nPassWard1">
                                                </td>
                                        </tr>
                                        <tr>
                                            <td>确认新密码：</td>
                                            <td>
                                                <input type="password" class="form-control" id="rPassWard1" name="rPassWard1">
                                                </td>
                                        </tr>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10 weui-mt30" value="修改资料">
                </div>
                </form>
            </div>
        </div>
    </div>
</div>

<link href="plug-in/bootstrap3/validate/css/bootstrapValidator.min.css" rel="stylesheet">
<script src="plug-in/bootstrap3/validate/js/bootstrapValidator.js"></script>
<script src="plug-in/bootstrap3/validate/js/language/zh_CN.js"></script>

<script type="text/javascript">

    $(function() {
        // validate form
        $("form.required-validate").each(function () {
            var $form = $(this);
            $form.bootstrapValidator({
                live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
                excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
                message: '通用的验证失败消息',//好像从来没出现过
                fields: {
                    oPassWard: {
                        validators: {
                            notEmpty: {
                                message: '旧登录密码不能为空'
                            }
                        }
                    },
                    oPassWard1: {
                        validators: {
                            notEmpty: {
                                message: '旧安全密码不能为空'
                            }
                        }
                    },
                    nPassWard: {
                        validators: {
                            notEmpty: {
                                message: '新登录密码不能为空'
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
                    nPassWard1: {
                        validators: {
                            notEmpty: {
                                message: '新安全密码不能为空'
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
                    rPassWard: {
                        validators: {
                            notEmpty: {
                                message: '新重复登录密码不能为空'
                            },
                            identical: {
                                field: 'nPassWard',
                                message: '新登录密码两次输入的不一致'
                            }
                        }
                    },
                    rPassWard1: {
                        validators: {
                            notEmpty: {
                                message: '新重复安全密码不能为空'
                            },
                            identical: {
                                field: 'nPassWard1',
                                message: '新安全密码两次输入的不一致'
                            }
                        }
                    }
                }
            });

            // 修复bootstrap validator重复向服务端提交bug
            $form.on('success.form.bv', function (e) {
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
            var url="frontUserRegisterController.do?doUpdatePwd";
            var fromData = $('#updpwdForm').serialize();
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
                                    offset: '240px',
                                    closeBtn: 0
                                },
                                function(){
                                    location.href="userLoginController.do?logout";
                                }
                        );
                    } else {
                        layer.alert(d.msg, {
                            offset: '240px',
                            closeBtn: 0
                        });
                    }
                }
            });
        }
        return false;
    }



</script>
