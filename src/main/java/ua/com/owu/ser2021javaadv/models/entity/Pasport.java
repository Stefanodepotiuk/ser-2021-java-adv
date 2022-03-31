package ua.com.owu.ser2021javaadv.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ua.com.owu.ser2021javaadv.models.User;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(value = {"HibernateLazy"})
public class Pasport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;
    @OneToOne(mappedBy = "passport", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private User user;
}
