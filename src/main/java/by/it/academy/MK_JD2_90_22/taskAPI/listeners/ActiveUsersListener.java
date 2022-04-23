package by.it.academy.MK_JD2_90_22.taskAPI.listeners;

import by.it.academy.MK_JD2_90_22.taskAPI.service.StatisticsService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class ActiveUsersListener implements HttpSessionAttributeListener {
    private StatisticsService statisticsService = StatisticsService.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            statisticsService.addActiveUsers();
            System.out.println("Active users added");
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            statisticsService.deleteActiveUsers();
            System.out.println("Active users delete");
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
