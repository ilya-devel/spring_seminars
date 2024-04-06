package home.seminar_04_homeworks.controller;

import home.seminar_04_homeworks.models.User;
import home.seminar_04_homeworks.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public List<User> userList() {
        return registrationService.getDataProcessingService()
                .getRepository().getUsers();
    }

    @PostMapping
    public String userAddFromParam(
            @RequestParam(defaultValue = "Anonim") String name,
            @RequestParam(defaultValue = "0") int age,
            @RequestParam(defaultValue = "example@example.example") String mail
    ) {
        registrationService.processRegistration(name, age, mail);
        return "User added from body";
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        registrationService.processRegistration(user.getName(), user.getAge(), user.getMail());
        return "User added from body";
    }
}
