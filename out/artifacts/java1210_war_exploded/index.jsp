<%--
  Created by IntelliJ IDEA.
  User: yr
  Date: 2018-12-10
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      body > div {
        background: #eee;
        width: 80%;
        margin: auto;
      }

      .header {
        width: 100%;
        height: 20%;
        background: cornflowerblue;
      }
      .mainDiv {
        width: 100%;
        height: 55%;
      }
      .footer {
        background: darkslategrey;
        width: 100%;
        height: 25%;
      }

      .mainDiv .slider {
        width: 30%;
        height: 100%;
      }
    </style>
  </head>
  <body>
    <div>
      <div class="header">
        <h4>here is a jsp Page!</h4>
      </div>
      <div class="mainDiv">
        <div class="slider">

        </div>
        <div class="content">
          <p>
            The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. The Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed under the Java Community Process.
          </p>
          <p>
            The Apache Tomcat software is developed in an open and participatory environment and released under the Apache License version 2. The Apache Tomcat project is intended to be a collaboration of the best-of-breed developers from around the world. We invite you to participate in this open development project. To learn more about getting involved, click here.
          </p>
        </div>
      </div>
      <div class="footer">

      </div>
    </div>
  </body>
</html>
