<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--页面导航-->
<span class="m_nav"><i class="glyphicon glyphicon-menu-hamburger"></i></span>
<div class="leftmenu">
    <div class="logo weui-t_c"><img src="plug-in/smp/images/logo.png"></div>
    <ul>
        <li>
            <a href="userLoginController.do?toIndex"><i class="ihome"></i> 系统首页 <em></em></a>
        </li>
        <li>
            <a href="usdtTradeController.do?toTrade"><i class="idt"></i> 交易大厅 <em></em></a>
        </li>
        <li>
            <a href="javascript:;"><i class="icw"></i> 财务中心 <em></em></a>
            <ul class="weui-pt5 weui-d_n">
                <li><a href="orderInjectInfoController.do?tofinancelist">财务明细</a></li>
                <li><a href="orderInjectInfoController.do?toInjectList">注资列表</a></li>
                <li><a href="orderDrawInfoController.do?toDrawList">提取列表</a></li>
                <li><a href="frontUserMemberController.do?toMemberShip">推荐关系</a></li>
                <li><a href="orderInjectInfoController.do?toTeamList">团队业绩</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:;"><i class="iyh"></i> 用户中心 <em></em></a>
            <ul class="weui-pt5 weui-d_n">
                <li><a href="frontUserRegisterController.do?gouserinfo">个人资料</a></li>
                <li><a href="frontUserRegisterController.do?updatepwd">修改密码</a></li>
                <li><a href="frontUserActivatecodeController.do?list">激活码管理</a></li>
                <li><a href="frontUserRegisterController.do?tousergeneral">会员注册</a></li>
                <li><a href="#"  onclick="logout();">退出</a></li>
            </ul>
        </li>
        <li>
            <a href="javascript:;"><i class="ihelp"></i> 帮助中心 <em></em></a>
            <ul class="weui-pt5 weui-d_n">
                <li><a href="tSUsernoticeController.do?toNoticeList">最新公告</a></li>
                <li><a href="tSFeedbackController.do?toFeedback">问题反馈</a></li>
                <li><a href="tSUserquestionController.do?toIssueList">常见问题</a></li>
            </ul>
        </li>
        <li>
            <%--<a href="#" onclick="logout();"><i class="ihelp"></i> 退出 <em></em></a>--%>
        </li>
    </ul>
</div>

<%--${currentUser.userName}--%>
<%--<input type="hidden" id="currentUserId" name="currentUserId" value="${currentUser.id}">--%>
<%--<input type="hidden" id="currentUserName" name="currentUserName" value="${currentUser.userName}">--%>
<%--<li><a href="tSFeedreplyController.do?toMessagelist">留言中心</a> </li>--%>

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
    function setMenuOn() {
        var uu = window.location.href;
        var ab  = $('.leftmenu>ul>li>a');
        if(uu.indexOf("userLoginController.do?toIndex") != -1) {
            $(ab[0]).addClass('on');
        }
        if(uu.indexOf("usdtTradeController.do?toTrade") != -1) {
            $(ab[1]).addClass('on');
        }
        if(uu.indexOf("orderInjectInfoController.do?tofinancelist") != -1) {
            $(ab[2]).addClass('on');
            $(ab[2]).next().slideDown();
        }
        if(uu.indexOf("orderInjectInfoController.do?toInjectList") != -1) {
            $(ab[2]).addClass('on');
            $(ab[2]).next().slideDown();
        }
        if(uu.indexOf("orderDrawInfoController.do?toDrawList") != -1) {
            $(ab[2]).addClass('on');
            $(ab[2]).next().slideDown();
        }
        if(uu.indexOf("frontUserMemberController.do?toMemberShip") != -1) {
            $(ab[2]).addClass('on');
            $(ab[2]).next().slideDown();
        }
        if(uu.indexOf("orderInjectInfoController.do?toTeamList") != -1) {
            $(ab[2]).addClass('on');
            $(ab[2]).next().slideDown();
        }
        if(uu.indexOf("frontUserRegisterController.do?gouserinfo") != -1) {
            $(ab[3]).addClass('on');
            $(ab[3]).next().slideDown();
        }
        if(uu.indexOf("frontUserRegisterController.do?updatepwd") != -1) {
            $(ab[3]).addClass('on');
            $(ab[3]).next().slideDown();
        }
        if(uu.indexOf("frontUserActivatecodeController.do?list") != -1) {
            $(ab[3]).addClass('on');
            $(ab[3]).next().slideDown();
        }
        if(uu.indexOf("frontUserRegisterController.do?tousergeneral") != -1) {
            $(ab[3]).addClass('on');
            $(ab[3]).next().slideDown();
        }
        if(uu.indexOf("tSUsernoticeController.do?toNoticeList") != -1) {
            $(ab[4]).addClass('on');
            $(ab[4]).next().slideDown();
        }
        if(uu.indexOf("tSFeedbackController.do?toFeedback") != -1) {
            $(ab[4]).addClass('on');
            $(ab[4]).next().slideDown();
        }
        if(uu.indexOf("tSUserquestionController.do?toIssueList") != -1) {
            $(ab[4]).addClass('on');
            $(ab[4]).next().slideDown();
        }
    }
    setMenuOn();


</script>
