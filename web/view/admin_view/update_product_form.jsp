<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<a href="/logout">Logout</a> <br>
<br> <br>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<fieldset>
    <legend>Update Product</legend>
    <form method="post">
        <input type="hidden" name="id" value="${product.getId()}">
        <p>Product Name</p><br>
        <input type="text" name="name" value="${product.getName()}">
        <p>Product Brand</p><br>
        <input type="text" name="brand" value="${product.getBrand()}">
        <p>Product Price</p><br>
        <input type="text" name="price" value="${product.getPrice()}">
        <p>Product Stock</p><br>
        <input type="text" name="quantity" value="${product.getStock()}">
        <p>Product Description</p><br>
        <input type="text" name="description" value="${product.getDescription()}">
        <p>Product IMG URL</p><br>
        <input type="text" name="image" value="${product.getImgUrl()}"><br>
        <input type="submit">

    </form>
</fieldset>

</body>
</html>
