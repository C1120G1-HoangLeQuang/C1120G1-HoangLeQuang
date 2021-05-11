package Controller;

import Model.NhanVien;
import Repository.nhan_vien.NhanVienRepository;
import Repository.nhan_vien.NhanvienRepositoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", urlPatterns = {"","/nhanvien"})
public class NhanVienServlet extends javax.servlet.http.HttpServlet {

    private NhanVienRepository nhanVienRepository = new NhanvienRepositoryImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shownhanvien":
                showNhanVienList(request, response);
                break;
            case "edit":
//                updateUser(request, response);
                break;
            case "delete":
//                deleteUser(request, response);
                break;
            default:
//                showMainList(request, response);
                break;
        }
    }


    private void showNhanVienList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NhanVien> nhanVienList = this.nhanVienRepository.findAll();
        request.setAttribute("nhanVienList", nhanVienList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/nhanvien/listnhanvien.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

