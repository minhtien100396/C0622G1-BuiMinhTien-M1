package repository;

import model.Contract;

import java.sql.SQLException;
import java.util.List;

public interface IContractRepository {
    List<Contract> selectAllContract();

    Contract selectContract(int id);

    //    List<Contract> selectContract(String keyName);
    boolean deleteContract(int id) throws SQLException;

}
