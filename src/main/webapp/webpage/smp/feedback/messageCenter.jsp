<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="messagelist">
    <div class="row">

        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <div class="alert alert-danger" role="alert">
                    说明：点击留言标题可查看客服回复！<br>
                    客服工作时间每日上午<strong>9:00</strong>-中午<strong>12:00</strong> 下午<strong>14:00</strong>-晚上<strong>21:00</strong><br>
                    1、针对不同问题的留言，处理回复的时间也有所不同，请耐心等待回复！<br>
                    2、同一问题不要重复提交多条留言，以免被系统刪除而全部得不到处理。<br>
                    3、如果问题您已自行处理好，那可以及时关闭留言！<br>
                </div>
                <div class="col-lg-12" style="text-align: left">
                    <c:if test="${not empty feedbackInfos}">
                        <c:forEach items="${feedbackInfos}" var="feedbackInfo">
                                <div class="panel panel-default">
                                    <div class="panel-heading bg-info">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#accordion"
                                               href="#${feedbackInfo.feedbackid}">
                                                <strong>${feedbackInfo.title}</strong>
                                            </a>
                                        </h4>
                                    </div>
                                    <div id="${feedbackInfo.feedbackid}" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <span>
                                                <strong>反馈时间:${feedbackInfo.feedtime}</strong><br>
                                                <strong>反馈内容:${feedbackInfo.content}</strong><br>
                                            </span>
                                            =======================================================
                                            <br>
                                            <c:if test="${not empty feedbackInfo.feedReplyInfo}">
                                                <span>
                                                    <strong>回复时间:${feedbackInfo.feedReplyInfo.replyTime}</strong><br>
                                                    <strong>回复内容:${feedbackInfo.feedReplyInfo.replyContent}</strong><br>
                                                </span
                                            </c:if>
                                            <c:if test="${empty feedbackInfo.feedReplyInfo}">
                                                <span>暂无回复,敬请期待!
                                                </span>
                                            </c:if>

                                        </div>
                                    </div>
                                </div>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty feedbackInfos}">
                        暂无记录
                    </c:if>
                </div>
            </div>
        </div>

        <div class="col-sm-1"></div>

    </div>
</div>

