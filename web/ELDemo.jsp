<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yr
  Date: 2019-10-31
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  引入JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EL-Demo</title>
</head>
<body>

<h3>这里是 EL & JSTL 综合DEMO</h3>

<%
    List<String> list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    list.add("fff");

    request.setAttribute("list", list);
%>

<table border="1px" width="500px" align="center">
    <tr>
        <th>Num</th>
        <th>name</th>
        <th>other</th>
    </tr>
    <c:forEach items="${list}" var="obj" varStatus="s">
        <c:if test="${s.index % 2 == 0}">
            <tr bgcolor="#f5f5dc">
                <td>${s.index}</td>
                <td>${obj}</td>
                <td>-</td>
            </tr>
        </c:if>
        <c:if test="${s.index % 2 != 0}">
            <tr bgcolor="#5f9ea0">
                <td>${s.index}</td>
                <td>${obj}</td>
                <td>-</td>
            </tr>
        </c:if>
    </c:forEach>
</table>



</body>
</html>
