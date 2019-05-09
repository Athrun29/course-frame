<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h3>
        ${sessionScope.user.username}
        您好!
    </h3>
    <h3>欢迎使用书签管理系统.</h3>

    <a href="/bookmark/list">查看书签列表</a>&nbsp;&nbsp;&nbsp;
    <a href="/bookmark/add">添加书签</a>&nbsp;&nbsp;&nbsp;
    <a href="/doLogout">退出登录</a><br>
</body>
</html>
