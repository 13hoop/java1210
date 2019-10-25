<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: yr
  Date: 2019-10-25
  Time: 09:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jspDemo1</title>
</head>
<body>

    <h2>方式一：使用out 本次访问时间:
        <%
            Date now = new Date();
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            String str = format.format(now);
            out.write(str);
        %>
    </h2>

    <h3>方式二：%= 赋值 本次访问时间<%=str%></h3>
</body>
</html>
