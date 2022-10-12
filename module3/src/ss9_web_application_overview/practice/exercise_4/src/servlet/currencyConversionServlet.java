package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "currencyConversionServlet", urlPatterns = "/currency")
public class currencyConversionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double rate = Double.parseDouble(request.getParameter("rate"));
        double usd = Double.parseDouble(request.getParameter("usd"));
        double vnd = Math.floor((rate * usd) * 1000.0) / 1000.0;
        if (usd < 0) {
            request.setAttribute("vnd", "USD không thể là số âm");
            request.getRequestDispatcher("currency_conversion.jsp").forward(request, response);
        } else {
            request.setAttribute("vnd", usd + " USD = " + vnd + " VND");
            request.getRequestDispatcher("currency_conversion.jsp").forward(request, response);
        }
    }
}
