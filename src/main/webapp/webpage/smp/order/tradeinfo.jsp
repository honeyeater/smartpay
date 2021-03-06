<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<div class="container" id="tradeinfo">
    <%--<div class="row" style="margin-top: 10px;display: none">--%>
        <%--<div class="col-sm-1"></div>--%>
        <%--<div class="col-sm-5" style="padding-top: 20px">--%>
            <%--<button type="button" id="inn" class="btn btn-lg btn-success" style="width: 100%" data-toggle="modal" data-target="#provide">注入资金</button>--%>
        <%--</div>--%>
        <%--<div class="col-sm-5" style="padding-top: 20px">--%>
            <%--<button type="button" id="outt" class="btn btn-lg btn-warning " style="width: 100%" data-toggle="modal" data-target="#accept">提出资金</button>--%>
        <%--</div>--%>
        <%--<div class="col-sm-1"></div>--%>
    <%--</div>--%>
    <%--<div class="row" style="margin-top: 10px">--%>
        <%--<div id="g12" class="col-sm-6" style="padding-top: 10px">--%>
            <%--<a href="javascript:;" style="text-decoration:none;width: 100%;">--%>
                <%--<div id="d_1" style="background: url(&quot;plug-in/webfront/images/in-bg.png&quot) 0% 0% / 100% 100%;--%>
                <%--min-width: 90%;--%>
                <%--margin-left: 5%;--%>
                <%--color: rgb(31, 88, 11);--%>
                <%--font-size: 30px;--%>
                <%--text-align: center;--%>
                <%--font-weight: 900;--%>
                <%--height: 75px;--%>
                <%--line-height: 75px;">--%>
                    <%--<img src="plug-in/webfront/images/in.png">&nbsp;注入资金--%>
                <%--</div>--%>
            <%--</a>--%>
        <%--</div>--%>

        <%--<div id="g13" class="col-sm-6" style="padding-top: 10px">--%>
            <%--<a href="javascript:;" style="text-decoration:none;width: 100%;">--%>
                <%--<div id="d_2" style="background: url(&quot;plug-in/webfront/images/out-bg.png&quot) 0% 0% / 100% 100%;--%>
                <%--width: 90%;--%>
                <%--margin-left: 5%;--%>
                <%--color: rgb(90, 45, 16);--%>
                <%--font-size: 30px;--%>
                <%--text-align: center;--%>
                <%--font-weight: 900;--%>
                <%--height: 75px;--%>
                <%--line-height: 75px;">--%>
                    <%--<img src="plug-in/webfront/images/out.png">&nbsp;提出资金--%>
                <%--</div>--%>
            <%--</a>--%>
        <%--</div>--%>
    <%--</div>--%>

    <%--注入资金弹出框--%>
    <div class="modal fade" id="provide" tabindex="-1" role="dialog" aria-labelledby="provide" aria-hidden="true">
        <div class="modal-dialog modal-dialog1">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                    <h4 class="modal-title weui-f18" id="provideLabel">注入资金</h4>
                </div>
                <div class="modal-body">
                    <form method="post" id="provideFrom">
                    <div class="weui-pb20">
                        <table width="100%" style="font-size: 14px;">
                            <tr>
                                <td class="weui-pb20 weui-v_t" width="70">金      额：</td>
                                <td class="weui-pb20">
                                    <input class="form-control" id="price" name="price" type="text" value="">
                                    <span class="weui-dnb weui-pt10 weui-red">注入资金${baseTimes}-${baseLimit},必须是${baseTimes}的倍数</span></td>
                            </tr>
                            <tr>
                                <td class="weui-pb20">验 证 码 ：</td>
                                <td class="weui-pb20 weui-p_r">
                                    <input type="text" class="form-control" placeholder="验证码" aria-describedby="basic-addon2" name="code" id="code">
                                    <img src="randCodeImage" class="yzm" id="codeImg" style="width: 72px; height: 27px;">
                                </td>
                            </tr>
                            <tr>
                                <td class="weui-pb10">安全密码：</td>
                                <td class="weui-pb10">
                                    <input class="form-control" id="threePwin" name="threePwin" type="password" value="" required="">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="checkbox" value="aOk" name="aOk" id="aOk"> 我已知悉所有风险，自愿参与！</td>
                            </tr>
                        </table>
                        <div class="tip weui-mt10">温馨提示：排单请根据自己的经济能力，用非关键资金参与，排单成功进入系统数据库不能删除，请谨慎操作! </div>
                    </div>
                    <div>
                        <input type="hidden" id="inUserName" name="inUserName" value="${currentUser.userName}">
                        <input type="button" id="insave" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10" value="确定" onclick="return validateCallback();"></div>
                    </form>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <%--提出资金弹出框--%>
    <div class="modal fade" id="accept" tabindex="-1" role="dialog" aria-labelledby="accept" aria-hidden="true">
        <div class="modal-dialog modal-dialog1">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close " data-dismiss="modal" aria-hidden="true"><i class="glyphicon glyphicon-remove-circle weui-c_6 weui-f24"></i></button>
                    <h4 class="modal-title weui-f18" id="acceptLabel">提出资金</h4>
                </div>
                <div class="modal-body">
                    <form id="acceptForm" method="post">
                        <div class="weui-pb20">
                            <input class="form-control" id="aaPrice" name="aaPrice" type="hidden" value="0.00" readonly="">
                            <input class="form-control" id="aabPrice" name="aabPrice" type="hidden" value="" readonly="">
                            <input class="form-control" id="aabbPrice" name="aabbPrice" type="hidden" value="" readonly="">
                            <input class="form-control" id="drawType" name="drawType" type="hidden" value="" readonly="">
                            <p class="weui-f16" id="aPrice" name="aPrice">可提出金额：￥0 USDT      数量：0.000</p>
                            <p>R钱包  (余额<span id="nsMoney_r">${userMember.backWallet}</span>)   |  PI钱包 (余额<span id="dMoney_r">${userMember.couponWallet}</span>)  |  直推钱包 (余额<span id="oMoney_r">${userMember.introWallet}</span>)</p>
                            <p><input type="checkbox" value="1" name="mTypeP" id="getPriceOne" onclick="getPriceType(1,1);"> 提取R钱包 </p>
                            <p><input type="checkbox" value="4" name="mTypeP" id="getPriceTwo" onclick="getPriceType(2,1);"> 提取PI\直推钱包</p>
                            <table width="100%" class="weui-mt10" style="font-size: 14px;">
                                <tr>
                                    <td class="weui-pb10" width="70">安全密码：</td>
                                    <td class="weui-pb10"><input class="form-control" id="threePwOut" name="threePwOut" type="password" value="" required=""></td>
                                </tr>
                            </table>
                            <p class="weui-red weui-mt10">警告！一切行为属参与者自愿，本平台不承担任何责任。 (请用非关键资金参与)。</p>
                        </div>
                        <div class="form-group" style="display: none">

                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="nsMoney" name="mType[]" id="nsMoney" price="${userMember.backWallet}"> 待返钱包 (余额<span id="nsMoney_p">${userMember.backWallet}</span>)
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="dMoney" name="mType[]" id="dMoney" price="${userMember.couponWallet}"> 本息钱包 (余额<span id="dMoney_p">${userMember.couponWallet}</span>)
                                </label>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="oMoney" name="mType[]" id="oMoney" price="${userMember.introWallet}"> 直推钱包 (余额<span id="oMoney_p">${userMember.introWallet}</span>)
                                </label>
                            </div>
                        </div>
                        <div class="form-group" style="display: none;">
                            <label class="control-label" for="smscode">手机验证码</label>
                            <div class="input-group" style="width: 100%">
                                <input type="text" class="form-control" placeholder="验证码" aria-describedby="basic-addon2" name="smscode" id="smscode">
                                <span class="input-group-addon" id="basic-addon3" style="width: 80px;padding:0px">
                                    <input type="button" class="btn btn-success" value="点击手机验证码" onclick="generalSmsCode(this)" id="getSmsCode"></span>
                            </div>
                        </div>
                        <div><input type="button" id="outsave" class="btn btn-block btn-danger weui-f16 weui-pt10 weui-pb10" value="确定" onclick="return validateOutCallback();"></div>
                    </form>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>

<script type="text/javascript">

//    $(function() {
//        $("#d_1").mousemove(function(){
//            $("#d_1").css('background',"url('plug-in/webfront/images/in-bg1.png')");
//            $("#d_1").css('background-size',"100% 100%");
//        });
//        $("#d_1").mouseout(function(){
//            $("#d_1").css('background',"url('plug-in/webfront/images/in-bg2.png')");
//            $("#d_1").css('background-size',"100% 100%");
//        });
//        $("#d_2").mousemove(function(){
//            $("#d_2").css('background',"url('plug-in/webfront/images/out-bg1.png')");
//            $("#d_2").css('background-size',"100% 100%");
//        });
//        $("#d_2").mouseout(function(){
//            $("#d_2").css('background',"url('plug-in/webfront/images/out-bg2.png')");
//            $("#d_2").css('background-size',"100% 100%");
//        });
//        $("#g12").click(function(){
//            $("#inn").click();
//        });
//        $("#g13").click(function(){
//            $("#outt").click();
//        });
//    });
    /**
     * 刷新验证码
     */
    $('#codeImg').click(function(){
        reloadRandCodeImage();
    });
    function reloadRandCodeImage() {
        var date = new Date();
        var img = document.getElementById("codeImg");
        img.src='randCodeImage?a=' + date.getTime();
    }

    function validateCallback(form, callback, confirmMsg) {
        if(!$("#aOk").prop('checked')) {
            layer.alert("请勾选已知悉所有风险，自愿参与!", {
                offset: '240px'
            });
            return false;
        }

        var $form = $(form);
        // 提交信息
        var url="orderInjectInfoController.do?generalOrder";
        var fromData = $('#provideFrom').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            url : url,// 请求的action路径
            data : fromData,
            error : function() {// 请求失败处理函数
                layer.alert("服务器异常,请稍后重试!")
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    layer.alert(d.msg, {
                        offset: '240px'
                    }, function() {
                        location.href= "userLoginController.do?toIndex";
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
     * 提出资金验证
     * @param form
     * @param callback
     * @param confirmMsg
     * @returns {boolean}
     */
    function validateOutCallback(form, callback, confirmMsg) {
        if(!$("#getPriceOne").is(':checked') && !$("#getPriceTwo").is(':checked')
            && !$("#getPriceThree").is(':checked')) {
            layer.alert("请选择提取的钱包", {
                offset: '240px'
            });
            return false;
        }

        var price = $("#aaPrice").val();
        if(price <= 0 ) {
            layer.alert("提取金额为零不能提交", {
                offset: '240px'
            });
            return false;
        }

        // 提交信息
        var url="orderDrawInfoController.do?generalOutOrder";
        var fromData = $('#acceptForm').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            url : url,// 请求的action路径
            data : fromData,
            error : function() {// 请求失败处理函数
                layer.alert("服务器异常,请稍后重试!")
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    layer.alert(d.msg, {
                        offset: '240px'
                    }, function() {
                        location.href= "userLoginController.do?toIndex";
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
     * 获取短信验证码
     */
    function generalSmsCode(thiz) {
        var vfcode = $("#threePwOut").val();
        var url="frontVerifyCodeController.do?smsCode&phoneNo&vfCode="+vfcode;
        $.ajax({cache : false,type : 'POST',url : url,
            error : function() {
                layer.alert("系统错误!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    settime($("#getSmsCode"));
                    layer.alert(d.msg, {
                        offset: '25%'
                    });
                } else {
                    layer.alert(d.msg, {
                        offset: '25%'
                    });
                }
            }
        });
    }

    //短信后倒计时
    var countdown=60;
    function settime(obj) {
        if (countdown == 0) {
            $(obj).attr("disabled",false);
            $(obj).attr("mark","1");
            $(obj).val("获取手机验证码");
            countdown = 60;
            return;
        } else {
            $(obj).attr("disabled", true);
            $(obj).attr("mark","0");
            $(obj).val("重新发送(" + countdown + ")");
            countdown--;
        }
        setTimeout(function() {
                    settime(obj) }
                ,1000)
    }

    var first = true;
    function getPriceType(types,need){
        if(need==1&&first){
            first=false;
            layer.alert("温馨提示：提现请认真检查个人银行资料，确保准确无误，如因个人资料错误，提现将视为无效提现，系统将不予重新支付，任何损失，后果自负!", {
                offset: '25%'
            });
        }

        var a = $("#getPriceOne").is(':checked');
        var b = $("#getPriceTwo").is(':checked');

        var canDoAccept = false; //可以提取
        var drawType = "";

        if(a && types == "1") {
            drawType = "1";
        }
        if(b && types == "2") {
            drawType = "2";
        }

        var url="orderDrawInfoController.do?checkDrawOrder&phoneNo&drawType="+drawType;
        $.ajax({cache : false,type : 'POST',url : url,
            error : function() {
                layer.alert("系统错误!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    if(d.attributes.canDraw=="1") {
                        canDoAccept = true;
                    } else {
                        canDoAccept = false;
                    }
                    $("#nsMoney").attr('price', d.attributes.userMem.nfield3);
                    $("#dMoney").attr('price', d.attributes.userMem.nfield4);
                    $("#oMoney").attr('price', d.attributes.userMem.introWallet);
                    var newPrice = d.attributes.newPrice;

                    var price = 0;
                    var nsMoney = parseInt($("#nsMoney").attr('price')); //待返钱包
                    var dMoney = parseInt($("#dMoney").attr('price')); //本息钱包
                    var oMoney = parseInt($("#oMoney").attr('price')); //直推钱包
                    var nsMoneyT = nsMoney; //可提取待返金额
                    var dMoneyT = dMoney;  //可提取本息金额(注入资金的1.2倍）
                    var oMoneyT = oMoney;  //可提取直推金额

                    if(!canDoAccept){
                        nsMoneyT = dMoneyT = oMoneyT= 0;
                        if(a){
                            $("#getPriceOne").attr("checked", false);
                        }
                        if(b){
                            $("#getPriceTwo").attr("checked", false);
                        }
                    }else{
                        if(types==1){ //待返钱包
                            if(a){ //选中本息钱包
                                if(nsMoneyT>0){
                                    dMoneyT= oMoneyT= 0;
                                    price+=nsMoneyT;
                                }

                                if(b){
                                    $("#getPriceTwo").attr("checked", false);
                                }
                            } else {
                                nsMoneyT = 0;
                                if(!b) {
                                    dMoneyT= oMoneyT= 0;
                                }
                            }


                        }else if(types==2) { //本息钱包和直推钱包
                            if(b) { //选中
                                nsMoneyT = 0; //可提取待返钱包为0
                                price+=(dMoneyT+oMoneyT);
                                if(a){
                                    $("#getPriceOne").attr("checked", false);
                                }
                            } else { //未选中
                                dMoneyT= oMoneyT= 0;
                                if(!a) {
                                    nsMoneyT = 0;
                                }
                            }
                        }
                    }

                    $("#nsMoney_r").html(nsMoney-nsMoneyT);
                    $("#dMoney_r").html(dMoney-dMoneyT);
                    $("#oMoney_r").html(oMoney-oMoneyT);
                    $("#drawType").val(drawType);
                    $("#aaPrice").val(price);
                    $("#aabPrice").val(dMoneyT);
                    $("#aabbPrice").val(oMoneyT);
//                    if(!canDoAccept){
//                        $('#moneyMsg').html('&nbsp;（当前没有可用提现订单）');
//                    } else {
//                        $('#moneyMsg').html('');
//                    }
                    var usdtNum = Number(price/newPrice).toFixed(3);

                    $("#aPrice").html("可提出金额：￥"+price + " USDT数量：" + usdtNum);

                } else {
                    layer.alert(d.msg);
                }
            }
        });
    }


</script>