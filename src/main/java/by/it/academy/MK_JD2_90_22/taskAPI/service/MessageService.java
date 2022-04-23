package by.it.academy.MK_JD2_90_22.taskAPI.service;

import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.Message;
import by.it.academy.MK_JD2_90_22.taskAPI.core.dto.User;
import by.it.academy.MK_JD2_90_22.taskAPI.service.api.IMessageService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {


    private static MessageService messageService;
    private static StatisticsService statisticsService = StatisticsService.getInstance();

    private Map<String, List<Message>> messageStorage;

    private MessageService() {
        messageStorage = new HashMap<>();
    }

    public static MessageService getInstance() {
        if (messageService == null) {
            messageService = new MessageService();
        }
        return messageService;
    }

    public void sendMessage(Message message) throws IllegalArgumentException {
        UserService userService = UserService.getInstance();
        User user = userService.get(message.getToWhom());
        List<Message> messagesList;
        if (messageStorage.containsKey(user.getLogin())) {
            messagesList = messageStorage.getOrDefault(user.getLogin(), new ArrayList<>());
        } else {
            messagesList = new ArrayList<>();
        }
        messagesList.add(message);
        messageStorage.put(user.getLogin(), messagesList);
        statisticsService.addMessagesSent();
    }

    public List<Message> getMessage(User user) {
        List<Message> messages = null;
        if (messageStorage.containsKey(user.getLogin())) {
            messages = messageStorage.get(user.getLogin());
        }
        return messages;
    }

}