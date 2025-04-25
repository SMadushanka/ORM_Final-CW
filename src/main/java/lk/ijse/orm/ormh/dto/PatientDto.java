package lk.ijse.orm.ormh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDto {
    private int id;
    private String name;
    private String email;
    private int phone;
    private int programmeId;
    private int sessionId;

    public PatientDto(String name, String email, int phone, int programmeId, int sessionId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.programmeId = programmeId;
        this.sessionId = sessionId;
    }
}
