package ua.com.owu.ser2021javaadv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.ser2021javaadv.models.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

}
