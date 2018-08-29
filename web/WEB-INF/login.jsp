<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎登陆</h1>
<form action="/myshopping/GohallUI" method="post">
<table border="1px" border-collapse="collapse">
    <tr><td>请输入用户账号:</td><td><input type="text" name="id" /></td></tr>
    <tr><td>请输入密  码:</td><td><input type="password" name="password" /></td></tr>
    <tr><td><input type="submit" value="登 陆"></td><td><input type="reset" value="重新输入" /></td></tr>
</table>
</form>
</body>
</html>
