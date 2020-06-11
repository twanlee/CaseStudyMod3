package dao;

import java.sql.SQLException;

public interface ICartDAO {
    void addToCart(int user_id, int product_id, int quantity) throws SQLException;
    void deleteFromCart(int user_id, int product_id, int quantity) throws SQLException;
    void updateQuantity(int user_id, int product_id, int quantity) throws SQLException;
}
