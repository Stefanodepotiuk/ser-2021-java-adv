package ua.com.owu.ser2021javaadv.controlles;


import org.springframework.web.bind.annotation.*;
import ua.com.owu.ser2021javaadv.models.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainControler {

    private List<User> users = new ArrayList<>();

    public MainControler() {
        users.add(new User(1, "Stepan", true));
        users.add(new User(12, "Stepan2", true));
        users.add(new User(13, "Stepan3", false));
        users.add(new User(14, "Stepan4", true));
    }

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/users")
    public List<User> users() {
        return users;
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable("id") int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    @GetMapping("/user")
    public User getUserByParams(@RequestParam("userId") int userId) {
        return users.stream().filter(user -> user.getId() == userId).findFirst().get();
    }

    @PostMapping("/user")
    public List<User> saveUser(@RequestBody User user) {
        System.out.println(user);
        if (user != null) {
            users.add(user);
        } else {
            throw new RuntimeException("no user");
        }
        return users;
    }

}
