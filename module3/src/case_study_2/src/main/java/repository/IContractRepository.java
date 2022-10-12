package repository;

import model.Contract;
import model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    List<Contract> selectAllContract();

    Contract selectContract(int idKey);

    //    List<Contract> selectContract(String keyName);
    boolean deleteContract(int id) throws SQLException;
    void insertContract(Contract contract) throws SQLException;
    boolean updateContract(Contract contract) throws SQLException;

}
