package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Matches;

public interface MatchesRepo extends CrudRepository<Matches, Integer> {
}
