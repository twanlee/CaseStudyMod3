package dao;

import java.sql.SQLException;

public interface ICartDAO {
    void addToCart(int productId, int customer_id) throws SQLException;
    void deleteFromCart(int productId) throws SQLException;
    void updateQuantity(int cartId,int quantity) throws SQLException;
}
