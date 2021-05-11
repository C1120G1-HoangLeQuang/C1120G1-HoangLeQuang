<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/26/21
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="../assert/style/fontawesome/css/all.min.css" />
    <link rel="stylesheet" href="../assert/style/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../assert/style/datatables/css/dataTables.bootstrap4.min.css">
    <script src="../assert/style/bootstrap/js/jquery-3.3.1.slim.min.js"></script>
    <script src="../assert/style/bootstrap/js/popper.min.js"></script>
    <script src="../assert/style/bootstrap/js/popper.min.js.map"></script>
    <script src="../assert/style/bootstrap/js/bootstrap.min.js"></script>
    <title>Employee Management</title>
</head>
<body>
<h1 align="center">Employee Management</h1>
<div class="container">
    <h2>Add new Employee</h2>
    <form method="post">
        <table class="table table-hover">
            <tr>
                <th>Ten nhan vien: </th>
                <td>
                    <input type="text" name="ho_ten" size="45">
                </td>
            </tr>
            <tr>
                <th>Vi tri: </th>
                <td>
                   <select name="id_vitri">
                       <option value="1">Giam Doc</option>
                       <option value="2">Quan Ly</option>
                       <option value="3">Giam Sat</option>
                       <option value="4">Chuyen Vien</option>
                       <option value="5">Phuc Vu</option>
                       <option value="6">Le Tan</option>
                   </select>
                </td>
            </tr>
            <tr>
                <th>Trinh do: </th>
                <td>
                    <select name="id_trinhdo">
                        <option value="1">Trung Cap</option>
                        <option value="2">Cao Dang</option>
                        <option value="3">Dai Hoc</option>
                        <option value="4">Sau Dai Hoc</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Bo Phan: </th>
                <td>
                    <select name="id_bophan">
                        <option value="1">Sale Maketing</option>
                        <option value="2">Hanh Chinh</option>
                        <option value="3">Phuc Vu</option>
                        <option value="4">Quan Ly</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ten nguoi dung: </th>
                <td>
                    <select name="ten_nguoidung">
                        <option value="admin">Admin</option>
                        <option value="giamdoc">Giam Doc</option>
                        <option value="quanly">Quan Ly</option>
                        <option value="giamsat">Giam Sat</option>
                        <option value="nhanvien">Nhan Vien</option>
                        <option value="nguoidung">Nguoi Dung</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ngay Sinh: </th>
                <td>
                    <input type="date" name="ngay_sinh" >
                </td>
            </tr>
            <tr>
                <th>So cmnd: </th>
                <td>
                    <input type="text" name="so_cmnd" size="45">
                </td>
            </tr>
            <tr>
                <th>Luong: </th>
                <td>
                    <input type="text" name="luong" size="45">
                </td>
            </tr>
            <tr>
                <th>So dien thoai: </th>
                <td>
                    <input type="text" name="sdt" size="45">
                </td>
            </tr>
            <tr>
                <th>Email: </th>
                <td>
                    <input type="text" name="email" size="45">
                </td>
            </tr>
            <tr>
                <th>Dia chi: </th>
                <td>
                    <input type="text" name="dia_chi" size="45">
                </td>
            </tr>
            <tr>
                <td><a type="buttuon" class="btn btn-info" href="/employee">Back</a></td>
                <td><button type="submit" class="btn btn-success">Create</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
