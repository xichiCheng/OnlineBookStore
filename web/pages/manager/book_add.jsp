<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/11
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
</head>
<body>
<form action="FileServlet" method="post" enctype="multipart/form-data">
<table>
    <tr>
        <td>名称</td>
        <td>价格</td>
        <td>作者</td>
        <td>库存</td>
        <td>类型</td>
        <td>简介</td>
        <td>封面</td>
    </tr>
    <tr>
        <td><input name="name" type="text"></td>
        <td><input name="price" type="text" ></td>
        <td><input name="author" type="text"></td>
        <td><input name="stock" type="text"></td>
        <td><input name="type" type="text"></td>
        <td><input name="profile" type="text"></td>
        <td><input name="imgPath" type="file"></td>
    </tr>
</table>
    <input type="submit" value="提交">
</form>

</body>
</html>
