package by.it.academy.MK_JD2_90_22.taskAPI.service.api;

public interface IStatisticsService {
    void addActiveUsers();
    void deleteActiveUsers();
    void addSignUpUsers();
    void addMessagesSent();
    int getActiveUsers();
    int getSignUpUsers();
    int getMessagesSent();
}
