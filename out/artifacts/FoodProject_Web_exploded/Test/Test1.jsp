<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/11
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <%request.setAttribute("msg","xxoo");
   request.getRequestDispatcher("/Test/Test2.jsp").forward(request,response);%>
</body>
</html>
