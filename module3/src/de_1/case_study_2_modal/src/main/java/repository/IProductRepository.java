package repository;

import model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Product> selectAllProduct();
    List<Product> search(String searchName, String searchPrice);
    List<Product> search(String searchName);
    boolean deleteProduct(int id) throws SQLException;
    void insertProduct(Product product) throws SQLException;
    Map<Integer,String> selectAllCategory();
}
