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
<script src="pages/user/check.js"></script>
<body>
<div class="shell">
    <h2 class="title">Register</h2>
    <form id="registrationForm" action="UserServlet" method="post">
        <input type="hidden" name="action" value="register"/>
    <div class="wave-group">
        <input required="" type="text" class="input" autocomplete="off" tabindex="1" name="username" id="username">
        <span class="bar"></span>
        <label class="label">
            <span class="label-char" style="--index: 0">N</span>
            <span class="label-char" style="--index: 1">a</span>
            <span class="label-char" style="--index: 2">m</span>
            <span class="label-char" style="--index: 3">e</span>
        </label>
    </div>
        <span id="usernameError" class="error"></span>
        <br/>

    <div class="wave-group">
        <input required=""  type="password" class="input" autocomplete="off" tabindex="1" name="password" id="password" >
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
    </div>
        <span id="passwordError" class="error"></span>
        <br>

    <div class="wave-group">
        <input required="" id="confirmPassword" type="password" class="input" autocomplete="off" tabindex="1" name="confirmPassword" >
        <span class="bar"></span>
        <label class="label">
            <!--Confirm -->
            <span class="label-char" style="--index: 0">C</span>
            <span class="label-char" style="--index: 1">o</span>
            <span class="label-char" style="--index: 2">n</span>
            <span class="label-char" style="--index: 3">f</span>
            <span class="label-char" style="--index: 3">i</span>
            <span class="label-char" style="--index: 3">r</span>
            <span class="label-char" style="--index: 3">m</span>
            <span class="label-char" style="--index: 3">-</span>
            <span class="label-char" style="--index: 3">p</span>
            <span class="label-char" style="--index: 3">a</span>
            <span class="label-char" style="--index: 3">s</span>
            <span class="label-char" style="--index: 3">s</span>
            <span class="label-char" style="--index: 3">w</span>
            <span class="label-char" style="--index: 3">o</span>
            <span class="label-char" style="--index: 3">rd</span>
        </label>
        <span id="confirmPasswordError" class="error"></span>
    </div>

    <br>
    <div class="wave-group">
        <input required="" type="text" class="input"  onblur="func()" autocomplete="off" tabindex="1" name="email" id="email" >
        <span class="bar"></span>
        <label class="label">
            <span class="label-char" style="--index: 0">E</span>
            <span class="label-char" style="--index: 1">-</span>
            <span class="label-char" style="--index: 2">m</span>
            <span class="label-char" style="--index: 3">a</span>
            <span class="label-char" style="--index: 3">i</span>
            <span class="label-char" style="--index: 3">l</span>
        </label>
        <span id="emailError" class="error"></span>
        <span style="color: red;"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
    </div>

    <input type="submit" value="注册" id="but">

    </form>

    <div class="footer">
        <div class="Remember">
            <input type="checkbox" id="rememberMe">
            <label for="rememberMe">记住我</label>
        </div>
   <a href="index.jsp">  <button id="Jump">去登录</button></a>
    </div>
</div>
</body>

</html>