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
    <link rel="stylesheet" href="static/css/book_add_edit.css">
</head>
<body>
<form action="UpdateServlet" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${requestScope.book.id}">
    <input type="hidden" name="sales" value="${requestScope.book.sales}">
    <input type="hidden" name="preImgPath" value="${requestScope.book.imgPath}">
    <input type="hidden" name="preProfile" value="${requestScope.book.profile}">

    <div class="relative-container">
        <div class="main">
            <div class="my_div">名称：<input name="name" type="text" class="input" value="${requestScope.book.name}"></div>
            <div class="my_div">价格：<input name="price" type="text" class="input" value="${requestScope.book.price}"></div>
            <div class="my_div">作者：<input name="author" type="text" class="input" value="${requestScope.book.author}"></div>
            <div class="my_div">库存：<input name="stock" type="text" class="input" value="${requestScope.book.stock}"></div>
            <div class="my_div">类型：<input name="type" type="text" class="input"  value="${requestScope.book.type}"></div>
            <div >简介：<textarea name="profile" style="width: 500px; height: 200px;">${requestScope.book.profile}</textarea></div>
            <div class="custom-file-upload">
                <label for="imgPath">
                    <span>选择封面图片</span>
                    <input type="file" id="imgPath" name="imgPath" class="hidden-input">
                </label>
            </div>
            <div>
                <input type="submit" value="提交" class="button">
            </div>
        </div>
    </div>
</form>
<div><a  href="manager/BookServlet?action=page" class="right"><button class="mybut" id="back">back</button></a></div>
</body>
</html>
