<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User Management</title>
</head>
<body>
<a href="/logout">Logout</a>
<fieldset>
    <legend>User information</legend>
    <table border="1">
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Permission</th>
            <th colspan="2"></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getUsername()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getPermission()}</td>
                <td><a href="/command?action=update&id=${user.getId()}">Update User</a></td>
                <td><a href="/command?action=delete&id=${user.getId()}">Delete User</a></td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
