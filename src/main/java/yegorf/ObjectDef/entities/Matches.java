package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@Entity
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sign_id")
    private Sign sign;

    public Matches(Animal animal, Sign sign) {
        this.animal = animal;
        this.sign = sign;
    }
}
