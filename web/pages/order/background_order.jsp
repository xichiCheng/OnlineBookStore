<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/15
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/book_manager.css">
</head>
<body>
<div id="main"  class="container">
    <table>
        <tr>
            <td>名字</td>
            <td>数量</td>
            <td>价格</td>
            <td>总价</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="OrderServlet?action=showAllOrders"><button class="button"> 返回</button></a>
</div>

</body>
</html>
