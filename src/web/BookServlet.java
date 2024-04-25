package web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Book;
import pojo.Page;
import service.impl.BookServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;


public class BookServlet extends BaseServlet{
        BookServiceImpl bookService=new BookServiceImpl();

        //请求当前页面和数量
        protected void page(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
              int pageNo=1,pageSize= Page.PAGE_SIZE;
                if(req.getParameter("pageNo")!=null){
                      pageNo= Integer.parseInt(req.getParameter("pageNo"));
                }
                if(req.getParameter("pageSize")!=null){
                        pageSize= Integer.parseInt(req.getParameter("pageSize"));
                }

                Page<Book>  page=bookService.page(pageNo,pageSize);
                //将page放进req中
                req.setAttribute("page",page);
                req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
        }

        protected void add(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
                Book book=new Book();
                //请求
            book= (Book) WebUtils.copyParamToBean(req, book);
            book.setSales(0);
            bookService.addBook(book);
            resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
        }
        protected void delete(HttpServletRequest req,HttpServletResponse resp) throws SQLException, IOException {
                String id = req.getParameter("id");
                bookService.deleteBookById(Integer.parseInt(id));
                resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");

        }
        protected void update(HttpServletRequest req,HttpServletResponse resp) throws SQLException, IOException {
                Book book=new Book();
                 book=(Book)WebUtils.copyParamToBean(req,book);
                 String sales=req.getParameter("sales");
                 String imgPath=req.getParameter("imgPath");
                 book.setSales(Integer.valueOf(sales));
                 if(Objects.equals(book.getImgPath(), "")){
                     book.setImgPath(imgPath);
                 }
                 bookService.updateBook(book);
                 resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
        }
        protected  void list(HttpServletRequest req,HttpServletResponse resp) throws SQLException, ServletException, IOException {
                List<Book> books=bookService.queryBooks();
                req.setAttribute("books",books);
                req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

        }

        protected void getBook(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException, SQLException {
                String id = req.getParameter("id");
                Book book = bookService.queryBookById(Integer.parseInt(id));
                req.setAttribute("book",book);
                req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
        }


}
















