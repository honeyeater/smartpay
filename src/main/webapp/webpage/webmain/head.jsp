<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


