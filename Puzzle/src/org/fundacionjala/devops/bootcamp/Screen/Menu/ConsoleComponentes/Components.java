package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.Timer;
import org.fundacionjala.devops.bootcamp.GameLogic.DifficultyLevels;
import org.fundacionjala.devops.bootcamp.GameLogic.Game;

abstract class Components implements Indicators {

    @Override
    public String print(){

        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append(printUser());
        builder.append(printSpace());
        builder.append(printLevel());
        builder.append(printSpace());
        builder.append(printTime());
        builder.append(printSpace());
        builder.append(printInPlace());
        builder.append("\n");
        return builder.toString();
    }

    protected abstract String printSpace();
    protected abstract String printUser();
    protected abstract String printLevel();
    protected abstract String printTime();
    protected abstract String printInPlace();
}
