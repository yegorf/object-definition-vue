package yegorf.ObjectDef.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.DbHandler;

@RestController
@RequestMapping("/result")
public class ResultController {
    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;
    private final MatchesRepo matchesRepo;

    private DbHandler handler;

    public ResultController(SignRepo signRepo, AnimalRepo animalRepo, MatchesRepo matchesRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
        this.matchesRepo = matchesRepo;
    }

    @PostMapping("/addTwo")
    public void addTwo(@RequestParam String animal,
                       @RequestParam String sign1,
                       @RequestParam String sign2) {
        handler = new DbHandler(signRepo, animalRepo, matchesRepo);
        handler.addAll(new Animal(animal),
                new Sign(sign1),
                new Sign(sign2));
    }

    @PostMapping("/addOne")
    public void addOne(@RequestParam String animal,
                       @RequestParam String sign,
                       @RequestParam Integer id) {
        handler = new DbHandler(signRepo, animalRepo, matchesRepo);
        handler.addOne(new Animal(animal),
                new Sign(sign), id);
    }
}
