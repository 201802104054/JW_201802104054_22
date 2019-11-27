package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter 2", urlPatterns = {"/*"}/*通配符（*）表示对所有的web资源有效*/)
public class Filter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Filter 2 beigns");
        String path = request.getRequestURI();
        String method = request.getMethod();
        if (!path.contains("/login")&& !path.contains("/myapp")){
            if (method.equals("PUT")||method.equals("POST")){
                request.setCharacterEncoding("UTF-8");
            }
            response.setContentType("text/html;charset=UTF-8");
        }
//       System.out.println("请求的资源为：" + path);
       filterChain.doFilter(servletRequest,servletResponse);
       System.out.println("Filter 2 ends");
    }

    @Override
    public void destroy() {

    }
}