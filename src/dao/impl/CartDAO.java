package dao.impl;

import dao.ICartDAO;
import utils.Constant;
import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDAO implements ICartDAO {
    DBConnection connection = DBConnection.getInstance();
    @Override
    public void addToCart(int user_id,int product_id, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_TO_CART);
        statement.setInt(1,product_id);
        statement.setInt(2,user_id);
        statement.setInt(3,quantity);
        statement.executeUpdate();
    }

    @Override
    public void deleteFromCart(int user_id, int product_id, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_TO_CART);
        statement.setInt(1,product_id);
        statement.setInt(2,user_id);
        statement.setInt(3,quantity);
        statement.executeUpdate();
    }

    @Override
    public void updateQuantity(int user_id, int product_id, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_TO_CART);
        statement.setInt(1,product_id);
        statement.setInt(2,user_id);
        statement.setInt(3,quantity);
        statement.executeUpdate();
    }
}
