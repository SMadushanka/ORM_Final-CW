package lk.ijse.orm.ormh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TherapistDto {
    private int id;
    private String name;
    private String email;
    private int phone;

    public TherapistDto(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public TherapistDto(String name) {
        this.name = name;
    }
}
