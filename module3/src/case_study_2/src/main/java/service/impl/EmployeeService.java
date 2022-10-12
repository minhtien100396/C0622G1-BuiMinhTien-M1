package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int idKey) {
        return employeeRepository.selectEmployee(idKey);
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
    public Map<Integer, String> selectAllPosition() {
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

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> search(String name, double salary, int positionId) {
        return employeeRepository.search(name, salary, positionId);
    }

    @Override
    public List<Employee> selectEmployeeByNameSalary(String searchName, double searchSalary) {
        return employeeRepository.selectEmployeeByNameSalary(searchName, searchSalary);
    }
}
