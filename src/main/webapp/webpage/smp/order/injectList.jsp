<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="injectlist">
    <div class="row" style="margin-top: 20px">
        <div class="col-sm-12">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <a href="#">
                        <h3 class="panel-title" style="text-align: center">注入资金列表 <i id="pList" class="glyphicon glyphicon-triangle-bottom"></i></h3>
                    </a>
                </div>
                <div class="panel-body" style="padding: 0px;" id="pListHolder">
                    <%--注入资金列表--%>
                    <c:if test="${not empty inlist}">
                        <c:forEach var="unInjectInfo" items="${inlist}">
                            <div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color: #EDFFA1 ">
                                <div style="float:left;min-width: 150px;width:20%;height: 50px; ">
                                    <div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">
                                        <img src="plug-in/webfront/images/00.png">
                                    </div>
                                    <div style="float: left;height:50px;line-height :25px; text-align: left" id="orderno">
                                        <strong>订单编号</strong>:
                                        <br>
                                        ${unInjectInfo.orderCode}
                                    </div>
                                </div>
                                <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px " id="orderamount">
                                    <strong>订单金额</strong>:
                                    ${unInjectInfo.orderMoney}CNY
                                    <br> <strong>应得利息</strong>:
                                    ${unInjectInfo.interest}CNY
                                    <br>
                                    <c:if test="${not empty unInjectInfo.firstPayTime && empty unInjectInfo.endPayTime}">
                                       一次款 已支付
                                    </c:if>
                                    <c:if test="${not empty unInjectInfo.firstPayTime && not empty unInjectInfo.endPayTime}">
                                        二次款 已支付
                                    </c:if>
                                </div>
                                <div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">
                                    <strong>订单状态</strong>:
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        待支付首付款
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        队列等待<br>(支付尾款)
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        回流中
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        回流完毕
                                    </c:if>
                                </div>
                                <div style="float:left;min-width: 200px;width:20%;">
                                    <strong>订单时间</strong>:
                                    ${unInjectInfo.orderTime}
                                </div>
                                <div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        <a class="btn btn-info" href="javascript:payAmout('${unInjectInfo.orderCode}','1');">等待支付首付款</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        <a class="btn btn-info" href="javascript:payAmout('${unInjectInfo.orderCode}','2');">等待尾款匹配</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        <a class="btn btn-info" href="javascript:;">保存期</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        <a class="btn btn-success" href="javascript:checkProvideQEnd('${unInjectInfo.orderCode}');">转入提现</a>
                                    </c:if>
                                </div>
                                <div style="clear: both"></div>
                            </div>
                        </c:forEach>
                    </c:if>


                    <%--<div style=" border-radius: 10px;margin:5px;padding: 0px;padding-left: 20px;background-color:  cornflowerblue">--%>
                        <%--<div style="float:left;min-width: 150px;width:20%;height: 50px; ">--%>
                            <%--<div style="float: left;line-height: 50px;height: 50px;color: white;margin-right: 5px">--%>
                                <%--<img src="https://www.vipzftaab.com//t/images/button1/00.png">--%>
                            <%--</div>--%>
                            <%--<div style="float: left;height:50px;line-height :25px; text-align: right">--%>

                                <%--<strong>订单编号</strong>:--%>
                                <%--<br>--%>
                                <%--P1872326--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">--%>
                            <%--<strong>订单金额</strong>:--%>
                            <%--8000CNY--%>
                            <%--<br> <strong>应得利息</strong>:--%>
                            <%--2880.00CNY--%>


                        <%--</div>--%>
                        <%--<div style="float:left;min-width: 240px;width:20%;height: 50px;line-height: 25px ">--%>
                            <%--<strong>订单状态</strong>:--%>
                            <%--回流完毕<br>--%>
                        <%--</div>--%>
                        <%--<div style="float:left;min-width: 200px;width:20%;">--%>
                            <%--<strong>订单时间</strong>:--%>
                            <%--2017-12-26 08:33:00--%>
                        <%--</div>--%>
                        <%--<div style="float:left;min-width: 185px;width:15%;height: 50px;line-height: 50px ">--%>

                            <%--<a class="btn btn-success" href="javascript:checkProvideQEnd('1872326')">转入提现</a>--%>

                        <%--</div>--%>
                        <%--<div style="clear: both"></div>--%>
                    <%--</div>--%>
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
                                    <%--<input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>--%>
                                <%--</li>--%>
                            <%--</ul>--%>
                        <%--</nav>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<%--注入资金弹出框--%>
<div class="modal fade" id="orderPay" tabindex="-1" role="dialog" aria-labelledby="orderPay" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="orderPayLabel">订单支付</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="orderPayFrom">
                    <div class="form-group">
                        <label class="control-label" for="payType">支付方式</label>
                        <select class="form-control" id="paytype" name="paytype">
                            <option value="01">交易盘</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="payAmount">支付金额</label>
                        <input class="form-control" id="payAmount" name="payAmount" type="text" value="" readonly>
                    </div>
                    <div class="form-actions">
                        <input type="hidden" id="payOrderCode" name="payOrderCode" value="">
                        <input type="hidden" id="payOrderType" name="payOrderType" value="">
                        <button id="paysave" class="btn btn-primary btn-block" onclick="return orderPayCallback();">确定</button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>

<%--<button type="button" id="ppp" class="btn btn-lg btn-success" style="width: 100%" data-toggle="modal" data-target="#orderPay">注入资金</button>--%>

<script type="text/javascript">

    /**
     * 支付首付款
     */
    function payAmout(orderCode, payType) {
        var url="orderInjectInfoController.do?doCheckPay&orderCode="+orderCode+"&orderType="+payType;
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            url : url,// 请求的action路径
            error : function() {// 请求失败处理函数
                alert("服务器异常,请稍后重试!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    $("#payAmount").val(d.obj);
                    $("#payOrderCode").val(orderCode);
                    $("#payOrderType").val(payType);
                    $('#orderPay').modal({
                        keyboard: true
                    });
                } else {
                    layer.alert(d.msg, {
                        offset: '240px'
                    });
                }
            }
        });
    }

    function orderPayCallback() {
        var url="orderInjectInfoController.do?doPayConfirm";
        var fromData = $('#orderPayFrom').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            data : fromData,
            url : url,// 请求的action路径
            error : function() {// 请求失败处理函数
                alert("服务器异常,请稍后重试!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    layer.alert(d.msg, {
                        offset: '240px'
                    }, function(){
                        location.href="userLoginController.do?toIndex";
                    });
                } else {
                    layer.alert(d.msg, {
                        offset: '240px'
                    });
                }
            }
        });
        return false;
    }

    /**
     * 提取本息钱包
     * @param id
     */
    function checkProvideQEnd(orderCode){
        layer.confirm('确定转入个人钱包？', {
            offset: '240px',
            scrollbar: false,
            btn: ['确定','取消'], //按钮
            shade: 0.3 //不显示遮罩
        }, function(){
            var url="orderInjectInfoController.do?saveInWl&payOrderCode="+orderCode;
            var fromData = $('#orderPayFrom').serialize();
            $.ajax({
                cache: false,
                async : false,
                type : 'POST',
                data : fromData,
                url : url,// 请求的action路径
                error : function() {// 请求失败处理函数
                    alert("服务器异常,请稍后重试!");
                },
                success : function(data) {
                    var d = $.parseJSON(data);
                    if (d.success) {
                        layer.alert(d.msg, {
                            offset: '240px'
                        }, function(){
                            location.href="userLoginController.do?toIndex";
                        });
                    } else {
                        layer.alert(d.msg, {
                            offset: '240px'
                        });
                    }
                }
            });

        }, function(){
            return;
        });
    }

</script>


