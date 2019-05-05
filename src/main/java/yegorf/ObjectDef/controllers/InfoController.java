package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.Analyzer;
import yegorf.ObjectDef.tools.DbHandler;

import java.util.HashSet;

@RestController
@RequestMapping("/info")
public class InfoController {
    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;
    private final MatchesRepo matchesRepo;

    @Autowired
    public InfoController(SignRepo signRepo, AnimalRepo animalRepo, MatchesRepo matchesRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
        this.matchesRepo = matchesRepo;
    }

    //Animals
    @GetMapping("/animals")
    public HashSet<Animal> animals() {
        return animalRepo.findAll();
    }

    @PostMapping("/addAnimal")
    public String addAnimal(
            @RequestParam String animal,
            @RequestParam Integer id1,
            @RequestParam Integer id2
    ) {
        //Проверить нет ли совпадений, если нет - добавить
        System.out.println(animal + " " + id1 + " " + id2);
        Analyzer analyzer = new Analyzer(signRepo, animalRepo, matchesRepo);

        String result = "Adding successful";
        boolean success = true;
        if(analyzer.checkAnimalName(animal)) {
            result = "Animal name already exists!";
            success = false;
        } else if(analyzer.checkUnique(id1, id2)) {
            result = "Animal with same signs already exists!";
            success = false;
        }

        if(success) {
            DbHandler handler = new DbHandler(signRepo, animalRepo, matchesRepo);
            handler.addAnimal(animal, id1, id2);
        }

        System.out.println(result);
        return result;
    }

    @PostMapping("/deleteAnimal")
    public void deleteAnimal(@RequestParam String animal) {
        DbHandler handler = new DbHandler(signRepo, animalRepo, matchesRepo);
        for(Animal a : animalRepo.findAll()) {
            if(a.getAnimal().equals(animal)) {
                handler.deleteAnimal(a);
            }
        }
    }

    //Signs
    @GetMapping("/signs")
    public HashSet<Sign> signs() {
        return signRepo.findAll();
    }

    @PostMapping("/addSign")
    public void addSign(@RequestParam String sign) {
        signRepo.save(new Sign(sign));
    }

    @PostMapping("/deleteSign")
    public void deleteSign(@RequestParam String sign) {
        DbHandler handler = new DbHandler(signRepo, animalRepo, matchesRepo);
        for(Sign s : signRepo.findAll()) {
            if(s.getSign().equals(sign)) {
                handler.deleteSign(s);
            }
        }
    }
}
