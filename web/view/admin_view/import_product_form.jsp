<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Import</title>
</head>
<body>
<a href="/logout">Logout</a><br>
<a href="/products">Back</a>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<fieldset>
    <legend>Import</legend>
    <form method="post">
<%--        <input type="hidden" name="_id" value="${product.getId()}">--%>
        <table border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Brand</th>
                <th>Product Stock</th>
                <th>Enter Quantity</th>

            </tr>
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getBrand()}</td>
                <td>${product.getStock()}</td>
                <td><input type="text" name="addValue"></td>

            </tr>

        </table>
        <input type="submit">
    </form>
</fieldset>
</body>
</html>
