package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;
import service.OrderServiceInterface;
import service.impl.OrderServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

public class OrderServiceInterfaceImplTest {
    @Test
    public void createOrder() throws SQLException {
        Cart cart=new Cart();
        cart.addItem(new CartItem(2,"三体",1,new BigDecimal(69),new BigDecimal(69)));
        cart.addItem(new CartItem(1,"挪威的森林",1,new BigDecimal(69),new BigDecimal(69)));
        OrderServiceInterface orderServiceInterface =new OrderServiceImpl();
        System.out.println(orderServiceInterface.creatOrder(cart,1));
    }

}