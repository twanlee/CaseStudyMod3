<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 10:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<a href="/logout">Logout</a><br>
<a href="/products">Back</a><br>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<fieldset>
    <legend>Add new product</legend>
    <form method="post">
    <p>Product Name</p><br>
        <input type="text" name="name">
    <p>Product Brand</p><br>
        <input type="text" name="brand">
    <p>Product Price</p><br>
        <input type="text" name="price">
    <p>Product Quantity</p><br>
        <input type="text" name="quantity">
    <p>Product Description</p><br>
        <input type="text" name="description">
    <p>Product IMG URL</p><br>
        <input type="text" name="image"><br>
        <input type="submit">

    </form>
</fieldset>
</body>
</html>
