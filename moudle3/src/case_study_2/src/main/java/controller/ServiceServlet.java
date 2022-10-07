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
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IServiceService serviceService = new ServiceSevice();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewService(request, response);
                break;
            case "edit":
                updateService(request, response);
                break;
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        Service service = new Service(id,name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        try {
            serviceService.updateService(service);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully Edit");
        try {
            request.getRequestDispatcher("/view/service/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        Service service = new Service(name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        try {
            serviceService.insertService(service);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully added new");
        try {
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
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
                addNewService(request, response);
                break;
            case "edit":
                showEditForm(request, response);
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

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceService.selectService(id);
        try {
            request.getRequestDispatcher("/view/service/edit.jsp").forward(request,response);
            request.setAttribute("service",service);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewService(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
        Map<Integer, String> rentTypeMap = serviceService.selectAllRentType();
        Map<Integer, String> facilityTypeMap = serviceService.selectAllFacilityType();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("rentTypeMap", rentTypeMap);
        request.setAttribute("facilityTypeMap", facilityTypeMap);
        request.getRequestDispatcher("/view/service/list.jsp").forward(request, response);
    }
}
