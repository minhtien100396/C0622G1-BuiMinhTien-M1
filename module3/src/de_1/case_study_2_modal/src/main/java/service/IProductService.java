package service;

import model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> selectAllProduct();
    List<Product> search(String searchName, String searchPrice);
    List<Product> search(String searchName);
    boolean deleteProduct(int id) throws SQLException;
    Map<String,String> insertProduct(Product product) throws SQLException;
    Map<Integer,String> selectAllCategory();
}
