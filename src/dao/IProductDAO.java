package dao;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> selectAll() throws SQLException;
    Product findById(int id) throws SQLException;
    List<Product> findByName(String productName) throws SQLException;
    void addProduct(Product product) throws SQLException;
    void updateProduct(Product product) throws SQLException;
    void deleteProduct(int id) throws SQLException;
}
