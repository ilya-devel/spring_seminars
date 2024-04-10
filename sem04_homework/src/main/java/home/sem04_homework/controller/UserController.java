package home.sem04_homework.controller;

import home.sem04_homework.models.User;
import home.sem04_homework.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.logging.Level;

/**
 * Контроллёр сайта
 */
@Controller
@RequestMapping("/")
@Log
public class UserController {
    @Autowired
    private UserRepository userRepository;

    /**
     * Возврат главной страницы с формой добавления участника и их списком, если они есть
     * @param model
     * @return
     */
    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("users", userRepository.getAllUsers());
        System.out.println(userRepository.getAllUsers());
        return "index.html";
    }

    /**
     * Добавление нового участника в список
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public RedirectView addNewUser(User user, Model model) {
        userRepository.addNewUser(user);
        log.log(Level.INFO, "Add user: " + user);
        return new RedirectView("/");
    }

    /**
     * Вывод страницы с подробностями об участнике
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/user/{id}")
    public String getUserPage(@PathVariable("id") int id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user", user);
        return "user.html";
    }

    /**
     * Обновление информации об участнике
     * @param id
     * @param user
     * @param model
     * @return
     */
    @PostMapping("/user/{id}")
    public RedirectView updateUserPage(@PathVariable("id") int id, User user, Model model) {
        userRepository.update(user);
        return new RedirectView("/");
    }

    /**
     * Удаление участника из списка
     * @param id
     * @return
     */
    @PostMapping("/user/{id}/delete")
    public RedirectView deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return new RedirectView("/");
    }
}
