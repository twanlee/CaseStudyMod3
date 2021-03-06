package filters;

import utils.Constant;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/admin_home")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session = ((HttpServletRequest) req).getSession();
        Object o = session.getAttribute("role");
        if(o!=null){
            String role = o.toString();
            if(role.equals(Constant.ADMIN)){
                chain.doFilter(req,resp);
            }else {
                PrintWriter writer = resp.getWriter();
                writer.write("Access Denied!");
            }
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer_view/login_form.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
