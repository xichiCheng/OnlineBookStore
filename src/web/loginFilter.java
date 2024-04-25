package web;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()");
    }

    @Override
    public void destroy() {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpSession session=httpServletRequest.getSession();
        Object user=session.getAttribute("username");
        if(user==null){
            httpServletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
     }
}
