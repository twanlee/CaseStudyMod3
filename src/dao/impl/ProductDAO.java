package dao.impl;

import dao.IProductDAO;
import model.Product;
import utils.Constant;
import utils.DBConnection;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    DBConnection connection;
    public ProductDAO(DBConnection connection){
        this.connection = connection;
    }

    @Override
    public List<Product> selectAll() throws SQLException {
        PreparedStatement statement =  connection.getConnection().prepareStatement(Constant.SELECT_ALL_PRODUCT);
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            String productBrand = resultSet.getString(3);
            Double productPrice = resultSet.getDouble(4);
            int productQuantity = resultSet.getInt(5);
            String description = resultSet.getString(6);
            String imgUrl = resultSet.getString(7);
            products.add(new Product(id,productName,productBrand,productPrice,productQuantity,description,imgUrl));
        }
        return products;
    }

    @Override
    public Product findById(int id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.FIND_PRODUCT_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Product product=null;
        while (resultSet.next()){
            int _id = resultSet.getInt(1);
            String productName = resultSet.getString(2);
            String productBrand = resultSet.getString(3);
            Double productPrice = resultSet.getDouble(4);
            int productQuantity = resultSet.getInt(5);
            String description = resultSet.getString(6);
            String imgUrl = resultSet.getString(7);
            product = new Product(_id,productName,productBrand,productPrice,productQuantity,description,imgUrl);

        }
        return product;
    }

    @Override
    public List<Product> findByName(String productName) throws SQLException {
        PreparedStatement statement =  connection.getConnection().prepareStatement(Constant.FIND_PRODUCT_BY_NAME);
        statement.setString(1, "%"+productName+"%");
        ResultSet resultSet = statement.executeQuery();
        List<Product> products = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String _productName = resultSet.getString(2);
            String productBrand = resultSet.getString(3);
            Double productPrice = resultSet.getDouble(4);
            int productQuantity = resultSet.getInt(5);
            String description = resultSet.getString(6);
            String imgUrl = resultSet.getString(7);
            products.add(new Product(id,_productName,productBrand,productPrice,productQuantity,description,imgUrl));
        }
        return products;
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.INSERT_PRODUCT);
        statement.setString(1,product.getName());
        statement.setString(2,product.getBrand());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getQuantity());
        statement.setString(5,product.getDescription());
        statement.setString(6,product.getImgUrl());
        statement.executeUpdate();

    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.UPDATE_PRODUCT);
        statement.setString(1,product.getName());
        statement.setString(2,product.getBrand());
        statement.setDouble(3,product.getPrice());
        statement.setInt(4,product.getQuantity());
        statement.setString(5,product.getDescription());
        statement.setString(6,product.getImgUrl());
        statement.setInt(7,product.getId());
        statement.executeUpdate();
    }

    @Override
    public void deleteProduct(int id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.DELETE_PRODUCT);
        statement.setInt(1,id);
        statement.execute();
    }
}
