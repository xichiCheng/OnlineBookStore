package service.impl;

import dao.impl.BookDaoImpl;
import pojo.Book;
import pojo.Comment;
import pojo.Page;
import service.BookServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookServiceInterface {
    BookDaoImpl bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) throws SQLException {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) throws SQLException {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) throws SQLException {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() throws SQLException {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) throws SQLException {
        Page<Book> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //总记录数
        Integer pageToTalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageToTalCount);
        //求总页码
        Integer pageTotal=pageToTalCount/pageSize;
        if(pageToTalCount%pageSize>0)
            pageTotal+=1;
        page.setPageTotal(pageTotal);
        //设置当前页数据
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) throws SQLException {
        Page<Book> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //总记录数
        Integer pageToTalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageToTalCount);
        //求总页码
        Integer pageTotal=pageToTalCount/pageSize;
        if(pageToTalCount%pageSize>0)
            pageTotal+=1;
        page.setPageTotal(pageTotal);
        //设置当前页数据
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }

    public Page<Book> pageByName(int pageNo, int pageSize ,String name) throws SQLException {
        Page<Book> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //总记录数
        Integer pageToTalCount=bookDao.queryForPageTotalCountByName(name);
        page.setPageTotalCount(pageToTalCount);
        //求总页码
        Integer pageTotal=pageToTalCount/pageSize;
        if(pageToTalCount%pageSize>0)
            pageTotal+=1;
        page.setPageTotal(pageTotal);
        //设置当前页数据
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryBookByName(begin,pageSize,name);
        page.setItems(items);
        return page;
    }

    public String queryProfileById(Integer id) throws SQLException {
        return bookDao.queryProfileById(id);
    }
    @Override
    public boolean isBeyondStock(Integer id, int count)  {
        Book book= null;
        try {
            book = bookDao.queryBookById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //
        return book.getStock() < count;
    }

    @Override
    public Page<Book> pageByType(int pageNo, int pageSize, int min, int max, String type) throws SQLException {
        Page<Book> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        //总记录数
        Integer pageToTalCount=bookDao.queryForPageTotalCountByType(min,max,type);
        System.out.println(pageToTalCount);
        page.setPageTotalCount(pageToTalCount);
        //求总页码
        Integer pageTotal=pageToTalCount/pageSize;
        if(pageToTalCount%pageSize>0)
            pageTotal+=1;
        page.setPageTotal(pageTotal);
        //设置当前页数据
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItemsByType(begin,pageSize,min,max,type);
        page.setItems(items);
        return page;
    }

    @Override
    public List<Comment> getCommentByBookName(String bookName) throws SQLException {
        return bookDao.getCommentByName(bookName);
    }
}
