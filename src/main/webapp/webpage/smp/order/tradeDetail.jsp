<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">

        <h3 class="weui-f16 weui-f_b title">明细列表</h3>
        <div class="p10 box_h">
            <form action="orderInjectInfoController.do?tofinancelist" method="post" style="min-height: 30px">
            <div class="form-inline">
                <div class="form-group">开始时间：</div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="" id="bTimeDate" name="bTimeDate" onClick="WdatePicker()">
                        <span class="input-group-addon" id="basic-addon2"><i class="glyphicon glyphicon-calendar weui-c_9"></i></span>
                    </div>
                </div>
                <div class="form-group">结束时间：</div>
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" class="form-control" id="eTimeDate" name="eTimeDate" onClick="WdatePicker()" placeholder="" >
                        <span class="input-group-addon" id="basic-addon3" ><i class="glyphicon glyphicon-calendar weui-c_9"></i></span>
                    </div>
                </div>
                <div class="form-group"><input type="submit" value="搜索" class="btn btn-warning2 weui-pl30 weui-pr30"></div>
            </div>
            </form>
            <div class="table-responsive weui-mt15">
                <table class="table table-hover table-striped weui-bb" style="font-size: 14px;">
                    <tr>
                        <th>支付注入金额</th>
                        <th>利息金额</th>
                        <th>R钱包金额</th>
                        <th>直推奖金</th>
                        <th>提出奖金</th>
                        <th>时间</th>
                        <th>原因</th>
                    </tr>
                    <c:if test="${empty logTradeInfos}">
                        <tr>
                            暂无信息
                        </tr>
                    </c:if>
                    <c:if test="${not empty logTradeInfos}">
                        <c:forEach items="${logTradeInfos}" var="tradeInfo">
                            <tr>
                                <td class="weui-red">${tradeInfo.staticMoney}</td>
                                <td >${tradeInfo.dynMoney}</td>
                                <td >${tradeInfo.backMoney}</td>
                                <td >${tradeInfo.releaseMoney}</td>
                                <td >${tradeInfo.nfield1}</td>
                                <td >${tradeInfo.tradeTime}</td>
                                <td >${tradeInfo.reason}</td>
                            </tr>
                        </c:forEach>
                    </c:if>

                </table>
            </div>
            <%--<nav class="weui-t_c" aria-label="Page navigation">--%>
                <%--<ul class="pagination">--%>
                    <%--<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>--%>
                    <%--<li class="active"><a href="#">1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>
                    <%--<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>--%>
                <%--</ul>--%>
            <%--</nav>--%>

        </div>
    </div>
</div>



