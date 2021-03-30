<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 30/03/21
  Time: 7:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Email Validation</title>
  </head>
  <body>
  <h1>Email Validation</h1>
  <h3 style="color:red">${message}</h3>
  <form action="/validation" method="post">
    <input type="text" name="email">
    <input type="submit" value="Validation">
  </form>
  </body>
</html>
