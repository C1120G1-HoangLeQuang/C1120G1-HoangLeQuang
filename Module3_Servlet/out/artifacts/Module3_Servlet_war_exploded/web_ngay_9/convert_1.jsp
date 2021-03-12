<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/11/21
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Convert</title>
    <style>
        input[type=text]{
            width: 300px;
            font-size: 16px;
            border: 2px solid black;
            border-radius: 4px;
            padding: 12px 10px 12px 10px;
        }
        #submit{
            border-radius: 4px;
            padding: 10px 32px;
            font-size: 16px;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<form method="post" action="convert_2.jsp">
    <label>RATE: </label><br>
    <input type="text" name="rate" placeholder="Rate" value="23000"><br>
    <label>USD: </label><br>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>
