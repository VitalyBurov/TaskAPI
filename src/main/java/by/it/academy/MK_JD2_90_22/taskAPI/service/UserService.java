package by.it.academy.MK_JD2_90_22.taskAPI.service;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Role;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;
import by.it.academy.MK_JD2_90_22.taskAPI.service.api.IUserService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UserService implements IUserService {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private Map<String, User> users;

    private static UserService userService;
    private static StatisticsService statisticsService = StatisticsService.getInstance();

    private UserService() {
        users = new HashMap<>();
        User admin = new User(ADMIN,ADMIN,ADMIN,ADMIN,"1993-11-16");
        admin.setRole(Role.ADMIN);
        users.put(ADMIN, admin);
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
        }
        return userService;
    }


    @Override
    public void signUp(User user) throws IllegalArgumentException {
        for (Map.Entry<String, User> savedUser : users.entrySet()) {
            if (savedUser.getKey().equals(user.getLogin())) {
                throw new IllegalArgumentException("The User has already exist!!!");
            }
        }
        users.put(user.getLogin(), user);
        statisticsService.addSignUpUsers();
    }

    @Override
    public void signIn(String login, String password, HttpSession session) throws IllegalArgumentException {
        boolean isExist = false;
        for (Map.Entry<String, User> savedUser : users.entrySet()) {
            if (savedUser.getKey().equals(login)) {
                if (savedUser.getValue().getPassword().equals(password)) {
                    session.setAttribute(USER, savedUser.getValue());
                    isExist = true;
                } else {
                    throw new IllegalArgumentException("Wrong login or password");
                }
            }
        }
        if (!isExist) {
            throw new IllegalArgumentException("The User doesn't exist");
        }
    }

    @Override
    public User get(String login) throws IllegalArgumentException {
        for (Map.Entry<String, User> savedUser : users.entrySet()) {
            if (savedUser.getKey().equals(login))
                return savedUser.getValue();
        }
        throw new IllegalArgumentException("The User doesn't exist");
    }
}



