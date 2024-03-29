<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/16/21
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Seaching</title>
</head>
<body>
<h1>User Management</h1>
<h2>
    <a href="/users">Back to List Users</a>
</h2>
<div align="center">
    <table border="1px" cellpadding="5px">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
<%--            <td>Actions</td>--%>
        </tr>
        <c:forEach items='${listUser}' var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getEmail()}</td>
                <td>${user.getCountry()}</td>
<%--                <td>--%>
<%--                    <a href="/users?action=edit&id=${user.getId()}">Edit</a>--%>
<%--                    <a href="/users?action=delete&id=${user.getId()}">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
