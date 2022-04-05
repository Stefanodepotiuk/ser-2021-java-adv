package ua.com.owu.ser2021javaadv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.ser2021javaadv.models.entity.Card;

public interface CardDAO extends JpaRepository<Card, Integer> {

}
