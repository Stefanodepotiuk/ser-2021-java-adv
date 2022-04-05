package ua.com.owu.ser2021javaadv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.ser2021javaadv.models.entity.City;

public interface CityDAO extends JpaRepository<City, Integer> {

}
