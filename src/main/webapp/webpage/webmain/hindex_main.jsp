<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title>理财社区</title>
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

    <%@include file="/webpage/smp/user/userinfoBase.jsp"%>

    <div class="container" id="tradeinfo">
        <div class="row" style="margin-top: 10px">
            <div id="g12" class="col-sm-6" style="padding-top: 10px">
                <button type="button" id="g8" style="display: none" data-toggle="modal" data-target="#provide">注入资金</button>
                <a href="javascript:;" style="text-decoration:none;width: 100%;">
                    <div style="background: url(&quot;https://www.vipzftaab.com//t/images/button/1.png&quot;) 0% 0% / 100% 100%; min-width: 90%; margin-left: 5%; color: rgb(31, 88, 11); font-size: 30px; text-align: center; font-weight: 900; height: 75px; line-height: 75px;" id="d_1">
                        <img src="https://www.vipzftaab.com//t/images/button/10.png">&nbsp;注入资金
                    </div>
                </a>
            </div>
            <div id="g13" class="col-sm-6" style="padding-top: 10px">
                <button type="button" id="g9" class="btn btn-lg btn-warning " style="display: none" data-toggle="modal" data-target="#accept">提出资金</button>
                <a href="javascript:;" style="text-decoration:none;width: 100%;">
                    <div style="background: url(&quot;https://www.vipzftaab.com//t/images/button/4.png&quot;) 0% 0% / 100% 100%; width: 90%; margin-left: 5%; color: rgb(90, 45, 16); font-size: 30px; text-align: center; font-weight: 900; height: 75px; line-height: 75px;" id="d_2">
                        <img src="https://www.vipzftaab.com/t/images/button/12.png">&nbsp;提出资金
                    </div>
                </a>
            </div>
        </div>
    </div>

    <%@include file="/webpage/smp/order/injectList.jsp"%>
    <%@include file="/webpage/smp/order/drawList.jsp"%>

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
