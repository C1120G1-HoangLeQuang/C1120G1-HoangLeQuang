<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 1:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../page/header.jsp"/>
<jsp:include page="../page/navbar/navbarservice.jsp"/>
<body>
<div style="text-align: center;">
    <h1>Dich Vu Management</h1>
    <p>
        <a href="/service?action=create"><i class="fas fa-plus"></i>  Create new Service</a>
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
            <th>Id Dich Vu</th>
            <th>Ten Dich Vu</th>
            <th>Dien Tich</th>
            <th>So Nguoi Toi Da</th>
            <th>Chi Phi Thue</th>
            <th>ID Kieu Thue</th>
            <th>ID Loai Dich Vu</th>
            <th>Tieu Chuan Phong</th>
            <th>Tien Nghi Khac</th>
            <th>Dien Tich Ho Boi</th>
            <th>So Tang</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items='${dichVuList}' var="dichVu">
            <tr>
                <td>${dichVu.getId_dichvu()}</td>
                <td>${dichVu.getTen_dich_vu()}</td>
                <td>${dichVu.getDien_tich()}</td>
                <td>${dichVu.getSonguoi_toida()}</td>
                <td>${dichVu.getChi_phi_thue()}</td>
                <td>${dichVu.getId_kieuthue().getTen_kieuthue()}</td>
                <td>${dichVu.getId_loaidichvu().getTen_loaidichvu()}</td>
                <td>${dichVu.getTieu_chuan_phong()}</td>
                <td>${dichVu.getMota_tiennghi_khac()}</td>
                <td>${dichVu.getDientich_hoboi()}</td>
                <td>${dichVu.getSo_tang()}</td>
                <td>
                    <a type="button" class="btn btn-warning"
                       href="/service?action=edit&id_dichvu=${dichVu.getId_dichvu()}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a type="button" class="btn btn-danger"
                       href="/service?action=delete&id_dichvu=${dichVu.getId_dichvu()}">
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
