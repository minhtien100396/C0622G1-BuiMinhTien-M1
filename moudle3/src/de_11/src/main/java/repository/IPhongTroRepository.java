package repository;

import model.PhongTro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPhongTroRepository {
    List<PhongTro> selectAllPhongTro();
    Map<Integer,String> selectAllHinhThucThanhToan();
    boolean deletePhongTro(int maPhongTro) throws SQLException;
    List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai, int searchMaThanhToan);
    List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai);
    boolean insertPhongTro(PhongTro phongTro) throws SQLException;
}
