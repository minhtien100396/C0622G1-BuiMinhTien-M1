package case_study.task_1.services;

import java.io.IOException;

public interface ICustomerService extends IService {
    void addCustomer() throws IOException;

    void displayListCustomer() throws IOException;

    void editCustomer() throws IOException;
}
