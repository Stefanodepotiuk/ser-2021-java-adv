package ua.com.owu.ser2021javaadv.controlles;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.ser2021javaadv.models.dto.UserDTO;
import ua.com.owu.ser2021javaadv.models.entity.User;
import ua.com.owu.ser2021javaadv.services.UserService;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("")
    public void saveUser(@RequestParam String name, @RequestParam MultipartFile avatar) throws IOException {

        userService.saveUser(name,avatar);

    }


}
