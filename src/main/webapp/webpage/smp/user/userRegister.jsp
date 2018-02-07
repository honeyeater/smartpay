<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="plug-in/jquery-qrcode/jquery.qrcode.min.js"></script>

<div class="container" id="regmem">
    <div class="row" style="">
        <div class="col-sm-12">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <div class="col-sm-12">
                    <form class="form-horizontal" action="https://www.vipzftaab.com/index/doRegister/" method="post">
                        <div class="col-sm-12" style="text-align: center;margin-bottom: 20px">
                            推广二维码
                            <br>
                            <br>
                            <div id="code"></div>
                            <br>
                            <br>
                            推广链接  <br>
                            <a id="userUrl" href="${webRoot}/${commentUrl}" target="_blank" style="color: white">${webRoot}/${commentUrl}</a>
                            <input type="hidden" value="${webRoot}/${commentUrl}" id="comUrl" name="comUrl">
                        </div>

                    </form>
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
        $('#code').qrcode($("#comUrl").val());
    }
    generQrcode();

</script>