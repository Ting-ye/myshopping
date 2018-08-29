<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dy.domain.Book" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎来到购物大厅</h1>
<table  border="1px">
<tr><td>书名</td><td>价格</td><td>出版社</td><td>点击购买</td></tr>
    <%
        //取出request中的ArrayList
        ArrayList al= (ArrayList) request.getAttribute("booksInfo");
        for(int i=0;i<al.size();i++){
            Book book= (Book) al.get(i);
            %>
    <tr><td><%=book.getBookname()%></td>
        <td><%=book.getPrice()%></td>
        <td><%=book.getPublishhouse()%></td>
        <td><a href="/myshopping/ShoppingClServlet?type=add&id=<%=book.getId()%>">加入购物车</a></td></tr>
    <%
        }
    %>

<tr><td colspan="4"><input type="button" value="查看购物车" /></td></tr>
</table>
<a href="/myshopping">返回重新登录</a>
</body>
</html>
