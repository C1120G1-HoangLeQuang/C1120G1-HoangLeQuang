<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 2:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../page/header.jsp"/>
<jsp:include page="../page/navbar/navbar.jsp"/>
<body>
<div style="text-align: center;">
    <h1>Hop Dong Management</h1>
    <p>
        <a href="/contract?action=create"><i class="fas fa-plus"></i>  Create new Contract</a>
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
            <th>ID Hop Dong</th>
            <th>ID Nhan vien</th>
            <th>ID Khach Hang</th>
            <th>ID Dich Vu</th>
            <th>Ngay Lam Hop Dong</th>
            <th>Ngay Ket Thuc</th>
            <th>Tien Dat Coc</th>
            <th>Tong Tien</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${hopDongList}' var="hopDong">
            <tr>
                <td>${hopDong.getId_hopdong()}</td>
                <td>${hopDong.getId_nhanvien().getHo_ten()}</td>
                <td>${hopDong.getId_khachhang().getHo_ten()}</td>
                <td>${hopDong.getId_dichvu().getTen_dich_vu()}</td>
                <td>${hopDong.getNgaylam_hopdong()}</td>
                <td>${hopDong.getNgay_ketthuc()}</td>
                <td>${hopDong.getTien_datcoc()}</td>
                <td>${hopDong.getTong_tien()}</td>
                <td>
                    <a type="button" class="btn btn-warning"
                       href="/contract?action=edit&id_hopdong=${hopDong.getId_hopdong()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger"
                       href="/contract?action=delete&id_hopdong=${hopDong.getId_hopdong()}">
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
