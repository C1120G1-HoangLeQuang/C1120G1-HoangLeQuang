<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/16/21
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Detail</title>
</head>
<body>
<h1>User Detail</h1>
<h4>
    <a href="/users">Back to user list</a>
</h4>
<table>
    <tr>
        <td>Name: </td>
        <td>${requestScope["user"].getName()}</td>
    </tr>
    <tr>
        <td>Email: </td>
        <td>${requestScope["user"].getEmail()}</td>
    </tr>
    <tr>
        <td>Country: </td>
        <td>${requestScope["user"].getCountry()}</td>
    </tr>
</table>
</body>
</html>
