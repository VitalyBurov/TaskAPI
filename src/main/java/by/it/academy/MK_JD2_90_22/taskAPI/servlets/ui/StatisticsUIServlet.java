package by.it.academy.MK_JD2_90_22.taskAPI.servlets.ui;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Role;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;
import by.it.academy.MK_JD2_90_22.taskAPI.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsUIServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsUIServlet extends HttpServlet {

    private static final StatisticsService statisticsService = StatisticsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && user.getRole() == Role.ADMIN) {
            req.setAttribute("ActiveUsers", statisticsService.getActiveUsers());
            req.setAttribute("SignUpUsers", statisticsService.getSignUpUsers());
            req.setAttribute("MessagesSent", statisticsService.getMessagesSent());
        } else {
            writer.write("403 Forbidden");
        }
        req.getRequestDispatcher("/jsp/Statistics.jsp").forward(req, resp);
    }
}
