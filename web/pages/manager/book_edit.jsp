<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/11
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
</head>
<body>
<form action="manager/BookServlet" method="get">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${requestScope.book.id}">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
        </tr>
        <tr>
            <td><input name="name" type="text" value="${requestScope.book.name}"></td>
            <td><input name="price" type="text" value="${requestScope.book.price}"></td>
            <td><input name="author" type="text" value="${requestScope.book.author}"></td>
            <td><input name="sales" type="text"  value="${requestScope.book.sales}"></td>
            <td><input name="stock" type="text" value="${requestScope.book.stock}"></td>
        </tr>
    </table>
    <input type="submit" value="提交">
</form>
</body>
</body>
</html>
