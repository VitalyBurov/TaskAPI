package by.it.academy.MK_JD2_90_22.taskAPI.service.api;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;

import javax.servlet.http.HttpSession;

public interface IUserService {
    void signUp(User user);
    void signIn(String login, String password, HttpSession session);
    User get(String login);


}
