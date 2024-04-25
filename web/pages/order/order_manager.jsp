<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/18
  Time: 9:04
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
            <td>订单号</td>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.orders}" var="orders">
            <tr>
                <td>${orders.orderId}</td>
                <td>${orders.creatTime}</td>
                <td>${orders.price}</td>
                <c:if test="${orders.status==0}">
                    <td><a href="OrderServlet?action=sendOrder&orderId=${orders.orderId}&status=1">确认发货</a></td>
                </c:if>
                <c:if test="${orders.status==1}">
                    <td>未签收</td>
                </c:if>
                <c:if test="${orders.status==2}">
                    <td>已签收</td>
                </c:if>
                <td><a href="OrderServlet?action=showOrderDetail&orderId=${orders.orderId}">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>
    <div><a  href="background.jsp" class="right"><button class="mybut">back</button></a></div>
</div>
</body>
</html>
