package repository;

import model.Employee;
import model.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IServiceRepository {
    List<Service> selectAllService();
    Service selectService(int idKey);
    List<Service> selectService(String keyName);
    boolean deleteService(int id) throws SQLException;
    Map<Integer,String> selectAllRentType();
    Map<Integer,String> selectAllFacilityType();
    void insertService(Service service) throws SQLException;
    boolean updateService(Service service) throws SQLException;

}
