package case_study.task_1.services;

import java.io.IOException;

public interface IContractService extends IService {
    void createNewConstracts() throws IOException;

    void displayListContracts() throws IOException;

    void editContracts() throws IOException;
}
