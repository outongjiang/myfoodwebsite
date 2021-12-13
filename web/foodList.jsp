<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/13
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./bootstrap-js-插件/css/bootstrap.min.css">
    <script src="./bootstrap-js-插件/js/jquery-3.2.1.min.js"></script>
    <script src="./bootstrap-js-插件/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./cssFile/foodList.css">
</head>
<body>
<table class="table table-bordered">
    <tr>
        <th>食物编号</th>
        <th>食物名称</th>
        <th>食物价格</th>
        <th>食物数量</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="list" varStatus="s">
    <tr>
        <td>${s.index}</td>
        <td>${list[1]}</td>
        <td>${list[2]}</td>
        <td>${list[3]}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
