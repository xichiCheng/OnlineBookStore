package service.impl;

import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserServiceInterface;

import java.sql.SQLException;

public class UserServiceImpl implements UserServiceInterface {
    UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public void regisUser(User user){
        try {
            userDao.saveUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(User user) {
        try {
            return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsUsername(String name) {
        try {
            if(userDao.queryUserByUsername(name)==null){
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
