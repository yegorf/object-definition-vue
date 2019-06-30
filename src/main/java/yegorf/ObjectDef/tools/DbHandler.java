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

    public String addAnimal(String name, Integer id1, Integer id2) {
        Animal animal = new Animal(name);
        animalRepo.save(animal);

        for (Sign s : signRepo.findAll()) {
            if (s.getId().equals(id1)) {
                matchesRepo.save(new Matches(s, animal));
            } else if (s.getId().equals(id2)) {
                matchesRepo.save(new Matches(s, animal));
            }
        }

        return "Успешно";
    }

    public void deleteAnimal(Animal animal) {
        HashSet<Matches> matches = matchesRepo.findAllByAnimal(animal);
        for (Matches m : matches) {
            matchesRepo.delete(m);
        }
        animalRepo.delete(animal);
    }

    public String addSign(Sign sign) {
        boolean check = true;
        HashSet<Sign> signs = signRepo.findAll();
        for (Sign s : signs) {
            if (s.getSign().equals(sign.getSign())) {
                check = false;
                return "Такое уже есть";
            }
        }
        if (check) {
            signRepo.save(sign);
            return "Успешно";
        }
        return "Такое уже есть";
    }

    public void deleteSign(Sign sign) {
        HashSet<Matches> matches = matchesRepo.findAllBySign(sign);
        for (Matches m : matches) {
            matchesRepo.delete(m);
        }
        signRepo.delete(sign);
    }

    public void addAll(Animal animal, Sign sign1, Sign sign2) {
        signRepo.save(sign1);
        signRepo.save(sign2);
        animalRepo.save(animal);
        matchesRepo.save(new Matches(sign1, animal));
        matchesRepo.save(new Matches(sign2, animal));
    }

    public void addOne(Animal animal, Sign sign, Integer id) {
        signRepo.save(sign);
        animalRepo.save(animal);
        matchesRepo.save(new Matches(sign, animal));
        for (Sign s : signRepo.findAll()) {
            if (s.getId().equals(id)) {
                matchesRepo.save(new Matches(s, animal));
            }
        }
    }
}
