package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yegorf.ObjectDef.entities.Entity;
import yegorf.ObjectDef.entities.Match;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.EntityRepo;
import yegorf.ObjectDef.repos.MatchRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SignRepo signRepo;
    @Autowired
    private EntityRepo entityRepo;
    @Autowired
    private MatchRepo matchRepo;

    @GetMapping
    public HashSet<Sign> kek() {
        HashSet<Sign> signs = signRepo.findAll();
        return signs;
    }

    @PostMapping("/find")
    public void find(@RequestParam String sign) {
            String[] strings = sign.split(" ");
            ArrayList<Integer> list = new ArrayList<>();

            for(String s : strings) {
                list.add(Integer.parseInt(s));
            }
            for(Integer i : list) {
                System.out.println(i);
            }

            int count = check(list);
            switch (count) {
                case 0:
                    System.out.println("Нема");
                    break;
                case 1:
                    System.out.println("Один");
                    break;
                case 2:
                    System.out.println("Два");
                    break;
            }
    }

    public int check(ArrayList<Integer> list) {
        HashSet<Entity> entities = entityRepo.findAll();
        int count = 0;

        for(Entity e : entities) {
            //HashSet<Match> matches = matchRepo.fi
        }

        return count;
    }
}
