<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/10/21
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Discount Product</title>
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
<h2>PRODUCT INFORMATION</h2>
<form method="post" action="/discount">
    <label>Product Description: </label><br>
    <input type="text" name="description" placeholder="PRODUCT"><br>
    <label>List Price: </label><br>
    <input type="text" name="price" placeholder="PRICE"><br>
    <label>Discount Percent: </label><br>
    <input type="text" name="percent" placeholder="DISCOUNT"><br>
    <input type="submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>
