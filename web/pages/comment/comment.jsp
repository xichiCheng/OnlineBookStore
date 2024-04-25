<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/23
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String bookName = request.getParameter("bookName");
  String id=request.getParameter("orderId");
%>
<html>
<head>
    <title>comment</title>
  <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/book_manager.css">
    <style type="text/css">
        body {

            background: linear-gradient(45deg, #49a09d, #5f2c82);
            font-family: sans-serif;
            font-weight: 100;
        }
        textarea {
            font-size: 20px; /* 设置字体大小为16像素 */
            font-family: Arial, sans-serif; /* 设置字体样式为Arial或者sans-serif */
            color: #333; /* 设置文本颜色为深灰色 */
        }
        #relative-container {
            position: relative; /* 设置父元素为相对定位 */
            height: 30vh; /* 使父元素占据整个视口高度 */
        }

        #first{
            position: absolute; /* 设置子元素为绝对定位 */
            top:100px;
            left: 250px;
            width: 500px;
            height: 30px;
            font-size: 20px;
        }
        #second{
            position: absolute; /* 设置子元素为绝对定位 */
            top:150px;
            left: 250px;
            width: 600px;
            height: 250px;

        }
        #third{
            position: absolute; /* 设置子元素为绝对定位 */
            top:400px;
            left: 500px;
            width: 120px;
            height: 50px;

        }
        #fourth{
            position: absolute; /* 设置子元素为绝对定位 */
            top:500px;
            right: 100px;
            width: 120px;
            height: 50px;
        }
    </style>
</head>
<body>
<div id="relative-container">
    <div id="first" style="font-size: 22px">请发表您对《<span style="font-size: 20px ;color: #ebf4ff"><%=bookName%></span>》的评价:</div>
    <form method="get" action="OrderServlet" >
        <input type="hidden" name="action" value="bookComment">
        <input type="hidden" name="bookName" value=<%=bookName%> >
        <input type="hidden" name="userName" value="${sessionScope.username}">
        <input type="hidden" name="userId" value="${sessionScope.userid}">
        <div id="second"><textarea name="commentContent" style="width: 600px; height: 250px;"></textarea></div>
        <div id="third"><input type="submit" value="提交" class="button"></div>
    </form>
    <div id="fourth"><a href="OrderServlet?action=showOrderDetail&orderId=<%=id%>"><button class="mybut">返回</button></a></div>
</div>


</body>
</html>
