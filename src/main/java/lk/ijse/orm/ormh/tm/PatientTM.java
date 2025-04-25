package lk.ijse.orm.ormh.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientTM {
    private int id;
    private String name;
    private String email;
    private int phone;
    private int programmeId;
    private int sessionId;

    public PatientTM(String name, String email, int phone, int programmeId, int sessionId) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.programmeId = programmeId;
        this.sessionId = sessionId;
    }
}
