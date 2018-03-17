<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">账户信息</h3>
        <div class="p10 box_h">
            <div class="row">
                <div class="col-md-4 col-md-push-4 weui-pt30 weui-pb30">
                    <table width="100%" style="font-size: 14px;">
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r" width="120"><span class=" ta_left weui-db">用户名</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.userName}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">推荐人</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.introducer}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">真实名</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.realname}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">手机号</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.phoneno}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">身份证号</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.identityNo}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">银行卡</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.bankCard}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">开户行省市</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.province}-${userinfo.city}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">开户行详址</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.bankAddress}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">开户行名称</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.bankCode}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">支付宝账户</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.vfield3}</span></td>
                        </tr>
                        <tr>
                            <td class="weui-pt10 weui-pr10 weui-t_r"><span class=" ta_left weui-db">支付宝名称</span></td>
                            <td class="weui-pt10"><span class=" ta_right weui-db">${userinfo.vfield4}</span></td>
                        </tr>
                    </table>
                    <button type="button" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10 weui-mt30" onclick="editUser()">修改资料</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeInfo" id="editUser" style="display: none">修改资料</button>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="plug-in/webfront/js/address/distpicker.data.js"></script>
<script src="plug-in/webfront/js/address/distpicker.js"></script>
<script src="plug-in/webfront/js/address/main.js"></script>

<script type="text/javascript">
    function editUser() {
        $("#editUser").click();
        $("#bankCode").val($("#bankCode1").val());
        $("#province").val($("#province1").val());
        $("#province").onclick();
        $("#city").val($("#city1").val());
    }

    function validateCallback(form, callback, confirmMsg) {
        var $form = $(form);
        // 提交信息
        var url="frontUserRegisterController.do?doUpdate";
        var fromData = $('#changeInfoFrom').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            url : url,// 请求的action路径
            data : fromData,
            error : function() {// 请求失败处理函数
                alert("服务器异常,请稍后重试!");
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
                            location.href="frontUserRegisterController.do?gouserinfo";
                        }
                    );
                } else {
                    layer.alert(d.msg);
                }
            }
        });
        return false;
    }


</script>


