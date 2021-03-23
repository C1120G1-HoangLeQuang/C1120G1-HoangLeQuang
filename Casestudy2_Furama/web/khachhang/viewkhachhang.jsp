<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Customer Detail</title>
</head>
<body>
<div class="container">
    <h1>Customer Detail</h1>
    <fieldset>
        <legend>Customer information</legend>
        <table class="table table-hover">
            <tr>
                <td>Id Loai khach:</td>
                <td>${requestScope["khachHang"].getId_loaikhach().getTen_loaikhach()}</td>
            </tr>
            <tr>
                <td>Ten Khach hang:</td>
                <td>${requestScope["khachHang"].getHo_ten()}</td>
            </tr>
            <tr>
                <td>Ngay sinh:</td>
                <td>${requestScope["khachHang"].getNgay_sinh()}</td>
            </tr>
            <tr>
                <td>Gioi tinh:</td>
                <td>
                    <c:out value="${khachHang.isGioi_tinh() ? 'Male' : 'Female'}"></c:out>
                </td>
            </tr>
            <tr>
                <td>So CMND:</td>
                <td>${requestScope["khachHang"].getSo_cmnd()}</td>
            </tr>
            <tr>
                <td>SDT:</td>
                <td>${requestScope["khachHang"].getSdt()}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${requestScope["khachHang"].getEmail()}</td>
            </tr>
            <tr>
                <td>Dia chi:</td>
                <td>${requestScope["khachHang"].getDia_chi()}</td>
            </tr>
        </table>
    </fieldset>
    <div>
        <a type="button" class="btn btn-info" href="/customer">Back to Customer List</a>
    </div>
</div>
</body>
</html>
