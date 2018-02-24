<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="payOrder">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <div class="alert alert-success" role="alert">
                    <form method="post" id="payOrderFrom" class="form-group">
                        <div class="input-group">
                            <label for="paytype" class="label-control">支付方式</label>
                            <select class="form-control" aria-describedby="basic-addon1" id="paytype" name="paytype">
                                <option value="01">交易盘</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2" style="width: 85px">支付金额</span>
                                <input type="text" class="form-control" placeholder="标题" aria-describedby="basic-addon2" id="payPrice" name="payPrice" required="">
                            </div>
                        </div>
                        <br>
                        <div class="input-group">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon3" style="width: 85px">安全密码</span>
                                <input type="password" class="form-control" placeholder="标题" aria-describedby="basic-addon2" id="saftPwd" name="saftPwd" required="">
                            </div>
                        </div>
                        <br>
                        <div style="clear: both"></div>
                        <div style="width:100%;text-align: center">
                            <button type="submit" class="btn btn-primary" onclick="return validateCallback();">提交</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
<script type="text/javascript">
    function validateCallback(form, callback, confirmMsg) {
        var $form = $(form);
        // 提交信息支付信息
        var url="tSFeedbackController.do?doAdd";
        var fromData = $('#feedbackFrom').serialize();
        $.ajax({
            cache: false,
            async : false,
            type : 'POST',
            url : url,// 请求的action路径
            data : fromData,
            error : function() {// 请求失败处理函数
                alert("服务器异常,请稍后重试!");
            },
            success : function(data) {
                var d = $.parseJSON(data);
                if (d.success) {
                    layer.alert(
                            d.msg,
                            {   offset: '240px',
                                closeBtn: 0
                            },
                            function(){
                                location.href="tSFeedbackController.do?toFeedback";
                            }
                    );
                } else {
                    alert("系统异常,请稍后重试!");
                }
            }
        });
        return false;
    }
</script>

