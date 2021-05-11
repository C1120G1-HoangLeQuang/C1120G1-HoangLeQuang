package Controller;

import Model.PhongTro;
import Model.SanPham;
import Repository.san_pham.SanPhamRepository;
import Repository.san_pham.SanPhamRepositoryImpl;
import common.CustomerException;
import common.PriceException;
import common.StockException;
import common.Validate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "SanPhamServlet", urlPatterns = "/sanpham")
public class SanPhamServlet extends HttpServlet {

    SanPhamRepository sanPhamRepository = new SanPhamRepositoryImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewSanPham(request, response);
                break;
            case "edit":
//                updatePhongTro(request, response);
                break;
            case "delete":
//                deletePhongTro(request, response);
                break;
            case "viewTop":
                viewTopSanPham(request, response);
                break;
            case "viewDateOrder":
                viewDateOrderSanPham(request, response);
                break;
            default:
//                showPhongTroList(request, response);
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
//                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request, response);
                break;
            case "viewTop":
//                viewTopSanPham(request, response);
                break;
            case "search":
//                searchPhongTro(request, response);
                break;
            default:
                showSanPhamList(request, response);
                break;
        }
    }

    private void showSanPhamList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<SanPham> sanPhamList = this.sanPhamRepository.findAll();
        request.setAttribute("sanPhamList", sanPhamList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/khachhang/createkhachhang.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewSanPham(HttpServletRequest request, HttpServletResponse response) {
        boolean check = true;
        String message_price = null;
        String message_stock = null;
        String ten_sanpham = request.getParameter("ten_sanpham");
        double gia = Double.parseDouble(request.getParameter("gia"));
//        try {
//            Validate.checkPrice(gia);
//        } catch (PriceException e) {
//            message_price = e.getMessage();
//            check = false;
//        }
        double muc_giamgia = Double.parseDouble(request.getParameter("muc_giamgia"));
        int ton_kho = Integer.parseInt(request.getParameter("ton_kho"));
        try {
            Validate.checkStock(ton_kho);
        } catch (StockException e) {
            message_stock = e.getMessage();
            check = false;
        }
        if (!check) {
            request.setAttribute("message_price", message_price);
            request.setAttribute("message_stock", message_stock);
            showCreateForm(request, response);
        } else {
            SanPham sanPham = new SanPham(ten_sanpham, gia, muc_giamgia, ton_kho);
            sanPhamRepository.save(sanPham);

            List<SanPham> sanPhamList = this.sanPhamRepository.findAll();
            request.setAttribute("sanPhamList",sanPhamList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewTopSanPham(HttpServletRequest request, HttpServletResponse response) {
        int top = Integer.parseInt(request.getParameter("top"));
        List<SanPham> sanPhamList = this.sanPhamRepository.findTop3510(top);
        request.setAttribute("sanPhamList", sanPhamList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewDateOrderSanPham(HttpServletRequest request, HttpServletResponse response) {
        Date start = null;
        Date end = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
             java.util.Date startDay = format.parse(request.getParameter("start"));
            java.util.Date endDay = format.parse(request.getParameter("end"));
            start = new Date(startDay.getTime());
            end = new Date(endDay.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<SanPham> sanPhamList = this.sanPhamRepository.findDateOrder(start, end);
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("sanPhamList", sanPhamList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
