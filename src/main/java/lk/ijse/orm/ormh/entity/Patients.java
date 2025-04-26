package lk.ijse.orm.ormh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int phone;

    @ManyToOne
    @JoinColumn(name = "programme_id")
    private Programme programmeID;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Sessions sessionID;
}
