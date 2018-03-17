<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">注资列表</h3>
        <div class="p10 box_h">
            <%--<div class="form-inline">--%>
                <%--<div class="form-group">订单编号：</div>--%>
                <%--<div class="form-group">--%>
                    <%--<input type="text" class="form-control" placeholder="">--%>
                <%--</div>--%>
                <%--<div class="form-group"> 订单时间：</div>--%>
                <%--<div class="form-group">--%>
                    <%--<div class="input-group">--%>
                        <%--<input type="text" class="form-control" placeholder=""  onClick="WdatePicker()">--%>
                        <%--<span class="input-group-addon" id="basic-addon2"><i class="glyphicon glyphicon-calendar weui-c_9"></i></span>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="form-group"> 订单状态：</div>--%>
                <%--<div class="form-group weui-p_r">--%>
                    <%--<select class="form-control"><option></option></select>--%>
                    <%--<span class="p_select" style="right:10px;"><i class="glyphicon glyphicon-menu-down"></i></span>--%>
                <%--</div>--%>
                <%--<div class="form-group"><input type="button" value="搜索" class="btn btn-warning2 weui-pl30 weui-pr30"></div>--%>

            <%--</div>--%>
            <div class="table-responsive weui-mt15">
                <table class="table table-hover table-striped weui-bb" style="font-size: 14px;">
                    <tr>
                        <th>订单编号</th>
                        <th>订单金额</th>
                        <th>应得利息</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th></th>
                        <th>时间</th>
                        <th>操作</th>
                    </tr>
                    <c:if test="${not empty inlistAll}">
                        <c:forEach var="unInjectInfo" items="${inlistAll}">
                            <tr>
                                <td>${unInjectInfo.orderCode}</td>
                                <td>${unInjectInfo.orderMoney}.CNY </td>
                                <td><span class="weui-red">${unInjectInfo.interest}CNY</span> </td>
                                <td>
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        待支付首付款
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        待支付尾款
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        回流中
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        队列等待
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '05'}">
                                        已完成
                                    </c:if>
                                </td>
                                <c:if test="${empty unInjectInfo.firstPayTime && empty unInjectInfo.endPayTime}">
                                    <td></td>
                                    <td></td>
                                </c:if>
                                <c:if test="${not empty unInjectInfo.firstPayTime && empty unInjectInfo.endPayTime}">
                                    <td>首付款</td>
                                    <td>已支付</td>
                                </c:if>
                                <c:if test="${not empty unInjectInfo.firstPayTime && not empty unInjectInfo.endPayTime}">
                                    <td>尾款</td>
                                    <td>已支付</td>
                                </c:if>
                                <td>${unInjectInfo.orderTime}</td>
                                <td>
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        <a class=" weui-blue weui-t_d paycolor" >等待支付首付款</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        <a class=" weui-blue weui-t_d paycolor">等待支付尾款</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        <a class=" weui-blue weui-mr10" href="javascript:;">保存期</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        <a class=" weui-green" href="#">队列等待</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '05'}">
                                        <a class=" weui-green" href="#">已完成</a>
                                    </c:if>
                                </td>
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




