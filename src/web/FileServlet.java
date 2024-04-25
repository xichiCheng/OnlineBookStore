package web;

import dao.BookDaoInterface;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pojo.Book;
import service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book=new Book();
        if(ServletFileUpload.isMultipartContent(req)){//表单
            System.out.println("???");
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if(!fileItem.isFormField()){
                        fileItem.write(new File("D:\\java文件夹\\OnlineBookstore01\\web\\static\\img\\"+fileItem.getName()));
                        book.setImgPath("static/img/"+fileItem.getName());
                    }else{
                        if(Objects.equals(fileItem.getFieldName(), "name")){
                            book.setName(fileItem.getString("UTF-8"));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "price")){
                            book.setPrice(new BigDecimal(fileItem.getString("UTF-8")));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "author")){
                            book.setAuthor(fileItem.getString("UTF-8"));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "stock")){
                            book.setStock(Integer.valueOf(fileItem.getString("UTF-8")));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "type")){
                            book.setType(fileItem.getString("UTF-8"));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "profile")){
                            book.setProfile(fileItem.getString("UTF-8"));
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            book.setSales(0);

            try {
                new BookServiceImpl().addBook(book);
                System.out.println(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            req.getRequestDispatcher("manager/BookServlet?action=page").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
