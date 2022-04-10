package ua.com.owu.ser2021javaadv.service;

import ua.com.owu.ser2021javaadv.models.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAllUserDTO();
}
