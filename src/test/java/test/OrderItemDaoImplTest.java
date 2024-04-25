package test;

import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import org.junit.Test;
import pojo.Order;
import pojo.OrderItem;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() throws SQLException {
        OrderDaoImpl orderDao=new OrderDaoImpl();
        OrderItemDaoImpl orderItemDao=new OrderItemDaoImpl();
        //orderDao.saveOrder(new Order("1321434215",new Date(),new BigDecimal(1000),0,1));
        orderItemDao.saveOrderItem(new OrderItem(null,"java从入门到精通",1,new BigDecimal(100),new BigDecimal(100),"1321434215"));

    }
}