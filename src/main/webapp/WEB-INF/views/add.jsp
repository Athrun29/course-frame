<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加书签</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<script type="text/javascript">
    function check(form) {
        var id = form.username.value;
        var name = form.password.value;
        var author = form.username.value;
        var category = form.password.value;
        if(id.length == 0 || name.length == 0
            || author.length == 0 || category.length == 0) {
            alert('书签信息不完整，请检查.');
            return false;
        } else {
            return true;
        }
    }
</script>
<form method="post" action="/bookmark/doAdd" onsubmit="return check(this)">
    编号：<input name="id"><br>
    名称：<input name="name"><br>
    作者：<input name="author"><br>
    分类：
    <select name="category">
        <option value="Java">Java</option>
        <option value="架构">架构</option>
        <option value="数据库">数据库</option>
    </select>
    <br>
    <input value="添加" type="submit"><br>
</form>
</body>
</html>