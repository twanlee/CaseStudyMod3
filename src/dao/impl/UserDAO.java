package dao.impl;

import dao.IUserDAO;
import model.User;
import utils.Constant;
import utils.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private DBConnection connection;
    public UserDAO(DBConnection connection){
        this.connection = connection;
    }
    @Override
    public List<User> selectAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = this.connection.getConnection().prepareStatement(Constant.SELECT_ALL_USER);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(1));
            String username = resultSet.getString(2);
            String password = resultSet.getString(3);
            String permission = resultSet.getString(4);
            users.add(new User(id,username,password,permission));
        }
        return users;
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        PreparedStatement statement = this.connection.getConnection().prepareStatement(Constant.FIND_BY_USERNAME);
        statement.setString(1,username);
        ResultSet resultSet = statement.executeQuery();
        User user;
        while (resultSet.next()){
            int id = Integer.parseInt(resultSet.getString(1));
            String _username = resultSet.getString(2);
            String password = resultSet.getString(3);
            String permission = resultSet.getString(4);
            user = new User(id,_username,password,permission);
            return user;
        }
        return null;
    }

    @Override
    public User findById(int id) throws SQLException {
        PreparedStatement statement = this.connection.getConnection().prepareStatement(Constant.FIND_BY_ID);
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        User user;
        while (resultSet.next()){
            int _id = Integer.parseInt(resultSet.getString(1));
            String _username = resultSet.getString(2);
            String password = resultSet.getString(3);
            String permission = resultSet.getString(4);
            user = new User(_id,_username,password,permission);
            return user;
        }
        return null;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        PreparedStatement statement = this.connection.getConnection().prepareStatement(Constant.INSERT_USER);
        statement.setString(1,user.getUsername());
        statement.setString(2,user.getPassword());
        statement.setString(3,user.getPermission());
        int resultSet = statement.executeUpdate();
    }
}
