package ngay_9.bai_tap.controller;

import ngay_9.bai_tap.models.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList;

    @Override
    public void init() throws ServletException {
        customerList = new ArrayList<>();
        customerList.add(new Customer("Alex Chamberlain", "20/12/1990", "Liverpool", "chamberlain.jpg"));
        customerList.add(new Customer("Mikel Arteta", "02/02/1980", "Arsenal", "arteta.jpg"));
        customerList.add(new Customer("Paolo Maldini", "22/11/1987", "AC Milan", "Maldini.jpg"));
        customerList.add(new Customer("Aaroon Ramsey", "10/09/1994", "Arsenal", "ramsey.jpg"));
        customerList.add(new Customer("Tomas Rosicky", "20/12/1980", "Dortmund", "rosicky.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/web_ngay_9/customer_list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
