package lk.ijse.orm.ormh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionDto {
    private int id;
    private String name;
    private int start;
    private int end;
    private int therapistId;

    public SessionDto(String name, int start, int end, int therapistId) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.therapistId = therapistId;
    }
}
