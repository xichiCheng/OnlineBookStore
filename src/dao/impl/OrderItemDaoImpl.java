package dao.impl;

import dao.DAO.OrderItemDAO;
import dao.OrderItemInterface;
import pojo.OrderItem;

import java.sql.SQLException;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemInterface {
    OrderItemDAO orderItemDAO=new OrderItemDAO();
    @Override
    public int saveOrderItem(OrderItem orderItem) throws SQLException {
        String sql="insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`) values(?,?,?,?,?)";
        return orderItemDAO.update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryItemsByOrderId(String orderId) throws SQLException {
        String sql="select `id` ,`name` ,`price`,`count`,`total_price` totalPrice,`order_id` orderId from t_order_item where order_id= ?";
        return orderItemDAO.queryMulti(sql,OrderItem.class,orderId);
    }
}
