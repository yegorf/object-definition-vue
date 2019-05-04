package yegorf.ObjectDef.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties("matches")
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
