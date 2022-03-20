package controller;

import config.AppConfig;
import model.Score;

import java.util.*;

public class ScoreLogic {

    AppConfig appConfig = new AppConfig();
    Score score = appConfig.score();
    HashMap<Long, Integer> resultList = new LinkedHashMap<>();

    public HashMap<Long, Integer> sortByAscend(HashMap<Long, Integer> scoreList) {
        List<Map.Entry<Long, Integer>> entries = new LinkedList<>(scoreList.entrySet());
        Collections.sort(entries, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return -1;
            } else if (o1.getValue() < o2.getValue()) {
                return 1;
            }
            return o1.getKey().compareTo(o2.getKey());
        });
        for (Iterator<Map.Entry<Long, Integer>> iter = entries.iterator(); iter.hasNext();) {
            Map.Entry<Long, Integer> entry = iter.next();
            resultList.put(entry.getKey(), entry.getValue());
        }
        return resultList;
    }

}