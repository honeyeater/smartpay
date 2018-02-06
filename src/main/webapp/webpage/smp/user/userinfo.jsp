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
                            <li class="list-group-item">用户名：Z05942939</li>

                            <li class="list-group-item">推荐人：Z01973857</li>
                            <li class="list-group-item">真实名：张敏</li>
                            <li class="list-group-item">手机号：18525366806</li>
                            <li class="list-group-item">身份证：34122619891008294x</li>
                            <li class="list-group-item">银行卡：6227000785060362398</li>
                            <li class="list-group-item">开户行省市：辽宁省-大连市</li>
                            <li class="list-group-item">开户行详址：普兰店支行</li>
                            <li class="list-group-item">开户行名称：建设银行</li>

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

