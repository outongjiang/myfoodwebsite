<%@ page import="Test.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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
<%--    <% User user=new User();--%>
<%--        user.setName("张三");--%>
<%--    %>--%>
<%--    <% request.setAttribute("u",user);%>--%>
<%--    ${requestScope.u.ser}--%>
<%--    <h1>${s}</h1>--%>
<%
    request.setAttribute("requestmsg","request-msg");
    ServletContext servletContext=this.getServletConfig().getServletContext();
    servletContext.setAttribute("applicationmsg","application-msg");
%>

</body>
</html>
