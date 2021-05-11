//package Controller;
//
//import Model.Khachhang;
//import Model.LoaiKhach;
//import Model.PhongTro;
//import Model.ThanhToan;
//import Service.phong_tro.HinhThucService;
//import Service.phong_tro.HinhThucServiceImpl;
//import Service.phong_tro.PhongTroService;
//import Service.phong_tro.PhongTroServiceImpl;
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
//@WebServlet(name = "PhongTroServlet", urlPatterns = "/phongtro")
//public class PhongTroServlet extends HttpServlet {
//
//    PhongTroService phongTroService = new PhongTroServiceImpl();
//    HinhThucService hinhThucService = new HinhThucServiceImpl();
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = "";
//        }
//        switch (action) {
//            case "create":
//                createNewPhongTro(request, response);
//                break;
//            case "edit":
////                updatePhongTro(request, response);
//                break;
//            case "delete":
////                deletePhongTro(request, response);
//                break;
//            default:
//                showPhongTroList(request, response);
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
////                viewPhongTro(request, response);
//                break;
//            case "search":
////                searchPhongTro(request, response);
//                break;
//            default:
//                showPhongTroList(request, response);
//                break;
//        }
//    }
//
//    private void showPhongTroList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<PhongTro> phongTroList = this.phongTroService.findAll();
//        request.setAttribute("phongTroList", phongTroList);
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
//    private void createNewPhongTro(HttpServletRequest request, HttpServletResponse response) {
//        boolean check = true;
//        String message_ma_phongtro = null;
//        String message_ngay_thue = null;
//        String message_ten_khachthue = null;
//        String ma_phongtro = request.getParameter("ma_phongtro");
//        try {
//            Validate.checkIdCustomer(ma_phongtro);
//        } catch (CustomerException e) {
//            message_ma_phongtro = e.getMessage();
//            check = false;
//        }
//        String ten_khachthue = request.getParameter("ten_khachthue");
//        try {
//            Validate.checkName(ten_khachthue);
//        } catch (NameCustomerException e) {
//            message_ten_khachthue = e.getMessage();
//            check = false;
//        }
//        String sdt = request.getParameter("sdt");
//        String ngay_thue = request.getParameter("ngay_thue");
//        try {
//            Validate.checkDate(ngay_thue);
//        } catch (DateException e) {
//            message_ngay_thue = e.getMessage();
//            check = false;
//        }
//        ThanhToan ma_thanhtoan = hinhThucService.findById(Integer.parseInt(request.getParameter("ma_thanhtoan")));
//        String ghi_chu = request.getParameter("ghi_chu");
//        if (!check) {
//            request.setAttribute("message_ma_phongtro", message_ma_phongtro);
//            request.setAttribute("message_ten_khachthue", message_ten_khachthue);
//            request.setAttribute("message_ngay_thue", message_ngay_thue);
//            showCreateForm(request, response);
//        } else {
//            PhongTro phongTro = new PhongTro(ma_phongtro, ten_khachthue, sdt, ngay_thue, ma_thanhtoan, ghi_chu);
//            this.phongTroService.save(phongTro);
//            List<PhongTro> phongTroList = this.phongTroService.findAll();
//            request.setAttribute("phongTroList",phongTroList);
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
//        String ma_phongtro = request.getParameter("ma_phongtro");
//        PhongTro phongTro = this.phongTroService.findById(ma_phongtro);
//        RequestDispatcher requestDispatcher;
//        try {
//            request.setAttribute("phongTro", phongTro);
//            requestDispatcher = request.getRequestDispatcher("/khachhang/editkhachhang.jsp");
//            requestDispatcher.forward(request, response);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        String ma_phongtro = request.getParameter("ma_phongtro");
//        PhongTro phongTro = this.phongTroService.findById(ma_phongtro);
//        RequestDispatcher requestDispatcher;
//        request.setAttribute("phongTro", phongTro);
//        requestDispatcher = request.getRequestDispatcher("/khachhang/deletekhachhang.jsp");
//        try {
//            requestDispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
