package case_study.task_1.services;

import java.io.IOException;

public interface IEmployeeService extends IService {
    void addEmployee() throws IOException;

    void displayListEmployee() throws IOException;

    void editEmployee() throws IOException;

    void deleteEmployee() throws IOException;

    void sortName() throws IOException;

    void sortSalary() throws IOException;

    void searchIdEmployee() throws IOException;
}

