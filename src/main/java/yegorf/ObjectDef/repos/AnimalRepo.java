package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Animal;

public interface AnimalRepo extends CrudRepository<Animal, Integer> {
}
