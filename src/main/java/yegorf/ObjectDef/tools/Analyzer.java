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

    public String analyzeAnswers(ArrayList<Integer> list) {
        HashSet<Animal> animals = animalRepo.findAll();

        for (Integer i: list){
            System.out.println(i);
        }

        for(Animal animal : animals) {
            HashSet<Matches> matches = matchesRepo.findAllByAnimal(animal);
            int count = 0;
            for(Matches m : matches) {
                for(Integer i : list) {
                    if(i.equals(m.getSign().getId())) {
                        count++;
                    }
                }
            }
            if(count >=2) {
                return animal.getAnimal();
            }
        }
        return "no";
    }

//    public String analyzeResult(ArrayList<Integer> list) {
////        String result = analyzeAnswers(list);
////
////        if(result != null) {
////            //Если результат есть, выводим
////        } else {
////            //Если нет, просим ввести название зверя
////        }
//        return analyzeAnswers(list);
//    }

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
