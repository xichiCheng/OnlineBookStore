package dao;

import pojo.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderItemInterface {
    public int saveOrderItem(OrderItem orderItem) throws SQLException;
    public List<OrderItem> queryItemsByOrderId(String orderId) throws SQLException;
}
