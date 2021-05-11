<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/22/21
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../page/header.jsp"/>
<jsp:include page="../page/navbar/navbarservice.jsp"/>
<body>
<h1 align="center">Service Management</h1>
<div class="container">

    <c:if test="${requestScope['serviceTypeId'] == 1}">
        <h2>Add New Villa Service</h2>
        <form method="post" id="createVilla">
        <div>
        <table class="table table-hover">
            <tr>
                <th>Id Dich Vu:</th>
                <td>
                    <input type="text" name="id_dichvu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>ten Dich vu:</th>
                <td>
                    <input type="text" name="ten_dich_vu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Dien tich:</th>
                <td>
                    <input type="text" name="dien_tich" size="45"/>
                </td>
            </tr>
            <tr>
                <th>So nguoi toi da:</th>
                <td>
                    <input type="text" name="songuoi_toida" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Chi phi thue:</th>
                <td>
                    <input type="text" name="chi_phi_thue" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Id kieu thue:</th>
                <td>
                    <input type="text" name="id_kieuthue" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Id loai dich vu:</th>
                <td>
                    <input type="text" name="id_loaidichvu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tieu chuan phong:</th>
                <td>
                    <input type="text" name="tieu_chuan_phong"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tien nghi khac:</th>
                <td>
                    <input type="text" name="mota_tiennghi_khac" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Dien tich ho boi:</th>
                <td>
                    <input type="text" name="dientich_hoboi" size="45"/>
                </td>
            </tr>
            <tr>
                <th>So tang:</th>
                <td>
                    <input type="text" name="so_tang" size="45"/>
                </td>
            </tr>
            <tr>
                <td><a type="button" class="btn btn-info" href="/service">Back</a></td>
                <td><button type="submit" class="btn btn-success">Create</button></td>
            </tr>
        </table>
        </div>
    </form>
    </c:if>
    <c:if test="${requestScope['serviceTypeId'] == 2}">
        <h2>Add New House Service</h2>
        <form method="post" id="createHouse">
        <div>
        <table class="table table-hover" >
            <tr>
                <th>Id Dich Vu:</th>
                <td>
                    <input type="text" name="id_dichvu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>ten Dich vu:</th>
                <td>
                    <input type="text" name="ten_dich_vu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Dien tich:</th>
                <td>
                    <input type="text" name="dien_tich" size="45"/>
                </td>
            </tr>
            <tr>
                <th>So nguoi toi da:</th>
                <td>
                    <input type="text" name="songuoi_toida" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Chi phi thue:</th>
                <td>
                    <input type="text" name="chi_phi_thue"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Id kieu thue:</th>
                <td>
                    <input type="text" name="id_kieuthue"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Id loai dich vu:</th>
                <td>
                    <input type="text" name="id_loaidichvu" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tieu chuan phong:</th>
                <td>
                    <input type="text" name="tieu_chuan_phong" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Tien nghi khac:</th>
                <td>
                    <input type="text" name="mota_tiennghi_khac" size="45"/>
                </td>
            </tr>
            <tr hidden>
                <th>Dien tich ho boi:</th>
                <td>
                    <input type="text" name="dientich_hoboi" size="45" value= 0 />
                </td>
            </tr>
            <tr>
                <th>So tang:</th>
                <td>
                    <input type="text" name="so_tang" size="45"/>
                </td>
            </tr>
            <tr>
                <td><a type="button" class="btn btn-info" href="/service">Back</a></td>
                <td><button type="submit" class="btn btn-success">Create</button></td>
            </tr>
        </table>
        </div>
    </form>
    </c:if>
    <c:if test="${requestScope['serviceTypeId'] == 3}">
        <h2>Add New Room Service</h2>
        <form method="post" id="createRoom">
            <div>
                <table class="table table-hover">
                    <tr>
                        <th>Id Dich Vu:</th>
                        <td>
                            <input type="text" name="id_dichvu" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>ten Dich vu:</th>
                        <td>
                            <input type="text" name="ten_dich_vu" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Dien tich:</th>
                        <td>
                            <input type="text" name="dien_tich" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>So nguoi toi da:</th>
                        <td>
                            <input type="text" name="songuoi_toida" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Chi phi thue:</th>
                        <td>
                            <input type="text" name="chi_phi_thue" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Id kieu thue:</th>
                        <td>
                            <input type="text" name="id_kieuthue" size="45"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Id loai dich vu:</th>
                        <td>
                            <input type="text" name="id_loaidichvu" size="45"/>
                        </td>
                    </tr>
                    <tr hidden>
                        <th>Tieu chuan phong:</th>
                        <td>
                            <input type="text" name="tieu_chuan_phong" size="45" value=""/>
                        </td>
                    </tr>
                    <tr hidden>
                        <th>Tien nghi khac:</th>
                        <td>
                            <input type="text" name="mota_tiennghi_khac" size="45" value=""/>
                        </td>
                    </tr>
                    <tr hidden>
                        <th>Dien tich ho boi:</th>
                        <td>
                            <input type="text" name="dientich_hoboi" size="45" value=0 />
                        </td>
                    </tr>
                    <tr hidden>
                        <th>So tang:</th>
                        <td>
                            <input type="text" name="so_tang" size="45" value=0 />
                        </td>
                    </tr>
                    <tr>
                        <td><a type="button" class="btn btn-info" href="/service">Back</a></td>
                        <td>
                            <button type="submit" class="btn btn-success">Create</button>
                        </td>
                    </tr>
                </table>
            </div>
        </form>
    </c:if>
    <jsp:include page="../page/footer.jsp"/>
