package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;
import validation.Validate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/users")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(request, response);
                    break;
                case "edit":
                    updateUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "search":
                    searchByCountry(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String country = request.getParameter("country");
        List<User> userList;
        if (country.equals("")) {
            response.sendRedirect("/users");
            return;
        } else {
            userList = userService.selectUser(country);
        }
        request.setAttribute("listUser", userList);
        try {
            request.getRequestDispatcher("/view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<User> listUser = userService.selectAllUsers();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User existingUser = userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/edit.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        // Khai báo các biến cần regex
        String emailError = null;
        String nameError = null;
        String countryError = null;
        //Biến flag check xem có thuộc tính nào sai định dạng với Regex hay không?
        boolean flag = false;


        String name = request.getParameter("name");

        //Kiểm tra thuộc tính có đúng định dạng không nếu không đúng định dạng đổi flag =true, chuyển xuống if dưới
        if (Validate.regexName(name)) {
            nameError = "Tên không đúng định dạng (chỉ chứa 5-50 kí tự)";
            flag = true;
        }


        String email = request.getParameter("email");
        if (Validate.regexEmail(email)) {
            emailError = "Email không đúng định dạng (XXXXX@XX.XX)";
            flag = true;
        }


        String country = request.getParameter("country");
        if (Validate.regexCountry(country)) {
            countryError = "Quốc gia không đúng định dạng (chỉ chứa 5-50 kí tự)";
            flag = true;
        }


        User newUser = new User(name, email, country);

        // Nếu có thuộc tính không đúng định dạng thì rơi vào đây
        if (flag) {
            request.setAttribute("messageEmailError", emailError);
            request.setAttribute("messageNameError", nameError);
            request.setAttribute("messageCountryError", countryError);
            request.setAttribute("user", newUser);
            request.getRequestDispatcher("/view/user/create.jsp").forward(request, response);
        } else {
            userService.insertUser(newUser);
            request.setAttribute("messageSuccess", "Bạn đã thêm mới thành công");
            request.getRequestDispatcher("/view/user/create.jsp").forward(request, response);
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        // Khai báo các biến cần regex
        String emailError = null;
        String nameError = null;
        String countryError = null;
        //Biến flag check xem có thuộc tính nào sai định dạng với Regex hay không?
        boolean flag = false;

        int id = Integer.parseInt(request.getParameter("id"));


        String name = request.getParameter("name");
        //Kiểm tra thuộc tính có đúng định dạng không nếu không đúng định dạng đổi flag =true, chuyển xuống if dưới
        if (Validate.regexName(name)) {
            nameError = "Tên không đúng định dạng (chỉ chứa 5-50 kí tự)";
            flag = true;
        }

        String email = request.getParameter("email");
        if (Validate.regexEmail(email)) {
            emailError = "Email không đúng định dạng (XXXXX@XX.XX)";
            flag = true;
        }


        String country = request.getParameter("country");
        if (Validate.regexCountry(country)) {
            countryError = "Quốc gia không đúng định dạng (chỉ chứa 5-50 kí tự)";
            flag = true;
        }

        User book = new User(id, name, email, country);

        // Nếu có thuộc tính không đúng định dạng thì rơi vào đây
        if (flag) {
            request.setAttribute("messageEmailError", emailError);
            request.setAttribute("messageNameError", nameError);
            request.setAttribute("messageCountryError", countryError);
            request.setAttribute("user", book);
            request.getRequestDispatcher("/view/user/edit.jsp").forward(request, response);
        } else {
            userService.updateUser(book);
            request.setAttribute("messageSuccess", "Bạn đã chỉnh sửa thành công");
            request.getRequestDispatcher("/view/user/edit.jsp").forward(request, response);
        }
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
//        List<User> listUser = userService.selectAllUsers();
//        request.setAttribute("listUser", listUser);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/user/list.jsp");
//        dispatcher.forward(request, response);
        response.sendRedirect("/users");
    }
}
