<%@ page import="service.impl.BookServiceImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/15
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/book_manager.css">
    <script type="text/javascript" src="static/script/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        $(function () {

            $("a.deleteItem").click(function () {
               return  confirm("确定删除《"+$(this).parent().parent().find("td:first").text()+"》吗");
            });

            $("a.clear").click(function () {
                return confirm("确定清空购物车吗");
            });
            $("a.order").click(function () {
                return confirm("确定结账吗");
            });
            $("input.updateCount").change(function () {
                var inputElement = this;
                var  name=$(this).parent().parent().find("td:first").text();
                var  value=this.value;
                var  bookId=$(this).attr('bookId');
                var preValue=this.defaultValue;
                $.ajax({
                    type: "POST",
                    url: "CartServlet",
                    data: {action: "checkStock", bookId: bookId,stock:value},
                    success: function (response) {
                        if (response === "available") {
                            if( confirm("确定将《"+name+"》数量修改为"+value+"吗")){
                                location.href="http://localhost:8080/OnlineBookstore/CartServlet?action=updateCount&count="+value+"&bookId="+bookId;
                            }else{
                                inputElement.value = preValue;
                            }
                        } else if (response === "outOfStock") {
                            alert("对不起，库存不足！购买失败");
                            inputElement.value = preValue;
                        }
                    }
                });

            });
        });
    </script>
</head>
<body>
<div id="main"  class="container">
<table>
    <tr>
        <td>商品名称</td>
        <td>数量</td>
        <td>单价</td>
        <td>金额</td>
        <td>删除</td>
    </tr>
    <!--从Session取出购物车的每个商品 -->
    <c:forEach items="${sessionScope.cart.items}" var="entry">
    <tr>
        <td>${entry.value.name}</td>
        <td><input class="updateCount" type="text" value="${entry.value.count}" style="width: 30px" bookId="${entry.value.id}"></td>
        <td>${entry.value.price}</td>
        <td>${entry.value.totalPrice}</td>
        <td><a href="CartServlet?action=deleteItem&id=${entry.value.id} " class="deleteItem"><button class="mybut">删除</button></a></td>
    </tr>
    </c:forEach>
</table>

<c:if test="${empty sessionScope.cart.items}">
    亲，当前购物车为空
</c:if>
<c:if test="${not empty sessionScope.cart.items}">
<div>
    购物车共<span style="font-size: 20px ;color: #ff2321">${sessionScope.cart.totalCount}</span>件商品
    总金额<span style="font-size: 20px;color: #ff131f">${sessionScope.cart.totalPrice}</span>元
</div>
    <div>
        .
    </div>
    <a href="CartServlet?action=clear" class="clear"><button class="button">清空购物车</button></a>
    <a href="OrderServlet?action=creatOrder" class="order"><button class="button" >结账</button></a>
</c:if>
    <a href="ClientBookServlet?action=pageByPrice"><button class="button"> 返回</button></a>
</div>
</body>
</html>
