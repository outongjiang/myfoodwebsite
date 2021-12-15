<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 86180
  Date: 2021/12/12
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%=this.getServletConfig().getServletContext().getAttribute("application-msg")%>--%>
<%--<%= request.getAttribute("request-msg")%>--%>
<%--    <h1>${requestScope.requestmsg}</h1>--%>
<%--    <h1>${applicationScope.applicationmsg}</h1>--%>

<%--<c:if test="${3>1}">--%>
<%--    我是真--%>
<%--</c:if>--%>
<%--<% List<String>list=new ArrayList<>();--%>
<%--    list.add("a");list.add("b");list.add("c");list.add("d");--%>
<%--    request.setAttribute("list",list);--%>
<%--%>--%>
<%--<c:forEach var="v" items="${list}" step="2">--%>
<%--    ${v}--%>
<%--</c:forEach>--%>
<%--<% List<Object>list=new ArrayList<>();--%>
<%--    list.add(12);--%>
<%--    list.add(144);--%>
<%--    list.add(133);--%>
<%--    list.add(122);--%>
<%--    request.setAttribute("list",list);--%>
<%--%>--%>
<%--<c:choose>--%>
<%--    <c:when test="${list[0]==13}">对了</c:when>--%>
<%--    <c:when test="${list[0]==13}">错了了</c:when>--%>
<%--</c:choose>--%>
<% List<Object>list=new ArrayList<>();
    list.add("张飞");
    list.add("刘备");
    list.add("关羽");
    request.setAttribute("list",list);
%>
<table>
<c:forEach items="${list}" var="n" varStatus="s">
    <tr>
        <td>${s.count}</td>
        <td>${n}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
