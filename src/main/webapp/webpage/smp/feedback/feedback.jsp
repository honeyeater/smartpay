<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="feedback">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-10">
            <div class="col-sm-12" style="background:rgba(250,250,250,0.5);padding-top: 20px">
                <div class="alert alert-danger" role="alert">

                    <p style="line-height:24px; padding-left:20px; font-size:14px;">
                        <font color="blue"><b>为了提高客服人员处理效率，请认真阅读以下说明：</b></font><br>
                        1、留言时请认真选择留言类型、并填写简要标题及详细内容。<br>
                        2、留言时请在一条留言把问题描述清楚，<strong style="color: red">同一问题提交多条留言，那么记录将有可能被系统全部刪除而得不到处理。</strong><br>
                        3、在操作上有不清楚的地方我们可以首先通过平台公告或帮助来了解，或者先咨询自己的推荐人或团队其它会员。<br>
                        4、客服工作时间每日上午9:00-中午12:00 下午14:00-晚上21:00<br>
                        <!--  5、提交申诉材料请发送邮件至公司相关负责人邮箱 <font color="blue">***@***.com</font>（请牢记此官方处理申诉事务唯一邮箱）-->
                    </p>
                    <hr><hr><hr><br>
                    <form action="https://www.vipzftaab.com/index/doSendMsg/" method="post">
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1" style="width:85px">留言类型</span>
                            <select class="form-control" aria-describedby="basic-addon1" style="width: 120px" id="msgType" name="msgType">
                                <option value="咨询">咨询</option>
                                <option value="建议/意见">建议/意见</option>
                                <option value="投诉/举报">投诉/举报</option>
                                <option value="账号被盜">账号被盜</option>
                                <option value="奖金问题">奖金问题</option>
                                <option value="其它">其它</option>
                            </select>
                        </div>
                        <br>
                        <div class="input-group">
                            <div class="input-group">
                                <span class="input-group-addon" id="basic-addon2" style="width: 85px">标题</span>
                                <input type="text" class="form-control" placeholder="标题" aria-describedby="basic-addon2" id="title" name="title" required="">
                            </div>
                        </div>
                        <br>
                        <textarea class="form-control" rows="3" placeholder="内容" id="content" name="content" required=""></textarea>
                        <br>
                        <script type="text/javascript" src="https://www.vipzftaab.com//js/jquery.js"></script>
                        <script type="text/javascript" src="https://www.vipzftaab.com//js/ajaxfileupload.js"></script>
                        <script>
                            var hehe;
                            function picUp(){
                                if($("#img_1").val()=='')return;
                                $.ajaxFileUpload({
                                    url: 'https://www.vipzftaab.com/public/upload/',
                                    secureuri: false, //一般设置为false
                                    fileElementId: 'img_1', //
                                    dataType: 'text',
                                    success: function(data){

                                        hehe = JSON.parse(data);
                                        if(hehe.data[0]!=''){
                                            $("#img_1_d").val( $("#img_1_d").val()+hehe.data[0]+';');
                                            $("#imgHolder").html($("#imgHolder").html()+'<img src="'+hehe.data[0]+'" style="max-width: 100px;float: left">');
                                            $("body").height($("#mainHolder").height()+68);
                                        }else{
                                            __Alert(hehe.data[1]);
                                        }

                                    },
                                    error: function(data, status, e){
                                        alert('上传失败');
                                        $("#imgShow").hide();

                                    }
                                });
                            }
                        </script>
                        <div style="clear: both"></div>
                        <div id="imgHolder"></div>
                        <div style="clear: both"></div>
                        <input id="img_1" name="img_1" type="file" style="display:none" onchange="picUp()">
                        <input id="img_1_d" name="img_1_d" type="hidden" style="display:none">
                        <div style="width:100%;text-align: center">
                            <button type="submit" class="btn btn-primary">提交</button>
                            <button type="button" class="btn btn-primary" onclick="$('#img_1').click()">上传证据图片</button>
                        </div>
                    </form>
                </div>


            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>



