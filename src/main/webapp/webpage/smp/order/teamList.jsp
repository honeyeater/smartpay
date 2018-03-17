<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">团队业绩</h3>
        <div class="p10 box_h">
            <form action="orderInjectInfoController.do?toTeamList" method="post" style="min-height: 30px">
            <div class="form-inline weui-pt10">
                <div class="form-group">会员名称：</div>
                <div class="form-group">
                    <div class="input-group">
                        <input class="form-control" size="16" type="text" name="un" value="">
                        <span class="input-group-addon" id="basic-addon2"><i class="glyphicon glyphicon-user weui-c_9"></i></span>
                    </div>
                </div>
                <%--<div class="form-group"> 排单时间：</div>--%>
                <%--<div class="form-group">--%>
                    <%--<div class="input-group">--%>
                        <%--<input type="text" class="form-control" placeholder=""  onClick="WdatePicker()">--%>
                        <%--<span class="input-group-addon" id="basic-addon2"><i class="glyphicon glyphicon-calendar weui-c_9"></i></span>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group"><input type="submit" value="搜索" class="btn btn-warning2 weui-pl30 weui-pr30"></div>
            </div>
            </form>

            <p class="weui-f_b weui-orange weui-pt15 txt_color">本页为会员（${users}）的订单记录</p>
            <div class="row">
                <c:if test="${not empty orders}">
                    <c:forEach items="${orders}" var="order">
                        <div class="col-md-12">
                            <div class="dd_box weui-mb15">
                                <h3 class="weui-f16 weui-f_b title title1">订单编号	${order.orderCode}</h3>
                                <div class="weui-pl15 weui-pt10 weui-pb10 weui-pr15">
                                    <table class="weui-lh30" width="100%" style="font-size: 14px;">
                                        <tr>
                                            <td width="70" class="weui-v_t">参与会员</td>
                                            <td>${order.username}</td>
                                        </tr>
                                        <tr>
                                            <td>订单金额</td>
                                            <td class="weui-red"> ${order.orderMoney}CNY</td>
                                        </tr>
                                        <tr>
                                            <td>排单时间</td>
                                            <td>${order.orderTime}</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>


                    </c:forEach>
                </c:if>
                <c:if test="${empty orders}">
                    <div class="col-md-12">
                        <div class="dd_box weui-mb15">
                            <h3 class="weui-f16 weui-f_b title title1">订单编号	${order.orderCode}</h3>
                            <div class="weui-pl15 weui-pt10 weui-pb10 weui-pr15">
                                <table class="weui-lh30" width="100%" style="font-size: 14px;">
                                    <tr>
                                        <td>暂无订单记录</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div>
                </c:if>




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
</div>