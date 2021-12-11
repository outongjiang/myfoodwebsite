<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/11
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./cssFile/login.css" type="text/css">
    <script src="./bootstrap-js-插件/js/bootstrap.min.js"></script>
    <script src="./bootstrap-js-插件/js/jquery-3.2.1.min.js"></script>
    <script src="./jsFile/login.js"></script>
</head>

<body>
<h1>欢迎来到otj餐厅</h1>
<form class="form-horizontal position" action="LoginServlet" method="get">
    <table>
        <tr>
            <td> <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label></td>
            <td> <input name="username" type="text" class="form-control q" id="inputEmail3" placeholder="用户名"></td>

        </tr>
        <tr>
            <td> <label for="inputEmail3" class="col-sm-2 control-label">密码:</label></td>
            <td> <input name="password" type="password" class="form-control q" id="inputEmail3" placeholder="密码"></td>
        </tr>
        <tr>
            <td> <label for="inputEmail3" class="col-sm-2 control-label">验证码:</label></td>
            <td><img id="checkCodeid" src="/CheckCode" alt=""></td>
        </tr>
        <tr>
            <td> </td>
            <td><a href="" class="flush">看不清，刷新一下</a></td>
        </tr>
    </table>

    <div class="btnPosition btnResponse">
        <input class="btn btn-default" type="submit" value="登录">&nbsp;&nbsp;
        <input class="btn btn-default" type="reset" value="重置">&nbsp;&nbsp;
        <input class="btn btn-default" type="submit" value="注册">
    </div>
</form>
</body>

</html>