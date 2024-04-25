package dao.impl;

import dao.DAO.UserDAO;
import dao.UserDaoInterface;
import pojo.User;

import java.sql.SQLException;

public class UserDaoImpl implements UserDaoInterface {
    UserDAO userDAO=new UserDAO();
    @Override
    public User queryUserByUsername(String username) throws SQLException {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
        return userDAO.querySingle(sql,User.class,username);
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ? and password = ?";
        return userDAO.querySingle(sql,User.class,username,password);
    }

    @Override
    public int saveUser(User user) throws SQLException {
        String sql ="insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return userDAO.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
