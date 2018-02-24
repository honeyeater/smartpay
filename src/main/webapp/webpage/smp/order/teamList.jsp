<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="teamList">
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <form action="orderInjectInfoController.do?toTeamList" method="post" style="min-height: 30px">
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">会员名称</label>
                            <div class="input-group date col-md-10">
                                <input class="form-control" size="16" type="text" name="un" value="">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <button type="submit" class="btn btn-primary">搜索</button>
                    </div>
                </form>
            </div>
            <div style="clear: both"></div>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <a href="javascript:showPList();"> <h3 class="panel-title" style="text-align: center">
                        团队业绩 <i id="pList" class="glyphicon glyphicon-triangle-bottom"></i></h3>
                    </a>
                    <p style="text-align: center">本页为会员（${users}）的订单记录</p>
                </div>
                <div class="panel-body" style="padding: 5px" id="pListHolder">
                    <c:if test="${not empty orders}">
                        <c:forEach items="${orders}" var="order">
                            <table class="table " style="border-radius: 10px;margin-top:5px;margin-bottom:5px;width: 100%;background-color:  white ">
                                <thead style="border:none">
                                <tr style="border:none">
                                    <th style="border:none">订单编号</th>
                                    <th style="border:none">${order.orderCode}</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td style="border:none">参与会员</td>
                                    <td style="border:none">${order.username}</td>
                                </tr>
                                <tr>
                                    <td style="border:none">
                                        订单金额
                                    </td>
                                    <td style="border:none">
                                        ${order.orderMoney}CNY
                                    </td>
                                </tr>
                                <tr>
                                    <td style="border:none">
                                        排单时间
                                    </td>
                                    <td style="border:none">
                                        ${order.orderTime}
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty orders}">
                        <span style="text-align: center">暂无订单记录</span>
                    </c:if>


                    <div style="width: 100%;text-align: center">
                        <nav style="text-align: center">
                            <ul class="pagination pagination-sm">
                                <li><a href="#">共1页</a></li>
                                <li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                                <li class="active">
                                    <a href="#">1</a>
                                </li>
                                <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
                                <li>
                                    <input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
