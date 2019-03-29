package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yegorf.ObjectDef.entities.Entity;

import java.util.HashSet;

@Repository
public interface EntityRepo extends CrudRepository<Entity, Integer> {
    HashSet<Entity> findAll();
}
