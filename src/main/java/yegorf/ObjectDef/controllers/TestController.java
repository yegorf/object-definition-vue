package yegorf.ObjectDef.controllers;

import org.springframework.web.bind.annotation.*;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.Analyzer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

@RestController
@RequestMapping("/test")
public class TestController {
    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;
    private final MatchesRepo matchesRepo;

    public TestController(SignRepo signRepo, AnimalRepo animalRepo, MatchesRepo matchesRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
        this.matchesRepo = matchesRepo;
    }

    @GetMapping
    public ArrayList<Sign> kek() {
        HashSet<Sign> signs = signRepo.findAll();
        ArrayList<Sign> list = new ArrayList<>(signs);
        Collections.shuffle(list);
        return list;
    }

    @PostMapping("/find")
    public String find(@RequestParam String sign) {
        String[] strings = sign.split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for (String s : strings) {
            list.add(Integer.parseInt(s));
        }

        Analyzer analyzer = new Analyzer(signRepo, animalRepo, matchesRepo);
        return analyzer.analyzeAnswers(list);
    }
}
