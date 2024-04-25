package web;

import pojo.Book;
import pojo.Comment;
import pojo.Page;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ClientBookServlet extends BaseServlet {
    BookServiceImpl bookService=new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int pageNo=1,pageSize= Page.PAGE_SIZE;
        if(req.getParameter("pageNo")!=null){
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        if(req.getParameter("pageSize")!=null){
            pageSize= Integer.parseInt(req.getParameter("pageSize"));
        }
        Page<Book>  page=bookService.page(pageNo,pageSize);
        int min=0,max=1000;
        if(req.getParameter("min")!=null){
            min= Integer.parseInt(req.getParameter("min"));
        }
        if(req.getParameter("max")!=null){
            max= Integer.parseInt(req.getParameter("max"));
        }
        req.setAttribute("min",min);
        req.setAttribute("max",max);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/ClientBook_buy.jsp").forward(req,resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int pageNo=1,pageSize=4;
        String type=req.getParameter("type");
        req.setAttribute("type",type);
        if(req.getParameter("pageNo")!=null){
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        if(req.getParameter("pageSize")!=null){
            pageSize= Integer.parseInt(req.getParameter("pageSize"));
        }
        int min=0,max=1000;
        String minString=req.getParameter("min");
        if(minString!=null&& !minString.isEmpty()){
            min= Integer.parseInt(req.getParameter("min"));
        }
       String maxString=req.getParameter("max");
        if(maxString!=null&& !maxString.isEmpty()){
            max= Integer.parseInt(maxString);
        }
        Page<Book> page;
        if(Objects.equals(type, "")||type==null) {
             page = bookService.pageByPrice(pageNo, pageSize, min, max);
        }else{
            System.out.println();
             page= bookService.pageByType(pageNo,pageSize,min,max,type);
        }

        HttpSession session = req.getSession();
        String mainURL="ClientBookServlet?"+req.getQueryString();
        session.setAttribute("mainURL",mainURL);

        req.setAttribute("min",min);
        req.setAttribute("max",max);
        req.setAttribute("page",page);
        req.setAttribute("type",type);
        req.getRequestDispatcher("/pages/client/ClientBook_buy.jsp").forward(req,resp);
    }

    protected void profile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        Integer id= Integer.valueOf(req.getParameter("id"));
        Book book=bookService.queryBookById(id);

        String bookName=book.getName();
        String mainURL="ClientBookServlet?"+req.getQueryString();
        HttpSession session=req.getSession();
        String previousUrl = (String) session.getAttribute("mainURL");

        List<Comment> comments=bookService.getCommentByBookName(bookName);

        req.setAttribute("book",book);
        req.setAttribute("comment",comments);

        req.getRequestDispatcher("pages/client/book_profile.jsp").forward(req,resp);
    }

    protected void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        String name=req.getParameter("name");
        System.out.println(name);
        int pageNo=1,pageSize=4;
        //如果没有pageNo,pageSize,默认为1和4
        if(req.getParameter("pageNo")!=null){
            pageNo= Integer.parseInt(req.getParameter("pageNo"));
        }
        if(req.getParameter("pageSize")!=null){
            pageSize= Integer.parseInt(req.getParameter("pageSize"));
        }
        HttpSession session = req.getSession();
        String mainURL="ClientBookServlet?"+req.getQueryString();
        session.setAttribute("mainURL",mainURL);

        Page<Book>  page=bookService.pageByName(pageNo,pageSize,name);
        req.setAttribute("page",page);
        req.setAttribute("name",name);
        req.setAttribute("msg","未查询到相关书籍");
        req.getRequestDispatcher("/pages/client/ClientBook_buy.jsp").forward(req,resp);

    }
}
