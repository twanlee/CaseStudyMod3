<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<a href="/users">Back</a>
<a href="/logout">Logout</a>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<c:if test='${requestScope["error"] != null}'>
    <h3 style="color: red">${requestScope["error"]}</h3>
</c:if>
<fieldset>
    <legend>Update Information</legend>
    <form method="post">
        <input type="hidden" name="id" value="<c:out value="${user.id}"/>"/>
        <input type="text" name="username" value="<c:out value="${user.username}"/>"/><br/>
        PassWord <br/>
        <input type="password" name="password" value="<c:out value="${user.password}"/>"/><br/>
        Permission <br/>
        <select name="permission">
            <option value="Admin">Admin</option>
            <option value="Staff">Staff</option>
            <option value="Customer" selected>Customer</option>
        </select><br>

        <input type="submit"/>
    </form>

</fieldset>
</body>
</html>
