<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">问题反馈</h3>
        <div class=" weui-p15 box_h">
            <p class="weui-lh30">
                为了提高客服人员处理效率，请认真阅读以下说明：
                <br>1、留言时请认真选择留言类型、并填写简要标题及详细内容。
                <br>2、留言时请在一条留言把问题描述清楚，同一问题提交多条留言，那么记录将有可能被系统全部刪除而得不到处理。
                <br>3、在操作上有不清楚的地方我们可以首先通过平台公告或帮助来了解，或者先咨询自己的推荐人或团队其它会员。
                <br>4、客服工作时间每日上午9:00-中午12:00 下午14:00-晚上21:00
            </p>
            <form method="post" id="feedbackFrom">
            <table width="100%">
                <tr>
                    <td class="weui-f16 weui-pb10" width="80">留言类型：</td>
                    <td class="weui-pb10"><div class="row"><div class="col-md-5 weui-p_r"><span class="p_select"><i class="glyphicon glyphicon-menu-down"></i></span>

                        <select class="form-control"  id="feedtype" name="feedtype">
                            <option value="01">咨询</option>
                            <option value="02">建议/意见</option>
                            <option value="03">投诉/举报</option>
                            <option value="04">账号被盜</option>
                            <option value="05">奖金问题</option>
                            <option value="06">其它</option>
                        </select>
                    </div></div></td>
                </tr>
                <tr>
                    <td class="weui-f16 weui-pb10">留言标题：</td>
                    <td class="weui-pb10"><div class="row"><div class="col-md-5 weui-p_r">
                        <input type="text" class="form-control" placeholder="标题" aria-describedby="basic-addon2" id="title" name="title" required="">
                    </div></div></td>
                </tr>
                <tr>
                    <td class="weui-f16 weui-pb10 weui-v_t">留言内容：</td>
                    <td class="weui-pb10">
                        <textarea class="form-control" rows="5" placeholder="内容" id="content" name="content" required=""></textarea>
                    </td>
                </tr>
                <tr>
                    <td class="weui-f16 weui-pb10 weui-v_t">上传照片：</td>
                    <td class="weui-pb10">
                        <div  id="imgHolder">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input id="img_1" name="img_1" type="file" style="display:none" onchange="picUp()">
                        <input id="img_1_d" name="img_1_d" type="" style="display:none">
                        <input type="submit" value="提交" class="btn btn-danger weui-f18 weui-pl30 weui-pr30"  onclick="return validateCallback();">
                        <input type="button" value="上传证据图片" class="btn btn-danger weui-f18 weui-pl30 weui-pr30" onclick="$('#img_1').click()">

                    </td>
                </tr>
            </table>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="plug-in/webfront/js/ajaxfileupload.js"></script>
<script type="text/javascript">
    function picUp(){
        if($("#img_1").val()=='')return;
        $.ajaxFileUpload({
            type: "post",
            url: 'tSFeedattachController.do?fileUpload',
            secureuri: false, //一般设置为false
            fileElementId: 'img_1', //图片地址
            dataType: 'json',
            success: function(data){
                var d = $.parseJSON(data);
                if(d.success){
                    $("#img_1_d").val( $("#img_1_d").val()+ d.obj+';');
                    $("#imgHolder").html($("#imgHolder").html()+'<img src="'+ d.obj+'" style="width: 100px; height: 100px;float: left">');
//                                            $("body").height($("#mainHolder").height()+68);
                }else{
                    layer.alert('上传失败,请重试!',{
                        offset: '240px'});
                }

            },
            error: function(data, status, e){
                layer.alert('上传失败,请重试!',{
                    offset: '240px'});
            }
        });
    }
    function validateCallback(form, callback, confirmMsg) {
        var $form = $(form);
        // 提交信息
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


