package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import org.fundacionjala.devops.bootcamp.GameLogic.DifficultyLevels;

import java.util.Map;

public class AvailableLevelsFormat extends AvailableLevels{
    DifficultyLevels dL;

    public AvailableLevelsFormat (DifficultyLevels dL){
        this.dL=dL;
    }

    @Override
    protected Map<Integer, Map<Integer, Integer>> printLevels() {
        return dL.getLevels();
    }
}
