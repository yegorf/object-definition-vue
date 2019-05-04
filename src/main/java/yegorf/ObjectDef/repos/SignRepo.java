package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Sign;

import java.util.HashSet;
import java.util.Optional;

public interface SignRepo extends CrudRepository<Sign, Integer> {
   HashSet<Sign> findAll();
}
