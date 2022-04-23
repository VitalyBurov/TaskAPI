package by.it.academy.MK_JD2_90_22.taskAPI.servlets.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "MainPageServlet", urlPatterns = "/ui")
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/jsp/Main.jsp").forward(req,resp);
        String login = req.getParameter("login");
        Writer writer = resp.getWriter();
        writer.write("Welcome " + "<p>" + login + "</p></br>");
    }
}
