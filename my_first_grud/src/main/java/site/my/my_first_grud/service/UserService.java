package site.my.my_first_grud.service;

import org.springframework.stereotype.Service;
import site.my.my_first_grud.model.User;
import site.my.my_first_grud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User findById(int id) {
        return userRepository.getOne(id);
    }

    public User update(User user) {
        return userRepository.update(user);
    }
}
