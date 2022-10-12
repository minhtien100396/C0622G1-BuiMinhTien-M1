package servlet;

import bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

//Dùng urlPatterns ="": là chuỗi rỗng thì Servlet sẽ được load lên đầu tiên và nó sẽ vào doGet()
@WebServlet(name = "StudentServlet", urlPatterns = "")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<Integer,String> classMap = new TreeMap<>();
        Map<Integer, String> a = new HashMap<>();
        classMap.put(1,"C06");
        classMap.put(2,"C07");
        classMap.put(3,"C08");
        classMap.put(4, null);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Bùi Minh Tiến","1996-03-10",1,4.0,1));
        studentList.add(new Student(2,"Nguyễn Thị Nguyệt","1991-02-12",0,9.0,2));
        studentList.add(new Student(3,"Lê Thị Huy","2000-06-11",0,6.0,3));
        studentList.add(new Student(4,"Nguyễn Thị Tùng","1998-02-01",1,7.0,4));
        request.setAttribute("studentListServlet",studentList);
        request.setAttribute("classMap",classMap);
        request.getRequestDispatcher("index.jsp").forward(request,response);


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
