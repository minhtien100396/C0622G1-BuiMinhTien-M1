package service;

import model.PhongTro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPhongTroService {
    List<PhongTro> selectAllPhongTro();
    Map<Integer,String> selectAllHinhThucThanhToan();
    boolean deletePhongTro(int id) throws SQLException;
    List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai, int searchMaThanhToan);
    List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai);
    Map<String,String> insertPhongTro(PhongTro phongTro) throws SQLException;
}
