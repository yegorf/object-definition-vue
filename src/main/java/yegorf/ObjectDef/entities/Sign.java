package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "sign", cascade = CascadeType.ALL)
    private Set<Matches> matches;

    public Sign(String sign) {
        this.sign = sign;
    }


}
