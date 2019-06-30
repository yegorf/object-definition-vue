package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Matches;
import yegorf.ObjectDef.entities.Sign;

import java.util.HashSet;

public interface MatchesRepo extends CrudRepository<Matches, Integer> {
    HashSet<Matches> findAllByAnimal(Animal animal);

    HashSet<Matches> findAllBySign(Sign sign);
}
