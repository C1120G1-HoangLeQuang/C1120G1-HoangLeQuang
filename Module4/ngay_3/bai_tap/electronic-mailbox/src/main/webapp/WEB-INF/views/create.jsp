<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 31/03/21
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mail Box</title>
</head>
<body>
<h3>Please fill information below</h3>
<form:form method="post" action="/update" modelAttribute="mailBox">
    <table>
        <tr>
            <td>Language: </td>
            <td><form:select path="language">
                <form:options items="${listLanguage}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Page Size: </td>
            <td><form:select path="pageSize">
                <form:options items="${listPageSize}"/>
            </form:select>
            </td>
        </tr>
        <tr>
            <td>Spam filter </td>
            <td>Show: <form:checkbox path="spamFilter"/>   emails per page</td>
        </tr>
        <tr>
            <td>Signature: </td>
            <td><form:textarea path="signature" cols="50" rows="4"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><input type="reset" value="Cancel"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
