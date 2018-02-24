<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style type="text/css">
    .htmleaf-header{margin-bottom: 15px;font-family: "Segoe UI", "Lucida Grande", Helvetica, Arial, "Microsoft YaHei", FreeSans, Arimo, "Droid Sans", "wenquanyi micro hei", "Hiragino Sans GB", "Hiragino Sans GB W3", "FontAwesome", sans-serif;}
    .htmleaf-icon{color: #fff;}
</style>

<div class="htmleaf-container">
    <div class="container" id="expandrel">
        <div class="row">
            <%--<div class="col-lg-2"></div>--%>
            <div class="col-lg-12">
                <div id="treeview1" class=""></div>
            </div>
            <%--<div class="col-lg-2"></div>--%>
        </div>
    </div>
</div>

<script type="text/javascript" src="plug-in/webfront/js/bootstrap-treeview.min.js"></script>
<script type="text/javascript">
    $(function() {
        var defaultData = [
            {
                text: '${registerUserInfo.userName}, ${registerUserInfo.realName}, ${registerUserInfo.userLevel}, ${registerUserInfo.validstatus}',
                href: '#${registerUserInfo.userName}',
                <c:if test="${not empty registerUserInfo.userInfos}">
                    tags: ['${fn:length(registerUserInfo.userInfos)}'],
                    nodes: [
                    <c:forEach items="${registerUserInfo.userInfos}" var="childUserInfo" varStatus="uss">
                        <c:if test="${fn:length(registerUserInfo.userInfos) == (uss.index+1)}">
                            {
                                text: '${childUserInfo.userName}, ${childUserInfo.realName}, ${childUserInfo.userLevel}, ${childUserInfo.validstatus}',
                                href: '#${childUserInfo.userName}',
                                tags: ['0']
                            }
                        </c:if>
                        <c:if test="${fn:length(registerUserInfo.userInfos) != (uss.index+1)}">
                            {
                                text: '${childUserInfo.userName}, ${childUserInfo.realName}, ${childUserInfo.userLevel}, ${childUserInfo.validstatus}',
                                href: '#${childUserInfo.userName}',
                                tags: ['0']
                            },
                        </c:if>
                    </c:forEach>
                    ]
                </c:if>
            }
        ];
        $('#treeview1').treeview({
            data: defaultData
        });
    });
</script>
