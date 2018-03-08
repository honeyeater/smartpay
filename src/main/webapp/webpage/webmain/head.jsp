<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--页面头部导航-->
<div id="header">
    <nav class="navbar navbar-default navbar-fixed-top" >
        <div class="container" style="width: 90%;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="userLoginController.do?toIndex" style="font-size: 24px;">金润理财</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="active"><a href="userLoginController.do?toIndex">系统首页</a></li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">个人管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="frontUserRegisterController.do?gouserinfo">个人资料</a></li>
                            <li><a href="frontUserRegisterController.do?updatepwd">修改密码</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">会员中心</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="frontUserRegisterController.do?tousergeneral">会员注册</a></li>
                            <li><a href="frontUserActivatecodeController.do?activatecode">激活码管理</a></li>
                        </ul>
                    </li>
                    <li><a href="usdtTradeController.do?toTrade">交易中心</a></li>
                    <li>
                        <a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">财务管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="orderInjectInfoController.do?tofinancelist">财务明细</a> </li>
                            <li><a href="orderInjectInfoController.do?toInjectList">注资列表</a> </li>
                            <li><a href="orderDrawInfoController.do?toDrawList">提取列表</a> </li>
                        </ul>
                    </li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">市场管理</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="frontUserMemberController.do?toMemberShip">推荐关系</a> </li>
                            <li><a href="orderInjectInfoController.do?toTeamList">团队业绩</a> </li>
                        </ul>
                    </li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">公告留言</a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="tSUsernoticeController.do?toNoticeList">最新公告</a> </li>
                            <li><a href="tSFeedreplyController.do?toMessagelist">留言中心</a> </li>
                            <li><a href="tSFeedbackController.do?toFeedback">问题反馈</a> </li>
                        </ul>
                    </li>
                    <li><a href="tSUserquestionController.do?toIssueList">常见问题</a></li>
                    <li><a href="#" onclick="logout();">安全退出</a></li>
                    <li><a href="#" class="dropdown" data-toggle="dropdown" aria-labelledby=""
                           role="button" aria-expanded="true" aria-haspopup="true">
                            ${currentUser.userName}
                        <input type="hidden" id="currentUserId" name="currentUserId" value="${currentUser.id}">
                        <input type="hidden" id="currentUserName" name="currentUserName" value="${currentUser.userName}">
                    </a>
                        <ul class="dropdown-menu dropdown-menu-left">
                            <li><a href="frontUserRegisterController.do?gouserinfo">修改资料</a></li>
                            <li><a href="#" onclick="logout();">安全退出</a> </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>


<script>
    $(function () {
        $(".dropdown").mouseover(function (e) {
            $(this).click();
        });
    });
    function logout(){
        layer.confirm('您确定要退出登录吗？', {
            offset: '240px',
            scrollbar: false,
            btn: ['确定','取消'], //按钮
            shade: 0.3 //不显示遮罩
        }, function(){
            location.href="userLoginController.do?logout";
        }, function(){
            return;
        });
    }
</script>
