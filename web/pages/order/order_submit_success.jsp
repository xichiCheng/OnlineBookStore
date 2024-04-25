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
    <style type="text/css">
        .relative-container {
            position: relative; /* 设置父元素为相对定位 */
            height: 30vh; /* 使父元素占据整个视口高度 */
        }

        .left1{
            position: absolute; /* 设置子元素为绝对定位 */
            top:200px;
            left: 450px;

        }
        .left2{
            position: absolute; /* 设置子元素为绝对定位 */
            top:250px;
            left: 500px;
        }

    </style>
</head>
<body>
<div class="relative-container">
    <div class="left1">
       <span style="font-size: 22px" >订单${requestScope.orderId}提交成功</span>
    </div>
    <div class="left2"><a href="pages/cart/cart.jsp">返回</a></div>
</div>

</body>
</html>
