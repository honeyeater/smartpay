<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%--注入资金弹出框--%>
<div class="modal fade" id="provide" tabindex="-1" role="dialog" aria-labelledby="provide" style="">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="provideLabel">注入资金</h4>
            </div>
            <div class="modal-body">
                <form action="#" method="post">
                    <div class="form-group">
                        <label class="control-label" for="price">金额</label>
                        <input class="form-control" id="price" name="price" type="text" value="">
                    </div>
                    <div class="alert alert-info" role="alert">
                        注入资金1000.00-1000000,必须是1000.00的倍数
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="code">验证码</label>
                        <div class="input-group" style="width: 100%;">
                            <input type="text" class="form-control" placeholder="验证码" aria-describedby="basic-addon2" name="code" id="code">
                            <span class="input-group-addon" id="basic-addon-in" style="width: 80px;padding:0px">
                                <img id="codeImg" alt="看不清?点击切换" src="randCodeImage" style="width: 80px;height: 32px;">
                            </span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="threePwin">安全密码</label>
                        <input class="form-control" id="threePwin" name="threePwin" type="password" value="" required="">
                    </div>
                    <div class="alert alert-danger" role="alert">
                        <strong>温馨提示：</strong>排单请根据自己的经济能力，用非关键资金参与，排单成功进入系统数据库不能删除，请谨慎操作!
                        <br>
                        <strong>我已知悉所有风险，自愿参与！</strong><input type="checkbox" value="aOk" name="aOk" id="aOk">
                    </div>
                    <div class="form-actions">
                        <button id="insave" class="btn btn-primary">确定</button>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>


<script type="text/javascript">
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


</script>