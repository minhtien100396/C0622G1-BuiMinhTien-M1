package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductController")
public class ProductController extends HttpServlet {
    IProductService iProductService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionProduct = request.getParameter("actionProduct");
        switch (actionProduct) {
            case "delete":
                delete(request, response);
                break;
            case "deleteAll":
                deleteAll(request, response);
                break;
            case "search":
                search(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            default:
                add(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", iProductService.getAll());
        request.getRequestDispatcher("/view/customer/index.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacture = request.getParameter("manufacture");
        Product product = new Product(id, name, price, description, manufacture);
        iProductService.add(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");
        String manufacture = request.getParameter("manufacture");
        Product product = new Product(id, name, price, description, manufacture);
        iProductService.edit(product);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String search = request.getParameter("search");
        request.setAttribute("products", iProductService.search(search));
        try {
            request.getRequestDispatcher("/view/customer/index.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void deleteAll(HttpServletRequest request, HttpServletResponse response) {
        iProductService.deleteAll();
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
