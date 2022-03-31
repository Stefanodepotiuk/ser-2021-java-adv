package ua.com.owu.ser2021javaadv.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.com.owu.ser2021javaadv.models.entity.Pasport;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @OneToOne(cascade = CascadeType.ALL,fetch =FetchType.LAZY )
    @JoinColumn(name = "passport_id")
    @ToString.Exclude
    private Pasport passport;

}
