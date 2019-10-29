<%--
  Created by IntelliJ IDEA.
  User: yr
  Date: 2019-10-25
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>

    <script>
        window.onload = function () {
            var img = document.getElementById("validImg");
            img.onclick = function () {
                console.log(" new valid code here");
                // this.src = "/getValidCode" + "?time=" + (new Date().getTime());
                this.src = "/getValidCode";
            }


        }

    </script>
</head>
<body>
    <div>
        <form action="/login">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>验证码：</td>
                    <td><input type="text" name="validCode"></td>
                    <td><img id="validImg" src="/getValidCode"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit"></td>
                </tr>

            </table>
        </form>

        <div>
            USER:
            <%=request.getSession().getAttribute("YR_USER")%>
        </div>
        <div>
            msg:
            <%=request.getSession().getAttribute("msg")%>
        </div>

    </div>
</body>
</html>
