package yegorf.ObjectDef.repos;

import org.springframework.data.repository.CrudRepository;
import yegorf.ObjectDef.entities.Sign;

import java.util.HashSet;

public interface SignRepo extends CrudRepository<Sign, Integer> {
    HashSet<Sign> findAll();
}
