package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet", urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String describe = request.getParameter("describe");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double discountAmount = price * discount * 0.01;
        double discountPrice = price - discountAmount;
        if (discount < 0 || discount > 100) {
            request.setAttribute("result", "Tỷ lệ chiết khấu bạn nhập vào không hợp lệ (0-100%)");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else if (price < 0) {
            request.setAttribute("result", "Giá sản phẩm bạn nhập vào không hợp lệ (>=0)");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            request.setAttribute("describe", describe);
            request.setAttribute("price", price);
            request.setAttribute("discount", discount);
            request.setAttribute("discountAmount", discountAmount);
            request.setAttribute("discountPrice", discountPrice);
            request.getRequestDispatcher("product_discount.jsp").forward(request, response);
        }
    }
}
