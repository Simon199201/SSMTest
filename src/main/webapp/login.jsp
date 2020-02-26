<%--
  Created by IntelliJ IDEA.
  User: simon
  Date: 2020/2/24
  Time: 11:50 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <link href="favicon.ico" rel="shortcut icon"/>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>--%>
    <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>

</head>
<body style=" background: url(http://global.bing.com/az/hprichbg/rb/RavenWolf_EN-US4433795745_1920x1080.jpg) no-repeat center center fixed; background-size: 100%;">


<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">

            <h4 class="modal-title text-center" id="myModalLabel">登录</h4>
        </div>
        <div class="modal-body" id="model-body">
            <div class="form-group">
                <input id="username" type="text" class="form-control" placeholder="用户名" autocomplete="off"
                       name="username">
            </div>
            <div class="form-group">
                <input id="password" type="password" class="form-control" placeholder="密码" autocomplete="off"
                       name="password">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="button" class="btn btn-primary form-control" onclick="login()">登录</button>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-default form-control">注册</button>
            </div>

        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal -->

</body>
<script type="text/javascript">
    function login() {
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        console.log("username is " + username + "\tpassword is " + password)
        $.post("${pageContext.request.contextPath}/user/login.action", {
            username: username,
            password: password
        }, function (response) {
            let data = JSON.parse(response);
            if (data != null && data.code !== null && data.code === 0) {
                location.href="${pageContext.request.contextPath}/index.html"
            } else {
                alert("用户名或密码错误")
            }
            console.log("response data is " + data);
        })
    }
</script>
</html>
