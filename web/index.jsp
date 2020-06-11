<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Home</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h1 style="color:red; text-align: center">WELCOME</h1>--%>
<%--<a href="/login">Login--%>
<%--</a>--%>
<%--<br><br><br>--%>
<%--<a href="/register">Register</a>--%>
<%--<br><br>--%>
<%--<fieldset>--%>
<%--    <legend>Product Information</legend>--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>Product ID</th>--%>
<%--            <th>Product Name</th>--%>
<%--            <th>Product Brand</th>--%>
<%--            <th>Product Price</th>--%>
<%--            <th>Product Stock</th>--%>
<%--            <th>Product Description</th>--%>
<%--            <th>Product ImgUrl</th>--%>
<%--            <th>Action</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${products}" var="product">--%>
<%--            <tr>--%>
<%--                <td>${product.getId()}</td>--%>
<%--                <td>${product.getName()}</td>--%>
<%--                <td>${product.getBrand()}</td>--%>
<%--                <td>${product.getPrice()}</td>--%>
<%--                <td>${product.getStock()}</td>--%>
<%--                <td>${product.getDescription()}</td>--%>
<%--                <td><img src="${product.getImgUrl()}" alt="${product.getName()}" width="250px" height="270px"></td>--%>
<%--                <td><a href="/login">Add to cart</a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</fieldset>--%>

<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 6/9/2020
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <style>
        header{
            position: relative;
        }
        .shopping-mall{
            margin-top: auto;
            font-variant: small-caps;
        }
        .shopping-mall h1{
            font-family: Impact;
            font-size: 50px;
            color: white;
            letter-spacing: 0.3px;
            text-shadow: 0 0 2px black;
            padding-bottom:0px;
            border-bottom: 1px dotted gray;
            margin: 0px;
            width: 49%;
        }
        .shopping-mall h5{
            margin-top: 5px;
            letter-spacing: 0.5px;
            font-size: small;
        }
        .poly-cart ul{
            margin: auto;
            padding: 0px;
            list-style: none;
            font-variant: small-caps;
        }
        *{
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<div class="container" style="height: auto">
    <header class="row">
        <div class="col-sm-8 shopping-mall">
            <h1>Online shopping mall</h1>
            <h5>The center point of the professional programming</h5>
        </div>
        <img class="col-sm-4" src="https://demo.codegym.vn/web/15/layout-bootstrap/images/header-object.png" alt="Logo"/>
    </header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/product">
                        <i class="fas fa-home"></i> Trang chủ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#"><i class="fas fa-list-alt"></i> Giới thiệu</a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/TestProduct/creatP.jsp" class="nav-link"><i class="fas fa-plus"></i>Thêm Mới Sản Phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/TestProduct/editP.jsp"><i class="fa fa-wrench"></i> Sửa Thông Tin Sản Phẩm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/TestProduct/deleteP.jsp"><i class="fas fa-times"></i> Xóa Thông Tin Sản Phẩm</a>
                </li>
            </ul>
            <ul class="navbar navbar-nav navbar-right">
                <li class="nav-item">
                    <a class="nav-link" href="/login">Đăng Nhập</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Đăng Kí</a>
                </li>
            </ul>
        </div>
    </nav>
    <div align="center">
        <h1 style="color:red; text-align: center">WELCOME</h1>
        </a>
        <br><br><br>
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
    </div>
</div>
</body>
</html>