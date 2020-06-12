<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/9/2020
  Time: 1:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>User Management</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<a href="/logout">Logout</a>--%>
<%--<fieldset>--%>
<%--    <legend>User information</legend>--%>
<%--    <table border="1">--%>
<%--        <tr>--%>
<%--            <th>User ID</th>--%>
<%--            <th>Username</th>--%>
<%--            <th>Password</th>--%>
<%--            <th>Permission</th>--%>
<%--            <th colspan="2"></th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${users}" var="user">--%>
<%--            <tr>--%>
<%--                <td>${user.getId()}</td>--%>
<%--                <td>${user.getUsername()}</td>--%>
<%--                <td>${user.getPassword()}</td>--%>
<%--                <td>${user.getPermission()}</td>--%>
<%--                <td><a href="/command?action=update&id=${user.getId()}">Update User</a></td>--%>
<%--                <td><a href="/command?action=delete&id=${user.getId()}">Delete User</a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</fieldset>--%>
<%--</body>--%>
<%--</html>--%>
<%---------%>
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
            <%--            <h1>Online shopping mall</h1>--%>
            <%--            <h5>The center point of the professional programming</h5>--%>
            <img src="http://r69.cooltext.com/rendered/cooltext-357128915048232.gif">
        </div>
        <img class="col-sm-4" src="http://r70.cooltext.com/rendered/cooltext-357129078671985.gif" alt="Logo"/>
    </header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="/index">
                        <i class="fas fa-home"></i> Trang chủ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="https://cdn.dribbble.com/users/2363127/screenshots/6483598/dribble.png"><i class="fas fa-list-alt"></i> Giới thiệu</a>
                </li>

            </ul>
            <ul class="navbar navbar-nav navbar-right">
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Log out</a>
                </li>

            </ul>
        </div>
    </nav>
    <div align="center">
        <h1 style="color:red; text-align: center"><img src="http://r69.cooltext.com/rendered/cooltext-357128807107202.gif"></h1>
        <fieldset>
            <legend>User information</legend>
            <table border="1" class="table-hover">
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
    </div>
</div>
</body>
</html>
