package yegorf.ObjectDef.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yegorf.ObjectDef.entities.Entity;
import yegorf.ObjectDef.entities.Match;
import yegorf.ObjectDef.repos.EntityRepo;
import yegorf.ObjectDef.repos.MatchRepo;
import yegorf.ObjectDef.repos.SignRepo;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class Analyzer {
    private static SignRepo signRepo = null;
    private static EntityRepo entityRepo = null;
    private static MatchRepo matchRepo = null;

    @Autowired
    public Analyzer(SignRepo signRepo, MatchRepo matchRepo, EntityRepo entityRepo) {
        this.signRepo = signRepo;
        this.matchRepo = matchRepo;
        this.entityRepo = entityRepo;
    }

    public static int analyzeAnswers(ArrayList<Integer> list) {
        HashSet<Entity> entities = entityRepo.findAll();
        int count = 0;

        for(Entity e : entities) {
            HashSet<Match> matches = matchRepo.findAllByEntity(e);
            for(Match m : matches) {
                for(Integer i : list) {
                    if(m.getSign().getId() == i) {
                        count ++;
                    }
                }
            }
        }
        return count;
    }

}
