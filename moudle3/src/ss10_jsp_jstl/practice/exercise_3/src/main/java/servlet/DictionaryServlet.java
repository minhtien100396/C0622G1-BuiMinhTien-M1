package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/dictionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionaryList = new HashMap<>();
        dictionaryList.put("hello", "Xin chào");
        dictionaryList.put("how", "Thế nào");
        dictionaryList.put("book", "Quyển vở");
        dictionaryList.put("computer", "Máy tính");
        String search = request.getParameter("search");
        String result = dictionaryList.get(search);
        String error = "Từ Bạn Cần Tìm Kiếm Không Tồn Tại";
        if (result != null) {
            request.setAttribute("result", search + " : " + result);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("result", error);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
