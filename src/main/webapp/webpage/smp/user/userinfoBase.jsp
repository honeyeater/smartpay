<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="baseinfo">
    <div class="row" style="margin-top: 10px;padding-top: 10px;padding-bottom: 20px">
        <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
            <div class="panel panel-warning panel-base">
                <div class="panel-heading panel-base-heading">
                    <i class="glyphicon glyphicon-user"></i> 会员信息
                </div>
                <input type="hidden" name="validFlag" id="validFlag" value="${frontUser.validFlag}">
                <div class="panel-body" style="padding: 2px;">
                    <table width="100%" class="table-bordered table-striped table-condensed flip-content" style="border: 1px solid #555555">
                        <tbody>
                        <tr>
                            <td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-king"></i> 会员级别</td>
                            <td style="text-align:center;font-size: 10px" width="29%">
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

                            </td>
                            <td style="font-size: 10px" class="tit" width="21%"><i class="glyphicon glyphicon-yen"></i> 账户总值</td>
                            <td style="text-align:center;font-size: 10px" width="29%"><span id="AccountNickName">
                                ${userMember.sumAmount}
                            </span> <!--<i class="icon-refresh" id="todo" style="color:red;"></i>--></td>
                        </tr>

                        <tr>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-object-align-vertical"></i> 直推人数</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.introNums}
                            </td>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-align-justify"></i> 团队人数</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.teamNums}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 本息钱包</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.couponWallet}
                            </td>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 直推钱包</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.introWallet}

                            </td>
                        </tr>

                        <tr>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 冻结钱包</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.blockWallet}
                            </td>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-lock"></i> 红包钱包</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.redWallet}
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 待返钱包</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.backWallet}
                            </td>
                            <td style="font-size: 10px" class="tit"><i class="glyphicon glyphicon-yen"></i> 激活资金</td>
                            <td style="text-align: center;font-size: 10px">
                                ${userMember.activeCost}
                            </td>
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
                            <c:if test="${not empty userNotices}">
                                <c:forEach items="${userNotices}" var="userNotice">
                                    <tr>
                                        <td class="tit" colspan="4" style="text-align: left;font-size: 10px">
                                        <span style="color: #bbb;font-size: 10px;display: block;float: left;width: 40%; font-style: italic; margin-right: 10px">
                                            ${userNotice.createTime}
                                        </span>
                                            <a href="tSUsernoticeController.do?toNoticeList" style="color: #8a6d3b">  <i class="icon-file-alt"></i> ${userNotice.noticeTitle}</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $(function() {
       var validFlag = $("#validFlag").val();
        if(validFlag != "1") {
            layer.alert("用户被冻结,请联系管理员购买激活码激活账户!", {
               offset:'25%',
                closeBtn: 0
            });
        }
    });
</script>