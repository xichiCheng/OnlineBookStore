package test;

import dao.impl.BookDaoImpl;
import org.junit.Test;
import pojo.Book;
import pojo.Page;
import service.impl.BookServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;

public class BookDaoeTest {
    BookDaoImpl bookDao=new BookDaoImpl();
    BookServiceImpl bookService=new BookServiceImpl();
    @Test
    public void addBook() throws SQLException {
        bookDao.addBook(new Book(null,"MySQL必知必会","Smith",new BigDecimal(56.55),210,101,null));
    }

    @Test
    public void deleteBookById() throws SQLException {
        bookDao.deleteBookById(16);
    }

    @Test
    public void updateBook() throws SQLException {
        bookDao.updateBook(new Book(30,"MySQL必知必会"," Ben Forta",new BigDecimal(56.55),210,101,null));
    }

    @Test
    public void queryBookById() throws SQLException {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() throws SQLException {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

   @Test
    public void queryForPageTotalCount() throws SQLException {
       System.out.println(bookDao.queryForPageTotalCount());
    }

   @Test
    public void queryForPageItems() throws SQLException {
       for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
           System.out.println(book);
       }
    }
    @Test
    public void page() throws SQLException {
        System.out.println(bookService.page(1,Page.PAGE_SIZE));
    }

    @Test
    public void profile() throws SQLException {
        System.out.println(bookDao.queryBookById(58));
    }

    @Test
    public void queryBookByName() throws SQLException {
        System.out.println(bookDao.queryBookByName(1,4,"计算机"));
    }
    @Test
    public void queryBookByType() throws SQLException {
        System.out.println(bookDao.queryForPageItemsByType(1,4,1,1000,"文学类"));
    }
    @Test
    public void getComment() throws SQLException {
        System.out.println(bookDao.getCommentByName("中国古代史纲要"));
    }
}