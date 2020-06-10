package dao.impl;

import dao.ICartDAO;
import utils.Constant;
import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO implements ICartDAO {
    DBConnection connection = DBConnection.getInstance();
    @Override
    public void addToCart(int productId, int customer_id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_TO_CART);
        statement.setInt(1,productId);
        statement.setInt(2,customer_id);
        statement.setInt(3,1);
        statement.executeUpdate();
    }

    @Override
    public void deleteFromCart(int productId) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.DELETE_PRODUCT_CART);
        statement.setInt(1,productId);
        statement.executeUpdate();
    }

    @Override
    public void updateQuantity(int cartId, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.UPDATE_QUANTITY_CART);
        statement.setInt(1,cartId);
        statement.setInt(2,quantity);
        statement.executeUpdate();
    }
}
