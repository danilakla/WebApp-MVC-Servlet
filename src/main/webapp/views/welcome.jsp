<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h1>welcome</h1>
<div class="navbar-collapse">
    <ul class="nav navbar-nav">
        <li class="active"><a href="#"></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.request.contextPath}/controller?command=login_page">Вход</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
        <li><a href="${pageContext.servletContext.contextPath}/controller?command=sing_out">Выход</a></li>
    </ul>
</div>
</nav>
<div class="container">
    <H3>Добрый день, ${username}</H3>
    <caption>Список вашей группы</caption>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Телефон</th>
            <th>email</th>
        </tr>
        <c:forEach items="${group}" var="person">
            <tr><td>${person.name}</td>
                <td>${person.phone}</td>
                <td>${person.email}</td>
            </tr>
        </c:forEach>
    </table>
    <p><font color="red">${errorMessage}</font></p>
    <form method="POST" action="${pageContext.servletContext.contextPath}/controller?command=add_new_user">
        Новый :
        <p> Введите имя <input name="name" type="text" /> </p>
        <p> Введите телефон <input name="phone" type="text" /> </p>
        <p> Введите email <input name="email" type="text" /> </p>
        <input class ="button-main-page" value="Добавить" type="submit" />
    </form>
</div>
<p> ${lastdate}</p>
</body>
</html>
