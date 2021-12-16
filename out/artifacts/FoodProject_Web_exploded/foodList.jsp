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
   <script src="./jsFile/foodList.js"></script>
</head>
<body>
<form method="get" action="FoodListServlet">
<div class="container-fluid">
    <div class="row">
        <div class="input-group col-lg-6">


            <input name="id" type="hidden" class="inputWidth form-control" placeholder="食物名称">

            <span class="input-group-addon" id="basic-addon1">食物名称</span>
            <input name="name" type="text" class="inputWidth form-control" placeholder="食物名称">

            <span class="input-group-addon" id="basic-addon1">食物价格</span>
            <input name="price" type="text" class="inputWidth form-control " placeholder="食物价格" aria-describedby="basic-addon1">

            <span class="input-group-addon" id="basic-addon1">食物数量</span>
            <input name="num" type="text" class="inputWidth form-control " placeholder="食物数量" aria-describedby="basic-addon1">

            <span class="input-group-addon hiddenSpan" id="basic-addon1"></span>
            <input type="submit" class="findBtn form-control " aria-describedby="basic-addon1" value="查询">

            <span class="input-group-addon hiddenSpan" id="basic-addon1"></span>
            <button type="button" class="findBtn form-control " aria-describedby="basic-addon1" onclick="dels()">删除选中</button>


        </div>

    </div>
</div>
</form>
<table class="table table-bordered">
    <tr>
        <th><sapn>全选</sapn><input id="firstcheckbox" type="checkbox"></th>
        <th>食物编号</th>
        <th>食物名称</th>
        <th>食物价格</th>
        <th>食物数量</th>
        <th>状态</th>
        <th>更新</th>
    </tr>
    <form id="dels" action="${pageContext.request.contextPath}/DeleteFoodServlet" method="get">
    <c:forEach items="${sessionScope.foods}" var="food" varStatus="s">
        <tr>
            <td><input name="id" value="${food.id}" type="checkbox"></td>
            <td><input name="" id="bkbj" class="foodPropertiesWidth" type="text" value="${s.index}"></td>
            <td><input name="" class="foodPropertiesWidth2" type="text" value="${food.name}"></td>
            <td><input name="price" class="foodPropertiesWidth" type="text" value="${food.price}"></td>
            <td><input name="num" class="foodPropertiesWidth" type="text" value="${food.num}"></td>
            <c:if test="${food.status eq '1'}">
            <td><input name="status" class="foodPropertiesWidth" type="text" value="正在销售"></td>
            </c:if>
            <c:if test="${food.status eq '0'}">
                <td><input name="status" class="foodPropertiesWidth" type="text" value="已下架"></td>
            </c:if>
            <td>
                <button id="${food.id}" type="button" onclick="javascript:edit('${food.id}')">编辑</button>&nbsp;&nbsp;&nbsp;
                <button type="button" onclick="del(${food.id})">删除</button>
            </td>
        </tr>
    </c:forEach>
    </form>
</table>
<nav aria-label="...">
    <ul class="pagination">
        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        <li class=""><a href="#">1 <span class="sr-only">(current)</span></a></li>
        <li class=""><a href="#">1 <span class="sr-only">(current)</span></a></li>
        <li class=""><a href="#">1 <span class="sr-only">(current)</span></a></li>
        <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
        <li class="disabled"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
    </ul>
</nav>
</body>
</html>
