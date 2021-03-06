<%--
  Created by IntelliJ IDEA.
  User: yr
  Date: 2019-11-12
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>管理员登录</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">

        function refreshCode() {
            var src = "${pageContext.request.contextPath}/verifycode?time" + new Date().getTime();
            var img = document.getElementById("vcode");
            img.src = src;
        }

    </script>

    <style>
        .yrDemo {
            height: 300px;
            margin: 0 auto;
            background: #d0e9c6;
        }

        .yrDemo .flexDemo {
            height: 200px;
            background: #3e8f3e;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-content: center;
        }

        .yrDemo .flexDemo .yrcell {
            background: darkorange;
            width: 45px;
            height: 30px;
        }
    </style>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">管理员登录</h3>
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <div class="form-group">
            <label for="user">用户名：</label>
            <input type="text" name="name" class="form-control" id="user" placeholder="请输入用户名"/>
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
        </div>

        <div class="form-inline">
            <label for="vcode">验证码：</label>
            <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
                <a href="javascript:refreshCode()">
                    <img src="${pageContext.request.contextPath}/verifycode" title="看不清点击刷新" id="vcode"/>
                </a>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="登录">
        </div>
    </form>

    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${login_msg}</strong>
    </div>
    <div class="yrDemo">
        <h5>------ here for CSS demo --------</h5>
        <div class="flexDemo">
            <div class="yrcell">001</div>
            <div class="yrcell">002</div>
            <div class="yrcell">003</div>
            <div class="yrcell">004</div>
            <div class="yrcell">005</div>
        </div>
    </div>
</div>
</body>
</html>
