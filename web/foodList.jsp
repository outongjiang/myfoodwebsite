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
    <script>
        function f(id1,name,price,num) {
            var id = "#" + id1;
            if($(id).html() == "编辑"){
                var input = $(id).parent().parent().children("td").children("input[type='text']").not("#bkbj");
                input.attr("readOnly", false);
                input.attr("disabled", false);
                input.removeClass("foodProperties_border");
                input.focus();
                $(id).html("完成");
                ${sessionScope.inputStatus.add(id1)}
            }else{
                var input =$(id).parent().parent().children("td").children("input[type='text']");
                input.prop("readOnly", true);
                input.prop("disabled", true);
                input.addClass("foodProperties_border");
                // input.focus();
                $(id).html("编辑");
                ${sessionScope.inputStatus.remove(id1)}
                self.location.href ="/vd/UpdateFoodServlet?id="+id1+"&name="+input.eq(1).val()+"&price="+input.eq(2).val()+"&num="+input.eq(3).val();
            }
        }
        $(function () {
            <c:forEach items="${sessionScope.inputStatus}" var="inputStatu">
            var id="#"+inputStatu;
            var input = $(id).parent().parent().children("td").children("input[type='text']").not("#bkbj");
            input.attr("readOnly", false);
            input.attr("disabled", false);
            input.removeClass("foodProperties_border");
            input.focus();
            $(id).html("完成");
            </c:forEach>
        })
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="input-group col-lg-6">
            <span class="input-group-addon" id="basic-addon1">食物名称</span>
            <input type="text" class="inputWidth form-control" placeholder="食物名称">
            <span class="input-group-addon" id="basic-addon1">食物价格</span>
            <input type="text" class="inputWidth form-control " placeholder="食物价格" aria-describedby="basic-addon1">
            <span class="input-group-addon" id="basic-addon1">食物数量</span>
            <input type="text" class="inputWidth form-control " placeholder="食物数量" aria-describedby="basic-addon1">
            <span class="input-group-addon hiddenSpan" id="basic-addon1"></span>
            <input type="submit" class="findBtn form-control " aria-describedby="basic-addon1" value="查询">
        </div>

    </div>
</div>
<table class="table table-bordered">
    <tr>
        <th><input type="checkbox"></th>
        <th>食物编号</th>
        <th>食物名称</th>
        <th>食物价格</th>
        <th>食物数量</th>
        <th>更新</th>
    </tr>
    <c:forEach items="${sessionScope.foods}" var="food" varStatus="s">
        <tr>
            <td><input type="checkbox"></td>
            <td><input name="" id="bkbj" class="foodPropertiesWidth" type="text" value="${s.index}"></td>
            <td><input name="" class="foodPropertiesWidth2" type="text" value="${food.name}"></td>
            <td><input name="price" class="foodPropertiesWidth" type="text" value="${food.price}"></td>
            <td><input name="num" class="foodPropertiesWidth" type="text" value="${food.num}"></td>
            <td>
                <button id="${food.id}" onclick="f('${food.id}','${food.name}','${food.price}','${food.num}')">编辑</button>&nbsp;&nbsp;&nbsp;
                <button>删除</button>
            </td>
        </tr>
    </c:forEach>
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
