package yegorf.ObjectDef.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Matches;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.HashSet;


@Service
public class DbHandler {
    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;
    private final MatchesRepo matchesRepo;

    @Autowired
    public DbHandler(SignRepo signRepo, AnimalRepo animalRepo, MatchesRepo matchesRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
        this.matchesRepo = matchesRepo;
    }

    public void addAnimal(String name, Integer id1, Integer id2) {
        Animal animal = new Animal(name);
        animalRepo.save(animal);

        for(Sign s : signRepo.findAll()) {
            if(s.getId().equals(id1)) {
                matchesRepo.save(new Matches(s, animal));
            } else if(s.getId().equals(id2)) {
                matchesRepo.save(new Matches(s, animal));
            }
        }
    }

    public void deleteAnimal(Animal animal) {
        HashSet<Matches> matches = matchesRepo.findAllByAnimal(animal);
        for(Matches m : matches) {
            matchesRepo.delete(m);
        }
        animalRepo.delete(animal);
    }

    public void deleteSign(Sign sign) {
        HashSet<Matches> matches = matchesRepo.findAllBySign(sign);
        for(Matches m : matches) {
            matchesRepo.delete(m);
        }
        signRepo.delete(sign);
    }
}
