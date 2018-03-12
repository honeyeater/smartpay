<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" style="background-color: white">
    usdt当天价格:${usdtPrice.price}
    价格日期:${usdtPrice.createTime}
</div>

<div class="container" id="tradeCenter">
    <div class="row" style="margin-top: 10px;padding-top: 10px;padding-bottom: 20px">
        <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    买入
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" id="buyform">
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buyprice">买入价格</label>
                            <div class="col-lg-6">
                                <input id="buyprice" name="buyprice" type="text" class="form-control" value="${usdtPrice.price}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buynum">买入数量</label>
                            <div class="col-lg-6">
                                <input id="buynum" name="buynum" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buyfee">手续费</label>
                            <div class="col-lg-6">
                                <input id="buyfee" name="buyfee" type="text" class="form-control" readonly/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buysumamount">交易金额</label>
                            <div class="col-lg-6">
                                <input id="buysumamount" name="buysumamount" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="buysafepwd">安全密码</label>
                            <div class="col-lg-6">
                                <input id="buysafepwd" name="buysafepwd" type="password" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="hidden" id="buyalipay" name="buyalipay">
                            <input type="hidden" id="buybankcard" name="buybankcard">
                            <div class="col-lg-8 col-lg-offset-2">
                                <button type="submit" class="btn btn-info btn-block" onclick="return buySubmit();">买入</button>
                            </div>
                        </div>
                        <!-- Show the messages in #errors -->
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <ul id="errors"></ul>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-6" style="margin-bottom:-20px;margin-top: -20px;">
            <div class="panel panel-default">
                <div class="panel-heading">
                    卖出
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" id="saleform">
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="saleprice">卖出价格</label>
                            <div class="col-lg-6">
                                <input id="saleprice" name="saleprice" type="text" class="form-control" value="${usdtPrice.price}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salenum">卖出数量</label>
                            <div class="col-lg-6">
                                <input id="salenum" name="salenum" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salenum">最大可卖</label>
                            <div class="col-lg-6">
                                <input id="usersum" name="usersum" type="hidden" value="${userUsdtInfo.num}"/>
                                ${userUsdtInfo.num}
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salefee">手续费</label>
                            <div class="col-lg-6">
                                <input id="salefee" name="salefee" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salefeerate">手续费比例</label>
                            <div class="col-lg-6">
                                <input id="salefeerate" name="salefeerate" type="text" class="form-control" value="${feerate}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salesumamount">交易金额</label>
                            <div class="col-lg-6">
                                <input id="salesumamount" name="salesumamount" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="saledrawurl">提出地址</label>
                            <div class="col-lg-6">
                                <input id="saledrawurl" name="saledrawurl" class="form-control" type="text"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label" for="salesafepwd">安全密码</label>
                            <div class="col-lg-6">
                                <input id="salesafepwd" name="salesafepwd" class="form-control" type="password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-lg-8 col-lg-offset-2">
                                <button type="submit" class="btn btn-info btn-block" onclick="return saleSubmit();">卖出</button>
                            </div>
                        </div>
                        <!-- Show the messages in #errors -->
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-3">
                                <ul id="errorssale"></ul>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<style type="text/css">
    /* Simple message styles customization */
    #errors {
        border-left: 5px solid #a94442;
        padding-left: 15px;
    }
    #errors li {
        list-style-type: none;
    }
    #errors li:before {
        content: '\b7\a0';
    }
    #errorssale {
        border-left: 5px solid #a94442;
        padding-left: 15px;
    }
    #errorssale li {
        list-style-type: none;
    }
    #errorssale li:before {
        content: '\b7\a0';
    }
</style>

<script src="plug-in/bootstrap3/validate/js/bootstrapValidator.js"></script>
<script src="plug-in/bootstrap3/validate/js/language/zh_CN.js"></script>

<script type="text/javascript">

    $(function() {
        $("#buyform").bootstrapValidator({
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
//                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            fields: {
                buynum: {
                    validators: {
                        notEmpty: {
                            message: '买入数量必须输入'
                        }
                    }
                },
                buysafepwd: {
                    validators: {
                        notEmpty: {
                            message: '安全密码必须输入'
                        }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#errors').html('');
        })
        .on('error.field.bv', function(e, data) {

            var messages = data.bv.getMessages(data.element);

            $('#errors').find('li[data-field="' + data.field + '"]').remove();

            for (var i in messages) {
                $('<li/>')
                        .attr('data-field', data.field)
                        .wrapInner(
                                $('<a/>')
                                        .attr('href', 'javascript: void(0);')
                                        .html(messages[i])
                                        .on('click', function(e) {
                                            // Focus on the invalid field
                                            data.element.focus();
                                        })
                        )
                        .appendTo('#errors');
            }

            data.element
                    .data('bv.messages')
                    .find('.help-block[data-bv-for="' + data.field + '"]')
                    .hide();
        })
        .on('success.field.bv', function(e, data) {
            // Remove the field messages
            $('#errors').find('li[data-field="' + data.field + '"]').remove();
        });

        // 修复bootstrap validator重复向服务端提交bug
        $("#buyform").on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();
        });

        $("#saleform").bootstrapValidator({
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
//                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            fields: {
                salenum: {
                    validators: {
                        notEmpty: {
                            message: '卖出数量必须录入'
                        }
                    }
                },
                salesafepwd: {
                    validators: {
                        notEmpty: {
                            message: '安全密码必须输入'
                        }
                    }
                }
            }
        })
        .on('success.form.bv', function(e) {
            $('#errorssale').html('');
        })
        .on('error.field.bv', function(e, data) {

            var messages = data.bv.getMessages(data.element);

            $('#errorssale').find('li[data-field="' + data.field + '"]').remove();

            for (var i in messages) {
                $('<li/>')
                        .attr('data-field', data.field)
                        .wrapInner(
                                $('<a/>')
                                        .attr('href', 'javascript: void(0);')
                                        .html(messages[i])
                                        .on('click', function(e) {
                                            // Focus on the invalid field
                                            data.element.focus();
                                        })
                        )
                        .appendTo('#errorssale');
            }
            data.element
                    .data('bv.messages')
                    .find('.help-block[data-bv-for="' + data.field + '"]')
                    .hide();
        })
        .on('success.field.bv', function(e, data) {
            // Remove the field messages
            $('#errorssale').find('li[data-field="' + data.field + '"]').remove();
        });

        // 修复bootstrap validator重复向服务端提交bug
        $("#saleform").on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();
        });
    });

    $("#buynum").bind("change",function(){
        var buynum = Number($(this).val()).toFixed(3);
        $(this).val(buynum);
        var buyprice = $("#buyprice").val();
        var totalPrice = Number(buynum * buyprice).toFixed(2);
        $("#buysumamount").val(totalPrice);
    });

    $("#salenum").bind("change",function(){
        var usernum = Number($("#usersum").val()).toFixed(3);
        var salenum = Number($(this).val()).toFixed(3);
        if(parseFloat(usernum) < parseFloat(salenum)) {
            layer.msg('卖出数量大于账户最大数量,请确认!',
                {
                    closeBtn: 0,
                    offset: '25%'
                });
            $(this).val("");
            return false;
        }
        $(this).val(salenum);
        var saleprice = $("#saleprice").val();
        var salefeerate = $("#salefeerate").val();
        var totalPrice = Number(salenum * saleprice*(100-salefeerate)/100).toFixed(2);
        var salefee = Number(salenum*salefeerate*saleprice/100).toFixed(2);
        $("#salesumamount").val(totalPrice);
        $("#salefee").val(salefee);
    });


    /**
     * 买入提交
     */
    function buySubmit() {
        var $form = $("#buyform");
        var data = $form.data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
            // 提交信息
            var url="usdtTradeController.do?doBuy";
            var fromData = $('#buyform').serialize();
            $.ajax({
                cache: false,
                async : false,
                type : 'POST',
                url : url,// 请求的action路径
                data : fromData,
                error : function() {// 请求失败处理函数
                    layer.alert('系统异常,请稍后重试!',
                            {
                                closeBtn: 0,
                                offset: '25%'
                            });
                },
                success : function(data) {
                    var d = $.parseJSON(data);
                    if (d.success) {
                        layer.alert(
                                d.msg,
                                {
                                    closeBtn: 0,
                                    offset: '25%'
                                },
                                function(){
                                    location.href="usdtTradeController.do?toTrade";
                                }
                        );
                    } else {
                        layer.alert(d.msg,
                                {
                                    closeBtn: 0,
                                    offset: '25%'
                                });
                    }
                }
            });
        }
        return false;
    }

    /**
     * 卖出提交
     */
    function saleSubmit() {
        var $form = $("#saleform");
        var data = $form.data('bootstrapValidator');
        if (data) {
            // 修复记忆的组件不验证
            data.validate();
            if (!data.isValid()) {
                return false;
            }
            // 提交信息
            var url="usdtTradeController.do?doSale";
            var fromData = $('#saleform').serialize();
            $.ajax({
                cache: false,
                async : false,
                type : 'POST',
                url : url,// 请求的action路径
                data : fromData,
                error : function() {// 请求失败处理函数
                    layer.alert('系统异常,请稍后重试!',
                        {
                            closeBtn: 0,
                            offset: '25%'
                        });
                },
                success : function(data) {
                    var d = $.parseJSON(data);
                    if (d.success) {
                        layer.alert(
                            d.msg,
                            {
                                closeBtn: 0,
                                offset: '25%'
                            },
                            function(){
                                location.href="usdtTradeController.do?toTrade";
                            }
                        );
                    } else {
                        layer.alert(d.msg, {
                                closeBtn: 0,
                                offset: '25%'
                        });
                    }
                }
            });
        }
        return false;
    }

</script>