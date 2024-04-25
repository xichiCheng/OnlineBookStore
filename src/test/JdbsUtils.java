package test;

import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;
import service.impl.UserServiceImpl;
import utils.JDBCUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

public class JdbsUtils {
    UserServiceImpl userService=new UserServiceImpl();
    @Test
    public void Test1() throws SQLException {
        System.out.println(JDBCUtils.getConnection()+"连接成功");
    }
    @Test
    public void Test2() throws SQLException {
        UserDaoImpl userDaoImp=new UserDaoImpl();
        if(userDaoImp.queryUserByUsernameAndPassword("Aurore","a123456")==null){
            System.out.println("登录失败");
        }
        else
            System.out.println("登录成功");
    }
    @Test
    public void Test3() throws SQLException {
        UserDaoImpl userDaoImp=new UserDaoImpl();
        System.out.println(userDaoImp.queryUserByUsername("Aurore"));
    }
    @Test
    public void Test4() throws SQLException {
        UserDaoImpl userDaoImp=new UserDaoImpl();
        System.out.println(userDaoImp.saveUser(new User(null,"Alice","a111111","2345677@qq.com")));
    }

    @Test
    public void Test5() throws SQLException {
        userService.regisUser(new User(null,"Jack","a222222","123456@qq.com"));
    }
    @Test
    public void Test6() throws SQLException {
        System.out.println(userService.existsUsername("Alice"));
    }
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Localhost IP Address: " + localhost.getHostAddress());
            System.out.println("Localhost Hostname: " + localhost.getHostName());
        } catch (UnknownHostException e) {
            System.err.println("Error occurred while getting local host information: " + e.getMessage());
        }
    }

}
