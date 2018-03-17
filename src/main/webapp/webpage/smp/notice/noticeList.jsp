<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="noticelist">

</div>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">最新公告</h3>
        <div class=" weui-p15 box_h">
            <c:if test="${not empty notices}">
                <c:forEach items="${notices}" var="notice">

                    <div class="row">
                        <div class="col-md-12">
                            <div class="news weui-bod_r weui-p15 weui-mb10">
                                <div class="clearfix">
                                    <a href="#" class="weui-f16 weui-f_b">${notice.noticeTitle}</a>
                                    <span class="weui-fr">${notice.createTime}</span>
                                </div>
                                <p>
                                   ${notice.noticeContent}
                                </p>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
    </div>
</div>

