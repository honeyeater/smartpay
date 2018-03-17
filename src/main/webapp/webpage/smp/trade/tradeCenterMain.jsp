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
</head>
<body>
<%--页面头部导航--%>
<%@include file="/webpage/webmain/head.jsp"%>

<div class="r_content">
    <%--用户信息--%>
    <%@include file="/webpage/webmain/userinfo.jsp"%>
    <%--财务明细--%>
    <%@include file="/webpage/smp/trade/tradeCenter.jsp"%>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                <h4 class="modal-title weui-f18" id="myModalLabel">转账信息</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="usdtChangeFrom">
                <div class="weui-pb20">
                    <table width="100%" style="font-size: 14px;">
                        <tr>
                            <td class="weui-pt10" width="110">我的usdt数量：</td>
                            <td class="weui-pt10">${userUsdtInfo.num}</td>
                        </tr>
                        <tr>
                            <td class="weui-pt30">我的usdt价值：</td>
                            <td class="weui-pt30">${myprice}</td>
                        </tr>
                        <tr>
                            <td class="weui-pt30">转  账 数  量 ：</td>
                            <td class="weui-pt30"><input type="text" class="form-control" id="tradeNum" name="tradeNum"></td>
                        </tr>
                        <tr>
                            <td class="weui-pt30">转  账  账  户 ：</td>
                            <td class="weui-pt30"><input type="text" class="form-control" id="tradeUserName" name="tradeUserName"></td>
                        </tr>
                        <tr>
                            <td class="weui-pt30">安  全  密  码 ：</td>
                            <td class="weui-pt30"><input type="text" class="form-control" id="tradesafepwd" name="tradesafepwd"></td>
                        </tr>
                    </table>
                </div>
                <div class=" weui-mt30"><input type="button" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10" value="确认转账"
                                               onclick="return payChangeCallback();"></div>
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

<script type="text/javascript">
    function payChangeCallback() {
        var url="usdtTradeController.do?toChangeTrade";
        var fromData = $('#usdtChangeFrom').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            data : fromData,
            url : url,// 请求的action路径
            error : function() {// 请求失败处理函数
                alert("服务器异常,请稍后重试!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    layer.alert(d.msg, {
                        offset: '240px'
                    }, function(){
                        location.href="usdtTradeController.do?toTrade";
                    });
                } else {
                    layer.alert(d.msg, {
                        offset: '240px'
                    });
                }
            }
        });
        return false;
    }

</script>

</html>
