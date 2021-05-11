<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/11/21
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simlpe Dictionary</title>
    <style>
        input[type=text]{
            width: 300px;
            font-size: 16px;
            padding: 12px 10px 12px 10px;
            border-radius: 4px;
            border: 2px solid black;
        }
        #submit{
            border-radius: 4px;
            border: 2px solid black;
            font-size: 16px;
            padding: 10px 32px;
            margin-left: 4px;
        }
    </style>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="dictionary_2.jsp">
    <input type="text" placeholder="Enter your word" name="search">
    <input type="submit" id="submit" value="Search">
</form>
</body>
</html>
