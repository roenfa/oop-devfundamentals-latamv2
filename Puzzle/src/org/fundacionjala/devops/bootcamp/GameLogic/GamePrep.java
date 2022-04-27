package org.fundacionjala.devops.bootcamp.GameLogic;

import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;
import org.fundacionjala.devops.bootcamp.Basics.Timer;
import org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes.AvailableLevelsFormat;
import org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes.ComponentsFormat;
import org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes.GameOptionsFormat;
import org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes.Indicators;
import org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent.ConsoleConstants;
import org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent.TextHeaders;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class GamePrep {
    ConsoleConstants textHeaders;
    DifficultyLevels dL;
    TableTop table;
    Movement mov;
    Game game;
    Timer time;

    Scanner sc = new Scanner(System.in);

    public GamePrep (ConsoleConstants textHeaders, DifficultyLevels dL, TableTop table, Movement mov,Game game, Timer time ){
        this.textHeaders =textHeaders;
        this.dL=dL;
        this.table=table;
        this.mov=mov;
        this.game=game;
        this.time = time;
    }



    public void getUser (){

    }




}
