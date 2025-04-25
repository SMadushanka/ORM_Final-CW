package lk.ijse.orm.ormh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProgrammeDto {
    private int id;
    private String name;
    private String duration;
    private double fees;

    public ProgrammeDto(String name, String duration, double fees) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }
}
