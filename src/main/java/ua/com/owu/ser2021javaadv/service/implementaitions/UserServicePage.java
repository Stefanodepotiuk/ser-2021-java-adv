package ua.com.owu.ser2021javaadv.service.implementaitions;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.com.owu.ser2021javaadv.dao.UserDAO;
import ua.com.owu.ser2021javaadv.models.dto.UserDTO;
import ua.com.owu.ser2021javaadv.service.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServicePage implements IUserService {
    private UserDAO userDAO;

    @Override
    public List<UserDTO> findAllUserDTO() {
        PageRequest request = PageRequest.of(1, 2);

        return userDAO.findAll(request).getContent().stream().map(UserDTO::new).collect(Collectors.toList());
    }
}