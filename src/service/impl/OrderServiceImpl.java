package service.impl;

import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import pojo.Cart;
import pojo.CartItem;
import pojo.Order;
import pojo.OrderItem;
import service.OrderServiceInterface;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderServiceInterface {
    private OrderDaoImpl orderDao=new OrderDaoImpl();
    private OrderItemDaoImpl orderItemDao=new OrderItemDaoImpl();
    private BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public String creatOrder(Cart cart, Integer userId) throws SQLException {
        String orderId=System.currentTimeMillis()+""+userId;
        Order order=new Order(orderId, LocalDateTime.now(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null, cartItem.getName() ,cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            bookDao.addBookSales(orderItem.getName(),orderItem.getCount());
            bookDao.minusBookStock(orderItem.getName(),orderItem.getCount());
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showMyOrders(int id) throws SQLException {
        return orderDao.queryOrdersByUserId(id);
    }

    @Override
    public List<OrderItem> showOrderDetail(String orderId) throws SQLException {
        return orderItemDao.queryItemsByOrderId(orderId);
    }

    public void receiverOrder(String orderId,Integer status) throws SQLException {
        orderDao.changeOrderStatus(orderId,status);
    }

    @Override
    public List<Order> showAllOrders() throws SQLException {
        return orderDao.queryOrders();
    }

    @Override
    public void creatComment(String userName, String bookName, String content) throws SQLException {
        LocalDateTime currentDateTime = LocalDateTime.now();
        orderDao.saveComment(userName,bookName,currentDateTime,content);
    }


}
