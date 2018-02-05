<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title>用户基本信息</title>
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <link href="plug-in/webfront/css/common.css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <style>
        @media (min-width: 768px) {
            body {
                padding-top: 82px;
            }
        }
    </style>
</head>
<body>
<!--页面头部导航-->
<div id="header">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#" style="font-size: 26px;">理财社区</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#">系统首页</a></li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">个人管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">个人资料</a></li>
                            <li><a href="#">修改密码</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">会员中心</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">会员注册</a></li>
                            <li><a href="#">激活码管理</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">财务管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">财务明细</a> </li>
                            <li><a href="#">注资列表</a> </li>
                            <li><a href="#">提取列表</a> </li>
                        </ul>
                    </li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">市场管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">推荐关系</a> </li>
                            <li><a href="#">团队业绩</a> </li>
                        </ul>
                    </li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">公告留言</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">最新公告</a> </li>
                            <li><a href="#">留言中心</a> </li>
                            <li><a href="#">问题反馈</a> </li>
                        </ul>
                    </li>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#" onclick="logout();">安全退出</a></li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">MOCOTT</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="#">修改资料</a> </li>
                            <li><a href="#">安全退出</a> </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="content">
    <div class="container" id="operatorbar">
        <div class="row" style="padding-top: 10px;color: white">
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/inject.png"></a>
                    <h5><strong>注资列表</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/draw.png">
                    </a>
                    <h5><strong>提现列表</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/trad.png"></a>
                    <h5><strong>财务明细</strong></h5>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/regist.png"></a>
                    <h5><strong>注册会员</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/ship.png"></a>
                    <h5><strong>推荐列表</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/team.png"></a>
                    <h5><strong>团队业绩</strong></h5>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/activate.png"></a>
                    <h5><strong>激活码管理</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#"><img class="img-circle navImg" src="plug-in/webfront/images/pro.png"></a>
                    <h5><strong>问题反馈</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="#">
                        <img class="img-circle navImg" src="plug-in/webfront/images/notice.png"></a>
                    <h5><strong>新闻公告</strong></h5>
                </div>
            </div>
        </div>
    </div>
    <div class="container" id="banner">
        <div class="row">
            <ol class="breadcrumb" id="navtitle">
                <li><a href="#">系统首页</a> </li>
            </ol>
        </div>
    </div>
    <div class="container" id="baseinfo">
        <div class="row" style="margin-top: 10px;padding-top: 10px;padding-bottom: 20px">
            <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
                <div class="panel panel-warning panel-base">
                    <div class="panel-heading panel-base-heading">
                        <i class="glyphicon glyphicon-user"></i> 会员信息
                    </div>
                    <div class="panel-body" style="padding: 2px;">
                        <table width="100%" class="table-bordered table-striped table-condensed flip-content" style="border: 1px solid #555555">
                            <tbody>
                            <tr>
                                <td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-king"></i> 会员级别</td>
                                <td style="text-align:center;font-size: 10px" width="29%">初级</td>
                                <td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-yen"></i> 账户总值</td>
                                <td style="text-align:center;font-size: 10px" width="29%"><span id="AccountNickName">29424</span> <!--<i class="icon-refresh" id="todo" style="color:red;"></i>--></td>
                            </tr>

                            <tr>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-object-align-vertical"></i> 直推人数</td>
                                <td style="text-align: center;font-size: 10px">5</td>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-align-justify"></i> 团队人数</td>
                                <td style="text-align: center;font-size: 10px">8</td>
                            </tr>
                            <tr>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 本息钱包</td>
                                <td style="text-align: center;font-size: 10px">39150</td>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 直推钱包</td>
                                <td style="text-align: center;font-size: 10px">100</td>
                            </tr>

                            <tr>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 冻结钱包</td>
                                <td style="text-align: center;font-size: 10px">600</td>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 红包钱包</td>
                                <td style="text-align: center;font-size: 10px">904</td>
                            </tr>
                            <tr>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 待返钱包</td>
                                <td style="text-align: center;font-size: 10px">0</td>
                                <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 激活资金</td>
                                <td style="text-align: center;font-size: 10px">3963</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px">
                <div class="panel panel-warning panel-base">
                    <!-- Default panel contents -->
                    <div class="panel-heading panel-base-heading">
                        <i class="glyphicon glyphicon-comment"></i> 新闻公告
                    </div>
                    <div class="panel-body" style=";padding: 2px;">
                        <table width="100%" class="table-bordered table-striped table-condensed flip-content" style="border: 1px solid #555555">
                            <tbody>
                            <tr>
                                <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px">
                                            2017-12-21
                                        </span>
                                    <a href="https://www.vipzftaab.com/index/adList/?s=204" style="color: #8a6d3b">  <i class="icon-file-alt"></i> 【留言咨询必看】</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px">
                                            2018-01-10
                                        </span>
                                    <a href="https://www.vipzftaab.com/index/adList/?s=222" style="color: #8a6d3b">  <i class="icon-file-alt"></i> 【敬告】【警告】！！！</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px">
                                            2018-01-06
                                        </span>
                                    <a href="https://www.vipzftaab.com/index/adList/?s=221" style="color: #8a6d3b">  <i class="icon-file-alt"></i> 【通知】</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px">
                                            2018-01-04
                                        </span>
                                    <a href="https://www.vipzftaab.com/index/adList/?s=220" style="color: #8a6d3b">  <i class="icon-file-alt"></i> 【通知】</a>
                                </td>
                            </tr>
                            <tr>
                                <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 80px; font-style: italic; margin-right: 10px">
                                            2018-01-01
                                        </span>
                                    <a href="https://www.vipzftaab.com/index/adList/?s=217" style="color: #8a6d3b">  <i class="icon-file-alt"></i> 【支付渠道网络故障】</a>
                                </td>
                            </tr>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>
    </div>

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

    <div class="container" id="injectlist">
        <div class="row" style="margin-top: 20px">

            <div class="col-sm-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <a href="javascript:showPList();"> <h3 class="panel-title" style="text-align: center">注入资金列表 <i id="pList" class="glyphicon glyphicon-triangle-bottom"></i></h3></a>
                    </div>
                    <div class="panel-body" style="padding: 0px;" id="pListHolder">
                        <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color: #EDFFA1 ">
                            <div style="float:left;min-width: 150px;width:20%;height: 50px; ">
                                <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                    <img src="https://www.vipzftaab.com//t/images/button1/00.png">
                                </div>
                                <div style="float: left;height:50px;line-height :25px; text-align: right">

                                    <strong>订单编号</strong>:
                                    <br>
                                    P5899637
                                </div>
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单金额</strong>:
                                1000CNY
                                <br> <strong>应得利息</strong>:
                                200.00CNY
                                <br>
                                二次款

                                已支付
                                ,平衡金50CNY
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单状态</strong>:
                                队列等待<br>（支付尾款）
                            </div>
                            <div style="float:left;min-width: 200px;width:20%;">
                                <strong>订单时间</strong>:
                                2018-01-11 09:03:00
                            </div>
                            <div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">

                                <a class="btn btn-default" href="javascript:;">等待尾款匹配</a>
                            </div>
                            <div style="clear: both"></div>
                        </div>
                        <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color:  cornflowerblue">
                            <div style="float:left;min-width: 150px;width:20%;height: 50px; ">
                                <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                    <img src="https://www.vipzftaab.com//t/images/button1/00.png">
                                </div>
                                <div style="float: left;height:50px;line-height :25px; text-align: right">

                                    <strong>订单编号</strong>:
                                    <br>
                                    P1872326
                                </div>
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单金额</strong>:
                                8000CNY
                                <br> <strong>应得利息</strong>:
                                2880.00CNY


                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单状态</strong>:
                                回流完毕<br>
                            </div>
                            <div style="float:left;min-width: 200px;width:20%;">
                                <strong>订单时间</strong>:
                                2017-12-26 08:33:00
                            </div>
                            <div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">

                                <a class="btn btn-success" href="javascript:checkProvideQEnd('1872326')">转入提现</a>


                            </div>
                            <div style="clear: both"></div>
                        </div>
                        <div style="width: 100%;text-align: center">
                            <nav style="text-align: center">
                                <ul class="pagination pagination-sm">
                                    <li><a href="#">共1页</a></li>
                                    <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                    <li class="active">
                                        <a href="#">1</a>
                                    </li>
                                    <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                    <li>
                                        <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <div class="container" id="drawlist">
        <div class="row" style="">

            <div class="col-sm-12">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <a href="javascript:showAList();"> <h3 class="panel-title" style="text-align: center;color: #8a6d3b">提出资金列表 <i id="aList" class="glyphicon glyphicon-triangle-bottom"></i></h3></a>
                    </div>
                    <div class="panel-body" style="padding: 0px" id="aListHolder">
                        <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color: bisque;">
                            <div style="float:left;min-width: 190px;width:15%;height: 50px; ">
                                <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                    <img src="https://www.vipzftaab.com//t/images/button1/0.png">
                                </div>
                                <div style="float: left;height:190px;line-height :25px;">

                                    <strong>参与者</strong>: Z05942939
                                    <br>
                                    <strong>编&nbsp;&nbsp;&nbsp;&nbsp;号</strong>: G242993
                                </div>
                            </div>

                            <div style="float:left;min-width: 190px;width:15%; ">
                                <strong>钱包</strong>: 本息钱包 直推钱包                                                                    </div>
                            <div style="float:left;min-width: 190px;width:15%;">
                                <strong>金额</strong>:3800
                            </div>
                            <div style="float:left;min-width: 190px;width:20%; ">
                                <strong>日期</strong>: 2018-01-11 09:04:39
                            </div>
                            <div style="float:left;min-width: 200px;">
                                <strong>状态</strong>:等待处理
                            </div>

                            <div style="clear: both"></div>
                        </div>


                        <div style="width: 100%;text-align: center">
                            <nav style="text-align: center">
                                <ul class="pagination pagination-sm">
                                    <li><a href="#">共1页</a></li>
                                    <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                    <li class="active">
                                        <a href="#">1</a>
                                    </li>
                                    <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                    <li>
                                        <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage1"> <a href="javascript:gotoPageTO1()">跳</a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>


<footer style="padding: 20px">
    <p class="pull-right" style="color: white"><a href="#">top</a></p>
    <p style="text-align: center; color: white">Copyright © 2017 Smartpay.com All Rights Reversed.</p>
</footer>

<script src="plug-in-ui/hplus/js/plugins/layer/layer.min.js"></script>
<!-- 第三方插件 -->
<script src="plug-in-ui/hplus/js/plugins/pace/pace.min.js"></script>
<!-- Sweet alert -->
<script src="plug-in-ui/hplus/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="plug-in/jquery-plugs/storage/jquery.storageapi.min.js"></script>
<!-- 弹出TAB -->
<script type="text/javascript" src="plug-in/hplus/hplus-tab.js"></script>
<!-- 在线聊天 -->
<script>
    function logout(){
        $(function () {
            $(".dropdown").mouseover(function (e) {
                $(this).click();
            });
        });

        layer.confirm('您确定要退出登录吗？', {
            btn: ['确定','取消'], //按钮
            shade: false //不显示遮罩
        }, function(){
            location.href="userLoginController.do?logout";
        }, function(){
            return;
        });
    }
</script>

</body>

</html>
