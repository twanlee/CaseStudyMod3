package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    List<User> selectAll() throws SQLException;
    User findByUsername( String username) throws SQLException;
    User findById( int id) throws SQLException;
    void insertUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    void deleteUser(int id) throws SQLException;
}
