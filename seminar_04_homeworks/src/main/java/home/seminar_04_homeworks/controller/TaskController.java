package home.seminar_04_homeworks.controller;

import home.seminar_04_homeworks.models.User;
import home.seminar_04_homeworks.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortUserByAge() {
        return dataProcessingService.sortUserByAge(dataProcessingService.getRepository().getUsers());
    }

    @GetMapping(value = "/filter")
    public List<User> filterUserByAge(@RequestParam(defaultValue = "0") int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getRepository().getUsers(), age);
    }

    @GetMapping(value = "/filter/{age}")
    public List<User> filterUserByAgeWithPathVariable(@PathVariable int age) {
        return dataProcessingService.filterUsersByAge(dataProcessingService.getRepository().getUsers(), age);
    }

    @GetMapping("/calc")
    public double calculateAverageAge() {
        return dataProcessingService.calculateAverageAge(dataProcessingService.getRepository().getUsers());
    }

    // В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
}
