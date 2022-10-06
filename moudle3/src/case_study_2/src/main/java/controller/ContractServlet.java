package controller;

import model.Contract;
import model.Customer;
import service.IContractService;
import service.impl.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ContractServlet" ,urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IContractService contractService = new ContractService();
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
                deleteContract(request, response);
                break;
            case "search":
//                searchContractByName(request,response);
                break;
            default:
                listContract(request,response);
                break;
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
        request.setAttribute("contractList",contractList);
        request.getRequestDispatcher("/view/contract/list.jsp").forward(request,response);
    }
}
