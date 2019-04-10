package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Animal;

import java.util.HashSet;

public interface AnimalRepo extends CrudRepository<Animal, Integer> {
    HashSet<Animal> findAll();
}
