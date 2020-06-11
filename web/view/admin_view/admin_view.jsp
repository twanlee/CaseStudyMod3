<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 1:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
        .option{
            position: absolute;
            left: 40%;
            top: 40%;
            transform: translate(-40%, -40%);
        }
        body{
            background-color: burlywood;
        }
    </style>
</head>
<body>
<div class="option">
    <a href="/users" class="btn btn-primary btn-lg">User Management</a>
    <a href="/products" class="btn btn-primary btn-lg">Product Management</a>
    <a href="/orders" class="btn btn-primary btn-lg">Order Management</a>
    <a href="/carts" class="btn btn-primary btn-lg">Buy Product</a>
</div>
</body>
</html>
