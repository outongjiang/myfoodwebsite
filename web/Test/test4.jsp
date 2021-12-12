<%@ page import="Test.User" %><%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/12
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <% User user=new User();
        user.setName("张三");
    %>
    <% request.setAttribute("u",user);%>
    ${requestScope.u.name}
    <h1>${s}</h1>
</body>
</html>
