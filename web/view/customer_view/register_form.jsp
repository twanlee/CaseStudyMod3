<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<a href="/index.jsp">Back</a>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<c:if test='${requestScope["error"] != null}'>
    <h3 style="color: red">${requestScope["error"]}</h3>
</c:if>
<fieldset>
    <legend>Register</legend>
    <form method="post">
        <p>Username</p><br>
        <input type="text" name="username"> <br>
        <p>Password</p><br>
        <input type="password" name="password"> <br>
        <input type="submit">
    </form>

</fieldset>
</body>
</html>
