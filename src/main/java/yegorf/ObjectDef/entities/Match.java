package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;

@Data
@EqualsAndHashCode(of="id")
@Entity
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "entity_id")
    private yegorf.ObjectDef.entities.Entity entity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sign_id")
    private Sign sign;

    public Match(yegorf.ObjectDef.entities.Entity entity, Sign sign) {
        this.entity = entity;
        this.sign = sign;
    }
}
