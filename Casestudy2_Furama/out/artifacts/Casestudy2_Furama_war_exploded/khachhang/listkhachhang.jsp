<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/20/21
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../page/header.jsp"/>
<jsp:include page="../page/navbar/navbar.jsp"/>
<body>
<div style="text-align: center;">
    <h1>Khach Hang Management</h1>
    <p>
        <a href="/customer?action=create"><i class="fas fa-plus"></i>  Create new Customer</a>
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
</div >
<div class="container-fluid">
    <table  id="customer" class="table table-hover" >
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
                <td>
                    <a href="/customer?action=view&id_khachhang=${khachHang.getId_khachhang()}">${khachHang.getHo_ten()}</a>
                </td>
                <td>${khachHang.getNgay_sinh()}</td>
                <td>
                    <c:out value="${khachHang.isGioi_tinh() ? 'Male' : 'Female'}"></c:out>
                </td>
                <td>${khachHang.getSo_cmnd()}</td>
                <td>${khachHang.getSdt()}</td>
                <td>${khachHang.getEmail()}</td>
                <td>${khachHang.getDia_chi()}</td>
                <td>
                    <a type="button" class="btn btn-warning"
                       href="/customer?action=edit&id_khachhang=${khachHang.getId_khachhang()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger"
                       href="/customer?action=delete&id_khachhang=${khachHang.getId_khachhang()}">
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
    <script>
        $(document).ready(function () {
            $('#customer').dataTable({
                "dom": 'lrtip',
                "lengthChange": false,
                "pageLength": 2
            })
        })
    </script>
