package yegorf.ObjectDef.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(of="id")
@Entity
@NoArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
