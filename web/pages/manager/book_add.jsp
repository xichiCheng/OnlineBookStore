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
    <style type="text/css">
        body {
            background: linear-gradient(45deg, #49a09d, #5f2c82);
        }
        .relative-container {
            position: relative; /* 设置父元素为相对定位 */
            height: 30vh; /* 使父元素占据整个视口高度 */

        }

        .main{
            position: absolute; /* 设置子元素为绝对定位 */
            top:50px;
            left: 400px;
            width: 300px;

        }

        #back{
            position: absolute; /* 设置子元素为绝对定位 */
            top:500px;
            right: 40px;
            width: 80px;
            height:  40px;
        }
        .my_div{
            width: 300px;
            height: 40px;
        }
        .input {
            font-size: 13px;
            width: 80%;
            max-width: 150px;
            height: 25px;
            padding: 12px;
            border-radius: 12px;
            border: 1.5px solid lightgrey;
            outline: none;
            transition: all 0.3s cubic-bezier(0.19, 1, 0.22, 1);
            box-shadow: 0px 0px 20px -18px;
        }

        .input:hover {
            border: 2px solid lightgrey;
            box-shadow: 0px 0px 20px -17px;
        }

        .input:active {
            transform: scale(0.95);
        }

        .input:focus {
            border: 2px solid grey;
        }

        textarea {
            font-size: 16px; /* 设置字体大小为16像素 */
            font-family: Arial, sans-serif; /* 设置字体样式为Arial或者sans-serif */
            color: #333; /* 设置文本颜色为深灰色 */
        }
        .custom-file-upload {
            border: 2px solid #ccc;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            display: inline-block;
            color: #333;
            background-color: #fff;
            text-align: center;
            transition: background-color 0.3s ease;
        }

        .custom-file-upload:hover {
            background-color: #f0f0f0;
        }

        .custom-file-upload span {
            display: inline-block;
            margin-right: 10px;
        }

        .hidden-input {
            width: 0.1px;
            height: 0.1px;
            opacity: 0;
            overflow: hidden;
            position: absolute;
            z-index: -1;
        }
        .button {
            font-size: 17px;
            padding: 0.5em 2em;
            border: transparent;
            box-shadow: 2px 2px 4px rgba(0,0,0,0.4);
            background: dodgerblue;
            color: white;
            border-radius: 4px;
        }

        .button:hover {
            background: rgb(2,0,36);
            background: linear-gradient(90deg, rgba(30,144,255,1) 0%, rgba(0,212,255,1) 100%);
        }

        .button:active {
            transform: translate(0em, 0.2em);
        }

        .mybut {
            padding: 0.6em 1.1em;
            font-size: 17px;
            font-weight: 500;
            color: #000;
            background-color: #fff;
            border: none;
            border-radius: 45px;
            box-shadow: 0px 8px 15px rgba(0, 0, 0, 0.1);
            transition: all 0.3s ease 0s;
            cursor: pointer;
            outline: none;
        }

        .mybut:hover {
            background-color: #23c483;
            box-shadow: 0px 15px 20px rgba(46, 229, 157, 0.4);
            color: #fff;
            transform: translateY(-7px);
        }

        .mybut:active {
            transform: translateY(-1px);
        }
        .right {
            float: right;
        }
    </style>
</head>
<body>
<form action="FileServlet" method="post" enctype="multipart/form-data">
    <div class="relative-container">
        <div class="main">
            <div class="my_div">名称：<input name="name" type="text" class="input"></div>
            <div class="my_div">价格：<input name="price" type="text" class="input" ></div>
            <div class="my_div">作者：<input name="author" type="text" class="input"></div>
            <div class="my_div">库存：<input name="stock" type="text" class="input"></div>
            <div class="my_div">类型：<input name="type" type="text" class="input"></div>
            <div >简介：<textarea name="profile" style="width: 500px; height: 200px; "></textarea></div>
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
