package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String admin = "admin";
        String checkTrue = "Welcome " + username + " to Website";
        String checkFalse = "Login Error";
        if (admin.equals(username) && admin.equals(password)) {
            request.setAttribute("check", checkTrue);
            request.getRequestDispatcher("result_login.jsp").forward(request, response);
        } else {
            request.setAttribute("check", checkFalse);
            request.getRequestDispatcher("result_login.jsp").forward(request, response);
        }
    }


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }
    }
