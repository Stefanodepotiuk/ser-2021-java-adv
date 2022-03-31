package ua.com.owu.ser2021javaadv.models.dto;

import lombok.Data;
import ua.com.owu.ser2021javaadv.models.entity.Pasport;

@Data

public class PassportDTO {
    private String series;

    public PassportDTO(Pasport pasport) {
        this.series = pasport.getSeries();
    }
}
