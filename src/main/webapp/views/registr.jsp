<%--
  Created by IntelliJ IDEA.
  User: yyyyt
  Date: 25.03.2023
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorRegister}</font></p>
<form action="${pageContext.servletContext.contextPath}/controller?command=new_user" method="POST">
  <p> Регистрация нового пользователя </p>
  <p> Введите имя : <input name="name" type="text" />
  </p>
  <p> Введите пароль : <input name="password" type="password" />
  </p>
  <input class ="button-main-page" type="submit" value="Зарегистрировать"/>
</form>
</body>
</html>
