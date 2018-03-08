<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="tradelist">
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-sm-10">
                <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                    <link href="plug-in/datepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">


                    <form action="orderInjectInfoController.do?tofinancelist" method="post" style="min-height: 30px">
                        <div class="col-sm-5">
                            <div class="form-group">
                                <label for="bTimeDate" class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">开始</label>
                                <div class="input-group date form_datetime col-md-10" data-date="" data-date-format="yyyy-mm-dd HH:ii:ss" data-link-field="bTimeDate">
                                    <input class="form-control" size="16" type="text" value="" readonly="">

                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <input type="hidden" id="bTimeDate" name="bTimeDate" value=""><br>
                            </div>
                        </div>

                        <div class="col-sm-5">
                            <div class="form-group">
                                <label for="eTimeDate" class="col-md-2 control-label" style="line-height: 30px; padding: 0px;">结束</label>
                                <div class="input-group date form_datetime col-md-10" data-date="" data-date-format="yyyy-mm-dd HH:ii:ss" data-link-field="eTimeDate">
                                    <input class="form-control" size="16" type="text" value="" readonly="">

                                    <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                                </div>
                                <input type="hidden" id="eTimeDate" name="eTimeDate" value=""><br>
                            </div>
                        </div>

                        <div class="col-sm-2">
                            <button type="submit" class="btn btn-primary">搜索</button>
                        </div>
                    </form>
                    <script type="text/javascript" src="plug-in/datepicker/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
                    <script type="text/javascript" src="plug-in/datepicker/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
                    <script>
                        $('.form_datetime').datetimepicker({
                            language:  'zh-CN',
                            weekStart: 1,
                            todayBtn:  1,
                            autoclose: 1,
                            todayHighlight: 1,
                            startView: 2,
                            forceParse: 0,
                            showMeridian: 1
                        });
                    </script>
                    <table class="table table-striped table-bordered " style="border-color: #0a0c0e">
                        <thead>
                        <tr>
                            <th style="font-size: 10px">支付注入金额</th>
                            <th style="font-size: 10px">利息金额</th>
                            <th style="font-size: 10px">返还钱包金额</th>
                            <th style="font-size: 10px">直推奖金</th>
                            <th style="font-size: 10px">提出奖金</th>
                            <th style="font-size: 10px">时间</th>
                            <th style="font-size: 10px">原因</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:if test="${empty logTradeInfos}">
                            <tr>
                                暂无信息
                            </tr>
                        </c:if>
                        <c:if test="${not empty logTradeInfos}">
                            <c:forEach items="${logTradeInfos}" var="tradeInfo">
                                <tr>
                                    <td style="font-size: 10px">${tradeInfo.staticMoney}</td>
                                    <td style="font-size: 10px">${tradeInfo.dynMoney}</td>
                                    <td style="font-size: 10px">${tradeInfo.backMoney}</td>
                                    <td style="font-size: 10px">${tradeInfo.releaseMoney}</td>
                                    <td style="font-size: 10px">${tradeInfo.nfield1}</td>

                                    <td style="font-size: 10px">${tradeInfo.tradeTime}</td>
                                    <td style="font-size: 10px">${tradeInfo.reason}</td>
                                </tr>
                            </c:forEach>
                        </c:if>

                        </tbody>
                    </table>
                    <%--<nav style="text-align: center">--%>
                        <%--<ul class="pagination pagination-sm">--%>
                            <%--<li><a href="#">共9页</a></li>--%>
                            <%--<li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>--%>
                            <%--<li class="active">--%>
                                <%--<a href="#">1</a>--%>
                            <%--</li>--%>
                            <%--<li><a href="javascript:gotoPage(2)">2</a></li>--%>
                            <%--<li><a href="javascript:gotoPage(3)">3</a></li>--%>
                            <%--<li><a href="javascript:gotoPage(4)">4</a></li>--%>
                            <%--<li><a href="javascript:gotoPage(5)">5</a></li>--%>
                            <%--<li><a href="javascript:gotoPage(6)">6</a></li>--%>
                            <%--<li><a href="javascript:gotoPage(2)" aria-label="Next"><span aria-hidden="true">»</span></a></li>--%>
                            <%--<li>--%>
                                <%--<input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>--%>
                            <%--</li>--%>
                        <%--</ul>--%>
                    <%--</nav>--%>
                </div>

            </div>
            <div class="col-sm-1"></div>

        </div>
    </div>


