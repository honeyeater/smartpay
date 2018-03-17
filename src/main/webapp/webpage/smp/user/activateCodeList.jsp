<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<input type="hidden" id="currentUserValidFlag" name="currentUserValidFlag" value="${frontUser.validFlag}">

<div class="weui-p20">
    <div class=" weui-bgf weui-bod_r">
        <h3 class="weui-f16 weui-f_b title">激活码管理</h3>
        <div class=" weui-p15 box_h">
            <p><a href="#" class="btn btn-primary btn-primary1" data-toggle="modal" data-target="#doActiveB" id="doActiveButton">会员激活</a>
                <span class="weui-red weui-ml10">请联系网站客服人员进行购买，购买后进行激活！平台统一售价，体验版100元，正式版500元！</span></p>
            <div class="table-responsive weui-mt15">
                <table class="table table-hover table-striped weui-bb" style="font-size: 14px;">
                    <tr>
                        <th>激活码</th>
                        <th>是否使用</th>
                        <th>使用者</th>
                        <th>时间</th>
                    </tr>
                    <c:if test="${not empty userActivates}">
                        <c:forEach items="${userActivates}" var="userActivate">
                            <tr class="bg-info">
                                <td>${userActivate.activieCode}</td>
                                <td class="weui-green">已使用</td>
                                <td>${userActivate.userUsername}</td>
                                <td>${userActivate.useTime}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>
            </div>

            <%--<nav class="weui-t_c" aria-label="Page navigation">--%>
                <%--<ul class="pagination">--%>
                    <%--<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>--%>
                    <%--<li class="active"><a href="#">1</a></li>--%>
                    <%--<li><a href="#">2</a></li>--%>
                    <%--<li><a href="#">3</a></li>--%>
                    <%--<li><a href="#">4</a></li>--%>
                    <%--<li><a href="#">5</a></li>--%>
                    <%--<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>--%>
                <%--</ul>--%>
            <%--</nav>--%>

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
    $(function() {
        var validFlag = $("#currentUserValidFlag").val();
        if(validFlag != "1") {
            layer.alert("用户被冻结,请客服人员购买激活码激活账户!", {
                offset:'25%',
                closeBtn: 0
            });
        }
    });
</script>
