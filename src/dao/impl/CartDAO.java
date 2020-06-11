package dao.impl;

import dao.ICartDAO;
import model.Order;
import utils.Constant;
import utils.DBConnection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO implements ICartDAO {
    DBConnection connection = DBConnection.getInstance();
    @Override
    public void addToCart(int user_id,int product_id, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.ADD_TO_CART);
        statement.setInt(1,user_id);
        statement.setInt(2,product_id);
        statement.setInt(3,quantity);
        statement.executeUpdate();
    }
    @Override
    public void deleteFromCart(int user_id, int product_id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.DELETE_PRODUCT_CART);
        statement.setInt(1,product_id);
        statement.setInt(2,user_id);
        statement.executeUpdate();
    }
    @Override
    public void updateQuantity(int user_id, int product_id, int quantity) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.UPDATE_QUANTITY_CART);
        statement.setInt(1,product_id);
        statement.setInt(2,user_id);
        statement.setInt(3,quantity);
        statement.executeUpdate();
    }
    @Override
    public int checkItem(int user_id, int product_id) throws SQLException {
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.CHECK_ITEM);
        statement.setInt(1,user_id);
        statement.setInt(2,product_id);
        ResultSet resultSet = statement.executeQuery();
        int quantity = 0;
        while (resultSet.next()){
             quantity = resultSet.getInt(4);
        }
        return quantity;
    }

    @Override
    public List<Order> showItemByUserId(int user_id) throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.SHOW_ITEM_BY_USER_ID);
        statement.setInt(1,user_id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int item_id = resultSet.getInt(1);
            String username= resultSet.getString(2);
            int productID = resultSet.getInt(3);
            String productName = resultSet.getString(4);
            int quantity = resultSet.getInt(5);
            Double price = resultSet.getDouble(6);
            Double amount = price*quantity;
            Date orderDate = resultSet.getDate(7);
            orders.add(new Order(item_id,username,productID,productName,quantity,price,amount,orderDate));
        }
        return orders;
    }

    @Override
    public List<Order> showAllOrder() throws SQLException {
        List<Order> orders = new ArrayList<>();
        PreparedStatement statement = connection.getConnection().prepareStatement(Constant.SHOW_ALL_ORDER);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int item_id = resultSet.getInt(1);
            String username= resultSet.getString(2);
            int productID = resultSet.getInt(3);
            String productName = resultSet.getString(4);
            int quantity = resultSet.getInt(5);
            Double price = resultSet.getDouble(6);
            Double amount = price*quantity;
            Date orderDate = resultSet.getDate(7);
            orders.add(new Order(item_id,username,productID,productName,quantity,price,amount,orderDate));
        }
        return orders;
    }
}
