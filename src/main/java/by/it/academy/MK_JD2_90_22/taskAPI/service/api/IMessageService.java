package by.it.academy.MK_JD2_90_22.taskAPI.service.api;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Message;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;

import java.util.List;

public interface IMessageService {
    void sendMessage(Message message);
    List<Message> getMessage(User user);
}

