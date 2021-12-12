<%@ page import="Test.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/12
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <% User user=new User();--%>
<%--        user.setName("张三");--%>
<%--    %>--%>
<%--    <% request.setAttribute("u",user);%>--%>
<%--    ${requestScope.u.ser}--%>
<%--    <h1>${s}</h1>--%>
<%
    request.setAttribute("request-msg","张三");
    ServletContext servletContext=request.getServletContext();
    servletContext.setAttribute("application-msg","张三");
%>

</body>
</html>
