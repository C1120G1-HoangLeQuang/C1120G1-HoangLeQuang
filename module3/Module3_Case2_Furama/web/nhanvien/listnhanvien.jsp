<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/19/21
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Nhan Vien</title>
</head>
<body>
<div style="text-align: center;">
    <h1>Nhan vien Management</h1>
    <a href="/furama/list.jsp#">Back to main memu</a>
    <h2>
        <a href="/users?action=create">Create new Nhan vien</a>
    </h2>
    <form method="get" action="/users">
        <input name="action" value="search" hidden>
        <input type="text" placeholder="Enter user's country" name="country">
        <input type="submit" value="Search">
    </form>
</div>
<div align="center">
    <table border="1px" cellpadding="5px">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <td>Id</td>
            <td>Ten
                <a href="/users?action=sort&sortBy=${"DESC"}">DESC</a>
                <a href="/users?action=sort&sortBy=${"ASC"}">ASC</a>
            </td>
            <td>Id Vi Tri</td>
            <td>Id Trinh Do</td>
            <td>Id Bo Phan</td>
            <td>Ten Nguoi Dung</td>
            <td>Ngay Sinh</td>
            <td>CMND</td>
            <td>Luong</td>
            <td>So dien thoai</td>
            <td>Email</td>
            <td>Dia chi</td>
            <td>Action</td>
        </tr>
        <c:forEach items='${nhanVienList}' var="nhanVien">
            <tr>
                <td>${nhanVien.getId_nhanvien()}</td>
                <td><a href="/users?action=view&id=${nhanVien.getId_nhanvien()}">${nhanVien.getHo_ten()}</a></td>
                <td>${nhanVien.getId_vitri().getTen_vitri()}</td>
                <td>${nhanVien.getId_trinhdo().getTrinh_do()}</td>
                <td>${nhanVien.getId_bophan().getTen_bophan()}</td>
                <td>${nhanVien.getTen_nguoidung().getMat_khau()}</td>
                <td>${nhanVien.getNgay_sinh()}</td>
                <td>${nhanVien.getSo_cmnd()}</td>
                <td>${nhanVien.getLuong()}</td>
                <td>${nhanVien.getSdt()}</td>
                <td>${nhanVien.getEmail()}</td>
                <td>${nhanVien.getDia_chi()}</td>
                <td>
                    <a href="/furama?action=edit&id_nhanvien=${nhanVien.getId_nhanvien()}">Edit</a>
                    <a href="/furama?action=delete&id_nhanvien=${nhanVien.getId_nhanvien()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
