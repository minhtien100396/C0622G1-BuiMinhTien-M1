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
//Dùng urlPatterns ="": là chuỗi rỗng thì Servlet sẽ được load lên đầu tiên và nó sẽ vào doGet()
@WebServlet(name = "StudentServlet", urlPatterns = "")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Bùi Minh Tiến","1996-03-10",1,4.0));
        studentList.add(new Student(2,"Nguyễn Thị Nguyệt","1991-02-12",0,9.0));
        studentList.add(new Student(3,"Lê Thị Huy","2000-06-11",0,6.0));
        studentList.add(new Student(4,"Nguyễn Thị Tùng","1998-02-01",1,7.0));
        request.setAttribute("studentListServlet",studentList);
        request.getRequestDispatcher("index.jsp").forward(request,response);



        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
