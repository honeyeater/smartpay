<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="header clearfix">
    <div class="media weui-fr" style="width:200px;">
        <div class="media-left">
            <a href="#"><img class="media-object" src="plug-in/smp/images/home_05.png" alt="..."></a>
        </div>
        <div class="media-body weui-white">
            <h4 class="media-heading weui-pt15">用户名：${currentUser.userName} <span class="caret"></span></h4>
            <input type="hidden" id="currentUserId" name="currentUserId" value="${currentUser.id}">
            <input type="hidden" id="currentUserName" name="currentUserName" value="${currentUser.userName}">
        </div>
    </div>
</div>
