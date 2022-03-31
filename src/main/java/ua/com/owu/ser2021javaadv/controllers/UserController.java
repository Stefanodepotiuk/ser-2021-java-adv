package ua.com.owu.ser2021javaadv.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.ser2021javaadv.dao.UserDAO;
import ua.com.owu.ser2021javaadv.models.User;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    @GetMapping("/")
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userDAO.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @PatchMapping("/{id}")
    public User UpdateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userDAO.save(user);
        return user;
    }

    @PostMapping("/")
    public List<User> saveUser(@RequestBody User user) {
        userDAO.save(user);
        return userDAO.findAll();
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        userDAO.deleteById(id);
        return findAll();
    }
}
