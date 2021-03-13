<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/12/21
  Time: 10:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting Customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
    <a href="/customers_10">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope["customer_10"].getName()}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${requestScope["customer_10"].getEmail()}</td>
            </tr>
            <tr>
                <td>Address: </td>
                <td>${requestScope["customer_10"].getAddress()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customers_10">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
