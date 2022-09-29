package controller;

import bean.Product;
import service.IProductService;
import service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController")
public class ProductController extends HttpServlet {
    IProductService iProductService = new ProductServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        int id;
        String name;
        double price;
        String description;
        String manufacture;
        Product product;
        switch (actionProduct) {
            case "delete":
                id = Integer.parseInt(request.getParameter("id"));
                iProductService.delete(id);
                break;
            case "deleteAll":
                iProductService.deleteAll();
                break;
            case "search":
                name = request.getParameter("search");
                request.setAttribute("products",iProductService.search(name));
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
            case "edit":
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                description = request.getParameter("description");
                manufacture = request.getParameter("manufacture");
                product = new Product(id, name, price, description, manufacture);
                iProductService.edit(product);
                break;
            default:
                id = Integer.parseInt(request.getParameter("id"));
                name = request.getParameter("name");
                price = Double.parseDouble(request.getParameter("price"));
                description = request.getParameter("description");
                manufacture = request.getParameter("manufacture");
                product = new Product(id, name, price, description, manufacture);
                iProductService.add(product);
        }
        request.setAttribute("products", iProductService.getAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", iProductService.getAll());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
