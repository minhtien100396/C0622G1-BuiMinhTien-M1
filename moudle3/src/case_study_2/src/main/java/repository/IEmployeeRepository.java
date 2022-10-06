package repository;

import model.Employee;
import model.Position;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();
    Employee selectEmployee(int id);
    List<Employee> selectEmployee(String keyName);
    boolean deleteEmployee(int id) throws SQLException;
    Map<Integer,String> selectAllPosition();
    Map<Integer,String> selectAllEducationDegree();
    Map<Integer,String> selectAllDivision();
}
