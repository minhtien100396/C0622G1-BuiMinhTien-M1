package controller;

import model.Customer;
import model.Employee;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomerByName(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.deleteCustomer(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/customer");
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchByName = request.getParameter("search");
        List<Customer> customerList;
        if (searchByName.equals("")) {
            response.sendRedirect("/customer");
            return;
        } else {
            customerList = customerService.selectCustomer(searchByName);
        }
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        Map<Integer,String> customerTypeMap = customerService.selectAllCustomerType();
        request.setAttribute("customerList",customerList);
        request.setAttribute("customerTypeMap",customerTypeMap);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request,response);
    }
}
