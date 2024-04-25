package web;

import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CartServlet extends BaseServlet{
    private BookServiceImpl bookService=new BookServiceImpl();
    protected void  addItem(HttpServletRequest req,HttpServletResponse resp) throws SQLException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBookById(id);

        CartItem cartItem=new CartItem(book.getId(), book.getName(), 1,book.getPrice(),book.getPrice());

        Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                req.getSession().setAttribute("cart", cart);
            }
            cart.addItem(cartItem);
        req.getSession().setAttribute("lastName",cartItem.getName());
        req.getSession().setAttribute("totalCount",cartItem.getCount());
        resp.sendRedirect(req.getHeader("Referer"));//返回请求回来的地址

    }
    protected void deleteItem(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart!=null){
            cart.clear();
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }


    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id= Integer.parseInt(req.getParameter("bookId"));
        int count= Integer.parseInt(req.getParameter("count"));
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(bookService.isBeyondStock(id,count)){
            resp.sendRedirect(req.getHeader("Referer"));
        }else {
            if (cart != null) {
                cart.update(id, count);
                resp.sendRedirect(req.getHeader("Referer"));
            }
        }
    }

    protected void checkStock(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookId = Integer.valueOf(req.getParameter("bookId"));
        int stock= Integer.parseInt(req.getParameter("stock"));
        resp.setContentType("text/plain;charset=UTF-8");
        String s=null;
        if(bookService.isBeyondStock(bookId,stock)){
            s="outOfStock";
        }else{
            s="available";
        }
        // 写入响应体
        try (PrintWriter out = resp.getWriter()) {
            out.print(s);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}















