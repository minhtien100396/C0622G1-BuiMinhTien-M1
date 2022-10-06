package service.impl;

import model.Employee;
import model.Position;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectEmployee(String keyName) {
        return employeeRepository.selectEmployee(keyName);
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public Map<Integer,String> selectAllPosition() {
        return employeeRepository.selectAllPosition();
    }

    @Override
    public Map<Integer, String> selectAllEducationDegree() {
        return employeeRepository.selectAllEducationDegree();
    }

    @Override
    public Map<Integer, String> selectAllDivision() {
        return employeeRepository.selectAllDivision();
    }
}
