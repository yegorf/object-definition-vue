package yegorf.ObjectDef.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.SignRepo;
import yegorf.ObjectDef.tools.Analyzer;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SignRepo signRepo;


    @GetMapping
    public HashSet<Sign> kek() {
        HashSet<Sign> signs = null;// = signRepo.findAll();
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
            Analyzer analyzer = new Analyzer();
            //analyzer.analyzeResult(list);
    }
}
