package repository.impl;

import model.PhongTro;
import repository.BaseRepository;
import repository.IPhongTroRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PhongTroRepository implements IPhongTroRepository {
    private static final String SELECT_ALL_PHONG_TRO = "select * from thong_tin_phong_tro;";
    private static final String SELECT_PHONG_TRO_BY_ID = "select * from thong_tin_phong_tro where id = ?;";
    private static final String DELETE_PHONG_TRO = "delete from thong_tin_phong_tro where id = ?;";
    private static final String SELECT_EMPLOYEE_BY_NAME = "select * from employee where name like ?;";
    private static final String SELECT_HINH_THUC_THANH_TOAN = "select * from hinh_thuc_thanh_toan;";
    private static final String SELECT_EDUCATIONDEGREE = "select * from education_degree;";
    private static final String SELECT_DIVISION = "select * from division;";
    private static final String INSERT_PHONG_TRO = "INSERT INTO thong_tin_phong_tro (`name`, `phone_number`, `date_begin`, `note`, `id_thanh_toan`) \n" + "VALUES \n" + "( ?,?,?,?,?);";
    private static final String UPDATE_PHONG_TRO = "update  thong_tin_phong_tro set  `name` = ?, `phone_number` = ?, `date_begin` = ?, \n" + "`note` = ?, `id_thanh_toan` =?\n" + "where id =?;";
    private static final String SEARCH_PHONG_TRO = "select * from thong_tin_phong_tro\n" + "where id = ? and `name` like ? and phone_number like ?;";
    private static final String SEARCH_NAME_AND_PHONE_NUMBER = "select * from thong_tin_phong_tro\n" + "where name like ? and phone_number like ?;";

    @Override
    public List<PhongTro> selectAllPhongTro() {
        List<PhongTro> phongTroList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONG_TRO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String dateBegin = resultSet.getString("date_begin");
                String note = resultSet.getString("note");
                int idThanhToan = resultSet.getInt("id_thanh_toan");
                phongTroList.add(new PhongTro(id, name, phoneNumber, dateBegin, note, idThanhToan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public PhongTro selectPhongTro(int idKey) {
        PhongTro phongTro = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONG_TRO_BY_ID);
            preparedStatement.setInt(1, idKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String dateBegin = resultSet.getString("date_begin");
                String note = resultSet.getString("note");
                int idThanhToan = resultSet.getInt("id_thanh_toan");
                phongTro = new PhongTro(id, name, phoneNumber, dateBegin, note, idThanhToan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTro;
    }


    @Override
    public boolean deletePhongTro(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_PHONG_TRO)) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Map<Integer, String> selectAllHinhThucThanhToan() {
        Map<Integer, String> hinhThucThanhToanMap = new LinkedHashMap<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HINH_THUC_THANH_TOAN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                hinhThucThanhToanMap.put(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hinhThucThanhToanMap;
    }


    @Override
    public void insertPhongTro(PhongTro phongTro) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONG_TRO);
        preparedStatement.setString(1, phongTro.getName());
        preparedStatement.setString(2, phongTro.getPhoneNumber());
        preparedStatement.setString(3, phongTro.getDateBegin());
        preparedStatement.setString(4, phongTro.getNote());
        preparedStatement.setInt(5, phongTro.getIdThanhToan());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean updatePhongTro(PhongTro phongTro) throws SQLException {
        boolean rowUpdated = false;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_PHONG_TRO);
            preparedStatement.setString(1, phongTro.getName());
            preparedStatement.setString(2, phongTro.getPhoneNumber());
            preparedStatement.setString(3, phongTro.getDateBegin());
            preparedStatement.setString(4, phongTro.getNote());
            preparedStatement.setInt(5, phongTro.getIdThanhToan());
            preparedStatement.setString(6, phongTro.getId());
            preparedStatement.executeUpdate();
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<PhongTro> search(String searchId, String searchName, String searchPhoneNumber) {
        List<PhongTro> phongTroList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PHONG_TRO);
            preparedStatement.setString(1, searchId);
            preparedStatement.setString(2, "%" + searchName + "%");
            preparedStatement.setString(3, "%" + searchPhoneNumber + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String dateBegin = resultSet.getString("date_begin");
                String note = resultSet.getString("note");
                int idThanhToan = resultSet.getInt("id_thanh_toan");
                phongTroList.add(new PhongTro(id, name, phoneNumber, dateBegin, note, idThanhToan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }

    @Override
    public List<PhongTro> searchNameAndPhoneNumber(String searchName, String searchPhoneNumber) {
        List<PhongTro> phongTroList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_NAME_AND_PHONE_NUMBER);
            preparedStatement.setString(1, "%" + searchName + "%");
            preparedStatement.setString(2, "%" + searchPhoneNumber + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String phoneNumber = resultSet.getString("phone_number");
                String dateBegin = resultSet.getString("date_begin");
                String note = resultSet.getString("note");
                int idThanhToan = resultSet.getInt("id_thanh_toan");
                phongTroList.add(new PhongTro(id, name, phoneNumber, dateBegin, note, idThanhToan));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }
}