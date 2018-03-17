<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title><t:mutiLang langKey="jeect.platform"/>
    </title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/smp/css/style.css" type="text/css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
<%--页面头部导航--%>
<%@include file="/webpage/webmain/head.jsp"%>

<div class="r_content">
    <%--用户信息--%>
    <%@include file="/webpage/webmain/userinfo.jsp"%>
    <%--注册用户信息--%>
    <%@include file="/webpage/smp/user/userinfo.jsp"%>
</div>
<div class="modal fade" id="changeInfo" tabindex="-1" role="dialog" aria-labelledby="changeInfoLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog1" style="margin-top:30px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                <h4 class="modal-title weui-f18" id="changeInfoLabel">修改资料</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="changeInfoFrom">
                <input type="hidden" id="userInfoId" name="userInfoId" value="${userinfo.id}">
                <div class="weui-pb20" data-toggle="distpicker">
                    <table width="100%" class="weui-mt10" style="font-size: 14px;">
                        <tbody>
                        <tr>
                            <td class="weui-pb15 weui-t_r" width="90">银行省份：</td>
                            <td class="weui-pb15 weui-p_r">
                                <span class="p_select" style="right:8px;"><i class="glyphicon glyphicon-menu-down"></i></span>
                                <select class="form-control" id="province" name="province"></select>
                                <input type="hidden" value="${userinfo.province}" name="province1" id="province1">
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r" >银行城市：</td>
                            <td class="weui-pb15 weui-p_r"><span class="p_select" style="right:8px;"><i class="glyphicon glyphicon-menu-down"></i></span>
                                <select class="form-control" id="city" name="city"></select>
                                <input type="hidden" value="${userinfo.city}" name="city1" id="city1">
                            </td>
                        </tr>
                        <tr style="display: none">
                            <td class="weui-pb15 weui-t_r" >银行县：</td>
                            <td class="weui-pb15 weui-p_r"><span class="p_select" style="right:8px;"><i class="glyphicon glyphicon-menu-down"></i></span>
                                <select class="form-control" id="downt" name="downt"></select>
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">详细地址：</td>
                            <td class="weui-pb15">
                                <input class="form-control" id="bankAddress" name="bankAddress" type="text" value="${userinfo.bankAddress}">
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">开户银行：</td>
                            <td class="weui-pb15 weui-p_r"><span class="p_select" style="right:8px;"><i class="glyphicon glyphicon-menu-down"></i></span>
                                <input type="hidden" value="${userinfo.bankCode}" name="bankCode1" id="bankCode1">
                                <select id="bankCode" name="bankCode" class="form-control">
                                    <option></option>
                                    <option value="中国人民银行">中国人民银行</option>
                                    <option value="中国工商银行">中国工商银行</option>
                                    <option value="中国农业银行">中国农业银行</option>
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
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">银行卡号：</td>
                            <td class="weui-pb15">
                                <input id="bankCard" name="bankCard" type="text"  class="form-control" value="${userinfo.bankCard}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">支付宝账号：</td>
                            <td class="weui-pb15">
                                <input type="text" class="form-control" placeholder="" id="vfield3" name="vfield3" value="${userinfo.vfield3}">
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">支付宝名称：</td>
                            <td class="weui-pb15">
                                <input type="text" class="form-control" placeholder="" id="vfield4" name="vfield4" value="${userinfo.vfield4}">
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">验证码：</td>
                            <td class="weui-pb15 weui-p_r"><img id="codeImg" alt="看不清?点击切换" src="randCodeImage" style="width: 76px;height: 27px;" class="yzm">
                                <input type="text" class="form-control" placeholder="验证码" aria-describedby="basic-addon2" name="randcode" id="randcode">
                            </td>
                        </tr>
                        <tr>
                            <td class="weui-pb15 weui-t_r">安全密码：</td>
                            <td class="weui-pb15">
                                <input class="form-control" id="saftPassword" name="saftPassword" type="password" value="" required="">
                            </td>
                        </tr>
                        </tbody></table>
                    <div class="weui-red">温馨提示：修改资料请留言联系管理员!</div>
                </form>
                </div>
                <div><input type="button" id="changerInfoSave" onclick="return validateCallback();" class="btn btn-block btn-primary weui-f16 weui-pt10 weui-pb10" value="确认修改"></div>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<!-- 第三方插件 -->
<script src="plug-in-ui/hplus/js/plugins/pace/pace.min.js"></script>
<!-- Sweet alert -->
<script src="plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<!-- 弹出TAB -->
<script type="text/javascript" src="plug-in/hplus/hplus-tab.js"></script>
<!-- 在线聊天 -->
<script src="plug-in/smp/js/menu.js"></script>

</body>

</html>
