<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="plug-in/jquery-qrcode/jquery.qrcode.min.js"></script>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">会员注册</h3>
        <div class=" weui-p15 box_h">
            <div class="ewm_rest">
                <div class="row">
                    <div class="col-md-8 col-md-push-2">
                        <form class="form-horizontal" action="" method="post">
                        <div class="row">
                            <div class="col-md-4 weui-t_c weui-f16 weui-b_r">
                                <div class=" weui-pl30 weui-pr30">
                                    <div  id="code" style="margin: 20px;"></div>
                                    <h3 class="weui-f_b">推广二维码 </h3>
                                    <input type="hidden" value="${webRoot}/${commentUrl}" id="comUrl" name="comUrl">
                                </div>
                            </div>
                            <div class="col-md-8 weui-f16">
                                <div class="pass_p">
                                    <p class="address">
                                    <a id="userUrl" href="${webRoot}/${commentUrl}" target="_blank">${webRoot}/${commentUrl}</a>
                                    </p>
                                    <%--<p class="address">http://47.94.108.124:8080/smartpay/frontUserRegisterController.do?register&t=8a8bbf2a61211b560161211b56a30000 </p>--%>
                                    <p class="weui-pt30"><a class="btn btn-hei weui-f16" >推广链接</a></p>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    /**
     * 生成二维码
     */
    function generQrcode() {
        $('#code').qrcode({width: 180,height: 180, text:$("#comUrl").val()});
    }
    generQrcode();



</script>