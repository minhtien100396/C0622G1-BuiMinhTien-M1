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
    public boolean deletePhongTro(int maPhongTro) throws SQLException {
        return phongTroRepository.deletePhongTro(maPhongTro);
    }

    @Override
    public List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai, int searchMaThanhToan) {
        return phongTroRepository.search(searchTenNguoiThueTro, searchSoDienThoai, searchMaThanhToan);
    }

    @Override
    public List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai) {
        return phongTroRepository.search(searchTenNguoiThueTro, searchSoDienThoai);
    }

    @Override
    public Map<String, String> insertPhongTro(PhongTro phongTro) throws SQLException {
        Map<String, String> errorMap = new HashMap<>();
        if (phongTro.getTenNguoiThueTro().equals("")) {
            errorMap.put("tenNguoiThueTro", "Tên Người Thuê Trọ không được để trống!");
        } else if (!Validation.checkName(phongTro.getTenNguoiThueTro())) {
            errorMap.put("tenNguoiThueTro", "Tên Người Thuê Trọ  không đúng định dạng");
        }
        if (phongTro.getSoDienThoai().equals("")) {
            errorMap.put("soDienThoai", "Số Điện Thoại không được để trống!");
        } else if (!Validation.checkPhone(phongTro.getSoDienThoai())) {
            errorMap.put("soDienThoai", "Số Điện Thoại không đúng định dạng (XX)-(0XXXXXXXXX)");
        }
        if (phongTro.getNgayBatDauThueTro().equals("")) {
            errorMap.put("ngayBatDauThueTro", "Ngày Bất Đầu Thuê Trọ không được để trống!");
        } else {
            if (LocalDate.parse(phongTro.getNgayBatDauThueTro()).isAfter(LocalDate.now())) {
                errorMap.put("ngayBatDauThueTro", "Ngày Bất Đầu Thuê Trọ Phải nhỏ hơn ngày hiện tại");
            }
        }
        if (phongTro.getMaThanhToan() == 100) {
            errorMap.put("maThanhToan", "Hình Thức Thanh Toán không được để trống!");
        }
        if (phongTro.getGhiChu().equals("")) {
            errorMap.put("ghiChu", "Ghi Chú không được để trống!");
        }
        if (errorMap.size() == 0) {
            boolean check = phongTroRepository.insertPhongTro(phongTro);
        }
        return errorMap;
    }
}
