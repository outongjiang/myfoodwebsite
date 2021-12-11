package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/Test/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse HttpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)HttpServletResponse;
        if(req.getSession().getAttribute("username")==null){
            resp.sendRedirect("/vd/Test/Welcome.jsp");
        }else{
            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
