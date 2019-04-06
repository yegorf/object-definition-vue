package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Matches;

import java.util.HashSet;

@Repository
public interface MatchesRepo extends CrudRepository<Matches, Integer> {
    HashSet<Matches> findAll();
    HashSet<Matches> findAllByAnimal(Animal animal);
}
