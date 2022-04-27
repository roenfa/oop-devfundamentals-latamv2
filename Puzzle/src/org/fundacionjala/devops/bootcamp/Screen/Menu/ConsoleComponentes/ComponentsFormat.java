package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.Timer;
import org.fundacionjala.devops.bootcamp.GameLogic.DifficultyLevels;
import org.fundacionjala.devops.bootcamp.GameLogic.Game;

public class ComponentsFormat extends Components {


    Timer time;
    DifficultyLevels dL;
    Movement mov;
    Game game;

    public ComponentsFormat(Timer time, DifficultyLevels dL, Movement mov, Game game){
        this.time = time;
        this.dL = dL;
        this.mov = mov;
        this.game = game;

    }

    @Override
    protected String printSpace() {
        return "    ";
    }

    @Override
    protected String printUser() {
        return "User: " + game.getPlayer();
    }

    @Override
    protected String printLevel() {
        return "Level: "+ dL.getCurrentLevel();
    }

    @Override
    protected String printTime() {
        String seconds;
        if(time.getSeconds()<10){
            seconds = "0" + String.valueOf(time.getSeconds());
        } else{
            seconds = String.valueOf(time.getSeconds());
        }

        return "Time: "+time.getMinutes()+":"+seconds;
    }

    @Override
    protected String printInPlace() {
        return "Figures in place: "+game.gameStatus();
    }
}
