package web;

import com.sun.org.apache.xpath.internal.operations.Or;
import pojo.Cart;
import pojo.CartItem;
import pojo.Order;
import pojo.OrderItem;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SplittableRandom;

public class OrderServlet extends BaseServlet{
    OrderServiceImpl orderService=new OrderServiceImpl();
    protected void creatOrder( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Cart cart=(Cart) req.getSession().getAttribute("cart");
        Integer id = (Integer) req.getSession().getAttribute("userid");
        String orderId=orderService.creatOrder(cart,id);
        for(Map.Entry<Integer, CartItem>entry:cart.getItems().entrySet()){
            CartItem cartItem=entry.getValue();
            System.out.println(cartItem.getId()+"?");
        }

        req.setAttribute("orderId",orderId);
        req.getRequestDispatcher("/pages/order/order_submit_success.jsp").forward(req,resp);

    }

    protected void showOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id= Integer.parseInt(req.getParameter("id"));
        List<Order> orderList=orderService.showMyOrders(id);
        req.setAttribute("orders",orderList);
        req.getRequestDispatcher("/pages/user/user_infor.jsp").forward(req,resp);
    }


    protected void showOrderDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String orderId=req.getParameter("orderId");
        List<OrderItem> orderItemList=orderService.showOrderDetail(orderId);

        req.setAttribute("orderId",orderId);
        String status=req.getParameter("status");
        req.setAttribute("status",status);

        req.setAttribute("orderItems",orderItemList);
        HttpSession session=req.getSession();
        Object username=session.getAttribute("username");
        if(username.equals("root")) {
            req.getRequestDispatcher("pages/order/background_order.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("pages/order/order.jsp").forward(req, resp);
        }

    }

    protected void receiverOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String orderId=req.getParameter("orderId");
        Integer status= Integer.valueOf(req.getParameter("status"));
        Integer userid= Integer.valueOf(req.getParameter("userid"));
        orderService.receiverOrder(orderId,status);
        resp.sendRedirect(req.getContextPath()+"/OrderServlet?action=showOrders&id="+userid);
    }
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String orderId=req.getParameter("orderId");
        Integer status= Integer.valueOf(req.getParameter("status"));
        orderService.receiverOrder(orderId,status);
        resp.sendRedirect(req.getContextPath()+"/OrderServlet?action=showAllOrders&id=");
    }
    protected void showAllOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Order> orderList=orderService.showAllOrders();
        req.setAttribute("orders",orderList);
        req.getRequestDispatcher("pages/order/order_manager.jsp").forward(req,resp);
    }


    protected void bookComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String userName=req.getParameter("userName");
        String bookName=req.getParameter("bookName");
        String content=req.getParameter("commentContent");
        String userId=req.getParameter("userId");
        if(!content.isEmpty()){
            orderService.creatComment(userName,bookName,content);
        }
        resp.sendRedirect(req.getContextPath()+"/OrderServlet?action=showOrders&id="+userId);
    }
}
