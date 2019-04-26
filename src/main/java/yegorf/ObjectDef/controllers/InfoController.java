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

    @GetMapping
    public HashSet<Sign> kek() {
        return signRepo.findAll();
    }

    @GetMapping("/animals")
    public HashSet<Animal> getAnimals() {
        return animalRepo.findAll();
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
