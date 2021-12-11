package Filter;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//loginStatus -1表示验证码错误 -2表示账户密码错误
@WebFilter("/Test/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse HttpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)HttpServletResponse;
        if("-1".equals(req.getSession().getAttribute("loginStatus"))){
            resp.sendRedirect("/vd/login.jsp");
        }else if("-2".equals(req.getSession().getAttribute("loginStatus"))){
            resp.sendRedirect("/vd/login.jsp");
        }else{

            filterChain.doFilter(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
