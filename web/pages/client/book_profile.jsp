<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/20
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>profile</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <script type="text/javascript" src="static/script/jquery-3.5.1.js"></script>
    <link href="static/css/book_comment.css">
    <style>
        body {

            background: linear-gradient(45deg, #49a09d, #5f2c82);

        }
        #card {

            background: linear-gradient(135deg, #ebadb6 0%, #aceae1 100%);
            border-radius: 7px;

        }
        .relative-container {
            position: relative; /* 设置父元素为相对定位 */
            height: 30vh; /* 使父元素占据整个视口高度 */
        }

        .left1{
            position: absolute; /* 设置子元素为绝对定位 */
            top:10px;
            left: 10px;
            width: 240px;
            height: 280px;
        }

        .left2{
            position: absolute; /* 设置子元素为绝对定位 */
            top:300px;
            left: 10px;
            width: 240px;

        }
        .right1{
            position: absolute; /* 设置子元素为绝对定位 */
            top:40px;
            right: 80px;
            width: 750px;
            height: 150px;

        }
        .right2{
            position: absolute; /* 设置子元素为绝对定位 */
            top:220px;
            right: 110px;
            width: 720px;

        }

        #page {
            position: relative;
            box-sizing: border-box;

            font-family: cursive;
            font-size: 20px;
            border-radius: 10px;
            background: #fff;
            background-image: linear-gradient(#f5f5f0 1.1rem, #ccc 1.2rem);
            background-size: 100% 1.2rem;
            line-height: 1.2rem;
            padding: 1.4rem 0.5rem 0.3rem 4.5rem;
        }

        #page::before,
        #page::after {
            position: absolute;
            content: "";
            bottom: 10px;
            width: 40%;
            height: 10px;
            box-shadow: 0 5px 14px rgba(0, 0, 0, 0.7);
            z-index: -1;
            transition: all 0.3s ease;
        }

        #page::before {
            left: 15px;
            transform: skew(-5deg) rotate(-5deg);
        }

        #page::after {
            right: 15px;
            transform: skew(5deg) rotate(5deg);
        }

        #page:hover::before,
        #page:hover::after {
            box-shadow: 0 2px 14px rgba(0, 0, 0, 0.4);
        }

        #margin {
            position: absolute;
            border-left: 1px solid #d88;
            height: 100%;
            left: 3.3rem;
            top: 0;
        }

        .page p {
            margin: 0;
            text-indent: 1rem;
            padding-bottom: 1.2rem;
            color: black;
            line-height: 20px;
        }

        #card1 {
            border-radius: 50px;
            background: #e0e0e0;
            font-size: 20px;
            margin: auto;;
        }
        .centered-content {
            margin: 0 auto;
            width: 30%; /* 可以根据需要调整宽度 */
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
        .addToCart {
            width: 150px;
            height: 40px;
            font-size: 13px;
            background-image: linear-gradient(rgb(214, 202, 254), rgb(158, 129, 254));
            border: none;
            border-radius: 50px;
            color: rgb(255, 255, 255);
            font-weight: 600;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 5px;
            cursor: pointer;
            box-shadow: 1px 3px 0px rgb(139, 113, 255);
            transition-duration: .3s;
        }

        .cartIcon{
            width: 40px;
            height: 30px;
        }

        .addToCart{
            fill: white;
        }

        .addToCart:active {
            transform: translate(2px ,0px);
            box-shadow: 0px 1px 0px rgb(139, 113, 255);
            padding-bottom: 1px;
        }
    </style>
    <script type="text/javascript">
        $(function () {
            $("button.addToCart").click(function () {
                var attr = $(this).attr("bookId");
                location.href = "CartServlet?action=addItem&id="+attr;
            });
        });
    </script>
</head>
<body>


<div class="relative-container">
    <div class="left1">
        <img src="${requestScope.book.imgPath}" alt="背景图片">
    </div>
    <div class="left2" id="card1">
        <div>&nbsp;&nbsp;&nbsp;<span style="font-size: 24px">《${requestScope.book.name}》</span></div>
        <div>作者：<span >${requestScope.book.author}</span></div>
        <div>销量：<span >${requestScope.book.sales}</span></div>
        <div>库存：<span >${requestScope.book.stock}</span></div>
        <div>类型：<span >${requestScope.book.type} </span></div>
        <div>&nbsp;</div>

        <button class="addToCart"   bookId="${requestScope.book.id}">
            Shop now
            <svg class="cartIcon" viewBox="0 0 576 512"><path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"></path></svg>
        </button>

        <div style="text-align: right"><a href=${sessionScope.mainURL} ><button class="mybut">返回</button></a></div>

    </div>
    <div class="right1" id="card">
        <span style="font-size: 18px; font-family:楷体 , sans-serif;">
    简介：${requestScope.book.profile}
        </span>
    </div>
    <div class="right2">
        <div >评论区</div>
        <c:forEach items="${requestScope.comment}" var="comment">
            <div id="page">
                <div id="margin"><span>${comment.userName}&nbsp;&nbsp;&nbsp;&nbsp;${comment.commentTime}</span>
                </div>
                <p>
                    ${comment.content}
                </p>
            </div>
        </c:forEach>
        <div>
            <span style="font-size: 22px">购买书可评价哦</span>
            <div>&nbsp;</div>
            <div>&nbsp;</div>
        </div>
    </div>
</div>

</body>
</html>
