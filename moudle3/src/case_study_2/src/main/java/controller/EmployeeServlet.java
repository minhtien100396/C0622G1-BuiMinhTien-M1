package controller;

import model.Employee;
import model.Position;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet",urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IEmployeeService employeeService = new EmployeeService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                addNewEmployee(request,response);
                break;
            case "edit":
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployeeByName(request,response);
                break;
            default:
                listEmployee(request,response);
                break;
        }
    }

    private void addNewEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/employee/create.jsp").forward(request,response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            employeeService.deleteEmployee(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/employee");
    }

    private void searchEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchByName = request.getParameter("search");
        List<Employee> employeeList;
        if (searchByName.equals("")) {
            response.sendRedirect("/employee");
            return;
        } else {
            employeeList = employeeService.selectEmployee(searchByName);
        }
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        Map<Integer,String> positionMap = employeeService.selectAllPosition();
        Map<Integer,String> educationDegreeMap = employeeService.selectAllEducationDegree();
        Map<Integer,String> divisionMap = employeeService.selectAllDivision();
        request.setAttribute("employeeList",employeeList);
        request.setAttribute("positionMap",positionMap);
        request.setAttribute("educationDegreeMap",educationDegreeMap);
        request.setAttribute("divisionMap",divisionMap);
        request.getRequestDispatcher("/view/employee/list.jsp").forward(request,response);
    }
}
