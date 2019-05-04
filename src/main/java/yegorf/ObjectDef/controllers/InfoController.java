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
    private final SignRepo signRepo;
    private final AnimalRepo animalRepo;

    @Autowired
    public InfoController(SignRepo signRepo, AnimalRepo animalRepo) {
        this.signRepo = signRepo;
        this.animalRepo = animalRepo;
    }

    //Animals
    @GetMapping("/animals")
    public HashSet<Animal> animals() {
        return animalRepo.findAll();
    }

    @PostMapping
    public void addAnimal(@RequestParam String animal,
                          @RequestParam Integer id1,
                          @RequestParam Integer id2) {
        //Проверить нет ли совпадений, если нет - добавить
    }

    @PostMapping("/deleteAnimal")
    public void deleteAnimal(@RequestParam Integer id) {
        animalRepo.deleteById(id);
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
    public void deleteSign(@RequestParam Integer id) {
        signRepo.deleteById(id);
    }
}
