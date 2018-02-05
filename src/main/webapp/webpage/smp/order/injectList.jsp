<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="injectlist">
        <div class="row" style="margin-top: 20px">

            <div class="col-sm-12">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <a href="javascript:showPList();"> <h3 class="panel-title" style="text-align: center">注入资金列表 <i id="pList" class="glyphicon glyphicon-triangle-bottom"></i></h3></a>
                    </div>
                    <div class="panel-body" style="padding: 0px;" id="pListHolder">
                        <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color: #EDFFA1 ">
                            <div style="float:left;min-width: 150px;width:20%;height: 50px; ">
                                <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                    <img src="https://www.vipzftaab.com//t/images/button1/00.png">
                                </div>
                                <div style="float: left;height:50px;line-height :25px; text-align: right">

                                    <strong>订单编号</strong>:
                                    <br>
                                    P5899637
                                </div>
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单金额</strong>:
                                1000CNY
                                <br> <strong>应得利息</strong>:
                                200.00CNY
                                <br>
                                二次款

                                已支付
                                ,平衡金50CNY
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单状态</strong>:
                                队列等待<br>（支付尾款）
                            </div>
                            <div style="float:left;min-width: 200px;width:20%;">
                                <strong>订单时间</strong>:
                                2018-01-11 09:03:00
                            </div>
                            <div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">

                                <a class="btn btn-default" href="javascript:;">等待尾款匹配</a>
                            </div>
                            <div style="clear: both"></div>
                        </div>
                        <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color:  cornflowerblue">
                            <div style="float:left;min-width: 150px;width:20%;height: 50px; ">
                                <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                    <img src="https://www.vipzftaab.com//t/images/button1/00.png">
                                </div>
                                <div style="float: left;height:50px;line-height :25px; text-align: right">

                                    <strong>订单编号</strong>:
                                    <br>
                                    P1872326
                                </div>
                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单金额</strong>:
                                8000CNY
                                <br> <strong>应得利息</strong>:
                                2880.00CNY


                            </div>
                            <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                <strong>订单状态</strong>:
                                回流完毕<br>
                            </div>
                            <div style="float:left;min-width: 200px;width:20%;">
                                <strong>订单时间</strong>:
                                2017-12-26 08:33:00
                            </div>
                            <div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">

                                <a class="btn btn-success" href="javascript:checkProvideQEnd('1872326')">转入提现</a>


                            </div>
                            <div style="clear: both"></div>
                        </div>
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

        </div>
    </div>

