package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
// Tạo đường dẫn ở servlet để JSP có thể dẫn tới
@WebServlet(name = "SumServlet", urlPatterns = "/sum_servlet")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String flag =request.getParameter("flag");
        // Từ servlet muốn lấy dữ liệu từ JSP dùng request.getParameter
        double a = Double.parseDouble(request.getParameter("numberOne"));
        double b = Double.parseDouble(request.getParameter("numberTwo"));
        double result = a + b;

        //C1: không dùng vì nếu dùng bootstrap thì code dài -> khó bảo trì
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<html>");
//        printWriter.write("<body>");
//        printWriter.write("<h2 style='color:red'>" + result + "</h2>");
//        printWriter.write("</body>");
//        printWriter.write("</html>");

//        C3: Gửi dữ liệu lại từ Servlet sang JSP
            request.setAttribute("resultFromServlet",result);
//        Đẩy request sang JSP và hiển thị dữ liệu cho người dùng
//        dùng forward
        request.getRequestDispatcher("result_finall.jsp").forward(request,response);
//        dùng response.sendRedirect
//        response.sendRedirect("result_finall.jsp");
    }
}
