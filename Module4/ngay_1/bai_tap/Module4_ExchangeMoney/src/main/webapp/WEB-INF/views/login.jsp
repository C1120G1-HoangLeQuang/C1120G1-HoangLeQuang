<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 29/03/21
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        input[type=text] {
            width: 300px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 4px;
            padding: 12px 10px 12px 10px;
        }
        #submit {
            border-radius: 2px;
            padding: 10px 32px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<form method="post" action="/login">
    <label>USD: </label><br/>
    <input type="text" name="usd" placeholder="USD"/><br/>
    <label>VND: </label><br/>
    <input type="text" name="vnd" placeholder="VND"/><br/>
    <input type="submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
