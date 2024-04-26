package web;

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

public class UpdateServlet extends HttpServlet {
    BookServiceImpl bookService=new BookServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=new Book();
        String imgPath="static/img/default.jpg";
        String profile="";

        if(ServletFileUpload.isMultipartContent(req)){
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem : list) {
                    if(!fileItem.isFormField()){
                        if(fileItem.getName()==null|| Objects.equals(fileItem.getName(), "")){
                            book.setImgPath(imgPath);
                        }else {
                            fileItem.write(new File("D:\\java文件夹\\OnlineBookstore01\\web\\static\\img\\" + fileItem.getName()));
                            book.setImgPath("static/img/" + fileItem.getName());
                        }
                    }else{
                        if(Objects.equals(fileItem.getFieldName(), "name")){
                            book.setName(fileItem.getString("UTF-8"));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "preProfile")){
                           profile=fileItem.getString("UTF-8");
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "id")){
                            book.setId(Integer.valueOf(fileItem.getString("UTF-8")));
                        }
                        else if(Objects.equals(fileItem.getFieldName(), "sales")){
                           book.setSales(Integer.valueOf(fileItem.getString("UTF-8")));
                        }
                         else if(Objects.equals(fileItem.getFieldName(), "preImgPath")){
                            imgPath=fileItem.getString("UTF-8");
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
                            if(Objects.equals(fileItem.getString("UTF-8"), "")){
                                book.setProfile(profile);
                            }else {
                                book.setProfile(fileItem.getString("UTF-8"));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                System.out.println("???");
                bookService.updateBook(book);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println(book);

            req.getRequestDispatcher("manager/BookServlet?action=page").forward(req,resp);
        }




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
