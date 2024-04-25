package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(2,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        cart.addItem(new CartItem(1,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void update() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(2,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        cart.addItem(new CartItem(1,"java核心技术卷1",1,new BigDecimal(69),new BigDecimal(69)));
        cart.update(2,3);
        System.out.println(cart);
    }
}