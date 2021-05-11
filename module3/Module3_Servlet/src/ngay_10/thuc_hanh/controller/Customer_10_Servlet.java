package ngay_10.thuc_hanh.controller;

import ngay_10.thuc_hanh.model.Customer_10;
import ngay_10.thuc_hanh.repository.CustomerRepository;
import ngay_10.thuc_hanh.repository.CustomerRepositoryImpl;
import ngay_10.thuc_hanh.service.CustomerService;
import ngay_10.thuc_hanh.service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Customer_10_Servlet", urlPatterns = "/customers_10")
public class Customer_10_Servlet extends HttpServlet {

    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) {
        List<Customer_10> customer_10s = this.customerRepository.findAll();
        request.setAttribute("customer_10s", customer_10s);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int)(Math.random() * 1000);

        Customer_10 customer_10 = new Customer_10(id, name, email, address);
        this.customerRepository.save(customer_10);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer_10 customer_10 = this.customerRepository.findById(id);
        RequestDispatcher dispatcher;
        if (customer_10 == null) {
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/error_404.jsp");
        } else {
            request.setAttribute("customer_10", customer_10);
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer_10 customer_10 = this.customerRepository.findById(id);
        RequestDispatcher dispatcher;
        if(customer_10 == null){
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/error_404.jsp");
        } else {
            customer_10.setName(name);
            customer_10.setEmail(email);
            customer_10.setAddress(address);
            this.customerRepository.update(id, customer_10);
            request.setAttribute("customer_10", customer_10);
            request.setAttribute("message", "Customer information was update");
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer_10 customer_10 = this.customerRepository.findById(id);
        RequestDispatcher dispatcher;
        if (customer_10 == null) {
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/error_404.jsp");
        } else {
            request.setAttribute("customer-10", customer_10);
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer_10 customer_10 = this.customerRepository.findById(id);
        RequestDispatcher dispatcher;
        if (customer_10 == null) {
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/error_404.jsp");
        } else {
            this.customerRepository.remove(id);
            try {
                response.sendRedirect("/customers_10");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer_10 customer_10 = this.customerRepository.findById(id);
        RequestDispatcher dispatcher;
        if (customer_10 == null) {
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/error_404.jsp");
        } else {
            request.setAttribute("customer_10", customer_10);
            dispatcher = request.getRequestDispatcher("/web_ngay_10/web_thuc_hanh/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
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
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                listCustomers(request, response);
                break;
        }
    }
}
