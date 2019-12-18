package yr.jstl.Filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String uri = request.getRequestURI();

        System.out.println(" ~~~~~~~ filter here ~~~~~~~~~~~~");

        if(uri.contains("/login.jsp") || uri.contains("/verifycode") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else  {

            Object user = request.getSession().getAttribute("user");
            if(user == null) {
                request.setAttribute("login_msg", "请先登录权限验证，已使用此功能");
                request.getRequestDispatcher("/login.jsp").forward(request, servletResponse);
            }else  {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }
}
