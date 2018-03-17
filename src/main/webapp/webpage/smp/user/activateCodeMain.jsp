<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title><t:mutiLang langKey="jeect.platform"/></title>
    <link rel="shortcut icon" href="images/favicon.ico">
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/smp/css/style.css" type="text/css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<%--页面头部导航--%>
<%@include file="/webpage/webmain/head.jsp"%>

<div class="r_content">
    <%--用户信息--%>
    <%@include file="/webpage/webmain/userinfo.jsp"%>
    <%--激活码列表信息--%>
    <%@include file="/webpage/smp/user/activateCodeList.jsp"%>

</div>


<%--激活弹出框--%>

<div class="modal fade" id="doActiveB" tabindex="-1" role="dialog" aria-labelledby="activatetitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                <h4 class="modal-title weui-f18" id="activatetitle">激活码</h4>
            </div>
            <div class="modal-body">
                <form id="actiForm" method="post">
                <div class="weui-pb20">
                    <table width="100%" style="font-size: 14px;">
                        <tr>
                            <td width="90">有效激活码：</td>
                            <td><input class="form-control" id="activatecode" name="activatecode" type="text" value=""
                                       required=""></td>
                        </tr>
                    </table>
                </div>
                <div class=""><input id="activatesub" type="button" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10" value="确认激活" onclick="return activateSub();"></div>
                </form>
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
