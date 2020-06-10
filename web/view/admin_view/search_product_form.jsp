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
<a href="/users">Back</a> <br> <br>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: blue">${requestScope["message"]}</h3>
</c:if>
<form method="post">
    <input type="text" name="name"><br>
    <input type="submit">
</form>
<c:if test='${requestScope["products"] != null}'>
    <fieldset>
        <legend>Product Result</legend>
        <table border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Brand</th>
                <th>Product Price</th>
                <th>Product Stock</th>
                <th>Product Description</th>
                <th>Product ImgUrl</th>
                <th colspan="4">Action</th>
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
                    <td><a href="/products_command?action=import&id=${product.getId()}">Import Product</a></td>
                    <td><a href="/products_command?action=export&id=${product.getId()}">Export Product</a></td>
                    <td><a href="/products_command?action=update&id=${product.getId()}">Update Product</a></td>
                    <td><a href="/products_command?action=delete&id=${product.getId()}">Delete Product</a></td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</c:if>
</body>
</html>
