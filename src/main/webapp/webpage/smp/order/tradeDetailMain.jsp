<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title>理财平台</title>
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/webfront/css/common.css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <style>

    </style>
</head>
<body>
<%--页面头部导航--%>
<%@include file="/webpage/webmain/head.jsp"%>

<div id="content">
    <%--操作工具栏--%>
    <%@include file="/webpage/webmain/operatorbar.jsp"%>
    <%--用户基础信息--%>
    <%@include file="/webpage/smp/user/userinfoBase.jsp"%>
    <%--财务明细--%>
    <%@include file="/webpage/smp/order/tradeDetail.jsp"%>

</div>

<%@include file="/webpage/webmain/foot.jsp"%>

<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<!-- 第三方插件 -->
<script src="plug-in-ui/hplus/js/plugins/pace/pace.min.js"></script>
<!-- Sweet alert -->
<script src="plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<!-- 弹出TAB -->
<script type="text/javascript" src="plug-in/hplus/hplus-tab.js"></script>
<!-- 在线聊天 -->

</body>

</html>
