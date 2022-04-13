package ua.com.owu.ser2021javaadv.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.owu.ser2021javaadv.models.dto.UserDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String avatar;

    public User(UserDTO dto) {
        this.name = dto.getName();
        this.avatar = dto.getAvatar();
    }

    public User(String name, String avatar) {
        this.name = name;
        this.avatar = avatar;
    }

}
