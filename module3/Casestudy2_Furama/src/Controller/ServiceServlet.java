package Controller;

import Model.*;
import Service.dich_vu.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {


    DichVuService dichVuService = new DichVuServiceImpl();
    KieuThueService kieuThueService = new KieuThueServiceImpl();
    LoaiDichVuService loaiDichVuService = new LoaiDichVuServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewService(request, response);
                break;
            default:
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":

                break;
            case "delete":
//                deleteUser(request, response);
                break;
            default:
                showDichVuList(request, response);
                break;
        }
    }

    private void showDichVuList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DichVu> dichVuList = this.dichVuService.findAll();
        request.setAttribute("dichVuList", dichVuList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dichvu/listdichvu.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        request.setAttribute("serviceTypeId", serviceTypeId);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dichvu/createdichvu.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewService(HttpServletRequest request, HttpServletResponse response) {
        String id_dichvu = request.getParameter("id_dichvu");
        String ten_dich_vu = request.getParameter("ten_dich_vu");
        int dien_tich = Integer.parseInt(request.getParameter("dien_tich"));
        int songuoi_toida = Integer.parseInt(request.getParameter("songuoi_toida"));
        double chi_phi_thue  = Double.parseDouble(request.getParameter("chi_phi_thue"));
        KieuThue id_kieuthue = kieuThueService.findById(Integer.parseInt(request.getParameter("id_kieuthue")));
        LoaiDichVu id_loaidichvu = loaiDichVuService.findById(Integer.parseInt(request.getParameter("id_loaidichvu")));
        String tieu_chuan_phong = request.getParameter("htieu_chuan_phong");
        String mota_tiennghi_khac = request.getParameter("mota_tiennghi_khac");
        double dientich_hoboi = Double.parseDouble(request.getParameter("dientich_hoboi"));
        int so_tang = Integer.parseInt(request.getParameter("so_tang"));
        DichVu dichVu = new DichVu(id_dichvu, ten_dich_vu, dien_tich, songuoi_toida, chi_phi_thue, id_kieuthue,
                id_loaidichvu, tieu_chuan_phong, mota_tiennghi_khac, dientich_hoboi, so_tang);
        this.dichVuService.save(dichVu);

        List<DichVu> dichVuList = this.dichVuService.findAll();
        request.setAttribute("dichVuList",dichVuList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("dichvu/listdichvu.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
