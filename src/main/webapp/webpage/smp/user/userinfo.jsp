<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="userinfo">
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">账户信息</h3>
                </div>
                <div class="panel-body" style="min-height: 450px">
                    <div class="col-sm-12">
                        <ul class="list-group">
                            <li class="list-group-item">用户名：${userinfo.userName}</li>
                            <li class="list-group-item">推荐人：${userinfo.introducer}</li>
                            <li class="list-group-item">真实名：${userinfo.realname}</li>
                            <li class="list-group-item">手机号：${userinfo.phoneno}</li>
                            <li class="list-group-item">身份证：${userinfo.identityNo}</li>
                            <li class="list-group-item">银行卡：${userinfo.bankCard}</li>
                            <li class="list-group-item">开户行省市：${userinfo.province}-${userinfo.city}</li>
                            <li class="list-group-item">开户行详址：${userinfo.bankAddress}</li>
                            <li class="list-group-item">开户行名称：${userinfo.bankCode}</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-12" style="text-align: center">
            <button type="button" class="btn btn-primary" onclick="editUser()">修改资料</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#changeInfo" id="editUser" style="display: none">修改资料</button>
        </div>
    </div>
</div>

<div class="modal fade" id="changeInfo" tabindex="-1" role="dialog" aria-labelledby="changeInfo" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="changeInfoLabel">修改资料</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="changeInfoFrom">
                    <input type="hidden" id="userInfoId" name="userInfoId" value="${userinfo.id}">
                    <div data-toggle="distpicker">
                        <div class="form-group">
                            <label class="control-label" for="province">银行省份:</label>
                            <select class="form-control" id="province" name="province"></select>
                            <input type="hidden" value="${userinfo.province}" name="province1" id="province1">
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="city">银行城市:</label>
                            <select class="form-control" id="city" name="city"></select>
                            <input type="hidden" value="${userinfo.city}" name="city1" id="city1">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="bankAddress">银行详细地址:</label>
                        <input class="form-control" id="bankAddress" name="bankAddress" type="text" value="${userinfo.bankAddress}">
                    </div>
                    <div class="form-group">
                        <input type="hidden" value="${userinfo.bankCode}" name="bankCode1" id="bankCode1">
                        <label class="control-label" for="bankCode">开户银行:</label>
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
                    <div class="form-group">
                        <label class="control-label" for="bankCard">银行卡号:</label>
                        <input id="bankCard" name="bankCard" type="text"  class="form-control" value="${userinfo.bankCard}"/>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="randcode">验证码</label>
                        <div class="input-group" style="width: 100%;">
                            <input type="text" class="form-control" placeholder="验证码" aria-describedby="basic-addon2" name="randcode" id="randcode">
                                <span class="input-group-addon" id="basic-addon-in" style="width: 80px;padding:0px">
                                    <img id="codeImg" alt="看不清?点击切换" src="randCodeImage" style="width: 80px;height: 32px;">
                                </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="saftPassword">安全密码</label>
                        <input class="form-control" id="saftPassword" name="saftPassword" type="password" value="" required="">
                    </div>
                    <div class="alert alert-danger" role="alert">
                        <strong>温馨提示：</strong>修改资料请留言联系管理员!
                    </div>
                    <div class="form-actions">
                        <button id="changerInfoSave" class="btn btn-primary btn-block" onclick="return validateCallback();">确定</button>
                    </div>

                </form>
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


