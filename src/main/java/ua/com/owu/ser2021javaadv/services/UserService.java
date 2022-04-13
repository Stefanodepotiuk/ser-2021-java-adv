package ua.com.owu.ser2021javaadv.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.ser2021javaadv.dao.UserDAO;
import ua.com.owu.ser2021javaadv.models.dto.UserDTO;
import ua.com.owu.ser2021javaadv.models.entity.User;

import java.io.File;
import java.io.IOException;

@Service
@AllArgsConstructor

public class UserService {
    private UserDAO userDAO;

    public void saveUser(UserDTO dto) {
        userDAO.save(new User(dto));
    }

    public void saveUser(String name , MultipartFile avatar) throws IOException {
        userDAO.save(new User(name, avatar.getOriginalFilename()));
        String path = System.getProperty("user.home") + File.separator + "avatars" + File.separator;
        avatar.transferTo(new File(path + avatar.getOriginalFilename()));
    }

//    public String getUserAvatar(int id) {
//        return userDAO.findAllById(id).get().getAvatar();
//    }

}
