<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html lang="en">
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
                <a class="navbar-brand" href="#" style="font-size: 28px;">理财社区</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="#">首页</a></li>
                    <li>
                        <a href="#" class="dropdown-toggle" aria-labelledby="personmanager" data-toggle="dropdown"
                           role="button" aria-expanded="true" aria-haspopup="true">个人管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="http://www.baidu.com">个人资料</a></li>
                            <li><a href="http://www.sina.com.cn">修改密码</a></li>
                        </ul>
                    </li>
                    <li><a href="#">会员中心</a></li>
                    <li><a href="#">财务管理</a></li>
                    <li><a href="#">市场管理</a></li>
                    <li><a href="#">公告留言</a></li>
                    <li><a href="#">常见问题</a></li>
                    <li><a href="#" onclick="logout();">安全退出</a></li>
                    <li><a href="#">HELLO</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div id="content">
    <div class="container">
        <div class="row" style="padding-top: 10px;color: white">
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/provideList/"><img class="img-circle navImg"
                                                                                src="https://www.vipzftaab.com//t/images/navImg/7.png"></a>
                    <h5><strong>注资列表</strong></h5>

                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/acceptList/"><img class="img-circle navImg"
                                                                               src="https://www.vipzftaab.com//t/images/navImg/6.png"></a>
                    <h5><strong>提现列表</strong></h5>


                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/logList/"><img class="img-circle navImg"
                                                                            src="https://www.vipzftaab.com//t/images/navImg/2.png"></a>
                    <h5><strong>财务明细</strong></h5>

                </div>
            </div>
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/register/"><img class="img-circle navImg"
                                                                             src="https://www.vipzftaab.com//t/images/navImg/3.png"></a>
                    <h5><strong>注册会员</strong></h5>


                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/dList/"><img class="img-circle navImg"
                                                                          src="https://www.vipzftaab.com//t/images/navImg/4.png"></a>
                    <h5><strong>推荐列表</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/teamList/"><img class="img-circle navImg"
                                                                             src="https://www.vipzftaab.com//t/images/navImg/9.png"></a>
                    <h5><strong>团队业绩</strong></h5>
                </div>


            </div>
            <div class="col-lg-4">
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/codeList/"><img class="img-circle navImg"
                                                                             src="https://www.vipzftaab.com//t/images/navImg/1.png"></a>
                    <h5><strong>激活码管理</strong></h5>

                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/sendMsg/"><img class="img-circle navImg"
                                                                            src="https://www.vipzftaab.com//t/images/navImg/5.png"></a>
                    <h5><strong>问题反馈</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="https://www.vipzftaab.com/index/adList/"><img class="img-circle navImg"
                                                                           src="https://www.vipzftaab.com//t/images/navImg/8.png"></a>
                    <h5><strong>新闻公告</strong></h5>
                </div>
                <div class="col-sm-4 col-xs-4" style="text-align: center">
                    <a href="frontUserRegisterController.do?register"><img class="img-circle navImg"
                                                                           src="https://www.vipzftaab.com//t/images/navImg/8.png"></a>
                    <h5><strong>用户注册</strong></h5>
                </div>
            </div>
        </div>
    </div>

    <div class="process" id="panelloadingDiv"><b>&nbsp;</b></div>

    <div class="container">
        <div class="row">
            <ol class="breadcrumb" id="navtitle">
                <li>1</li>
                <li>1</li>
                <li>1</li>
            </ol>
        </div>
    </div>

    <div id="myManu">
    </div>
</div>

<div id="copyright">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <p>Copyright © 2017 Smartpay.com All Rights Reversed.</p>
            </div>
        </div>
    </div>
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
<script>
    function logout(){
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
