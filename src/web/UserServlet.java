package web;

import pojo.User;
import service.impl.UserServiceImpl;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class UserServlet extends BaseServlet {
    UserServiceImpl userService=new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从req中获取username和password
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        //调用userService的login方法
        User user = userService.login(new User(null, name, password, null));
        if(user==null){
            //如果user为null，说明登录失败
            //将登录失败的信息返回给首页
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",name);
            //转到首页
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            //登录成功
            //将username和password保存到cookie中，以便再次登录时用户名和密码能直接显示在登录界面上
            Cookie cookie1=new Cookie("username",name);
            cookie1.setMaxAge(60*60*24*7*30);
            resp.addCookie(cookie1);
            Cookie cookie2=new Cookie("password",password);
            cookie2.setMaxAge(60*60*24*7*30);
            resp.addCookie(cookie2);
            //将username和userid保存至Session域中
            req.getSession().setAttribute("username",name);
            req.getSession().setAttribute("userid",user.getId());
            //转至首页
            if(Objects.equals(name, "root") && Objects.equals(password, "a123456")) {
                req.getRequestDispatcher("background.jsp").forward(req,resp);
                return;
            }
            req.getRequestDispatcher("book_buy.jsp").forward(req,resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注册，从req域中获取username
        String username = req.getParameter("username");
        User user=new User();
        WebUtils.copyParamToBean(req,user);
        //如果表中已存在username,则注册失败
        if (userService.existsUsername(username)) {
            req.setAttribute("msg","用户名已存在");
            req.getRequestDispatcher("pages/user/Register.jsp").forward(req,resp);
        }
        //可用
        else {
            userService.regisUser(user);
            req.setAttribute("msg","注册成功");
            //返回登录界面
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
