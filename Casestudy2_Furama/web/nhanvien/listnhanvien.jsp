<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/19/21
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../page/header.jsp"/>
<jsp:include page="../page/navbar/navbar.jsp"/>
<body>
<div style="text-align: center;">
    <h1>Nhan vien Management</h1>
    <p>
        <a href="/employee?action=create"><i class="fas fa-plus"></i>  Create new Employee</a>
    </p>
    <form method="get" style="float: right; width: 250px" class="input-group">
        <input type="text" name="search" id="search" class="form-control" placeholder="Search ...">

        <div class="input-group-append">
            <button type="submit" class="btn btn-outline-info">
                <i class="fas fa-search"></i>
            </button>
            <input name="action" value="search" hidden>
        </div>
    </form>
</div>
<div class="container-fluid">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Id</th>
            <th>Ten</th>
            <th>Id Vi Tri</th>
            <th>Id Trinh Do</th>
            <th>Id Bo Phan</th>
            <th>Ten Nguoi Dung</th>
            <th>Ngay Sinh</th>
            <th>CMND</th>
            <th>Luong</th>
            <th>So dien thoai</th>
            <th>Email</th>
            <th>Dia chi</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${nhanVienList}' var="nhanVien">
            <tr>
                <td>${nhanVien.getId_nhanvien()}</td>
                <td><a href="/employee?action=view&id=${nhanVien.getId_nhanvien()}">${nhanVien.getHo_ten()}</a></td>
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
                    <a type="button" class="btn btn-warning" href="/employee?action=edit&id_nhanvien=${nhanVien.getId_nhanvien()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger" href="/employee?action=delete&id_nhanvien=${nhanVien.getId_nhanvien()}">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <a type="button" class="btn btn-info" href="/">Back to Main menu</a>
    </div>
<jsp:include page="../page/footer.jsp"/>
