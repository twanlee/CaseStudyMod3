<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/11/2020
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<a href="/logout">Logout</a>
<br>
<a href="/carts">Back</a>
<c:if test='${requestScope["message"] != null}'>
    <h3 style="color: red">${requestScope["message"]}</h3>
</c:if>
<br>
<fieldset>
    <legend>Your Cart</legend>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Product Name</th>
            <th>User Name</th>
            <th>Quantity</th>
            <th>Price Per Unit</th>
            <th>Total Price</th>
            <th>Order Date</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <form method="post" action="/carts?action=update&user_id=${user_id}&prId=${order.getProductId()}">
            <tr>
                <td>${order.getItem_id()}</td>
                <td>${order.getProduct_name()}</td>
                <td>${order.getUserName()}</td>
                <td>
                    <input type="number" name="quantity" value="${order.getQuantity()}">
                </td>
                <td>${order.getPrice()}</td>
                <td>${order.getAmount()}</td>
                <td>${order.getOrder_date()}</td>
                <td><input type="submit" value="Save"></td>
                <td><a href="/carts?action=delete&user_id=${user_id}&prId=${order.getProductId()}">Delete</a></td>

            </tr>
            </form>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
