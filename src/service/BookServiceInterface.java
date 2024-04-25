package service;

import pojo.Book;
import pojo.Comment;
import pojo.Page;

import java.sql.SQLException;
import java.util.List;

public interface BookServiceInterface {
    public void addBook(Book book) throws SQLException;
    public void  deleteBookById(Integer id) throws SQLException;
    public void updateBook(Book book) throws SQLException;
    public Book queryBookById(Integer id) throws SQLException;
    public List<Book> queryBooks() throws SQLException;

    Page<Book> page(int pageNo, int pageSize) throws SQLException;

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException;

    public boolean isBeyondStock(Integer id,int count) throws SQLException;

    Page<Book> pageByType(int pageNo, int pageSize, int min, int max, String type) throws SQLException;

    List<Comment> getCommentByBookName(String bookName) throws SQLException;

}
