package repository.impl;

import model.Customer;
import model.Service;
import repository.BaseRepository;
import repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ServiceRepository implements IServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select * from facility;";
    private static final String SELECT_SERVICE_BY_ID = "select * from facility where id = ?;";
    private static final String SELECT_SERVICE_BY_NAME = "select * from facility where name like ?;";
    private static final String DELETE_SERVICE_BY_ID = "delete from facility where id = ?;";
    private static final String SELECT_RENT_TYPE = "select * from rent_type;";
    private static final String SELECT_FACILITY_TYPE = "select * from facility_type;";
    private static final String INSERT_SERVICE = "INSERT INTO facility (`name`, `area`, `cost`, `max_people`, `standard_room`, `description_other_convenience`, `pool_area`, `number_of_floors`, `facility_free`, `rent_type_id`, `facility_type_id`) \n" + "VALUES \n" + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_SERVICE = "update facility set `name`=?,  area = ?, cost = ?, max_people = ?, rent_type_id = ?,facility_type_id = ?,standard_room =?,\n" +
            "description_other_convenience = ?, pool_area= ?, number_of_floors = ?,facility_free = ? \n" +
            "where id = ? ;";

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                serviceList.add(new Service(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Service selectService(int idKey) {
        Service service = null;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, idKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                service = new Service(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> selectService(String keyName) {
        List<Service> serviceList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_NAME);
            preparedStatement.setString(1, "%" + keyName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int area = resultSet.getInt("area");
                double cost = resultSet.getDouble("cost");
                int maxPeople = resultSet.getInt("max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int facilityTypeId = resultSet.getInt("facility_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloors = resultSet.getInt("number_of_floors");
                String facilityFree = resultSet.getString("facility_free");
                serviceList.add(new Service(id, name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE_BY_ID);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public Map<Integer, String> selectAllRentType() {
        Map<Integer, String> rentTypeMap = new LinkedHashMap<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                rentTypeMap.put(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypeMap;
    }

    @Override
    public Map<Integer, String> selectAllFacilityType() {
        Map<Integer, String> facilityTypeMap = new LinkedHashMap<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACILITY_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                facilityTypeMap.put(id, name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return facilityTypeMap;
    }

    @Override
    public void insertService(Service service) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
        preparedStatement.setString(1, service.getName());
        preparedStatement.setInt(2, service.getArea());
        preparedStatement.setDouble(3, service.getCost());
        preparedStatement.setInt(4, service.getMaxPeople());
        preparedStatement.setInt(5, service.getRentTypeId());
        preparedStatement.setInt(6, service.getFacilityTypeId());
        preparedStatement.setString(7, service.getStandardRoom());
        preparedStatement.setString(8, service.getDescriptionOtherConvenience());
        preparedStatement.setDouble(9, service.getPoolArea());
        preparedStatement.setInt(10, service.getNumberOfFloors());
        preparedStatement.setString(11, service.getFacilityFree());
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean updateService(Service service) {
        boolean rowUpdated=false;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_SERVICE);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setInt(5, service.getRentTypeId());
            preparedStatement.setInt(6, service.getFacilityTypeId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloors());
            preparedStatement.setString(11, service.getFacilityFree());
            preparedStatement.setInt(12, service.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }
}



