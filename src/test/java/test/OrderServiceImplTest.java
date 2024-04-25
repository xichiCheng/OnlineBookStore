package test;

import dao.impl.OrderDaoImpl;
import org.junit.Test;
import service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderServiceImplTest {
    @Test
    public void test1() throws SQLException {
        System.out.println(new OrderServiceImpl().showMyOrders(1));
    }
    @Test
    public void test2() throws SQLException {
        System.out.println(new OrderServiceImpl().showOrderDetail("17133494039311"));
    }
    @Test
    public void test3() throws SQLException {
        new OrderServiceImpl().receiverOrder("17133494039311",2);
    }
  @Test
    public void test4() throws SQLException {
        System.out.println(  new OrderServiceImpl().showAllOrders());
    }
    @Test
    public void test5() throws SQLException {
        new OrderServiceImpl().creatComment("Aurore","计算机网络","很好的书，后面忘了");
    }
}