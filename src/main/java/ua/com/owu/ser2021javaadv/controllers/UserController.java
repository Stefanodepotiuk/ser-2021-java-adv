package ua.com.owu.ser2021javaadv.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.ser2021javaadv.dao.UserDAO;
import ua.com.owu.ser2021javaadv.models.User;
import ua.com.owu.ser2021javaadv.models.dto.UserWithPassportDTO;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserDAO userDAO;

    @GetMapping("")
    public ResponseEntity<List<UserWithPassportDTO>> findAll() {
        List<User> allUsers = userDAO.findAll();
        List<UserWithPassportDTO> userWithPassportDTOS = allUsers.stream().map(UserWithPassportDTO::new).collect(Collectors.toList());
        ResponseEntity<List<UserWithPassportDTO>> response = new ResponseEntity<>(userWithPassportDTOS, HttpStatus.OK);

        return response;
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

    @PostMapping("/with-passport")
    public List<UserWithPassportDTO> saveUserWithPassport(@RequestBody User user) {
        userDAO.save(user);
        return userDAO.findAll().stream().map(UserWithPassportDTO::new).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        userDAO.deleteById(id);
        return (List<User>) findAll();
    }
}
