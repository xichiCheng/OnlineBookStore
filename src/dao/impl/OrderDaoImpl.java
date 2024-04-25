package dao.impl;

import dao.DAO.OrderDAO;
import dao.OrderDaoInterface;
import pojo.Order;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDaoImpl implements OrderDaoInterface {
    OrderDAO orderDAO=new OrderDAO();
    @Override
    public int saveOrder(Order order) throws SQLException {
        String sql="insert into t_order(`order_id`,`creat_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";
        return orderDAO.update(sql,order.getOrderId(),order.getCreatTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryOrdersByUserId(int id) throws SQLException {
        String sql="select `order_id` orderId,`creat_time` creatTime,`price`,`status`,`user_id` userId from t_order where user_id= ?";
        return orderDAO.queryMulti(sql,Order.class,id);
    }

    @Override
    public int changeOrderStatus(String orderId, Integer status) throws SQLException {
        String sql="update t_order set status = ? where order_id=?";
        return orderDAO.update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrders() throws SQLException {
        String sql="select `order_id` orderId,`creat_time` creatTime,`price`,`status`,`user_id` userId from t_order";
        return orderDAO.queryMulti(sql,Order.class);
    }

    @Override
    public void saveComment(String userName, String bookName, LocalDateTime commentTime, String content) throws SQLException {
        String sql="insert into t_comment(`user_name`,`book_name`,`creat_time`,`content`) values(?,?,?,?)";
        orderDAO.update(sql,userName,bookName,commentTime,content);
    }


}
