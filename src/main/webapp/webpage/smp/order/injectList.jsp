<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class=" weui-bgf weui-bod_r weui-mt15">
    <h3 class="weui-f16 weui-f_b title"><i class="weui-dnb weui-v_m zr_ico"></i> 注入资金</h3>
    <div class=" weui-p15">
        <div class="table-responsive">
            <div class="">
                <table class="table2" width="100%" style="font-size: 14px;">
                    <tr>
                        <td>订单编号</td>
                        <td>订单金额</td>
                        <td>订单状态</td>
                        <td>订单时间：</td>
                        <td>应得利息: </td>
                        <td></td>
                        <td>剩余时间</td>
                        <td>操作</td>
                    </tr>
                    <c:if test="${not empty inlist}">
                        <c:forEach var="unInjectInfo" items="${inlist}">
                            <tr>
                                <td>${unInjectInfo.orderCode}</td>
                                <td>${unInjectInfo.orderMoney}.CNY </td>
                                <td>
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        待支付首付款
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        队列等待
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        回流中
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        待支付尾款
                                    </c:if> </td>
                                <td>${unInjectInfo.orderTime}</td>
                                <td><span class="weui-red">${unInjectInfo.interest}CNY</span> </td>
                                <c:if test="${empty unInjectInfo.firstPayTime && empty unInjectInfo.endPayTime}">
                                    <td></td>
                                </c:if>
                                <c:if test="${not empty unInjectInfo.firstPayTime && empty unInjectInfo.endPayTime}">
                                    <td>首付款 已支付</td>
                                </c:if>
                                <c:if test="${not empty unInjectInfo.firstPayTime && not empty unInjectInfo.endPayTime}">
                                    <td>尾款 已支付</td>
                                </c:if>
                                <td>
                                    <span name="syTime" syt="${unInjectInfo.nfield1}">${unInjectInfo.nfield1}</span>
                                </td>
                                <td>
                                    <c:if test="${unInjectInfo.vfield5 == '1'}">

                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '01'}">
                                        <a class=" weui-blue weui-t_d paycolor" href="javascript:payAmout('${unInjectInfo.orderCode}','1');">等待支付首付款</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '02'}">
                                        <c:if test="${unInjectInfo.vfield5 == '1'}">
                                            <a class="weui-blue weui-mr10" href="javascript:;">等待支付尾款</a>
                                        </c:if>
                                        <c:if test="${unInjectInfo.vfield5 != '1'}">
                                            <a class=" weui-blue weui-t_d paycolor" href="javascript:payAmout('${unInjectInfo.orderCode}','2');">等待支付尾款</a>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '03'}">
                                        <a class=" weui-blue weui-mr10" href="javascript:;">保存期</a>
                                        <a class="weui-green" href="javascript:checkProvideQEnd('${unInjectInfo.orderCode}');">转入钱包</a>
                                    </c:if>
                                    <c:if test="${unInjectInfo.orderStatus == '04'}">
                                        <a class=" weui-blue weui-mr10" href="#">等待中</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function countDown(times, obj){
        var timer=null;
        timer=setInterval(function(){
            var day=0,
                hour=0,
                minute=0,
                second=0;//时间默认值
            if(times > 0){
                day = Math.floor(times / (60 * 60 * 24));
                hour = Math.floor(times / (60 * 60)) - (day * 24);
                minute = Math.floor(times / 60) - (day * 24 * 60) - (hour * 60);
                second = Math.floor(times) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
            }
            if (day <= 9) day = '0' + day;
            if (hour <= 9) hour = '0' + hour;
            if (minute <= 9) minute = '0' + minute;
            if (second <= 9) second = '0' + second;
            //
//            console.log(day+"天:"+hour+"小时："+minute+"分钟："+second+"秒");
            times--;
            $(obj).html(day+"天"+hour+"小时"+minute+"分钟"+second+"秒");
        },1000);
        if(times<=0){
            clearInterval(timer);
        }
    }
//    alert($('span[name=\"syTime\"]').length);
    $('span[name=\"syTime\"]').each(function () {
        var tt = $(this).attr('syt');
        var ta = parseInt(tt);
        countDown(ta, this);
    });


</script>

