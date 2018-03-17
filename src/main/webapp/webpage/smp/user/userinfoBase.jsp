<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-6 weui-pt15">
        <div class=" weui-bgf weui-bod_r">
            <h3 class="weui-f16 weui-f_b title"><i class="hy_ico weui-dnb"></i> 会员信息</h3>
            <div class=" weui-pl15 weui-pr15 ">
                <input type="hidden" name="validFlag" id="validFlag" value="${frontUser.validFlag}">
                <div class="row">
                    <div class="col-md-6 weui-b_r">
                        <ul class="hy_h home_h weui-pt15">
                            <li class="clearfix">
                                <span class="weui-fl"><i class="hy weui-dnb"></i> 会员级别</span>
                                <span class="weui-fr">
                                    <c:if test="${userMember.userLevel == '1'}">
                                        普通
                                    </c:if>
                                    <c:if test="${userMember.userLevel == '2'}">
                                        中级
                                    </c:if>
                                    <c:if test="${userMember.userLevel == '3'}">
                                        高级
                                    </c:if>
                                    <c:if test="${userMember.userLevel == '4'}">
                                        VIP
                                    </c:if>
                                </span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="zt1 weui-dnb"></i> 直推人数</span>
                                <span class="weui-fr">${userMember.introNums}</span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="pi weui-dnb"></i> PI钱包</span>
                                <span class="weui-fr">${userMember.couponWallet}</span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="r1 weui-dnb"></i> R钱包</span>
                                <span class="weui-fr">${userMember.backWallet}</span>
                            </li>
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <ul class="hy_h home_h weui-pt15">
                            <li class="clearfix">
                                <span class="weui-fl"><i class="zh weui-dnb"></i> 账户总值</span>
                                <span class="weui-fr">${userMember.sumAmount}</span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="team weui-dnb"></i> 团队人数</span>
                                <span class="weui-fr">${userMember.teamNums}</span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="zt weui-dnb"></i> 直推钱包</span>
                                <span class="weui-fr">${userMember.introWallet}</span>
                            </li>
                            <li class="clearfix">
                                <span class="weui-fl"><i class="jh weui-dnb"></i> 激活资金</span>
                                <span class="weui-fr">${userMember.activeCost}</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-6 col_l_0  weui-pt15">
        <div class=" weui-bgf weui-bod_r">
            <h3 class="weui-f16 weui-f_b title"><i class="news_ico weui-dnb"></i> 新闻公告</h3>
            <div class=" weui-pl15 weui-pr15 weui-pt10 weui-pb10 home_h">
                <ul class="weui-lh30 newsul">
                    <c:if test="${not empty userNotices}">
                        <c:forEach items="${userNotices}" var="userNotice">
                            <li class="clearfix">
                                <a href="tSUsernoticeController.do?toNoticeList" class="weui-fl">${userNotice.noticeTitle}</a>
                                <span class="weui-c_9 weui-fr">${userNotice.createTime}</span>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>

<%--<div class="container" id="baseinfo">--%>
    <%--<div class="row" style="margin-top: 10px;padding-top: 10px;padding-bottom: 20px">--%>
        <%--<div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">--%>
            <%--<div class="panel panel-warning panel-base">--%>
                <%--<div class="panel-heading panel-base-heading">--%>
                    <%--<i class="glyphicon glyphicon-user"></i> 会员信息--%>
                <%--</div>--%>
                <%--<input type="hidden" name="validFlag" id="validFlag" value="${frontUser.validFlag}">--%>
                <%--<div class="panel-body" style="padding: 2px;">--%>
                    <%--<table width="100%" class="table-bordered table-striped table-condensed flip-content" style="border: 1px solid #555555">--%>
                        <%--<tbody>--%>
                        <%--<tr>--%>
                            <%--<td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-king"></i> 会员级别</td>--%>
                            <%--<td style="text-align:center;font-size: 10px" width="29%">--%>
                                <%--<c:if test="${userMember.userLevel == '1'}">--%>
                                    <%--普通--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${userMember.userLevel == '2'}">--%>
                                    <%--中级--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${userMember.userLevel == '3'}">--%>
                                    <%--高级--%>
                                <%--</c:if>--%>
                                <%--<c:if test="${userMember.userLevel == '4'}">--%>
                                    <%--VIP--%>
                                <%--</c:if>--%>

                            <%--</td>--%>
                            <%--<td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-yen"></i> 账户总值</td>--%>
                            <%--<td style="text-align:center;font-size: 10px" width="29%"><span id="AccountNickName">--%>
                                <%--${userMember.sumAmount}--%>
                            <%--</span> <!--<i class="icon-refresh" id="todo" style="color:red;"></i>--></td>--%>
                        <%--</tr>--%>

                        <%--<tr>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-object-align-vertical"></i> 直推人数</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.introNums}--%>
                            <%--</td>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-align-justify"></i> 团队人数</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.teamNums}--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 本息钱包</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.couponWallet}--%>
                            <%--</td>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 直推钱包</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.introWallet}--%>

                            <%--</td>--%>
                        <%--</tr>--%>

                        <%--<tr>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 冻结钱包</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.blockWallet}--%>
                            <%--</td>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 红包钱包</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.redWallet}--%>
                            <%--</td>--%>
                        <%--</tr>--%>
                        <%--<tr>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 待返钱包</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.backWallet}--%>
                            <%--</td>--%>
                            <%--<td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 激活资金</td>--%>
                            <%--<td style="text-align: center;font-size: 10px">--%>
                                <%--${userMember.activeCost}--%>
                            <%--</td>--%>
                        <%--</tr>--%>

                        <%--</tbody>--%>
                    <%--</table>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px">--%>
            <%--<div class="panel panel-warning panel-base">--%>
                <%--<!-- Default panel contents -->--%>
                <%--<div class="panel-heading panel-base-heading">--%>
                    <%--<i class="glyphicon glyphicon-comment"></i> 新闻公告--%>
                <%--</div>--%>
                <%--<div class="panel-body" style=";padding: 2px;">--%>
                    <%--<table width="100%" class="table-bordered table-striped table-condensed flip-content" style="border: 1px solid #555555">--%>
                        <%--<tbody>--%>
                            <%--<c:if test="${not empty userNotices}">--%>
                                <%--<c:forEach items="${userNotices}" var="userNotice">--%>
                                    <%--<tr>--%>
                                        <%--<td class="tit" colspan="4" style="text-align: left;font-size: 10px">--%>
                                        <%--<span style="color: #bbb;font-size: 10px;display: block;float: left;width: 40%; font-style: italic; margin-right: 10px">--%>
                                            <%--${userNotice.createTime}--%>
                                        <%--</span>--%>
                                            <%--<a href="tSUsernoticeController.do?toNoticeList" style="color: #8a6d3b">  <i class="icon-file-alt"></i> ${userNotice.noticeTitle}</a>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>
                                <%--</c:forEach>--%>
                            <%--</c:if>--%>
                        <%--</tbody>--%>
                    <%--</table>--%>

                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<script type="text/javascript">

</script>