package servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Bùi Minh Tiến","1996-03-10",0,2.0));
        studentList.add(new Student(2,"Nguyễn Thị Nguyệt","1999-08-121",1,8.0));
        studentList.add(new Student(3,"Bùi Minh Tuấn","1997-12-27",0,10.0));
        studentList.add(new Student(4,"Nguyễn Văn Huy","2000-02-11",0,7.0));
        studentList.add(new Student(5,"Phan Minh Châu","1999-02-15",1,9.0));
        request.setAttribute("studenListServlet",studentList);
        request.getRequestDispatcher("index.jsp").forward(request,response);



        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

}
