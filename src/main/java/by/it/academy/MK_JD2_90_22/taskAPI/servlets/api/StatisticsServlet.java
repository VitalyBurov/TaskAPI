package by.it.academy.MK_JD2_90_22.taskAPI.servlets.api;

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

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private static final StatisticsService statisticsService = StatisticsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();

        User user = (User) req.getSession().getAttribute("user");
        if(user!=null && user.getRole() == Role.ADMIN){
            writer.write("<p>Active users  = " + statisticsService.getActiveUsers() + " </p></br>");
            writer.write("<p>Sign Up users  = " + statisticsService.getSignUpUsers() + " </p></br>");
            writer.write("<p>Messages sent = " + statisticsService.getMessagesSent() + " </p></br>");
        }else{
            writer.write("403 Forbidden");
        }
    }
}
