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
    <h1>San Pham Management</h1>
    <p>
        <a href="/sanpham?action=create"><i class="fas fa-plus"></i>  Create new San Pham</a>
    </p>
    <div>
    <form action="/sanpham" method="post">
        <p>Danh sach top best seller</p>
        <select name="top">Top:
            <option value="3">3</option>
            <option value="5">5</option>
            <option value="10">10</option>
        </select>
        <button type="submit" name="action" value="viewTop">Xem</button>
    </form>
    </div>
    <div>
        <form action="/sanpham" method="post">
            <p>Danh sach san pham dat hang tu</p>
            <input type="date" name="start">
            <p>den</p>
            <input type="date" name="end">
            <button type="submit" name="action" value="viewDateOrder">Xem</button>
        </form>
    </div>
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
            <th>Ma San Pham</th>
            <th>Ten San Pham</th>
            <th>Gia</th>
            <th>Muc Giam Gia</th>
            <th>Ton Kho</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${sanPhamList}' var="sanPham">
            <tr>
                <td>${sanPham.getId_sanpham()}</td>
                <td>
                    <a href="/sanpham?action=view&id_sanpham=${sanPham.getId_sanpham()}">${sanPham.getTen_sanpham()}</a>
                </td>
                <td>${sanPham.getGia()}</td>
                <td>${sanPham.getMuc_giamgia()}</td>
                <td>${sanPham.getTon_kho()}</td>
                <td>
                    <a type="button" class="btn btn-warning"
                       href="/sanpham?action=edit&id_sanpham=${sanPham.getId_sanpham()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger"
                       href="/sanpham?action=delete&id_sanpham=${sanPham.getId_sanpham()}">
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
