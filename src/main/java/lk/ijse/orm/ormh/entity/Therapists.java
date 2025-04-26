package lk.ijse.orm.ormh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "therapist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Therapists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;
   private String email;
   private int phone;

    public Therapists(String name, String email, int phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
