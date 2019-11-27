package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Calendar;


//@WebFilter(filterName = "Filter 1", urlPatterns = {"/*"}/*通配符（*）表示对所有的web资源有效*/)
public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
//      int second = c.get(Calendar.SECOND);
//      System.out.println(year + "/" + month + "/" + date + " " +hour + ":" +minute + ":" + second);
        String path = request.getRequestURI();
        System.out.println(path + " @ " + year + "/" + month + "/" + date + " " +hour + ":" +minute);
        System.out.println("Filter 1 beigns");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("Filter 1 ends");
    }

    @Override
    public void destroy() {

    }
}