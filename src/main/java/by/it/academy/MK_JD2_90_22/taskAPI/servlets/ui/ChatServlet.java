package by.it.academy.MK_JD2_90_22.taskAPI.servlets.ui;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Message;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;
import by.it.academy.MK_JD2_90_22.taskAPI.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChatServlet", urlPatterns = "/ui/user/chats")
public class ChatServlet extends HttpServlet {

    private static MessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        String contextPath = req.getContextPath();
        List<Message> messages = messageService.getMessage(user);
        if (user == null) {
            resp.sendRedirect(contextPath + "/ui/signIn");
        } else {
            req.setAttribute("messages", messages);
            req.getRequestDispatcher("/jsp/Chat.jsp").forward(req, resp);
        }
    }
}
