package by.it.academy.MK_JD2_90_22.taskAPI.servlets.api;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;
import by.it.academy.MK_JD2_90_22.taskAPI.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

    public static final String REQUEST_LOGIN = "login";
    public static final String REQUEST_PASSWORD = "password";
    public static final String REQUEST_FIRST_NAME = "firstName";
    public static final String REQUEST_LAST_NAME = "lastName";
    public static final String REQUEST_DATE_OF_BIRTHDAY = "dateOfBirthday";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp
    ) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter(REQUEST_LOGIN);
        String password = req.getParameter(REQUEST_PASSWORD);
        String firstName = req.getParameter(REQUEST_FIRST_NAME);
        String lastName = req.getParameter(REQUEST_LAST_NAME);
        String dateOfBirthday = req.getParameter(REQUEST_DATE_OF_BIRTHDAY);

        User user = new User(login, password, lastName, firstName, dateOfBirthday);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        UserService userService = UserService.getInstance();
        try {
            userService.signUp(user);
        } catch (IllegalArgumentException e) {
            writer.write(e.getMessage());
        }
        writer.write("User created!");

    }

}
