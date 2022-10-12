package controller;

import model.Contract;
import service.IContractService;
import service.impl.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewContract(request, response);
                break;
            case "edit":
                updateContract(request, response);
                break;
        }
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int facilityId = Integer.parseInt(request.getParameter("facilityId"));
        Contract contract = new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId);
        try {
            contractService.updateContract(contract);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully Edit");
        try {
            request.getRequestDispatcher("/view/contract/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewContract(HttpServletRequest request, HttpServletResponse response) {
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int facilityId = Integer.parseInt(request.getParameter("facilityId"));
        Contract contract = new Contract(startDate, endDate, deposit, employeeId, customerId, facilityId);
        try {
            contractService.insertContract(contract);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("mess", "Successfully added new");
        try {
            request.getRequestDispatcher("/view/contract/create.jsp").forward(request, response);
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
                addNewContract(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "search":
//                searchContractByName(request,response);
                break;
            default:
                listContract(request, response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.selectContract(id);
        try {
            request.setAttribute("contract", contract);
            request.getRequestDispatcher("/view/contract/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/contract/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            contractService.deleteContract(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/contract");
    }

//    private void searchContractByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String searchByName = request.getParameter("search");
//        List<Contract> contractList;
//        if (searchByName.equals("")) {
//            response.sendRedirect("/contract");
//            return;
//        } else {
//            contractList = contractService.selectContract(searchByName);
//        }
//        request.setAttribute("contractList", contractList);
//        try {
//            request.getRequestDispatcher("/view/customer/list.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contractList = contractService.selectAllContract();
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("/view/contract/list.jsp").forward(request, response);
    }
}
