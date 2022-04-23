package by.it.academy.MK_JD2_90_22.taskAPI.servlets.api;

import by.it.academy.MK_JD2_90_22.taskAPI.service.StatisticsService;
import by.it.academy.MK_JD2_90_22.taskAPI.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

    public static final String REQUEST_LOGIN = "login";
    public static final String REQUEST_PASSWORD = "password";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter(REQUEST_LOGIN);
        String password = req.getParameter(REQUEST_PASSWORD);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        UserService userService = UserService.getInstance();
        HttpSession session = req.getSession();
        try {
            userService.signIn(login,password,session);
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/hello?login="+login);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }



    }
}
