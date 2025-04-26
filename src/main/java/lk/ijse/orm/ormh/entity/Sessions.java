package lk.ijse.orm.ormh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "session")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int start;
    private int end;

    @ManyToOne
    @JoinColumn(name = "therapist_ID")
    private Therapists therapists;
}

