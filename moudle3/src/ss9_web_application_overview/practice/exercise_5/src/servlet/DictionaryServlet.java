package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "DictionaryServlet", urlPatterns = "/distionary")
public class DictionaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> distionary = new HashMap<>();
        distionary.put("book","sách");
        distionary.put("pen","cây bút");
        distionary.put("pencil","cây bút chì");
        distionary.put("bag","cái cặp");
        distionary.put("telephone","điện thoại");
        String search = request.getParameter("word");
        String result = distionary.get(search);

        if (result == null){
            request.setAttribute("translate","Từ bạn cần tìm kiếm không có trong từ điển");
            request.getRequestDispatcher("dictionary.jsp").forward(request,response);
        }
        else {
            request.setAttribute("translate",search+" : "+result);
            request.getRequestDispatcher("dictionary.jsp").forward(request,response);
        }
    }
}
