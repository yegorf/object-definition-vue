package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yegorf.ObjectDef.entities.Animal;

import java.util.HashSet;

@Repository
public interface AnimalRepo extends CrudRepository<Animal, Integer> {
    HashSet<Animal> findAll();
}
