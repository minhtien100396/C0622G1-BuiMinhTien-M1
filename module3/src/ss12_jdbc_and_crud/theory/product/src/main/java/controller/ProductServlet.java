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

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    IProductService iProductService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                double price = Double.parseDouble(request.getParameter("price"));
                String description = request.getParameter("description");
                String manufacture = request.getParameter("manufacture");
                Product product = new Product(id, name, price, description, manufacture);
                iProductService.save(product);
                request.setAttribute("message", "New product was created");
                request.getRequestDispatcher("view/product/create.jsp").forward(request,response);
                break;
            case "edit":
                int id1 = Integer.parseInt(request.getParameter("id"));
                String name1 = request.getParameter("name");
                double price1 = Double.parseDouble(request.getParameter("price"));
                String description1 = request.getParameter("description");
                String manufacturer1 = request.getParameter("manufacturer");
                Product product1 = iProductService.findById(id1);
                product1.setId(id1);
                product1.setName(name1);
                product1.setPrice(price1);
                product1.setDescription(description1);
                product1.setManufacturer(manufacturer1);
                iProductService.update(id1,product1);
                request.setAttribute("message", "Product information was updated");
                request.getRequestDispatcher("view/product/edit.jsp").forward(request,response);
                break;
            case "delete":
                int id2 = Integer.parseInt(request.getParameter("id"));
                iProductService.remove(id2);
                response.sendRedirect("/products");
                break;
            case "view":
                int id3 = Integer.parseInt(request.getParameter("id"));
                Product product3 = this.iProductService.findById(id3);
                request.setAttribute("product",product3);
                request.getRequestDispatcher("/view/product/view.jsp").forward(request,response);
                break;
            case "search":

                break;
            default:

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                request.getRequestDispatcher("/view/product/create.jsp").forward(request, response);
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", iProductService.findById(id));
                request.getRequestDispatcher("/view/product/edit.jsp").forward(request, response);
                break;
            case "delete":
                int id1 = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", iProductService.findById(id1));
                request.getRequestDispatcher("/view/product/delete.jsp").forward(request, response);
                break;
            case "view":
                int id2 = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("product", iProductService.findById(id2));
                request.getRequestDispatcher("/view/product/view.jsp").forward(request, response);
                break;
            case "search":

                break;
            default:
                request.setAttribute("products", iProductService.findAll());
                request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
        }
    }
}
