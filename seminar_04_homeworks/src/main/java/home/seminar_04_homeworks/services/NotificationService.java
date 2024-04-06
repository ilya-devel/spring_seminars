package home.seminar_04_homeworks.services;

import home.seminar_04_homeworks.models.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void notifyUser(User user) {
        System.out.println("Create: " + user);
    }

    public void sendNotification (String msg) {
        System.out.println(msg);
    }
}
