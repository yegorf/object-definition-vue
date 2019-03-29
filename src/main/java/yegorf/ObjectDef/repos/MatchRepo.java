package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yegorf.ObjectDef.entities.Match;

import java.util.HashSet;

@Repository
public interface MatchRepo extends CrudRepository<Match, Integer> {
    HashSet<Match> findAll();
}
