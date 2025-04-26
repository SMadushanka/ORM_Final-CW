package lk.ijse.orm.ormh.tm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TherapistTM {
    private int id;
    private String name;
    private String email;
    private int phone;

    public TherapistTM(String name) {
        this.name = name;
    }
}
