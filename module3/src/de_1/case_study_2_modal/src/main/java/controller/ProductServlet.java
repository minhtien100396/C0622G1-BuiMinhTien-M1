package controller;

import model.PhongTro;
import model.Product;
import service.IProductService;
import service.impl.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewProduct(request, response);
                break;
            case "edit":
//                updatePhongTro(request, response);
                break;
        }
    }

    private void insertNewProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        Product product = new Product(name, price, quantity, color, category);
        try {
            Map<String, String> map = productService.insertProduct(product);
            List<Product> productList = productService.selectAllProduct();
            request.setAttribute("productList", productList);
            if (map.size() != 0) {
                request.setAttribute("show", "show");
                request.setAttribute("map", map);
                request.setAttribute("product", product);
                try {
                    request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
//            case "create":
////                addNewPhongTro(request, response);
////                insertNewPhongTro(request, response);
//                break;
            case "edit":
//                showEditForm(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            productService.deleteProduct(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchPrice = request.getParameter("searchPrice");
        try {
            if (searchName.equals("") && searchPrice.equals("")) {
                List<Product> productList = productService.selectAllProduct();
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
            } else if (searchPrice.equals("")) {
                List<Product> productList = productService.search(searchName);
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
            } else {
                List<Product> productList = productService.search(searchName, searchPrice);
                request.setAttribute("productList", productList);
                request.getRequestDispatcher("view/product/list.jsp").forward(request, response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAllProduct();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
