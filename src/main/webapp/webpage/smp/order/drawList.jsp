<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="drawlist">
        <div class="row" style="">

            <div class="col-sm-12">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <a href="javascript:"> <h3 class="panel-title" style="text-align: center;color: #8a6d3b">提出资金列表 <i id="aList" class="glyphicon glyphicon-triangle-bottom"></i></h3></a>
                    </div>
                    <div class="panel-body" style="padding: 0px" id="aListHolder">

                        <c:if test="${not empty outlist}">
                            <c:forEach items="${outlist}" var="outOrder">
                                <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color: bisque;">
                                    <div style="float:left;min-width: 30%;width:15%;height: 50px; ">
                                        <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                            <img src="plug-in/webfront/images/0.png">
                                        </div>
                                        <div style="float: left;height:190px;line-height :25px;">
                                            <strong>参与者</strong>: ${outOrder.username}
                                            <br>
                                            <strong>编&nbsp;&nbsp;&nbsp;&nbsp;号</strong>: ${outOrder.orderCode}
                                        </div>
                                    </div>

                                    <div style="float:left;min-width: 190px;width:15%; ">
                                        <strong>钱包</strong>:
                                        <c:if test="${outOrder.drawWallet == '1'}">
                                            待返钱包
                                        </c:if>
                                        <c:if test="${outOrder.drawWallet == '2'}">
                                            本息钱包 直推钱包
                                        </c:if>

                                    </div>
                                    <div style="float:left;min-width: 190px;width:15%;">
                                        <strong>金额</strong>:${outOrder.orderMoney}
                                    </div>
                                    <div style="float:left;min-width: 190px;width:20%; ">
                                        <strong>日期</strong>: ${outOrder.orderTime}
                                    </div>
                                    <div style="float:left;min-width: 200px;">
                                        <strong>状态</strong>:
                                        <c:if test="${outOrder.orderStatus == '01' || outOrder.orderStatus == '02'}">
                                            等待处理
                                        </c:if>
                                    </div>

                                    <div style="clear: both"></div>
                                </div>
                            </c:forEach>
                        </c:if>

                        <%--<div style="width: 100%;text-align: center">--%>
                            <%--<nav style="text-align: center">--%>
                                <%--<ul class="pagination pagination-sm">--%>
                                    <%--<li><a href="#">共1页</a></li>--%>
                                    <%--<li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>--%>
                                    <%--<li class="active">--%>
                                        <%--<a href="#">1</a>--%>
                                    <%--</li>--%>
                                    <%--<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>--%>
                                    <%--<li>--%>
                                        <%--<input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage1"> <a href="javascript:gotoPageTO1()">跳</a>--%>
                                    <%--</li>--%>
                                <%--</ul>--%>
                            <%--</nav>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>

        </div>
    </div>
