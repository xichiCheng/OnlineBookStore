<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: k
  Date: 2024/4/11
  Time: 10:56
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
        $("a.deleteClass").click(function () {
          return confirm("确定删除《"+$(this).parent().parent().find("td:first").text()+"》吗");
        })
      })
    </script>
  </head>
  <body>
  <div id="main"  class="container">
    <table>
      <tr>
        <td>名称</td>
        <td>价格</td>
        <td>作者</td>
        <td>销量</td>
        <td>库存</td>
        <td>修改</td>
        <td>删除</td>


      </tr>
      <!-- 从req中取出page page.items=page.getItems()-->
      <!-- 遍历items中每个book-->
      <c:forEach items="${requestScope.page.items}" var="book">
        <tr>
          <td>${book.name}</td>
          <td>${book.price}</td>
          <td>${book.author}</td>
          <td>${book.sales}</td>
          <td>${book.stock}</td>
          <td><a href="manager/BookServlet?action=getBook&id=${book.id}"><button class="mybut">update</button></a></td>
          <td><a class="deleteClass" href="manager/BookServlet?action=delete&id=${book.id}"><button class="mybut">delete</button></a></td>
        </tr>
      </c:forEach>

    </table>
    <div ><a  href="pages/manager/book_add.jsp"><button class="button">添加</button></a></div>
    <br>
    <div id="my-div">
      <c:if test="${requestScope.page.pageNo>1}">
      <a href="manager/BookServlet?action=page&pageNo=1">首页</a>
      <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>

      </c:if>

      【${requestScope.page.pageNo}】

      <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
      <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
      <a href="manager/BookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
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
              location.href="manager/BookServlet?action=page&pageNo="+pageNo;
          })
        })
      </script>
    </div>
    <div><a  href="background.jsp" class="right"><button class="mybut">back</button></a></div>

  </div>
  </body>
</html>
