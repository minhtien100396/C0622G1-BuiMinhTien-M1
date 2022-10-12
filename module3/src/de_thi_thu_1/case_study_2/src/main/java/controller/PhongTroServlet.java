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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/phongtro")
public class PhongTroServlet extends HttpServlet {
    private IPhongTroService phongTroService = new PhongTroService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertNewPhongTro(request, response);
                break;
            case "edit":
                updatePhongTro(request, response);
                break;
        }
    }

    private void updatePhongTro(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String dateBegin = request.getParameter("dateBegin");
        String note = request.getParameter("note");
        int idThanhToan = Integer.parseInt(request.getParameter("idThanhToan"));
        PhongTro phongTro = new PhongTro(name, phoneNumber, dateBegin, note, idThanhToan);
        try {
            Map<String, String> map = phongTroService.updatePhongTro(phongTro);
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            if (map.size() != 0) {
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("mess", "Chỉnh Sửa Thất Bại");
                request.setAttribute("map", map);
                request.setAttribute("phongTro", phongTro);
            } else {
                request.setAttribute("phongTro", phongTro);
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("mess", "Chỉnh Sửa Thành Công");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            request.getRequestDispatcher("/view/phong_tro/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void insertNewPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phoneNumber");
        String dateBegin = request.getParameter("dateBegin");
        String note = request.getParameter("note");
        int idThanhToan = Integer.parseInt(request.getParameter("idThanhToan"));
        PhongTro phongTro = new PhongTro(name, phoneNumber, dateBegin, note, idThanhToan);
        try {
            Map<String, String> map = phongTroService.insertPhongTro(phongTro);
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            if (map.size() != 0) {
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("mess", "Thêm Mới Thất Bại");
                request.setAttribute("map", map);
                request.setAttribute("phongTro", phongTro);
            } else {
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("mess", "Thêm Mới Thành Công");
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
                addNewPhongTro(request, response);
                break;
            case "edit":
                showEditForm(request, response);
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

    private void searchPhongTro(HttpServletRequest request, HttpServletResponse response) {
        String searchId = request.getParameter("searchId");
        String searchName = request.getParameter("searchName");
        String searchPhoneNumber = request.getParameter("searchPhoneNumber");
        try {
            if (searchId.equals("") && searchName.equals("") && searchPhoneNumber.equals("")) {
                Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
                List<PhongTro> phongTroList = phongTroService.selectAllPhongTro();
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("phongTroList", phongTroList);
                request.getRequestDispatcher("view/phong_tro/list.jsp").forward(request, response);
            } else if (searchId.equals("")) {
                Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
                List<PhongTro> phongTroList = phongTroService.searchNameAndPhoneNumber(searchName, searchPhoneNumber);
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("phongTroList", phongTroList);
                request.getRequestDispatcher("view/phong_tro/list.jsp").forward(request, response);
            } else {
                Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
                List<PhongTro> phongTroList = phongTroService.search(searchId, searchName, searchPhoneNumber);
                request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
                request.setAttribute("phongTroList", phongTroList);
                request.getRequestDispatcher("view/phong_tro/list.jsp").forward(request, response);
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        PhongTro phongTro = phongTroService.selectPhongTro(id);
        try {
            request.setAttribute("phongTro", phongTro);
            Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
            request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
            request.getRequestDispatcher("/view/phong_tro/edit.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addNewPhongTro(HttpServletRequest request, HttpServletResponse response) {
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

    private void deletePhongTro(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        try {
            phongTroService.deletePhongTro(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/phongtro");
    }

    private void listPhongTro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> phongTroList = phongTroService.selectAllPhongTro();
        Map<Integer, String> hinhThucThanhToanMap = phongTroService.selectAllHinhThucThanhToan();
        request.setAttribute("phongTroList", phongTroList);
        request.setAttribute("hinhThucThanhToanMap", hinhThucThanhToanMap);
        request.getRequestDispatcher("/view/phong_tro/list.jsp").forward(request, response);
    }
}
