<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/context/mytags.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="renderer" content="webkit">
    <title>理财平台</title>
    <meta name="keywords" content="理财">
    <meta name="description" content="一家专门从事理财的交易网站">
    <!--bootstrape-->
    <link href="plug-in/bootstrap3/css/bootstrap.min.css" rel="stylesheet">
    <script src="plug-in/ace/assets/js/jquery-2.0.3.min.js"></script>
    <script src="plug-in/bootstrap3/js/bootstrap.min.js"></script>
    <style>
       body {
           font-family: "microsoft Yahei", "Helvetica Neue", Helvetica, Arial, sans-serif;
       }
    </style>
</head>
<body class="login">
    <div class="logo" style="width: 100%;"></div>

    <div class="content text-center" style="padding-top: 10%;">
        <form class="form-vertical login-form" id="Success">
            <h3 class="erro " font="">该推荐人不可用</h3>
            <div class="loading">
                <div class="splash">
                    <div class="splash-title">
                        <br>
                        <b id="wait">5</b>
                        秒后返回指定页面！如果浏览器无法跳转，<a id="href" href="${baseUrl}userLoginController.do?login">请点击此处</a>
                    </div>
                </div>
                <script type="text/javascript">
                    $(function(){
                        var wait = document.getElementById('wait'),href = document.getElementById('href').href;
                        var time = --wait.innerHTML;
                        if(time <= 0) {
                            location.href = href;
                        };
                    })
                    $(function(){
                            var wait = document.getElementById('wait'),href = document.getElementById('href').href;
                            var interval = setInterval(function(){
                                var time = --wait.innerHTML;
                                if(time <= 0) {
                                    location.href = href;
                                    clearInterval(interval);
                                };
                            }, 1000);
                        }
                    );
                </script>
        </div>
        </form>
    </div>

</body>

</html>
