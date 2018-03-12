<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container" id="activatemanger">
    <div class="row">
        <div class="col-sm-12" style="text-align: center;margin-bottom: 20px">
            <button type="button" class="btn btn-primary" onclick="buyCode()">激活码购买</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#doBuyCode" id="buyCode" style="display: none">激活码购买</button>
            <button type="button" class="btn btn-primary" onclick="doActiveB()">会员激活</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#doActiveB" id="doActiveButton" style="display: none">会员激活</button>
        </div>
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="col-sm-12">
                <table class="table table-striped table-bordered" style="border-color: #0a0c0e">
                    <thead>
                    <tr class="bg-warning">
                        <th style="font-size: 10px">激活码</th>
                        <th style="font-size: 10px">是否使用</th>
                        <th style="font-size: 10px">使用者</th>
                        <th style="font-size: 10px">使用时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${not empty userActivates}">
                        <c:forEach items="${userActivates}" var="userActivate">
                            <tr class="bg-info">
                                <td style="font-size: 10px">${userActivate.activieCode}</td>
                                <td style="font-size: 10px">已使用</td>
                                <td style="font-size: 10px">${userActivate.userUsername}</td>
                                <td style="font-size: 10px">${userActivate.useTime}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <%--<nav style="text-align: center">--%>
                    <%--<ul class="pagination pagination-sm">--%>
                        <%--<li><a href="#">共0页</a></li>--%>
                        <%--<li><a href="javascript:;" aria-label="Previous"><span aria-hidden="true">«</span></a></li>--%>
                        <%--<li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>--%>
                        <%--<li>--%>
                            <%--<input type="text" class="input-mini" placeholder="0" style="width: 30px;float: left;height: 30px;" id="toPage"> <a href="javascript:gotoPageTO()">跳</a>--%>
                        <%--</li>--%>
                    <%--</ul>--%>
                <%--</nav>--%>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>

<%--激活弹出框--%>
<div class="modal fade" id="doActiveB" tabindex="-1" role="dialog" aria-labelledby="activatetitle">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="activatetitle">激活码</h4>
            </div>
            <div class="modal-body">
                <form id="actiForm" method="post">
                    <div class="form-group">
                        <label class="control-label" for="activatecode">有效激活码</label>
                        <input class="form-control" id="activatecode" name="activatecode" type="text" value=""
                               required="">
                    </div>
                    <div class="form-actions">
                        <button id="activatesub" class="btn btn-primary btn-block" onclick="return activateSub();">
                            确定激活
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">

    /**
     * 购买激活码
     */
    function buyCode(){
        layer.alert('请联系网站客服人员进行购买,购买后进行激活!', {
            closeBtn: 0,
            offset: '30%'
        });
    }

    /**
     * 会员激活
     */
    function doActiveB() {
        $("#activatecode").val("");
        $("#doActiveButton").click();
    }

    /**
     * 激活码激活
     */
    function activateSub() {
        // 提交信息
        var url="frontUserActivatecodeController.do?doAct";
        var fromData = $('#actiForm').serialize();
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
                            location.href="frontUserActivatecodeController.do?list";
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
        return false;
    }

</script>
