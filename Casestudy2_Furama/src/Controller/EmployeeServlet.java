package Controller;

import Model.NhanVien;
import Repository.nhan_vien.NhanVienRepository;
import Repository.nhan_vien.NhanvienRepositoryImpl;
import Service.nhan_vien.NhanVienSerVice;
import Service.nhan_vien.NhanVienServiceImpl;

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

    private NhanVienSerVice nhanVienSerVice = new NhanVienServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shownhanvien":

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
}
