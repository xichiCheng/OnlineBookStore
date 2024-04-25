<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/13
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/book_buy.css">
    <script type="text/javascript" src="static/script/jquery-3.5.1.js"></script>
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
<h1 class="gd" style="font-family:楷体 , sans-serif; font-size: 55px;text-align: center;">文 韵 书 坊</h1>
<div id="parent">
    <div id="left">
        <table >
            <tr>
                <td>
                    <form method="get" action="ClientBookServlet" style="float: left">
                        <input type="hidden" name="action" value="searchByName">
                        书名：<input type="text" id="my_input" name="name" value="${requestScope.name}">
                        <input type="submit" value="查询" class="button5">
                    </form>
                    <input type="button" value="取消查询" id="cancel1" class="button5">
                    <script type="text/javascript">
                        $(function () {
                            $("#cancel1").click(function () {
                                    location.href="ClientBookServlet?action=pageByPrice&pageNo=1&pageSize=4"+"&min=${requestScope.min}&max=${requestScope.max}";
                            })
                        })
                    </script>
                </td>
            </tr>
            <tr>
                <td>
                    <form method="get" action="ClientBookServlet" style="float: left" id="myForm">
                        <input type="hidden" name="action" value="pageByPrice">
                        <div>
                            价格：<input type="text" name="min" class="input" id="min" value="${param.min}">元 -
                            <input type="text" name="max"  class="input" id="max" value="${param.max}">元
                            <input type="submit" value="查询" class="button5" >
                        </div>
                        <div>
                            类型：
                            <input type="radio" name="type"  value="文学类" >文学
                            <input type="radio" name="type" value="历史类">历史
                            <input type="radio" name="type" value="编程与技术类">编程与技术
                            <input type="radio" name="type" value="社会心理类">社会心理
                        </div>
                        <script>
                            window.onload = function() {
                                // 假设我们要根据某个条件（比如从服务器获取的数据）来设置选中的radio
                                var condition = "${requestScope.type}"; // 这个值可以是动态的，比如从服务器获取

                                // 获取表单中的所有radio按钮
                                var radios = document.querySelectorAll('#myForm input[type="radio"]');
                                for (var i = 0; i < radios.length; i++) {
                                    if (radios[i].value === condition) {
                                        radios[i].checked = true;
                                        break; // 找到匹配的radio后退出循环
                                    }
                                }
                            };
                        </script>
                    </form>
                    <input type="button" value="取消查询" id="cancel2" class="button5">
                    <script type="text/javascript">
                        $(function () {
                            $("#cancel2").click(function () {
                                location.href="ClientBookServlet?action=pageByPrice&pageNo=1&pageSize=4";
                            })
                        })
                    </script>
                </td>
            </tr>
        </table>
    </div>
    <div id="center">
        <c:if test="${not empty sessionScope.cart.items}">

            <div>您的购物车有<span style="font-size: 20px;color: #ffffff">${sessionScope.cart.totalCount}</span>件商品</div>
            <div>您刚刚将<span style="font-size: 20px;color: #fcfcfc">《${sessionScope.lastName}》</span>加入购物车中</div>
        </c:if>
        <c:if test="${ empty sessionScope.cart.items}">

            <div>您的购物车有0件商品</div>
            <div>当前购物车为空</div>
        </c:if>
    </div>
    <div id="right">
        <a href="#" class="right"><button class="mybut">退出登录</button> </a>
        <a href="OrderServlet?action=showOrders&id=${sessionScope.userid}" class="right"><button class="mybut">账单</button></a>
        <a class="right" href="http://localhost:8080/OnlineBookstore/pages/cart/cart.jsp"><button class="mybut">购物车</button> </a>
    </div>

</div>

<div id="second">
    <div id="second_center">
    <table id="my_table">
            <tr>
                <c:forEach items="${requestScope.page.items}" var="book">
                <td>
                    <div id="my_card">
                        <ul >
                            <li>
                                书名:<span  style="font-size: 23px;color: #4a18ee">《${book.name}》</span>
                            </li>
                            <li>
                                价格：${book.price}
                            </li>
                            <li>
                                作者：${book.author}
                            </li>
                            <li>
                                类型：${book.type}
                            </li>
                            <li>
                                销量：${book.sales}
                            </li>
                            <li>
                                库存：${book.stock}
                            </li>
                            <li>
                                <a href="ClientBookServlet?action=profile&id=${book.id}">点击查看详情</a>
                            </li>
                        </ul>
                                    <button class="addToCart"   bookId="${book.id}">
                                        Shop now
                                        <svg class="cartIcon" viewBox="0 0 576 512"><path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"></path></svg>
                                    </button>
                    </div>
                </td>
                </c:forEach>
            </tr>
    </table>
        <div id="my-div">
            <c:if test="${requestScope.page.pageNo>1}">
                <a href="ClientBookServlet?action=pageByPrice&pageNo=1&pageSize=4&min=${requestScope.min}&max=${requestScope.max}">首页</a>
                <a href="ClientBookServlet?action=pageByPrice&pageNo=${requestScope.page.pageNo-1}&pageSize=4&min=${requestScope.min}&max=${requestScope.max}&type=${requestScope.type}">上一页</a>

            </c:if>

            【${requestScope.page.pageNo}】

            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
                <a href="ClientBookServlet?action=pageByPrice&pageNo=${requestScope.page.pageNo+1}&pageSize=4&min=${requestScope.min}&max=${requestScope.max}&type=${requestScope.type}">下一页</a>
                <a href="ClientBookServlet?action=pageByPrice&pageNo=${requestScope.page.pageTotal}&pageSize=4&min=${requestScope.min}&max=${requestScope.max}&type=${requestScope.type}">末页</a>
            </c:if>
            共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录，
            到第<input value="${param.pageNo}" name="pn" id="pn_input" class="input"/>页
            <input type="button" value="确定" id="searchPageBth" class="button">
            <script type="text/javascript">
                $(function () {
                    $("#searchPageBth").click(function () {
                        var pageNo=$("#pn_input").val();
                        var pageTotal=${requestScope.page.pageTotal};
                        if(pageNo>0&&pageNo<=pageTotal)
                            location.href="ClientBookServlet?action=pageByPrice&pageNo="+pageNo+"&pageSize=4"+"&min=${requestScope.min}&max=${requestScope.max}&type=${requestScope.type}";
                    })
                })
            </script>
        </div>

    </div>
</div>


</body>
</html>
