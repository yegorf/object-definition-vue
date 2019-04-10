package yegorf.ObjectDef.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Matches;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class Analyzer {

    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;
    private final MatchesRepo matchesRepo;

    @Autowired
    public Analyzer(SignRepo signRepo, AnimalRepo animalRepo, MatchesRepo matchesRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
        this.matchesRepo = matchesRepo;
    }

    private String analyzeAnswers(ArrayList<Integer> list) {
        HashSet<Animal> animals = animalRepo.findAll();
        int count = 0;
        int maxCount = 0;

        for(Animal e : animals) {
            HashSet<Matches> matches = matchesRepo.findAllByAnimal(e);
            for(Matches m : matches) {
                for(Integer i : list) {
                    if(m.getSign().getId() == i) {
                        count ++;
                        if(maxCount < count) {
                            maxCount = count;
                        }
                    }
                }
            }
            if (count == 2) {
                return e.getAnimal();
            }
        }
        return null;
    }

    public void analyzeResult(ArrayList<Integer> list) {
        String result = analyzeAnswers(list);

        if(result != null) {
            //Если результат есть, выводим
        } else {
            //Если нет, просим ввести название зверя
        }
    }

    public void addTwo(String sign1, String sign2, String entity) {
        Sign signOne = new Sign(sign1);
        Sign signTwo = new Sign(sign2);
        Animal animal = new Animal(entity);

        signRepo.save(signOne);
        signRepo.save(signTwo);
        animalRepo.save(animal);
        matchesRepo.save(new Matches(signOne, animal));
        matchesRepo.save(new Matches(signTwo, animal));
    }
}
