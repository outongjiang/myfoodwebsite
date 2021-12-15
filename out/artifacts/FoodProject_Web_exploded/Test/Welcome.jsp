<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/11
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎您,<%=request.getSession().getAttribute("loginStatus")%></h1>
</body>
</html>
