package service;

import pojo.User;

import java.sql.SQLException;

public interface UserServiceInterface {
    public void regisUser(User user) throws SQLException;
    public User login(User user) throws SQLException;
    public boolean existsUsername(String name) throws SQLException;

}
