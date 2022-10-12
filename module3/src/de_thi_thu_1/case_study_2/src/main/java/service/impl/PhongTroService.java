package service.impl;

import model.PhongTro;
import repository.IPhongTroRepository;
import repository.impl.PhongTroRepository;
import service.IPhongTroService;
import validation.Validation;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhongTroService implements IPhongTroService {
    private IPhongTroRepository phongTroRepository = new PhongTroRepository();

    @Override
    public List<PhongTro> selectAllPhongTro() {
        return phongTroRepository.selectAllPhongTro();
    }

    @Override
    public Map<Integer, String> selectAllHinhThucThanhToan() {
        return phongTroRepository.selectAllHinhThucThanhToan();
    }

    @Override
    public boolean deletePhongTro(String id) throws SQLException {
        return phongTroRepository.deletePhongTro(id);
    }

    @Override
    public List<PhongTro> search(String id, String name, String phoneNumber) {
        return phongTroRepository.search(id, name, phoneNumber);
    }

    @Override
    public List<PhongTro> searchNameAndPhoneNumber(String searchName, String searchPhoneNumber) {
        return phongTroRepository.searchNameAndPhoneNumber(searchName, searchPhoneNumber);
    }

    @Override
    public Map<String, String> insertPhongTro(PhongTro phongTro) throws SQLException {
        Map<String, String> errorMap = new HashMap<>();
        if (phongTro.getName().equals("")) {
            errorMap.put("name", "Tên Người Thuê Trọ không được để trống!");
        } else if (!Validation.checkName(phongTro.getName())) {
            errorMap.put("name", "Tên Người Thuê Trọ không đúng định dạng");
        }
        if (phongTro.getNote().equals("")) {
            errorMap.put("note", "Ghi Chú không được để trống!");
        }
        if (phongTro.getPhoneNumber().equals("")) {
            errorMap.put("phoneNumber", "Số Điện Thoại không được để trống!");
        } else if (!Validation.checkPhone(phongTro.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Số Điện Thoại không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (phongTro.getIdThanhToan() == 100) {
            errorMap.put("idThanhToan", "Hình Thức Thanh Toán không được để trống!");
        }

        if (phongTro.getDateBegin().equals("")) {
            errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không được để trống!");
        } else {
            if (LocalDate.parse(phongTro.getDateBegin()).isAfter(LocalDate.now())) {
                errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không hợp lệ (Phải Nhỏ Hơn Ngày Hiện Tại)");
            }
        }
        if (errorMap.size() == 0) {
            phongTroRepository.insertPhongTro(phongTro);
        }
        return errorMap;
    }

    @Override
    public Map<String, String> updatePhongTro(PhongTro phongTro) throws SQLException {
        Map<String, String> errorMap = new HashMap<>();
        if (phongTro.getName().equals("")) {
            errorMap.put("name", "Tên Người Thuê Trọ không được để trống!");
        } else if (!Validation.checkName(phongTro.getName())) {
            errorMap.put("name", "Tên Người Thuê Trọ không đúng định dạng");
        }
        if (phongTro.getNote().equals("")) {
            errorMap.put("note", "Ghi Chú không được để trống!");
        }
        if (phongTro.getPhoneNumber().equals("")) {
            errorMap.put("phoneNumber", "Số Điện Thoại không được để trống!");
        } else if (!Validation.checkPhone(phongTro.getPhoneNumber())) {
            errorMap.put("phoneNumber", "Số Điện Thoại không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (phongTro.getIdThanhToan() == 100) {
            errorMap.put("idThanhToan", "Hình Thức Thanh Toán không được để trống!");
        }

        if (phongTro.getDateBegin().equals("")) {
            errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không được để trống!");
        } else {
            if (LocalDate.parse(phongTro.getDateBegin()).isAfter(LocalDate.now())) {
                errorMap.put("dateBegin", "Ngày Bắt Đầu Thuê Trọ không hợp lệ (Phải Nhỏ Hơn Ngày Hiện Tại)");
            }
        }
        if (errorMap.size() == 0) {
            phongTroRepository.updatePhongTro(phongTro);
        }
        return errorMap;
    }

    @Override
    public PhongTro selectPhongTro(int idKey) {
        return phongTroRepository.selectPhongTro(idKey);
    }
}
