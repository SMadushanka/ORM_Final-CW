package lk.ijse.orm.ormh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "reception")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;
    private int contact;

    public Reception(String name, String email, String password, int contact) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.contact = contact;
    }
}
