<%--
  Created by IntelliJ IDEA.
  User: No Name VN
  Date: 3/10/2021
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="/login" method="post">
        <table>
            <tr>
                <td>user name: </td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>password: </td>
                <td><input type="text" name="password"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">Login</button>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
