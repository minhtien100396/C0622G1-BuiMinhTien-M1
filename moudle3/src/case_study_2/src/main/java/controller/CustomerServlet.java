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
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String idCard = request.getParameter("idCard");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerTypeId = Integer.parseInt(request.getParameter("customerTypeId"));
        Customer customer = new Customer(id, customerTypeId, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        try {
            customerService.updateCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully Edit");
        try {
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Date dateOfBirth = Date.valueOf(request.getParameter("dateOfBirth"));
        String idCard = request.getParameter("idCard");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        Customer customer = new Customer(customerType, name, dateOfBirth, gender, idCard, phoneNumber, email, address);
        try {
            customerService.insertCustomer(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully added new");
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                addNewEmployee(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomerByName(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);

        try {
            request.setAttribute("customer", customer);
            request.getRequestDispatcher("/view/customer/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        Map<Integer, String> customerTypeMap = customerService.selectAllCustomerType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeMap", customerTypeMap);
        request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
    }
}
