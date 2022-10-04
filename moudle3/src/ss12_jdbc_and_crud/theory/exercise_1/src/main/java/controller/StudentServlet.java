package controller;

import model.Student;
import service.IStudentService;
import service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StudentServlet", urlPatterns = {"", "/student_servlet"})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                String name = request.getParameter("nameStudent");
                String dateOfBirth = request.getParameter("dateOfBirth");
                //Tạo ra một đối tượng student không có tham số truyền vào =>
                // các thuộc tính đều null => chỉ cần set lại Name và birthday => sẽ tạo
                // ra đối tượng mới chỉ có 2 thuộc tính trên còn lại null hết
                Student student = new Student();
                student.setName(name);
                student.setDateOfBirth(dateOfBirth);
                studentService.save(student);
                response.sendRedirect("/");
                break;
            default:
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String actionUser = request.getParameter("actionUser");

        if (actionUser == null) {
            actionUser = "";
        }
        switch (actionUser) {
            case "create":
                request.getRequestDispatcher("create_student.jsp").forward(request, response);
                break;
            case "update":

                break;
            case "delete":

                break;
            case "transaction":
                String msg = studentService.callTransaction();
                request.setAttribute("msg",msg);
                request.getRequestDispatcher("result_transaction.jsp").forward(request,response);
                break;
            case "search":
                String search = request.getParameter("search");
                request.setAttribute("studenListServlet",studentService.findByKeyWord(search));
                request.getRequestDispatcher("/index.jsp").forward(request,response);
                break;
            default:
                request.setAttribute("studenListServlet", studentService.findAll());
                request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

}
