package yegorf.ObjectDef.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of="id")
@Entity
@NoArgsConstructor
@JsonIgnoreProperties("matches")
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

    @Override
    public String toString() {
        return id + " ";
    }
}
