<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <script type="text/javascript">
        function check(form) {
            var username = form.username.value;
            var password = form.password.value;
            if(username.length == 0 || password.length == 0) {
                alert('用户名和密码未填写，请检查.');
                return false;
            } else {
                return true;
            }
        }
    </script>
    <form action="/doLogin" method="post" onsubmit="return check(this)">
        账号：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="登录"><br>
    </form>
    <% if(request.getAttribute("error") != null) { %>
        <span style="color: red">
            <%= request.getAttribute("error") %>
        </span>
    <% } %>
    <br>
</body>
</html>
