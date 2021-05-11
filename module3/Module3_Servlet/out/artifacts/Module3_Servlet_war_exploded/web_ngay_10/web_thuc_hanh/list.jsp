<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/12/21
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customers</h1>
<p>
    <a href="/web_ngay_10/web_thuc_hanh?action=create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["customer_10s"]}' var="customer_10">
        <tr>
            <td><a href="/web_ngay_10/web_thuc_hanh?action=view&id=${customer_10.getId()}">${customer_10.getName()}</a></td>
            <td>${customer_10.getEmail()}</td>
            <td>${customer_10.getAddress()}</td>
            <td><a href="/customers?action=edit&id=${customer_10.getId()}">edit</a></td>
            <td><a href="/customers?action=delete&id=${customer_10.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
