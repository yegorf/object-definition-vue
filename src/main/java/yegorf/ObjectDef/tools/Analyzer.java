package yegorf.ObjectDef.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import yegorf.ObjectDef.entities.Animal;
import yegorf.ObjectDef.entities.Matches;
import yegorf.ObjectDef.entities.Sign;
import yegorf.ObjectDef.repos.AnimalRepo;
import yegorf.ObjectDef.repos.MatchesRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class Analyzer {


//    @Autowired
//    private SignRepo signRepo;
//    @Autowired
//    private AnimalRepo animalRepo;
//    @Autowired
//    private MatchesRepo matchesRepo;
//
//    public  String analyzeAnswers(ArrayList<Integer> list) {
//        HashSet<Animal> animals = animalRepo.findAll();
//        int count = 0;
//        int maxCount = 0;
//
//        for(Animal e : animals) {
//            HashSet<Matches> matches = matchesRepo.findAllByAnimal(e);
//            for(Matches m : matches) {
//                for(Integer i : list) {
//                    if(m.getSign().getId() == i) {
//                        count ++;
//                        if(maxCount < count) {
//                            maxCount = count;
//                        }
//                    }
//                }
//            }
//            if (count == 2) {
//                return e.getAnimal();
//            }
//        }
//        return String.valueOf(count);
//    }
//
//    public void analyzeResult(ArrayList<Integer> list) {
//        String result = analyzeAnswers(list);
//
//        switch (result) {
//            case "0":
//                System.out.println("Нема");
//                //Ввести название и 2 его признака (тупо добавление)
//                break;
//            case "1":
//                System.out.println("Один");
//                //Ввести название и 1 его признак (нужно вернуть и название первого признака)
//                break;
//            default:
//                System.out.println(result);
//                //Вывести результат
//                break;
//        }
//        HashSet<Sign> signs = signRepo.findAll();
//        for (Sign s : signs) {
//            System.out.println(s.getSign());
//        }
//    }
//
//    public static void addTwo(String sign1, String sign2, String entity) {
//
//    }
}
