package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = "/user")
public class UserController extends HttpServlet {
    private IUserService iUserService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "add":
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String country = request.getParameter("country");
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setCountry(country);
                iUserService.add(user);
                request.setAttribute("mess","Thêm mới User thành công");
                request.getRequestDispatcher("view/user/add.jsp").forward(request,response);
                break;
            case "edit":
//
            case "delete":
                break;
            default:

        }
    }

    private void add() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");
        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "add":
                request.getRequestDispatcher("view/user/add.jsp").forward(request, response);
                break;
            case "edit":
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("user",iUserService.findById(id));
            request.getRequestDispatcher("view/user/edit.jsp").forward(request,response);
            case "delete":
                request.getRequestDispatcher("view/user/delete.jsp").forward(request, response);
                break;
            default:
                request.setAttribute("userList", iUserService.getAll());
                request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        }
    }
}
