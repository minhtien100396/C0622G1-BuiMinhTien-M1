package case_study.task_1.services;

import java.io.IOException;

public interface IEmployeeService extends IService {
    void addEmployee() throws IOException;

    void displayListEmployee() throws IOException;

    void editEmployee() throws IOException;
}
