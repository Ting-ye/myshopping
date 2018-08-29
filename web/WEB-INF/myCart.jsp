<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dy.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/26
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="comm.css" />
</head>
<body>
<h1>我的购物车</h1>
<form action="/myshopping/ShoppingClServlet?type=update" method="post">
    <table border="1px" style="border-collapse:collapse;width: 600px;">
    <tr><td>bookID</td><td>书名</td><td>价格</td><td>出版社</td><td>数量</td><td>是否删除</td></tr>
        <%
            ArrayList al= (ArrayList) request.getAttribute("bookListInCart");
            for(int i=0;i<al.size();i++){
                Book book= (Book) al.get(i);
        %>
        <tr><td><%=book.getId()%><input type="hidden" name="id" value="<%=book.getId()%>"/></td>
            <td><%=book.getBookname()%></td>
            <td><%=book.getPrice()%></td>
            <td><%=book.getPublishhouse()%></td>
            <td><input type="text" name="goodsNum" value="<%=book.getBuybooknum()%>"/>本</td>
            <td><a href="/myshopping/ShoppingClServlet?type=del&id=<%=book.getId()%>">删 除</a></td></tr>
        <%
            }
        %>

    <tr><td colspan="6"><input type="submit" value="update" /></td></tr>
    <tr><td colspan="6">商品总价为： ${totalBookPrice}  元</td></tr>
    </table>
</form>
    <a href="/myshopping/GohallUI" >返回继续购物</a>
    <a href="/myshopping/GoMyOrderServlet" >提交订单</a>

</body>
</html>
