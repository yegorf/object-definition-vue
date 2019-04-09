package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@Entity
@ToString
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sign_id")
    private Sign sign;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    public Matches(Sign sign, Animal animal) {
        this.sign = sign;
        this.animal = animal;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
