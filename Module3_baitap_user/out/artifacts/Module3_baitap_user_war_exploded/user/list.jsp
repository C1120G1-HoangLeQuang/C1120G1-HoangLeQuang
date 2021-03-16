<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/15/21
  Time: 4:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<div style="text-align: center;">
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Create new User</a>
    </h2>
    <form method="get" action="/users">
<%--        <a href="/users?action=search&country=${user.getCountry}"></a>--%>
        <input name="action" value="search" hidden>
        <input type="text" placeholder="Enter user's country" name="country">
        <input type="submit" value="Search">
    </form>
</div>
<div align="center">
<table border="1px" cellpadding="5px">
    <caption><h2>List of Users</h2></caption>
    <tr>
        <td>ID</td>
        <td>Name
            <a href="/users?action=sort&sortBy=${"DESC"}">DESC</a>
            <a href="/users?action=sort&sortBy=${"ASC"}">ASC</a>
        </td>
        <td>Email</td>
        <td>Country</td>
        <td>Actions</td>
    </tr>
    <c:forEach items='${listUser}' var="user">
        <tr>
            <td>${user.getId()}</td>
            <td><a href="/users?action=view&id=${user.getId()}">${user.getName()}</a></td>
            <td>${user.getEmail()}</td>
            <td>${user.getCountry()}</td>
            <td>
                <a href="/users?action=edit&id=${user.getId()}">Edit</a>
                <a href="/users?action=delete&id=${user.getId()}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
