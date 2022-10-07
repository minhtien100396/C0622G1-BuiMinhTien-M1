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
    public Contract selectContract(int idKey) {
        return contractRepository.selectContract(idKey);
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return contractRepository.deleteContract(id);
    }

    @Override
    public void insertContract(Contract contract) throws SQLException {
        contractRepository.insertContract(contract);
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return contractRepository.updateContract(contract);
    }

//    @Override
//    public List<Contract> selectContract(String keyName) {
//        return contractRepository.selectContract(keyName);
//    }
}
