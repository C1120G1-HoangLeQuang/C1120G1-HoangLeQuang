<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/11/21
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="/assert/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Customer List</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>NAME</th>
            <th>DATE OF BIRTH</th>
            <th>ADDRESS</th>
            <th>IMAGE</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${customerList}" var="customer">
                <tr>
                    <td scope="row">${customer.name}</td>
                    <td>${customer.dateOfBirth}</td>
                    <td>${customer.address}</td>
                    <td><img src="/assert/image_ngay_9/${customer.image}" width="50" height="50"></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
