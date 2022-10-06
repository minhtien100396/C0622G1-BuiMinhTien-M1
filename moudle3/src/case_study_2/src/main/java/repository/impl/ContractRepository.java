package repository.impl;

import model.Contract;
import model.Customer;
import repository.BaseRepository;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private static final String SELECT_ALL_CONTRACT = "select * from contract;";
    private static final String SELECT_CONTRACT_BY_ID = "select * from contract where id = ?;";
    private static final String DELETE_CONTRACT_BY_ID = "delete from contract where id = ?;";

//    private static final String SELECT_CONTRACT_BY_NAME = "select * from contract where name like ?;";

    @Override
    public List<Contract> selectAllContract() {
        List<Contract> contractList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                double deposit = resultSet.getDouble("deposit");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int facilityId = resultSet.getInt("facility_id");
                contractList.add(new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contractList;
    }

    @Override
    public Contract selectContract(int id) {
        Contract contract = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("end_date");
                double deposit = resultSet.getDouble("deposit");
                int employeeId = resultSet.getInt("employee_id");
                int customerId = resultSet.getInt("customer_id");
                int facilityId = resultSet.getInt("facility_id");
                contract = new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return contract;
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

//    @Override
//    public List<Contract> selectContract(String keyName) {
//        List<Contract> contractList = new ArrayList<>();
//        try {
//            Connection connection = BaseRepository.getConnectDB();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTRACT_BY_NAME);
//            preparedStatement.setString(1, "%" + keyName + "%");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                Date startDate = resultSet.getDate("start_date");
//                Date endDate = resultSet.getDate("end_date");
//                double deposit = resultSet.getDouble("deposit");
//                int employeeId = resultSet.getInt("employee_id");
//                int customerId = resultSet.getInt("customer_id");
//                int facilityId = resultSet.getInt("facility_id");
//                contractList.add(new Contract(id, startDate, endDate, deposit, employeeId, customerId, facilityId));
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return contractList;
//    }
}

