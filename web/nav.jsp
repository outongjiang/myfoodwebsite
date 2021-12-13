<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/13
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./bootstrap-js-插件/css/bootstrap.min.css">
    <script src="./bootstrap-js-插件/js/jquery-3.2.1.min.js"></script>
    <script src="./bootstrap-js-插件/js/bootstrap.min.js"></script>
    <script src="./jsFile/nav.js"></script>
</head>
<body>
<ul class="nav nav-tabs">
    <li role="presentation" class=""><a href=${pageContext.request.contextPath}+"/foodList.jsp">>查询菜肴</a></li>
    <li role="presentation" class="active"><a href=${pageContext.request.contextPath}+"/appFood.jsp">添加菜肴</a></li>
    <li role="presentation"><a href=${pageContext.request.contextPath}+"/userInfo.jsp">>客户信息</a></li>
</ul>
</body>
</html>
