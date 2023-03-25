<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
${test}
<%--<c:forEach var="itm" items="${LISTdat}">--%>
<%--    ${itm.getName()}--%>
<%--</c:forEach>--%>
${dtalogin}


<a href="hello-servlet">Hello Servlet</a>
</body>
</html>