<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../resources/style/style.css">
</head>
<body>
<div align="center">
    <div style="width: 300px; height: 500px;">
        <form:form method="POST" action="/register" modelAttribute="user" cssClass="frm">
            <div class="imgcontainer">
                <img src="../resources/pictures/incognito.jpg" alt="Avatar" class="avatar">
            </div>
            <h3 align="center" style="color:maroon;">Don't hesitate, register now!</h3>

            <div class="container" align="left">
                <label>Username</label>
                <input type="text" name="username" required="required" class="inp"/>

                <label>Password</label>
                <input type="password" name="password" required="required" class="inp"/>

                <label>Age</label>
                <input type="date" name="age" required="required" class="inp"/>
                <br><br>

                <div align="center">
                    <input type="radio" name="gender" value="FEMALE"> FEMALE
                    <input type="radio" name="gender" value="MALE"> MALE
                    <br>
                </div>

                <button type="submit" class="btn">Register</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>
