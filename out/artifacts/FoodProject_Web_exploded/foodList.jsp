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

            <span class="input-group-addon" id="basic-addon1">食物名称</span>
            <c:if test="${empty sessionScope.huiXian.name}">
            <input name="name"  type="text" class="inputWidth form-control" placeholder="食物名称">
            </c:if>
            <c:if test="${not empty sessionScope.huiXian.name}">
                <input name="name" value="${sessionScope.huiXian.name}" type="text" class="inputWidth form-control" placeholder="">
            </c:if>

            <span class="input-group-addon" id="basic-addon1">食物价格</span>

            <c:if test="${not empty sessionScope.huiXian.price}">
            <input name="price" value="${sessionScope.huiXian.price}" type="text" class="inputWidth form-control " placeholder="" aria-describedby="basic-addon1">
            </c:if>
            <c:if test="${empty sessionScope.huiXian.price}">
            <input name="price" type="text" class="inputWidth form-control " placeholder="最大预算" aria-describedby="basic-addon1">
            </c:if>

            <span class="input-group-addon" id="basic-addon1">食物数量</span>
            <c:if test="${not empty sessionScope.huiXian.num}">
                <input name="num" value="${sessionScope.huiXian.num}" type="text" class="inputWidth form-control " placeholder="" aria-describedby="basic-addon1">
            </c:if>
            <c:if test="${empty sessionScope.huiXian.num}">
                <input name="num" type="text" class="inputWidth form-control " placeholder="最大数量" aria-describedby="basic-addon1">
            </c:if>
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
    <c:forEach items="${sessionScope.PageBean.foods}" var="food" varStatus="s">
        <tr>
            <td><input name="id" value="${food.id}" type="checkbox"></td>
            <td><input name="" id="bkbj" class="foodPropertiesWidth" type="text" value="${s.index+1+(sessionScope.PageBean.currPage-1)*5}"></td>
            <td><input name="" class="foodPropertiesWidth2" type="text" value="${food.name}"></td>
            <td><input name="price" class="foodPropertiesWidth" type="text" value="${food.price}"></td>
            <td><input name="num" class="foodPropertiesWidth" type="text" value="${food.num}"></td>
            <c:if test="${food.status eq '1'}">
            <td><input id="bkbj" name="status"   class="foodPropertiesWidth" type="text" value="正在销售"></td>
            </c:if>
            <c:if test="${food.status eq '0'}">
                <td><input id="bkbj" name="status"   class="foodPropertiesWidth" type="text" value="已下架"></td>
            </c:if>
            <td>
                <button id="${food.id}" type="button" onclick="edit(${food.id})">编辑</button>&nbsp;&nbsp;&nbsp;
                <button type="button" onclick="del(${food.id})">删除</button>&nbsp;&nbsp;
                <c:if test="${food.status eq '1'}">
                <button type="button" ><a class="status_a" href="${pageContext.request.contextPath}/UpdateFoodServlet?status=0&id=${food.id}" >下架</a></button>
                </c:if>
                <c:if test="${food.status eq '0'}">
                    <button type="button"><a class="status_a" href="${pageContext.request.contextPath}/UpdateFoodServlet?status=1&id=${food.id}" >上架</a></button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </form>
</table>
<nav aria-label="...">
    <ul class="pagination">
        <c:if test="${sessionScope.PageBean.currPage!=1}">
        <li class="active"><a href="FoodListServlet?currPage=${sessionScope.PageBean.currPage-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        </c:if>
        <c:if test="${sessionScope.PageBean.currPage==1}">
            <li class="disabled"><a href="" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
        </c:if>

        <c:forEach  step="1" var="v" varStatus="s" begin="${1}" end="${sessionScope.PageBean.rows}">
            <c:if test="${sessionScope.PageBean.currPage==s.index}">
            <li class="active"><a href="FoodListServlet?currPage=${s.index}">${s.index}<span class="sr-only">1</span></a></li>
            </c:if>
            <c:if test="${sessionScope.PageBean.currPage!=s.index}">
                <li class=""><a href="FoodListServlet?currPage=${s.index}">${s.index}<span class="sr-only">1</span></a></li>
            </c:if>
        </c:forEach>

        <c:if test="${sessionScope.PageBean.currPage==sessionScope.PageBean.rows}">
            <li class="disabled"><a href="" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
        </c:if>
        <c:if test="${sessionScope.PageBean.currPage!=sessionScope.PageBean.rows}">
            <li class="active"><a href="FoodListServlet?currPage=${sessionScope.PageBean.currPage+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
        </c:if>
    </ul>
</nav>
</body>
</html>



