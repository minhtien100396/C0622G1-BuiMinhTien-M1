package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "CurrencyConverterServlet", urlPatterns = {"/converter", "/chuyen-doi"})
public class CurrencyConverterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double usd = Double.parseDouble(request.getParameter("usd"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        BigDecimal vnd = new BigDecimal(rate * usd);
        request.setAttribute("vnd",vnd);
        request.setAttribute("usd",usd);
        request.getRequestDispatcher("index.jsp").forward(request,response);
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
}
