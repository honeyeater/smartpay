<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%--支付弹出框--%>
<div class="modal fade" id="orderPay"  role="dialog" aria-labelledby="orderPay" style="display: none;">
    <div class="modal-dialog modal-dialog1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                <h4 class="modal-title weui-f18" id="myModalLabel2" id="orderPayLabel">订单支付</h4>
            </div>
            <div class="modal-body">
                <form method="post" id="orderPayFrom">
                    <div class="weui-pb20">
                        <table width="100%" class="weui-mt10">
                            <tr>
                                <td class="weui-pb15 weui-t_r" width="120">支付方式：</td>
                                <td class="weui-pb15 weui-p_r"><span class="p_select" style="right:8px;"><i class="glyphicon glyphicon-menu-down"></i></span>
                                    <select class="form-control" id="paytype" name="paytype">
                                        <option value="01">USDT</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="weui-pb15 weui-t_r">支付金额：</td>
                                <td class="weui-pb15"><input class="form-control" id="payAmount" name="payAmount" type="text" value="" readonly></td>
                            </tr>
                            <tr>
                                <td class="weui-pb15 weui-t_r">USDT价格：</td>
                                <td class="weui-pb15">
                                    <input class="form-control" id="payUsdtPrice" name="payUsdtPrice" type="text" value="" readonly>
                                </td>
                            </tr>
                            <tr>
                                <td class="weui-pb15 weui-t_r">USDT支付数量：</td>
                                <td class="weui-pb15">
                                    <input class="form-control" id="payUsdtNum" name="payUsdtNum" type="text" value="" readonly>
                                </td>
                            </tr>
                            <tr>
                                <td class="weui-pb15 weui-t_r">我的USDT数量：</td>
                                <td class="weui-pb15">
                                    <input class="form-control" id="myUsdtNum" name="myUsdtNum" type="text" value="" readonly>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div>
                        <input type="hidden" id="payOrderCode" name="payOrderCode" value="">
                        <input type="hidden" id="payOrderType" name="payOrderType" value="">
                        <input type="button" id="paysave" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10" onclick="return orderPayCallback();" value="确定">
                    </div>
                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
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
                    $("#payUsdtNum").val(d.attributes.payNum);
                    $("#payUsdtPrice").val(d.attributes.price);
                    $("#myUsdtNum").val(d.attributes.myNum);
                    $('#orderPay').modal({
                        keyboard: true
                    });
                } else {
                    layer.alert(d.msg, {
                        offset: '25%'
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
