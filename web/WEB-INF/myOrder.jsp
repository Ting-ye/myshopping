<%@ page import="com.dy.domain.Users" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dy.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我的订单</h1>
<table border="1px" style="border-collapse:collapse;width: 600px;">
    <tr><td colspan="2">用户个人信息</td></tr>
    <tr><td>用户名</td><td><%=((Users)session.getAttribute("loginUser")).getUsername()%></td></tr>
    <tr><td>Email</td><td><%=((Users)session.getAttribute("loginUser")).getEmail()%></td></tr>
    <tr><td>用户级别</td><td><%=((Users)session.getAttribute("loginUser")).getGrade()%></td></tr>
</table>
<br/>
<hr/>
<br/>
<table border="1px" style="border-collapse:collapse;width: 600px;">
    <tr><td>bookID</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td></tr>
    <%
        ArrayList arrayList= (ArrayList) request.getAttribute("orderInfo");
        for(int i=0;i<arrayList.size();i++){
            Book book= (Book) arrayList.get(i);
    %>
    <tr><td><%=book.getId()%></td>
        <td><%=book.getBookname()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getPublishhouse()%></td>
        <td><%=book.getBuybooknum()%></td></tr>
    <%
        }
    %>

    <tr><td colspan="6">商品总价为： ${totalBookPrice}  元</td></tr>
</table>
<input type="button" value="确认订单" />
<br/>
<a href="/myshopping/GohallUI" >返回</a>
</body>
</html>
