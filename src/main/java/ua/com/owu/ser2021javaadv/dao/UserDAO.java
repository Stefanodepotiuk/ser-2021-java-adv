package ua.com.owu.ser2021javaadv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.com.owu.ser2021javaadv.models.entity.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    List<User> findByAge(int age);

    List<User> findByName(String name);

    List<User> findByNameAndAge(String name, int age);

    @Query("select u from User u join fetch u.cities")
    List<User> customQueryUsersWithFetchCities();

    @Query("select u from User u join fetch u.cities where u.name=:name")
    List<User> customQueryUsersByNAmeWithFetchCities(String name);

}
