package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@Entity
@NoArgsConstructor
@ToString
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String animal;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private Set<Matches> matches;

    public Animal(String animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return id + " ";
    }
}
