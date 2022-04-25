package org.fundacionjala.devops.bootcamp.GameLogic;

import java.util.HashMap;
import java.util.Map;

public class DifficultyLevels {

    //level - time - rows
    Map<Integer, Map<Integer, Integer>> levels = new HashMap<>();



    public void initializeLevels (){
        Map<Integer, Integer> levelZero = new HashMap<>();
        Map<Integer, Integer> levelOne = new HashMap<>();
        Map<Integer, Integer> levelTwo = new HashMap<>();

        levelZero.put(8, 3);
        levelOne.put(5,4);
        levelTwo.put(3, 5);

        levels.put(0, levelZero);
        levels.put(1,levelOne);
        levels.put(2, levelTwo);
    }

    public void createLevel(int level, int time, int rows){

        Map<Integer, Integer> customLevel = new HashMap<>();
        customLevel.put(time, rows);

        if(levels.keySet().contains(level)){
            System.out.println("level already exist");
        }else {
            levels.put(level, customLevel);
        }

    }

    public Map<Integer, Map<Integer, Integer>> getLevels() {
        return levels;
    }
}
