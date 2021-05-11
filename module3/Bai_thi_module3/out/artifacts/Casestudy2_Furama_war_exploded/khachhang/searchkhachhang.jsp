<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 1:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
          integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
          crossorigin="anonymous">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Khach Hang</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Khach Hang Management</h1>
</div>
<div class="container-fluid">
    <table class="table table-hover">
<%--        <caption><h2>List of Customer</h2></caption>--%>
        <thead>
        <tr>
            <th>Id Khach Hang</th>
            <th>Id Loai Khach</th>
            <th>Ten Khach Hang</th>
            <th>Ngay Sinh</th>
            <th>Gioi Tinh</th>
            <th>CMND</th>
            <th>So dien thoai</th>
            <th>Email</th>
            <th>Dia chi</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${khachHangList}' var="khachHang">
            <tr>
                <td>${khachHang.getId_khachhang()}</td>
                <td>${khachHang.getId_loaikhach().getTen_loaikhach()}</td>
                <td><a href="/customer?action=view&id_khachhang=${khachHang.getId_khachhang()}">${khachHang.getHo_ten()}</a></td>
                <td>${khachHang.getNgay_sinh()}</td>
                <td>
                    <c:out value="${khachHang.isGioi_tinh() ? 'Male' : 'Female'}"></c:out>
                </td>
                <td>${khachHang.getSo_cmnd()}</td>
                <td>${khachHang.getSdt()}</td>
                <td>${khachHang.getEmail()}</td>
                <td>${khachHang.getDia_chi()}</td>
                <td>
                    <a type="button" class="btn btn-warning" href="/customer?action=edit&id_khachhang=${khachHang.getId_khachhang()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger" href="/customer?action=delete&id_khachhang=${khachHang.getId_khachhang()}">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/customer">Back to Customer List</a>
    </div>
</div>
</body>
</html>
