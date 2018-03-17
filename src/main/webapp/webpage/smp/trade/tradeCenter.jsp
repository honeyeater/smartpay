<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class="jy_top weui-lh30">
        <table width="100%" style="color: #dab789; font-size: 14px;">
            <tr>
                <td width="88"><div class="dtjg weui-f_b weui-f24 weui-dnb">当天<br>价格</div></td>
                <td width="58" class="weui-pl30 weui-pr10"><img src="plug-in/smp/images/2_03.png"></td>
                <td>USDT币 对人民币<br>USDT / CNY</td>
                <td>最新价<p class="weui-f18 weui-white">${usdtPrice.price}</p></td>
                <%--<td>买一价/卖一价<p class="weui-f18">0.000 / 0.000</p></td>--%>
                <%--<td>最高价/最低价<p class="weui-f18">0.000 / 0.000</p></td>--%>
                <%--<td>24H成交量<p class="weui-f18">0.000 / 0.000</p></td>--%>
                <td class="weui-pl10" style="border-left:1px dashed #7a6c4e;">我的usdt数量<p class="weui-f18">${userUsdtInfo.num}</p></td>
                <td>我的usdt价值<p class="weui-f18 weui-red">${myprice}</p></td>
                <td><a href="#" class="btn btn-primary weui-f16 weui-pl30 weui-pr30 weui-pt10 weui-pb10" data-toggle="modal" data-target="#myModal">立即转账</a></td>
            </tr>
        </table>
    </div>
    <ul class="weui-white weui-lh30 m_block weui-d_n">
        <li>我的usdt数量： <span class="weui-f18">${userUsdtInfo.num}</span></li>
        <li>我的usdt价值：<span class="weui-f18 weui-red">${myprice}</span></li>
        <li class="weui-mt10"><a href="#" class="btn btn-primary weui-f16 weui-pl30 weui-pr30 weui-pt10 weui-pb10" data-toggle="modal" data-target="#myModal">立即转账</a></li>
    </ul>
    <div class="row">
        <div class="col-md-6 weui-pt15">
            <div class=" weui-bgf weui-bod_r">
                <h3 class="weui-f16 weui-f_b title">买入USDT币</h3>
                <div class=" weui-p15">
                    <div class="row">
                        <form class="form-horizontal" id="buyform">
                        <div class="col-md-7">
                            <table width="100%" class="table3">
                                <tr>
                                    <td>买入价格：</td>
                                    <td><input id="buyprice" name="buyprice" type="text" class="form-control" value="${usdtPrice.price}" readonly style="background-color: white;"/></td>
                                </tr>
                                <tr>
                                    <td>买入数量：</td>
                                    <td class="form-group"><input id="buynum" name="buynum" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')" /></td>
                                </tr>
                                <tr>
                                    <td>交易密码：</td>
                                    <td class="form-group"><input id="buysafepwd" name="buysafepwd" type="password" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <td >交 易 额 ：</td>
                                    <td><input id="buysumamount" name="buysumamount" type="text" class="form-control" readonly style="background-color: white;"/></td>
                                </tr>
                                <tr>
                                    <td>最大可买：</td>
                                    <td>9999</td>
                                </tr>
                                <tr>
                                <td width="80">最佳买价：</td>
                                <td>${usdtPrice.price}</td>
                                </tr>
                                <tr>
                                    <td>手 续 费：</td>
                                    <td>0.00
                                        <input id="buyfee" name="buyfee" type="hidden" class="form-control" readonly/>
                                    </td>
                                </tr>
                            </table>

                            <input type="hidden" id="buyalipay" name="buyalipay">
                            <input type="hidden" id="buybankcard" name="buybankcard">
                            <input type="button" value="立即买入" class="btn btn-block btn-danger weui-f16 weui-mt20" onclick="return buySubmit();">

                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-3">
                                    <ul id="errors"></ul>
                                </div>
                            </div>

                        </div>

                        <div class="col-md-5 weui-b_l weui-lh30">
                            <%--<div class=" weui-t_c weui-pt10">--%>
                                <%--<img src="plug-in/smp/images/2_07.png">--%>
                                <%--<div>支付宝扫码支付</div>--%>
                            <%--</div>--%>
                            <ul>
                                <li>支付宝账户:${usdtBank.vfield1}</li>
                                <li>支付宝姓名：${usdtBank.vfield2}</li>
                                <li>----------------------</li>
                                <li>银行卡号：${usdtBank.accountno}</li>
                                <li>银行户名：${usdtBank.accountname}</li>
                                <li>银行开户行：${usdtBank.bankname}</li>
                            </ul>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-6 col_l_0  weui-pt15">
            <div class=" weui-bgf weui-bod_r">
                <h3 class="weui-f16 weui-f_b title">卖出USDT币</h3>
                <div class=" weui-p15">
                    <div class="row">
                        <form class="form-horizontal" id="saleform">
                        <div class="col-md-8 col-md-push-2">
                            <table width="100%" class="table3">
                                <tr>
                                    <td>卖出价格：</td>
                                    <td><input id="saleprice" name="saleprice" type="text" class="form-control" value="${usdtPrice.price}" readonly style="background-color: white;"/></td>
                                </tr>
                                <%--<tr>--%>
                                    <%--<td>最大可卖：</td>--%>
                                    <%--<td><input id="usersum" name="usersum" type="hidden" value="${userUsdtInfo.num}"/>--%>
                                        <%--${userUsdtInfo.num}</td>--%>
                                <%--</tr>--%>
                                <tr >
                                    <td>卖出数量：</td>
                                    <td class="form-group"><input id="salenum" name="salenum" type="text" class="form-control" onkeyup="value=value.replace(/[^\d{1,}\.\d{1,}|\d{1,}]/g,'')"/></td>
                                </tr>
                                <tr>
                                    <td width="120">手续比例(%)：</td>
                                    <td><input id="salefeerate" name="salefeerate" type="text" class="form-control" value="${feerate}" readonly style="background-color: white;" /></td>
                                </tr>
                                <tr>
                                    <td>手续费：</td>
                                    <td><input id="salefee" name="salefee" type="text" class="form-control" readonly style="background-color: white;"/></td>
                                </tr>
                                <tr>
                                    <td>交 易 额 ：</td>
                                    <td><input id="salesumamount" name="salesumamount" class="form-control" type="text" readonly style="background-color: white;"/></td>
                                </tr>
                                <tr>
                                    <td>交易密码：</td>
                                    <td class="form-group"><input id="salesafepwd" name="salesafepwd" class="form-control" type="password"/></td>
                                </tr>
                                <tr>
                                    <td>提出地址：</td>
                                    <td><input id="saledrawurl" name="saledrawurl" class="form-control" type="text"/></td>
                                </tr>
                            </table>
                            <input type="button" value="立即卖出" class="btn btn-block btn-success weui-f16 weui-mt20"  onclick="return saleSubmit();">

                            <!-- Show the messages in #errors -->
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-3">
                                    <ul id="errorssale"></ul>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class=" weui-bgf weui-bod_r weui-mt15">
        <h3 class="weui-f16 weui-f_b title">交易列表</h3>
        <div class=" weui-p15">

            <div class="table-responsive border-yellow">
                <div class="">
                    <table class=" table2" width="100%" style="font-size: 14px;">
                        <tr bgcolor="#f3e3c0" style="color:#8c6001;">
                            <th>成交时间</th>
                            <th>类型</th>
                            <th>成交价格</th>
                            <th>手续费</th>
                            <th>成交量</th>
                            <th>总计</th>
                        </tr>
                        <c:if test="${not empty usdtTradeList}">
                            <c:forEach items="${usdtTradeList}" var="usdttrade">
                                <tr>
                                    <td>${usdttrade.inputtime}</td>
                                    <c:if test="${usdttrade.tradeType == 1}">
                                        <td class="weui-orange">买入</td>
                                    </c:if>
                                    <c:if test="${usdttrade.tradeType == 2}">
                                        <td class="weui-green">卖出</td>
                                    </c:if>
                                    <td class="weui-red">${usdttrade.money}</td>
                                    <td class="weui-black">${usdttrade.fee}</td>
                                    <td>${usdttrade.num}</td>
                                    <td>${usdttrade.price}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </table>
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
            container: 'tooltip',
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
//                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
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
        });


        // 修复bootstrap validator重复向服务端提交bug
        $("#buyform").on('success.form.bv', function(e) {
            // Prevent form submission
            e.preventDefault();
        });

        $("#saleform").bootstrapValidator({
            container: 'tooltip',
            live: 'disabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
            excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
//                submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
            message: '通用的验证失败消息',//好像从来没出现过
            feedbackIcons: {//根据验证结果显示的各种图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
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