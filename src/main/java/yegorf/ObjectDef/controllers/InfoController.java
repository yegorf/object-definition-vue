package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    private SignRepo signRepo;

    @GetMapping
    public HashSet<Sign> kek() {
        HashSet<Sign> signs = signRepo.findAll();

        for(Sign s : signs) {
            System.out.println(s.getId() + " " + s.getSign());
        }
        return signs;
    }

    @PostMapping("/add")
    public void lol(@RequestParam String sign) {
        signRepo.save(new Sign(sign));
    }

    @PostMapping("/delete")
    public void delete(@RequestParam Integer id) {
        signRepo.deleteById(id);
    }
}
