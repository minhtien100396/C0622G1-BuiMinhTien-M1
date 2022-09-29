package controller;

import bean.Customer;
import service.ICustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerController")
public class CustomerController extends HttpServlet {
    ICustomerService iCustomerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionCustomer = request.getParameter("actionCustomer");
        int id;
        String name;
        String email;
        String address;
        Customer customer;
        switch (actionCustomer) {
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                iCustomerService.delete(id);
                break;
            case "deleteAll":
                iCustomerService.deleteAll();
                break;
            case "search":
                name = request.getParameter("search");
                request.setAttribute("customers", iCustomerService.search(name));
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                address = request.getParameter("address");
                customer = new Customer(id, name, email, address);
                iCustomerService.edit(customer);
                break;
            default:
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                email = request.getParameter("email");
                address = request.getParameter("address");
                customer = new Customer(id, name, email, address);
                iCustomerService.add(customer);
        }
        request.setAttribute("customers", iCustomerService.getAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", iCustomerService.getAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
