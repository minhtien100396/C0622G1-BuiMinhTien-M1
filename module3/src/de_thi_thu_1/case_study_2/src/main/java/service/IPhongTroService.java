package service;

import model.PhongTro;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IPhongTroService {
    List<PhongTro> selectAllPhongTro();
    Map<Integer,String> selectAllHinhThucThanhToan();
    boolean deletePhongTro(String id) throws SQLException;
    List<PhongTro> search(String id, String name, String phoneNumber);
    List<PhongTro> searchNameAndPhoneNumber(String searchName,String searchPhoneNumber);
    Map<String,String> insertPhongTro(PhongTro phongTro) throws SQLException;
    Map<String,String> updatePhongTro(PhongTro phongTro) throws SQLException;
    PhongTro selectPhongTro(int idKey);

}
