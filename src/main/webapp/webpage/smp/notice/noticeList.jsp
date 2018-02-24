<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="noticelist">
    <c:if test="${not empty notices}">
        <c:forEach items="${notices}" var="notice">
            <div class="row">
                <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <div class="panel panel-warning">
                        <div class="panel-heading">
                            <h3 class="panel-title">${notice.noticeTitle}</h3>
                        </div>
                        <div class="panel-body" style="min-height: 150px">
                            <div style="margin-top: -10px;text-align: right; margin-bottom: 20px;">
                                ${notice.createTime}
                            </div>
                            ${notice.noticeContent}
                        </div>
                    </div>
                </div>
                <div class="col-sm-1"></div>
            </div>
        </c:forEach>
    </c:if>
</div>

