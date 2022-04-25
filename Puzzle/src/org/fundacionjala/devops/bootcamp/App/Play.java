package org.fundacionjala.devops.bootcamp.App;


import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.Position;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;
import org.fundacionjala.devops.bootcamp.Basics.Timer;
import org.fundacionjala.devops.bootcamp.GameLogic.DifficultyLevels;
import org.fundacionjala.devops.bootcamp.GameLogic.Game;
import org.fundacionjala.devops.bootcamp.Screen.Menu.HomeSOptions;
import org.fundacionjala.devops.bootcamp.Screen.Menu.HomeScreenFormatI;
import org.fundacionjala.devops.bootcamp.Screen.ScreenSections;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Play extends Thread {

    static ScreenSections ss = new HomeScreenFormatI();
    static HomeSOptions menuOptions = new HomeSOptions();
    static TableTop table;
    static DifficultyLevels Dlevels = new DifficultyLevels();
    static Movement mov;


    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        menuOptions.initializeOptions();

        int option=0;
        int option2=0;
        int optionCounter=1;

        while(option != menuOptions.getOptions().get(0).size()) {
            System.out.println(ss.print());

            for (String in : menuOptions.getOptions().get(0)) {
                System.out.println(optionCounter + ". " + in);
                optionCounter++;
            }

            option = sc.nextInt();


            while (option2 != menuOptions.getOptions().get(option).size()) {
                for (int in : menuOptions.getOptions().keySet()){
                    if (option==in){
                        if(option!=1) {
                            optionCounter = 1;
                            System.out.println(ss.print());

                            for (String submenu : menuOptions.getOptions().get(option)) {

                                System.out.println(optionCounter + ". " + submenu);
                                optionCounter++;

                            }

                            option2 = sc.nextInt();

                            gameManager(option, option2);
                        }else {
                            theGame();
                        }
                    }
                }



            }


        }

    }

    static void gameManager(int option, int option2){


    }

    static void go(int go){
        Position zero = new Position(table);

        Map<Integer, int[]> theMove = mov.possibleMoves(zero.getPosition());
        if(theMove.keySet().contains(go)){
            mov.move(theMove.get(go));
        }else {
            System.out.println("movement not possible");
        }

    }

    static void theGame(){

        Dlevels.initializeLevels();
        System.out.println(ss.print());
        System.out.println("Please enter your username: ");
        sc.nextLine();
        String username = sc.nextLine();
        System.out.println("Please select the level:");

        for (int in : Dlevels.getLevels().keySet()){
            for (Map.Entry<Integer, Integer> at : Dlevels.getLevels().get(in).entrySet()) {
                System.out.println("Level " + "[" + in + "]" + ":" + at.getKey() + " minutes, " + at.getValue() + " rows and columns.");
            }
        }

        int optionLevel = sc.nextInt();
        int optionGame = 0;
        int minutes=0;
        int rows=0;

        for (Map.Entry<Integer, Integer> in : Dlevels.getLevels().get(optionLevel).entrySet()){
            minutes=in.getKey();
            rows = in.getValue();
        }
        Timer time = new Timer(minutes);
        time.start();
        table = new TableTop(rows,rows);
        table.initializeTable();
        table.shuffle();
        Position zero = new Position(table);
        mov = new Movement(table, zero);
        Game game = new Game(table, mov);

        while (optionGame != 6){

            System.out.println(ss.print());
            System.out.println("User: " + username +"          "+ "Level: " + optionLevel +"          "+ "Time: "+time.getMinutes()+":"+time.getSeconds()+"          "+"Figures in place: "+game.gameStatus());
            System.out.println(" ");
            System.out.println(" ");
            table.consoleTable();
            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Possible moves:   ");

            for (Map.Entry<Integer, int[]> in : mov.possibleMoves(zero.getPosition()).entrySet()){
                System.out.print(Arrays.toString(in.getValue()) + "     ");
            }

            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("1. Up"+"      "+"2. Down"+"      "+"3.Left"+"      "+"4.Right"+"      "+"5. back"+"      "+"6. exit");
            optionGame= sc.nextInt();

            go(optionGame);

        }

    }


}
