<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 31/03/21
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Information </title>
</head>
<body>
<table>
    <tr>
        <td>Language: </td>
        <td>${mailBox.language}</td>
    </tr>
    <tr>
        <td>Page Size: </td>
        <td>${mailBox.pageSize}</td>
    </tr>
    <tr>
        <td>Spam filter: </td>
        <td>${mailBox.spamFilter}</td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${mailBox.signature}</td>
    </tr>
</table>
</body>
</html>
