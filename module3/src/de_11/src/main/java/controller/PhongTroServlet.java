package controller;

import model.PhongTro;
import service.IPhongTroService;
import service.impl.PhongTroService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PhongTroServlet", urlPatterns = "/phongtro")
public class PhongTroServlet extends HttpServlet {
    IPhongTroService phongTroService = new PhongTroService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertPhongTro(request, response);
                break;
            case "edit":
                break;
        }
    }

    private void insertPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String tenNguoiThueTro = request.getParameter("tenNguoiThueTro");
        String soDienThoai = request.getParameter("soDienThoai");
        String ngayBatDauThueTro = request.getParameter("ngayBatDauThueTro");
        int maThanhToan = Integer.parseInt(request.getParameter("maThanhToan"));
        String ghiChu = request.getParameter("ghiChu");
        PhongTro phongTro = new PhongTro(tenNguoiThueTro, soDienThoai, ngayBatDauThueTro, maThanhToan, ghiChu);
        try {
            Map<String, String> map = phongTroService.insertPhongTro(phongTro);
            if (map.size() != 0) {
                request.setAttribute("mess", "Add new failure");
                request.setAttribute("map", map);
                request.setAttribute("phongTro", phongTro);
                Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
            } else {
                Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("mess", "Successfully added new");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            request.getRequestDispatcher("/view/phong_tro/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                addPhongTro(request, response);
                break;
            case "edit":
                break;
            case "delete":
                deletePhongTro(request, response);
                break;
            case "search":
                searchPhongTro(request, response);
                break;

            default:
                listPhongTro(request, response);
                break;
        }
    }

    private void addPhongTro(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
            request.getRequestDispatcher("/view/phong_tro/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String searchTenNguoiThueTro = request.getParameter("searchTenNguoiThueTro");
        String searchSoDienThoai = request.getParameter("searchSoDienThoai");
        int searchHinhThucThanhToan = Integer.parseInt(request.getParameter("searchHinhThucThanhToan"));
        if (searchHinhThucThanhToan == 100) {
            List<PhongTro> phongTroList = phongTroService.search(searchTenNguoiThueTro, searchSoDienThoai);
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            request.setAttribute("phongTroList", phongTroList);
            request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
        } else {
            List<PhongTro> phongTroList = phongTroService.search(searchTenNguoiThueTro, searchSoDienThoai, searchHinhThucThanhToan);
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            request.setAttribute("phongTroList", phongTroList);
            request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
        }
        try {
            request.getRequestDispatcher("view/phong_tro/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) {
        int maPhongTro = Integer.parseInt(request.getParameter("maPhongTro"));
        try {
            phongTroService.deletePhongTro(maPhongTro);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            response.sendRedirect("/phongtro");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> phongTroList = phongTroService.selectAllPhongTro();
        Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
        request.setAttribute("phongTroList", phongTroList);
        request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
        try {
            request.getRequestDispatcher("/view/phong_tro/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

