<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Customer Management Application</title>
</head>
<body>
    <h1 align="center">Phong Tro Management</h1>
<div class="container">
    <h2>Add New Phong Tro</h2>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Ten San Pham:</th>
                <td>
                    <input type="text" name="ten_sanpham" id="ten_sanpham" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Gia:</th>
                <td>
                    <input type="text" name="gia" id="gia" size="45"/>
                    <p>
                        <c:if test='${message_price != ""}'>
                            <span style="color: red">${message_price}</span>
                        </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Muc Giam Gia:</th>
                <td>
                    <select name="muc_giamgia">
                        <option>5</option>
                        <option>10</option>
                        <option>15</option>
                        <option>20</option>
                    </select>
<%--                    <input type="text" name="muc_giamgia" id="muc_giamgia" size="45"/>--%>
                </td>
            </tr>
            <tr>
                <th>Ton Kho:</th>
                <td>
                    <input type="text" name="ton_kho" id="ton_kho" size="45"/>
                    <p>
                        <c:if test='${message_stock != ""}'>
                            <span style="color: red">${message_stock}</span>
                        </c:if>
                    </p>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>So Dien thoai:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="sdt" id="sdt" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Ngay Thue:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="ngay_thue" id="ngay_thue" size="45"/>--%>
<%--                    <p>--%>
<%--                        <c:if test='${message_ngay_thue != ""}'>--%>
<%--                            <span style="color: red">${message_ngay_thue}</span>--%>
<%--                        </c:if>--%>
<%--                    </p>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Hinh Thuc Thanh toan:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="ma_thanhtoan" id="ma_thanhtoan" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <th>Ghi chu:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="ghi_chu" id="ghi_chu" size="45"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <td><a type="button" class="btn btn-info" href="/sanpham">Back</a></td>
                <td><button type="submit" class="btn btn-success">Create</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
