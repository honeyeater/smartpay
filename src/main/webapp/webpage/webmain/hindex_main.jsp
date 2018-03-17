<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <title><t:mutiLang langKey="jeect.platform"/></title>
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/smp/css/style.css" type="text/css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <script src="plug-in/tools/curdtools_en.js"></script>
    <script src="plug-in/tools/jQuery.dialog.js"></script>
    <script src="plug-in/tools/jQuery.Drag.js"></script>

</head>
<body>

<%--页面头部导航--%>
<%@include file="/webpage/webmain/head.jsp"%>

<div class="r_content">
    <%--用户信息--%>
    <%@include file="/webpage/webmain/userinfo.jsp"%>
    <div class="pass_p">
        <%--操作工具栏--%>
        <%@include file="/webpage/webmain/operatorbar.jsp"%>
        <%--用户基础信息--%>
        <%@include file="/webpage/smp/user/userinfoBase.jsp"%>
        <%--注入资金列表--%>
        <%@include file="/webpage/smp/order/injectList.jsp"%>
        <%--提出资金列表--%>
        <%@include file="/webpage/smp/order/drawList.jsp"%>
    </div>
</div>
<%--交易信息--%>
<%@include file="/webpage/smp/order/tradeinfo.jsp"%>
<%--支付信息--%>
<%@include file="/webpage/smp/order/payinfo.jsp"%>

<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<!-- 第三方插件 -->
<script src="plug-in-ui/hplus/js/plugins/pace/pace.min.js"></script>
<!-- Sweet alert -->
<script src="plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<!-- 弹出TAB -->
<script type="text/javascript" src="plug-in/hplus/hplus-tab.js"></script>
<script src="plug-in/smp/js/menu.js"></script>


</body>
</html>
