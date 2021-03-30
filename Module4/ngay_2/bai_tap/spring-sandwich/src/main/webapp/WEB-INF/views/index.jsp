<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 30/03/21
  Time: 10:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>The World Clock</title>
  </head>
  <body>
  <h2>Sandwich Condiment</h2>
  <form action="/save" method="get">
    <input type="checkbox" name="condiment" value="Tomato">
    <label>Tomato</label><br>
    <input type="checkbox" name="condiment" value="Mustard">
    <label>Mustard</label><br>
    <input type="checkbox" name="condiment" value="Sprouts">
    <label>Sprouts</label><br>
    <input type="checkbox" name="condiment" value="Lettuce">
    <label>Lettuce</label><br>
    <input type="submit" value="Save">
    <p>Ket Qua: ${condiment}</p>
  </form>
  </body>
</html>
