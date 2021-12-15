<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/13
  Time: 19:43
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
    <link rel="stylesheet" href="./cssFile/addFood.css">
</head>
<body>
<form class="form-horizontal" method="post" action="addFoodServlet">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label"></label>
        <div class="col-sm-10">
            <input name="id" type="hidden" class="input_width form-control" id="inputEmail3" placeholder="菜肴名称">
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">菜肴名称</label>
        <div class="col-sm-10">
            <input name="name" type="text" class="input_width form-control" id="inputEmail3" placeholder="菜肴名称">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">菜肴价格</label>
        <div class="col-sm-10">
            <input name="price" type="text" class="input_width form-control" id="inputPassword3" placeholder="菜肴价格">
        </div>
    </div>
    <div class="form-group">
        <label for="inputPassword3" class="col-sm-2 control-label">菜肴数量</label>
        <div class="col-sm-10">
            <input name="num" type="text" class="input_width form-control" id="inputPassword3" placeholder="菜肴数量">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">添加</button>
        </div>
    </div>
</form>
</body>
</html>
