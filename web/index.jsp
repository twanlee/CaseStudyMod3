<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1 style="color:red; text-align: center">WELCOME</h1>
<a href="/login">Login
</a>
<br><br><br>
<a href="/register">Register</a>
<br><br>
<fieldset>
    <legend>Product Information</legend>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Brand</th>
            <th>Product Price</th>
            <th>Product Stock</th>
            <th>Product Description</th>
            <th>Product ImgUrl</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getBrand()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getStock()}</td>
                <td>${product.getDescription()}</td>
                <td><img src="${product.getImgUrl()}" alt="${product.getName()}" width="250px" height="270px"></td>
                <td><a href="/login">Add to cart</a></td>
            </tr>
        </c:forEach>
    </table>
</fieldset>

</body>
</html>
