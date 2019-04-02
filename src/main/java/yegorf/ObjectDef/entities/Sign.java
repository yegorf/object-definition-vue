package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@Entity
@NoArgsConstructor
public class Sign {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String sign;

    @OneToMany(mappedBy = "diagnose", cascade = CascadeType.ALL)
    private Set<Match> match;

    public Sign(String sign) {
        this.sign = sign;
    }
}
