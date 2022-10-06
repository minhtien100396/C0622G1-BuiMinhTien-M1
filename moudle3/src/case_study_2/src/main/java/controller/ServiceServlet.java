package controller;

import model.Customer;
import model.Employee;
import model.Service;
import service.IServiceService;
import service.impl.ServiceSevice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService serviceService = new ServiceSevice();

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
                deleteService(request, response);
                break;
            case "search":
                searchServiceByName(request, response);
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            serviceService.deleteService(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/service");
    }

    private void searchServiceByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchByName = request.getParameter("search");
        List<Service> serviceList;
        if (searchByName.equals("")) {
            response.sendRedirect("/service");
            return;
        } else {
            serviceList = serviceService.selectService(searchByName);
        }
        request.setAttribute("serviceList", serviceList);
        try {
            request.getRequestDispatcher("/view/service/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.selectAllService();
        Map<Integer,String> rentTypeMap = serviceService.selectAllRentType();
        Map<Integer,String> facilityTypeMap = serviceService.selectAllFacilityType();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeMap", rentTypeMap);
        request.setAttribute("facilityTypeMap", facilityTypeMap);
        request.getRequestDispatcher("/view/service/list.jsp").forward(request, response);
    }
}
