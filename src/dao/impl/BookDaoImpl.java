package dao.impl;
import dao.DAO.BookDAO;
import dao.BookDaoInterface;
import dao.DAO.CommentDAO;
import pojo.Book;
import pojo.Comment;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class BookDaoImpl implements BookDaoInterface {
    BookDAO bookDAO=new BookDAO();
    @Override
    public int addBook(Book book) throws SQLException {
        String sql="insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`,`type`,`profile`) values(?,?,?,?,?,?,?,?)";
        return bookDAO.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getType(),book.getProfile());
    }

    @Override
    public int deleteBookById(Integer id) throws SQLException {
        String sql="delete from t_book where id = ?";
        return bookDAO.update(sql,id);
    }

    @Override
    public int updateBook(Book book) throws SQLException {
        String sql="update t_book set `name`=? ,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? ,`profile`=?,`type`=? where id= ?";
        return  bookDAO.update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getProfile(),book.getType(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) throws SQLException {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath ,`profile` ,`type` from t_book where id=?";
        return bookDAO.querySingle(sql,Book.class,id);

    }

    @Override
    public List<Book> queryBooks() throws SQLException {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath , type from t_book";
        return bookDAO.queryMulti(sql,Book.class);
    }

    @Override
    public Integer queryForPageTotalCount() throws SQLException {
        String sql="select count(*) from t_book";
        Number count=(Number) bookDAO.quireScalar(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) throws SQLException {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return bookDAO.queryMulti(sql,Book.class,begin,pageSize);
    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) throws SQLException {
        String sql="select count(*) from t_book where price between ? and ?";
        Number count=(Number) bookDAO.quireScalar(sql,min,max);
        return count.intValue();
    }

    public Integer queryForPageTotalCountByName(String name) throws SQLException {
        name="%"+name+"%";
        String sql="select count(*) from t_book where name LIKE ?";
        Number count=(Number) bookDAO.quireScalar(sql,name);
        return count.intValue();
    }

    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) throws SQLException {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath, type from t_book " +
                "where price between ? and ? limit ?,?";
        return bookDAO.queryMulti(sql,Book.class,min,max,begin,pageSize);
    }

    public List<Book> queryBookByName(int begin,int pageSize,String name) throws SQLException {
        name="%"+name+"%";
        String sql="SELECT * FROM t_book where name LIKE ? limit ?,?";
        return  bookDAO.queryMulti(sql,Book.class,name,begin,pageSize);
    }

    public String queryProfileById(Integer id) throws SQLException {
        String sql="select profile from t_book where id=?";
        Book book=bookDAO.querySingle(sql,Book.class,id);
        return book.getProfile();
    }

    @Override
    public void minusBookStock(String name, int count) throws SQLException {
        String sql="UPDATE t_book SET stock = stock - ? WHERE name = ?";
        bookDAO.update(sql,count,name);
    }

    @Override
    public void addBookSales(String name, int count) throws SQLException {
        String sql="UPDATE t_book SET sales = sales + ? WHERE name = ?";
        bookDAO.update(sql,count,name);
    }

    @Override
    public Integer queryForPageTotalCountByType(int min, int max ,String type) throws SQLException {
        String sql="select count(*) from t_book where price between ? and ? and type = ?";
        Number count=(Number) bookDAO.quireScalar(sql,min,max,type);
        return count.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByType(int begin, int pageSize, int min, int max,String type) throws SQLException {
        String sql="select `id`,`name`,`author`,`price`,`sales`,`stock`,`img_path` imgPath,type from t_book " +
                "where type = ? and price between ? and ? limit ?,? ";
        return bookDAO.queryMulti(sql,Book.class,type,min,max,begin,pageSize);
    }

    @Override
    public List<Comment> getCommentByName(String bookName) throws SQLException {
        String sql="select `id` id,`user_name` userName ,`book_name` bookName ,`creat_time` commentTime ,content  from t_comment where book_name = ?";
        return new CommentDAO().queryMulti(sql,Comment.class,bookName);
    }


}
