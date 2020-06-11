package dao;

import model.Order;

import java.sql.SQLException;
import java.util.List;

public interface ICartDAO {
    void addToCart(int user_id, int product_id, int quantity) throws SQLException;
    void deleteFromCart(int user_id, int product_id) throws SQLException;
    void updateQuantity(int user_id, int product_id, int quantity) throws SQLException;
    int checkItem(int user_id, int product_id) throws SQLException;
    List<Order> showItemByUserId(int user_id) throws SQLException;
    List<Order> showAllOrder() throws SQLException;

}
