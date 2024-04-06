package home.seminar_04_homeworks.services;

import home.seminar_04_homeworks.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, int age, String email) {
        User user = new User(name, age, email);
        notificationService.notifyUser(user);
        return user;
    }

}
