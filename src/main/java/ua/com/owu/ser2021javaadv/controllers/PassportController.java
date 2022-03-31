package ua.com.owu.ser2021javaadv.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.owu.ser2021javaadv.dao.PassportDAO;
import ua.com.owu.ser2021javaadv.models.entity.Pasport;

import java.util.List;

@RestController
@RequestMapping("/passports")
@AllArgsConstructor


public class PassportController {
    private PassportDAO passportDAO;

    @GetMapping("")
    public List<Pasport> getPassport() {
        return passportDAO.findAll();
    }
}
