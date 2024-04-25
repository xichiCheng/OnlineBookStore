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
            <td>评论</td>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.totalPrice}</td>
                <c:if test="${requestScope.status==2}"> <td><a href="pages/comment/comment.jsp?bookName=${item.name}&orderId=${requestScope.orderId}">点击发表评论</a></td></c:if>
                <c:if test="${requestScope.status!=2}"><td>签收完可发表评论</td></c:if>
            </tr>
        </c:forEach>
    </table>
    <a href="OrderServlet?action=showOrders&id=${sessionScope.userid}"><button class="button"> 返回</button></a>
</div>

</body>
</html>
