<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/18
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/book_buy.css">
    <style type="text/css">
        #relative-container {
            position: relative; /* 设置父元素为相对定位 */
            height: 30vh; /* 使父元素占据整个视口高度 */
        }

        #first{
            position: absolute; /* 设置子元素为绝对定位 */
            top:150px;
            left: 450px;
            width: 240px;
            height: 50px;

        }

        #second{
            position: absolute; /* 设置子元素为绝对定位 */
            top:250px;
            left: 450px;
            width: 240px;
            height: 50px;

        }
        #third{
            position: absolute; /* 设置子元素为绝对定位 */
            top:350px;
            left: 450px;
            width: 240px;
            height: 50px;

        }

    </style>
</head>
<body>
<div id="relative-container">
    <div id="first">
        <a  href="OrderServlet?action=showAllOrders&type=0"><button class="mybut">订单管理</button> </a>
    </div>
    <div id="second">
        <a  href="manager/BookServlet?action=page"><button class="mybut">书籍管理</button> </a>
    </div>
    <div id="third">
        <a href=""><button class="mybut"> 返回登录界面</button></a>
    </div>
</div>
</body>
</html>
