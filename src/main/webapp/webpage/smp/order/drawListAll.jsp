<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">提取资金列表</h3>
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
                        <th>参与者</th>
                        <th>编号</th>
                        <th>钱包</th>
                        <th>状态</th>
                        <th>金额</th>
                        <th>时间</th>
                    </tr>
                    <c:if test="${not empty outlistAll}">
                        <c:forEach items="${outlistAll}" var="outOrder">

                            <tr>
                                <td> ${outOrder.username}</td>
                                <td>
                                        ${outOrder.orderCode}
                                </td>
                                <td>
                                    <c:if test="${outOrder.drawWallet == '1'}">
                                        R钱包
                                    </c:if>
                                    <c:if test="${outOrder.drawWallet == '2'}">
                                        PI钱包 直推钱包
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${outOrder.orderStatus == '01' || outOrder.orderStatus == '02'}">
                                        等待处理
                                    </c:if>
                                    <c:if test="${outOrder.orderStatus == '03'}">
                                        完成
                                    </c:if>
                                </td>
                                <td>${outOrder.orderMoney} </td>
                                <td>${outOrder.orderTime} </td>
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
