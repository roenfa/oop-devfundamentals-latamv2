package org.fundacionjala.devops.bootcamp.GameLogic;

import java.util.HashMap;
import java.util.Map;

// Level as class name please...
public class DifficultyLevels {

    //level - time - rows
    // add access modifiers...
    Map<Integer, Map<Integer, Integer>> levels = new HashMap<>();
    int currentLevel;

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

    // if this function is not used anymore, please remove it
    public void createLevel(int level, int time, int rows){

        Map<Integer, Integer> customLevel = new HashMap<>();
        customLevel.put(time, rows);

        if(levels.keySet().contains(level)) {
            System.out.println("level already exist");
        } else {
            levels.put(level, customLevel);
        }
    }

    public Map<Integer, Map<Integer, Integer>> getLevels() {
        return levels;
    }
    public int getCurrentLevel() {
        return currentLevel;
    }

    // remove function if is not needed anymore
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}