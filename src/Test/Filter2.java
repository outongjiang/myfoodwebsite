package Test;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(value ="/test/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2执行了");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter2回来了");
    }

    @Override
    public void destroy() {

    }
}
