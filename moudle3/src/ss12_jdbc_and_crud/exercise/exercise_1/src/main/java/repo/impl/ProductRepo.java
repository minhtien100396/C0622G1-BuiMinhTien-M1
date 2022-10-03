package repo.impl;

import model.Product;
import repo.BaseRepository;
import repo.IProductRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo implements IProductRepo {
    private static final String SELECT_ALL_PRODUCTS = "select * from product";
    private static final String ADD_PRODUCT = "insert into product (name, price, description, manufacture) values ( ?,?,?,?)";
    private static final String UPDATE_PRODUCT = "update product\n" + "set `name`= ?, price = ?, `description` = ?, manufacture = ?\n" + "where id = ?";
    private static final String DELETE_PRODUCT = "delete from product where id = ?";
    private static final String SELECT_BY_NAME = "select * from product where name like ?";
    private static final String DELETE_ALL = "delete from product";


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacture = resultSet.getString("manufacture");
                products.add(new Product(id, name, price, description, manufacture));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public void add(Product product) {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacture());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean edit(Product product) {
        boolean rowUpdated = true;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacture());
            preparedStatement.setInt(5, product.getId());
            preparedStatement.executeUpdate();
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDeleted = true;
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public List<Product> search(String data) {
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
            preparedStatement.setString(1, "%"+data+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String name = resultSet.getString("name");
                String manufacture = resultSet.getString("manufacture");
                productList.add(new Product(id, name, price, description, manufacture));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
//        return products.stream().filter(f -> f.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
