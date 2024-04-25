package dao;

import pojo.User;

import java.sql.SQLException;

public interface UserDaoInterface {
    public User queryUserByUsername(String username) throws SQLException;
    public User queryUserByUsernameAndPassword(String username,String password) throws SQLException;
    public int saveUser(User user) throws SQLException;
}
