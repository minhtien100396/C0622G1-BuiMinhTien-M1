package service;

import model.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceService {
    List<Service> selectAllService();
    Service selectService(int id);
    List<Service> selectService(String keyName);
    boolean deleteService(int id) throws SQLException;
    Map<Integer,String> selectAllRentType();
    Map<Integer,String> selectAllFacilityType();
}
