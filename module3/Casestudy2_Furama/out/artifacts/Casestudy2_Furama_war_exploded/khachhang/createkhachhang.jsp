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
    <h1 align="center">Customer Management</h1>
<div class="container">
    <h2>Add New Customer</h2>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Id Khach hang:</th>
                <td>
                    <input type="text" name="id_khachhang" id="id_khachhang" size="45"/>
                    <p>
                        <c:if test='${message_id_khachhang != ""}'>
                            <span style="color: red">${message_id_khachhang}</span>
                        </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Id Loai khach:</th>
                <td>
                    <input type="text" name="id_loaikhach" id="id_loaikhach" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ho ten:</th>
                <td>
                    <input type="text" name="ho_ten" id="ho_ten" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngay sinh:</th>
                <td>
                    <input type="text" name="ngay_sinh" id="ngay_sinh" size="45"/>
                    <p>
                    <c:if test='${message_ngaysinh != ""}'>
                        <span style="color: red">${message_ngaysinh}</span>
                    </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Gioi tinh:</th>
                <td>
                    <select name="gioi_tinh">
                        <option value="1">Male</option>
                        <option value="0">Female</option>
                    </select>
<%--                    <input type="text" name="gioi_tinh" id="gioi_tinh" size="45"/>--%>
                </td>
            </tr>
            <tr>
                <th>So cmnd:</th>
                <td>
                    <input type="text" name="so_cmnd" id="so_cmnd" size="45"/>
                    <p>
                    <c:if test='${message_cmnd != ""}'>
                        <span style="color: red">${message_cmnd}</span>
                    </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Sdt:</th>
                <td>
                    <input type="text" name="sdt" id="sdt" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                    <p>
                    <c:if test='${message_email != ""}'>
                        <span style="color: red">${message_email}</span>
                    </c:if>
                    </p>
                </td>
            </tr>
            <tr>
                <th>Dia chi:</th>
                <td>
                    <input type="text" name="dia_chi" id="dia_chi" size="45"/>
                </td>
            </tr>
            <tr>
                <td><a type="button" class="btn btn-info" href="/customer">Back</a></td>
                <td><button type="submit" class="btn btn-success">Create</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
