package by.it.academy.MK_JD2_90_22.taskAPI.service;

import by.it.academy.MK_JD2_90_22.taskAPI.service.api.IStatisticsService;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticsService implements IStatisticsService {
    private AtomicInteger activeUsers;
    private AtomicInteger signUpUsers;
    private AtomicInteger messagesSent;

    private static StatisticsService statisticsService;

    public StatisticsService() {
        this.activeUsers = new AtomicInteger(0);
        this.signUpUsers = new AtomicInteger(0);
        this.messagesSent = new AtomicInteger(0);
    }

    public static StatisticsService getInstance() {
        if (statisticsService == null) {
            statisticsService = new StatisticsService();
        }
        return statisticsService;
    }

    @Override
    public void addActiveUsers() {
        activeUsers.getAndIncrement();
    }

    @Override
    public void deleteActiveUsers() {
        activeUsers.getAndDecrement();
    }

    @Override
    public void addSignUpUsers() {
        signUpUsers.getAndIncrement();
    }

    @Override
    public void addMessagesSent() {
        messagesSent.getAndIncrement();
    }

    @Override
    public int getActiveUsers() {
        return activeUsers.get()    ;
    }

    @Override
    public int getSignUpUsers() {
        return signUpUsers.get();
    }

    @Override
    public int getMessagesSent() {
        return messagesSent.get();
    }
}

