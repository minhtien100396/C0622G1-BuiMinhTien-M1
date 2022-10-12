package repository.impl;

import model.PhongTro;
import repository.IPhongTroRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PhongTroRepository implements IPhongTroRepository {
    private static final String SELECT_ALL_PHONG_TRO = "select * from phong_tro;";
    private static final String SELECT_HINH_THUC_THANH_TOAN = "select * from hinh_thuc_thanh_toan;";
    private static final String DELETE_PHONG_TRO = "delete from phong_tro where ma_phong_tro = ?;";
    private static final String SEARCH_PHONG_TRO = "select * from phong_tro\n" + "where `ten_nguoi_thue_tro` like ? and so_dien_thoai LIKE ? and ma_thanh_toan = ?;";
    private static final String SEARCH_PHONG_TRO_2 = "select * from phong_tro\n" + "where `ten_nguoi_thue_tro` like ? and so_dien_thoai LIKE ?;";
    private static final String INSERT_PHONG_TRO = "INSERT INTO phong_tro (`ten_nguoi_thue_tro`, `so_dien_thoai`,`ngay_bat_dau_thue_tro`,`ma_thanh_toan`, `ghi_chu`) \n" + "VALUES \n" + "(?,?,?,?,?);";


    @Override
    public List<PhongTro> selectAllPhongTro() {
        List<PhongTro> phongTroList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONG_TRO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maPhongTro = resultSet.getInt("ma_phong_tro");
                String tenNguoiThueTro = resultSet.getString("ten_nguoi_thue_tro");
                String soDienThoai = resultSet.getString("so_dien_thoai");
                String ngayBatDauThueTro = resultSet.getString("ngay_bat_dau_thue_tro");
                int maThanhToan = resultSet.getInt("ma_thanh_toan");
                String ghiChu = resultSet.getString("ghi_chu");
                phongTroList.add(new PhongTro(maPhongTro, tenNguoiThueTro, soDienThoai, ngayBatDauThueTro, maThanhToan, ghiChu));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public Map<Integer, String> selectAllHinhThucThanhToan() {
        Map<Integer, String> hinhThucThanhToanMap = new LinkedHashMap<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HINH_THUC_THANH_TOAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maThanhToan = resultSet.getInt("ma_thanh_toan");
                String ten_hinh_thuc_thanh_toan = resultSet.getString("ten_hinh_thuc_thanh_toan");
                hinhThucThanhToanMap.put(maThanhToan, ten_hinh_thuc_thanh_toan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hinhThucThanhToanMap;
    }

    @Override
    public boolean deletePhongTro(int maPhongTro) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_PHONG_TRO);) {
            statement.setInt(1, maPhongTro);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;    }

    @Override
    public List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai, int searchMaThanhToan) {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PHONG_TRO);
            preparedStatement.setString(1, "%" + searchTenNguoiThueTro + "%");
            preparedStatement.setString(2, "%" + searchSoDienThoai + "%");
            preparedStatement.setInt(3, searchMaThanhToan);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maPhongTro = resultSet.getInt("ma_phong_tro");
                String tenNguoiThueTro = resultSet.getString("ten_nguoi_thue_tro");
                String soDienThoai = resultSet.getString("so_dien_thoai");
                String ngayBatDauThueTro = resultSet.getString("ngay_bat_dau_thue_tro");
                int maThanhToan = resultSet.getInt("ma_thanh_toan");
                String ghiChu = resultSet.getString("ghi_chu");
                phongTroList.add(new PhongTro(maPhongTro, tenNguoiThueTro, soDienThoai, ngayBatDauThueTro, maThanhToan, ghiChu));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public List<PhongTro> search(String searchTenNguoiThueTro, String searchSoDienThoai) {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PHONG_TRO_2);
            preparedStatement.setString(1, "%" + searchTenNguoiThueTro + "%");
            preparedStatement.setString(2, "%" + searchSoDienThoai + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maPhongTro = resultSet.getInt("ma_phong_tro");
                String tenNguoiThueTro = resultSet.getString("ten_nguoi_thue_tro");
                String soDienThoai = resultSet.getString("so_dien_thoai");
                String ngayBatDauThueTro = resultSet.getString("ngay_bat_dau_thue_tro");
                int maThanhToan = resultSet.getInt("ma_thanh_toan");
                String ghiChu = resultSet.getString("ghi_chu");
                phongTroList.add(new PhongTro(maPhongTro, tenNguoiThueTro, soDienThoai, ngayBatDauThueTro, maThanhToan, ghiChu));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public boolean insertPhongTro(PhongTro phongTro) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(INSERT_PHONG_TRO);
            preparedStatement.setString(1, phongTro.getTenNguoiThueTro());
            preparedStatement.setString(2, phongTro.getSoDienThoai());
            preparedStatement.setString(3, phongTro.getNgayBatDauThueTro());
            preparedStatement.setInt(4, phongTro.getMaThanhToan());
            preparedStatement.setString(5, phongTro.getGhiChu());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}
