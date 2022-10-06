package service.impl;

import model.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractService implements IContractService {
    IContractRepository contractRepository = new ContractRepository();
    @Override
    public List<Contract> selectAllContract() {
        return contractRepository.selectAllContract();
    }

    @Override
    public Contract selectContract(int id) {
        return contractRepository.selectContract(id);
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return contractRepository.deleteContract(id);
    }

//    @Override
//    public List<Contract> selectContract(String keyName) {
//        return contractRepository.selectContract(keyName);
//    }
}
