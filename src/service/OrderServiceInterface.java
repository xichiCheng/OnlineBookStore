package service;

import com.sun.org.apache.xpath.internal.operations.Or;
import pojo.Cart;
import pojo.Order;
import pojo.OrderItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderServiceInterface {
    public String creatOrder(Cart cart,Integer userId) throws SQLException;
    public List<Order> showMyOrders(int id) throws SQLException;
    public List<OrderItem> showOrderDetail(String orderId) throws SQLException;
    public void receiverOrder(String orderId,Integer status) throws SQLException;

    public List<Order> showAllOrders() throws SQLException;

    void creatComment(String userName, String bookName, String content) throws SQLException;

}
