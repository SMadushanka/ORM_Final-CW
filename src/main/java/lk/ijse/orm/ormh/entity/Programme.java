package lk.ijse.orm.ormh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "programme")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String duration;
    private double fees;

    public Programme(String name, String duration, double fees) {
        this.name = name;
        this.duration = duration;
        this.fees = fees;
    }
}
