<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/10/2020
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<a href="/logout">Logout</a> <br> <br> <br>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<form method="post">
    <input type="text" value="name"><br>
    <input type="submit">
</form>
<c:if test='${requestScope["products"] != null}'>
    <fieldset>
        <legend>Product Result</legend>

    </fieldset>
</c:if>
</body>
</html>
