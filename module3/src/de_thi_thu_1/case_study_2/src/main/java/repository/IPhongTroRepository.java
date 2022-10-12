package repository;

import model.PhongTro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPhongTroRepository {
    List<PhongTro> selectAllPhongTro();
    PhongTro selectPhongTro(int idKey);
    boolean deletePhongTro(String id) throws SQLException;
    Map<Integer,String> selectAllHinhThucThanhToan();
    void insertPhongTro(PhongTro phongTro) throws SQLException;
    boolean updatePhongTro(PhongTro phongTro) throws SQLException;
    List<PhongTro> search(String id, String name, String phoneNumber);
    List<PhongTro> searchNameAndPhoneNumber(String searchName,String searchPhoneNumber);
}
