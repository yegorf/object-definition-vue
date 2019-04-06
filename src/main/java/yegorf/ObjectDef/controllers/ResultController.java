package yegorf.ObjectDef.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yegorf.ObjectDef.tools.Analyzer;

@RestController
@RequestMapping("/result")
public class ResultController {

    @PostMapping("/addTwo")
    public void addTwo(@RequestParam String sign1,
                       @RequestParam String sign2,
                       @RequestParam String entity) {
        //Analyzer.addTwo(sign1, sign2, entity);
    }

    @PostMapping("/addOne")
    public void addOne(@RequestParam String sign,
                       @RequestParam String entity) {
    }
}
