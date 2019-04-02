package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@javax.persistence.Entity
@NoArgsConstructor
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String entity;

    @OneToMany(mappedBy = "diagnose", cascade = CascadeType.ALL)
    private Set<Match> match;

    public Entity(String entity) {
        this.entity = entity;
    }
}
