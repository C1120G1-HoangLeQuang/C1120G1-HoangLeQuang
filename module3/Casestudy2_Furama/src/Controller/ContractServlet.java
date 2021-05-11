package Controller;

import Model.DichVu;
import Model.HopDong;
import Service.hop_dong.HopDongService;
import Service.hop_dong.HopDongServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {

    HopDongService hopDongService = new HopDongServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
                showHopDongList(request, response);
                break;
        }
    }

    private void showHopDongList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HopDong> hopDongList = this.hopDongService.findAll();
        request.setAttribute("hopDongList", hopDongList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("hopdong/listhopdong.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
