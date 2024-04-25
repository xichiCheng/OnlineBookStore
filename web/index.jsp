<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>books</title>
    <base href="http://localhost:8080/OnlineBookstore/">
    <link rel="stylesheet" href="static/css/signup.css">
</head>
<script type="text/javascript" src="static/script/jquery-3.5.1.js"></script>
<body>
<div class="shell">
    <h2 class="title">Login</h2>
    <!-- 表示跳转至http://localhost:8080/OnlineBookstore/UserServlet?action=login&username=value&password=value -->
    <form id="registrationForm" action="UserServlet" method="post">
    <input type="hidden" name="action" value="login"/>
        <div class="wave-group">
        <input required="" type="text" class="input" autocomplete="off" tabindex="1" name="username" id="username"
               value="${cookie.username.value}">
        <span class="bar"></span>
        <label class="label">
            <span class="label-char" style="--index: 0">N</span>
            <span class="label-char" style="--index: 1">a</span>
            <span class="label-char" style="--index: 2">m</span>
            <span class="label-char" style="--index: 3">e</span>
        </label>
        <span id="usernameError" class="error"></span>
    </div>
    <br/>
    <div class="wave-group">
        <input required=""  type="password" class="input" autocomplete="off" tabindex="1" name="password" id="password"
        value="${cookie.password.value}">
        <span class="bar"></span>
        <label class="label">
            <span class="label-char" style="--index: 0">P</span>
            <span class="label-char" style="--index: 1">a</span>
            <span class="label-char" style="--index: 2">s</span>
            <span class="label-char" style="--index: 3">s</span>
            <span class="label-char" style="--index: 3">w</span>
            <span class="label-char" style="--index: 3">o</span>
            <span class="label-char" style="--index: 3">r</span>
            <span class="label-char" style="--index: 3">d</span>
        </label>
        <span id="passwordError" class="error"></span>
    </div>
        <span style="color: red;"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
    <input type="submit" value="Login" id="but">
    </form>

    <div class="footer">
        <div class="Remember">
            <input type="checkbox" id="rememberMe">
            <label for="rememberMe">记住我</label>
        </div>
   <a href="Register.jsp">     <button id="Jump">去注册</button></a>

    </div>
</div>
</body>

</html>