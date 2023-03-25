<%--
  Created by IntelliJ IDEA.
  User: yyyyt
  Date: 25.03.2023
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
</body>
<div class = "login-page">
    <div class="form">
        <p><font color="red">${errorMessage}</font></p>
        <form class="login-form" action="${pageContext.servletContext.contextPath}/controller?command=login" method="POST">
            <p> Вход в систему </p>
            <p> Имя : <input name="name" type="text" />
            </p>
            <p> Пароль : <input name="password" type="password" />
            </p>
            <input class ="button-main-page" type="submit" value="Войти"/>
        </form>
        <div>
            <form action="${pageContext.servletContext.contextPath}/controller?command=registration_page" method="post">
                <input class ="button-main-page" type="submit" value="Регистрация"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>
