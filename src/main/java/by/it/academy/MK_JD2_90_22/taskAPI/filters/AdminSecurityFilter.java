package by.it.academy.MK_JD2_90_22.taskAPI.filters;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Role;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && session.getAttribute("user") != null) {
            User user = (User) req.getSession().getAttribute("user");
            if(user.getRole() == Role.ADMIN) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            resp.sendRedirect(contextPath + "/ui/signIn");
            return;
        }
    }

    @Override
    public void destroy() {

    }
}
