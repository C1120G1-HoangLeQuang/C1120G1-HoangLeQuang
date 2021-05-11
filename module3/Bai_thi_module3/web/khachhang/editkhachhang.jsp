<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/21/21
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Customer Management Application</title>
</head>
<body>
<h1 align="center">Edit Customer</h1>
<div class="container">
    <form method="post">
        <table class="table table-hover">
                <h2>Edit Customer Information</h2>
            <c:if test='${requestScope["phongTro"] != null}'>
                <input type="hidden" name="ma_phongtro" value="<c:out value='${requestScope["phongTro"].getMa_phongtro()}'/>"/>
            </c:if>
            <tr>
                <th>Id Loai khach:</th>
                <td>
                    <select name="id_loaikhach">
                        <option value="1" <c:if test='${requestScope["khachHang"].getId_loaikhach().getId_loaikhach() == 1}'>
                                                selected="selected"
                                            </c:if>
                            >Diamond
                        </option>
                        <option value="2"  <c:if test='${requestScope["khachHang"].getId_loaikhach().getId_loaikhach() == 2}'>
                            selected="selected"
                        </c:if>
                        >Platinum
                        </option>
                        <option value="3"   <c:if test='${requestScope["khachHang"].getId_loaikhach().getId_loaikhach() == 3}'>
                            selected="selected"
                        </c:if>
                        >Gold
                        </option>
                        <option value="4"   <c:if test='${requestScope["khachHang"].getId_loaikhach().getId_loaikhach() == 4}'>
                            selected="selected"
                        </c:if>
                        >Silver
                        </option>
                        <option value="5"   <c:if test='${requestScope["khachHang"].getId_loaikhach().getId_loaikhach() == 5}'>
                            selected="selected"
                        </c:if>
                        >Members
                        </option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Ten Khach hang:</th>
                <td>
                    <input type="text" name="ho_ten" size="45"
                           value="${requestScope["khachHang"].getHo_ten()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngay sinh:</th>
                <td>
                    <input type="text" name="ngay_sinh" size="45"
                           value="${requestScope["khachHang"].getNgay_sinh()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Gioi tinh:</th>
                <td>
                    <select name="gioi_tinh">
                        <option value="true" ${requestScope["khachHang"].isGioi_tinh() ? 'selected':''}>Male</option>
                        <option value="false" ${requestScope["khachHang"].isGioi_tinh() ? 'selected':''}>Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>So CMND:</th>
                <td>
                    <input type="text" name="so_cmnd" size="45"
                           value="${requestScope["khachHang"].getSo_cmnd()}"
                    />
                </td>
            </tr>
            <tr>
                <th>SDT:</th>
                <td>
                    <input type="text" name="sdt" size="45"
                           value="${requestScope["khachHang"].getSdt()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="${requestScope["khachHang"].getEmail()}"
                    />
                </td>
            </tr>
            <tr>
                <th>Dia chi:</th>
                <td>
                    <input type="text" name="dia_chi" size="45"
                           value="${requestScope["khachHang"].getDia_chi()}"
                    />
                </td>
            </tr>
            </tr>
            <tr>
                <td><a type="button" class="btn btn-info" href="/customer">Back</a></td>
                <td><button type="submit" class="btn btn-warning">Update</button></td>
                <td><button name="action" value="edit" hidden></button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
