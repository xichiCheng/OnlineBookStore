package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract  class BaseServlet  extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action=req.getParameter("action");
        try {
            //这行代码通过反射机制，根据从请求参数中获取的动作名称（在 "action" 变量中），
            // 查找当前 Servlet 类中与该动作名称对应的方法。这里假设动作名称与方法名相同，
            // 并且这些方法都接受一个 HttpServletRequest 类型和一个 HttpServletResponse 类型的参数。
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            //method.invoke(this, req, resp);：这行代码调用之前获取的方法，并传递当前 Servlet 的实例（this）、
            // 请求对象（req）和响应对象（resp）作为参数。这样就会执行与请求动作对应的方法。
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
