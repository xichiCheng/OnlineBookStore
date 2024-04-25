package dao;
import pojo.Book;
import pojo.Comment;

import java.sql.SQLException;
import java.util.List;

public interface BookDaoInterface {
    public int addBook(Book book) throws SQLException;
    public int deleteBookById(Integer id) throws SQLException;
    public int updateBook(Book book) throws SQLException;
    public Book queryBookById(Integer id) throws SQLException;
    public List<Book> queryBooks() throws SQLException;

    Integer queryForPageTotalCount() throws SQLException;

    List<Book> queryForPageItems(int begin, int pageSize) throws SQLException;

    Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException;

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException;

    public void minusBookStock(String name,int count) throws SQLException;
    public void addBookSales(String name,int count) throws SQLException;

    Integer queryForPageTotalCountByType(int min, int max,String type) throws SQLException;

    List<Book> queryForPageItemsByType(int begin, int pageSize, int min, int max,String type) throws SQLException;

    List<Comment> getCommentByName(String bookName) throws SQLException;
}
