package controller;

import bean.Product;
import service.IProductServicce;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController")
public class ProductController extends HttpServlet {
    private IProductServicce iProductServicce = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id;
        switch (action) {
            case "delete":
                 id = Integer.parseInt(request.getParameter("id"));
                iProductServicce.delete(id);
                break;
            case "search":
                String search = request.getParameter("search");
                request.setAttribute("products", iProductServicce.search(search));
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            default:
                 id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                Double price = Double.valueOf(request.getParameter("price"));
                String description = request.getParameter("description");
                String manufacture = request.getParameter("manufacture");
                Product product = new Product(id, name, price, description, manufacture);
                iProductServicce.save(product);
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", iProductServicce.getAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
