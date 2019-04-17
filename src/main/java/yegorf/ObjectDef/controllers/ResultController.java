package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.Analyzer;

@RestController
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private SignRepo signRepo;
    @Autowired
    private AnimalRepo animalRepo;
    @Autowired
    private MatchesRepo matchesRepo;

    @PostMapping("/addTwo")
    public void addTwo(@RequestParam String sign1,
                       @RequestParam String sign2,
                       @RequestParam String entity) {
        (new Analyzer(signRepo, animalRepo, matchesRepo)).addTwo(sign1, sign2, entity);
        System.out.println(sign1);
        System.out.println(sign2);
        System.out.println(entity);
    }

    @PostMapping("/addOne")
    public void addOne(@RequestParam String sign,
                       @RequestParam String entity) {
    }
}
