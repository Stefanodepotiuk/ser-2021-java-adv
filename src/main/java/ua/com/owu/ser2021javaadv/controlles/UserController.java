package ua.com.owu.ser2021javaadv.controlles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.ser2021javaadv.models.entity.User;
import ua.com.owu.ser2021javaadv.services.UserService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("")
    public void saveUser(@RequestParam String name, @RequestParam MultipartFile avatar) throws IOException {

        userService.saveUser(name, avatar);

    }

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return userService.getByUserId(id);
    }

    @PostMapping("/plain")
    public void savePlainUser(@RequestBody User user) {
        userService.saveUser(user);
    }
}
