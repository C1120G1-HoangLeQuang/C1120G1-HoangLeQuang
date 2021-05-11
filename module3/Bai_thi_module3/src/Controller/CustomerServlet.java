//package Controller;
//
//import Model.Khachhang;
//import Model.LoaiKhach;
//import Service.khach_hang.KhachHangService;
//import Service.khach_hang.KhachHangServiceImpl;
//import Service.khach_hang.LoaiKhachService;
//import Service.khach_hang.LoaiKhachServiceImpl;
//import common.*;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
//public class CustomerServlet extends HttpServlet {
//
//    KhachHangService khachHangService = new KhachHangServiceImpl();
//    LoaiKhachService loaiKhachService = new LoaiKhachServiceImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createNewCustomer(request, response);
//                break;
//            case "edit":
//                updateCustomer(request, response);
//                break;
//            case "delete":
//                deleteCustomer(request, response);
//                break;
//            default:
//                showKhachHangList(request, response);
//                break;
//        }
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                showCreateForm(request, response);
//                break;
//            case "edit":
//                showEditForm(request, response);
//                break;
//            case "delete":
//                showDeleteForm(request, response);
//                break;
//            case "view":
//                viewCustomer(request, response);
//                break;
//            case "search":
//                searchCustomer(request, response);
//                break;
//            default:
//                showKhachHangList(request, response);
//                break;
//        }
//    }
//
//    private void showKhachHangList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Khachhang> khachHangList = this.khachHangService.findAll();
//        request.setAttribute("khachHangList", khachHangList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/khachhang/createkhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) {
//        boolean check = true;
//        String message_id_khachhang = null;
//        String message_ngaysinh = null;
//        String message_cmnd = null;
//        String message_email = null;
//        String id_khachhang = request.getParameter("id_khachhang");
//        try {
//            Validate.checkIdCustomer(id_khachhang);
//        } catch (CustomerException e) {
//            message_id_khachhang = e.getMessage();
//            check = false;
//        }
//        LoaiKhach id_loaikhach = loaiKhachService.findById(Integer.parseInt(request.getParameter("id_loaikhach")));
//        String ho_ten = request.getParameter("ho_ten");
//        String ngay_sinh = request.getParameter("ngay_sinh");
//        try {
//            Validate.checkDate(ngay_sinh);
//        } catch (DateException e) {
//            message_ngaysinh = e.getMessage();
//            check = false;
//        }
//        boolean gioi_tinh = Boolean.parseBoolean(request.getParameter("gioi_tinh"));
//        String so_cmnd = request.getParameter("so_cmnd");
//        try {
//            Validate.checkIdCard(so_cmnd);
//        } catch (IdCardException e) {
//            message_cmnd = e.getMessage();
//            check = false;
//        }
//        String sdt = request.getParameter("sdt");
//        String email = request.getParameter("email");
//        try {
//            Validate.checkEmail(email);
//        } catch (EmailException e) {
//            message_id_khachhang = e.getMessage();
//            check = false;
//        }
//        String dia_chi = request.getParameter("dia_chi");
//        if (!check) {
//            request.setAttribute("message_id_khachhang", message_id_khachhang);
//            request.setAttribute("message_ngaysinh", message_ngaysinh);
//            request.setAttribute("message_cmnd", message_cmnd);
//            request.setAttribute(" message_email",  message_email);
//            showCreateForm(request, response);
//        } else {
//            Khachhang khachHang = new Khachhang(id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi);
//            this.khachHangService.save(khachHang);
//            List<Khachhang> khachHangList = this.khachHangService.findAll();
//            request.setAttribute("khachHangList",khachHangList);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException | IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
//        String id_khachhang = request.getParameter("id_khachhang");
//        Khachhang khachHang = this.khachHangService.findById(id_khachhang);
//        RequestDispatcher requestDispatcher;
//        try {
//            request.setAttribute("khachHang", khachHang);
//            requestDispatcher = request.getRequestDispatcher("/khachhang/editkhachhang.jsp");
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String id_khachhang = request.getParameter("id_khachhang");
//        LoaiKhach id_loaikhach = loaiKhachService.findById(Integer.parseInt(request.getParameter("id_loaikhach")));
//        String ho_ten = request.getParameter("ho_ten");
//        String ngay_sinh = request.getParameter("ngay_sinh");
//        boolean gioi_tinh = Boolean.parseBoolean(request.getParameter("gioi_tinh"));
//        String so_cmnd = request.getParameter("so_cmnd");
//        String sdt = request.getParameter("sdt");
//        String email = request.getParameter("email");
//        String dia_chi = request.getParameter("dia_chi");
//        Khachhang khachHang = new Khachhang(id_khachhang, id_loaikhach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi);
//        this.khachHangService.update(khachHang);
//
//        List<Khachhang> khachHangList = this.khachHangService.findAll();
//        request.setAttribute("khachHangList",khachHangList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        String id_khachhang = request.getParameter("id_khachhang");
//        Khachhang khachHang = this.khachHangService.findById(id_khachhang);
//        RequestDispatcher requestDispatcher;
//        request.setAttribute("khachHang", khachHang);
//        requestDispatcher = request.getRequestDispatcher("/khachhang/deletekhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String id_khachhang = request.getParameter("id_khachhang");
//        this.khachHangService.delete(id_khachhang);
//        List<Khachhang> khachHangList = this.khachHangService.findAll();
//        request.setAttribute("khachHangList", khachHangList);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("khachhang/listkhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String id_khachhang = request.getParameter("id_khachhang");
//        Khachhang khachHang = this.khachHangService.findById(id_khachhang);
//        RequestDispatcher requestDispatcher;
//        request.setAttribute("khachHang", khachHang);
//        requestDispatcher = request.getRequestDispatcher("/khachhang/viewkhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
//        String search = request.getParameter("search");
//        List<Khachhang> khachHangList = this.khachHangService.findByEverything(search);
//        RequestDispatcher dispatcher;
//        request.setAttribute("khachHangList", khachHangList);
//        dispatcher = request.getRequestDispatcher("/khachhang/searchkhachhang.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
