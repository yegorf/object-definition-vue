package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.Analyzer;
import yegorf.ObjectDef.tools.DbHandler;

import java.util.logging.Handler;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private SignRepo signRepo;
    @Autowired
    private AnimalRepo animalRepo;
    @Autowired
    private MatchesRepo matchesRepo;

    private DbHandler handler;

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
