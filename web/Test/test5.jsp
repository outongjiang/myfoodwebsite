<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/12
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=this.getServletConfig().getServletContext().getAttribute("application-msg")%>
<%= request.getAttribute("request-msg")%>
    <h1>${requestScope.requestmsg}</h1>
    <h1>${applicationScope.applicationmsg}</h1>
</body>
</html>
