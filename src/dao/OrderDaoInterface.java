package dao;

import pojo.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderDaoInterface {
    public int saveOrder(Order order) throws SQLException;
    public List<Order> queryOrdersByUserId(int id) throws SQLException;
    public int changeOrderStatus(String orderId, Integer status) throws SQLException;
    public List<Order> queryOrders() throws SQLException;

    void saveComment(String userName, String bookName, LocalDateTime commentTime, String content) throws SQLException;
}
