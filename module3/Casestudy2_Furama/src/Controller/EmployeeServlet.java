package Controller;

import Model.*;
import Repository.nhan_vien.NhanVienRepository;
import Repository.nhan_vien.NhanvienRepositoryImpl;
import Service.nhan_vien.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    NhanVienSerVice nhanVienSerVice = new NhanVienServiceImpl();
    ViTriService viTriService = new ViTriServiceImpl();
    TrinhDoService trinhDoService = new TrinhDoServiceImpl();
    BoPhanService boPhanService = new BoPhanServiceImpl();
    NguoiDungService nguoiDungService = new NguoiDungServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewEmployee(request, response);
                break;
            case "edit":
//                updateEmployee(request, response);
                break;
            case "delete":
//                deleteEmployee(request, response);
                break;
            default:
//                showKhachHangList(request, response);
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
//                updateUser(request, response);
                break;
            case "delete":
//                deleteUser(request, response);
                break;
            default:
                showNhanVienList(request, response);
                break;
        }
    }

    private void showNhanVienList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> nhanVienList = this.nhanVienSerVice.findAll();
        request.setAttribute("nhanVienList", nhanVienList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("nhanvien/listnhanvien.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/nhanvien/createnhanvien.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        String ho_ten = request.getParameter("ho_ten");
        ViTri id_vitri = viTriService.findById(Integer.parseInt(request.getParameter("id_vitri")));
        TrinhDo id_trinhdo = trinhDoService.findById(Integer.parseInt(request.getParameter("id_trinhdo")));
        BoPhan id_bophan = boPhanService.findById(Integer.parseInt(request.getParameter("id_bophan")));
        NguoiDung ten_nguoidung = nguoiDungService.findById(request.getParameter("ten_nguoidung"));
        String ngay_sinh = request.getParameter("ngay_sinh");
        String so_cmnd = request.getParameter("so_cmnd");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String sdt = request.getParameter("sdt");
        String email = request.getParameter("email");
        String dia_chi = request.getParameter("dia_chi");
        NhanVien nhanVien = new NhanVien(ho_ten, id_vitri, id_trinhdo, id_bophan, ten_nguoidung, ngay_sinh, so_cmnd,
                luong, sdt, email, dia_chi);
        this.nhanVienSerVice.save(nhanVien);
        List<NhanVien> nhanVienList = this.nhanVienSerVice.findAll();
        request.setAttribute("nhanVienList", nhanVienList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("nhanvien/createnhanvien.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
