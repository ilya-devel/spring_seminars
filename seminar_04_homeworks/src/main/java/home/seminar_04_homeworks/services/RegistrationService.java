package home.seminar_04_homeworks.services;

import home.seminar_04_homeworks.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String mail) {
        User user = userService.createUser(name, age, mail);
        getDataProcessingService().addUserToList(user);
        notificationService.sendNotification("Added user: " + user);
    }

}
