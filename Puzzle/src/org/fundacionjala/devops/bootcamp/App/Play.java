package org.fundacionjala.devops.bootcamp.App;


import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;
import org.fundacionjala.devops.bootcamp.Basics.Timer;
import org.fundacionjala.devops.bootcamp.GameLogic.DifficultyLevels;
import org.fundacionjala.devops.bootcamp.GameLogic.Game;
import org.fundacionjala.devops.bootcamp.GameLogic.GamePrep;
import org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes.*;
import org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent.ConsoleConstants;
import org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent.TextHeaders;
import org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent.TextOptions;
import org.fundacionjala.devops.bootcamp.Screen.Menu.Windows.HelpWindow;
import org.fundacionjala.devops.bootcamp.utils.RandomNumber;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Play {

    static ConsoleConstants menuOptions = new TextOptions();
    static TableTop table;
    static DifficultyLevels Dlevels = new DifficultyLevels();
    static Movement mov;
    static Timer time;
    static Game game;
    static ConsoleConstants textHeaders = new TextHeaders();
    static Indicators indicators;

    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        menuOptions.initializeOptions();
        textHeaders.initializeOptions();

        int option=0;
        int option2=0;


        while(option != menuOptions.getIt().get(option).size()) {
            option2=0;

            textHeaders.getIt().get(0).stream().forEach(System.out::println);
            menuOptions.getIt().get(0).stream().forEach(System.out::println);

            option = sc.nextInt();

            while (option2 != menuOptions.getIt().get(option).size()) {
                textHeaders.getIt().get(option).stream().forEach(System.out::println);
                menuOptions.getIt().get(option).stream().forEach(System.out::println);
                option2= sc.nextInt();

                gameManager(option, option2);

            }
        }

    }

    static String gameManager(int option, int option2){

        if (option == 1 && option2 == 1){
            gamePrep();
        }else if (option == 1 && option2==2){
            return null;
        }

        return null;
    }

    static void gamePrep(){

        RandomNumber utils = new RandomNumber();
        Dlevels.initializeLevels();

        textHeaders.getIt().get(10).stream().forEach(System.out::print);
        sc.nextLine();
        String username=sc.nextLine();


        textHeaders.getIt().get(11).stream().forEach(System.out::println);
        Indicators availableLevels = new AvailableLevelsFormat(Dlevels);
        System.out.println(availableLevels.print());

        int optionLevel = sc.nextInt();
        int minutes=0;
        int rows=0;

        for (Map.Entry<Integer, Integer> in : Dlevels.getLevels().get(optionLevel).entrySet()){
            minutes=in.getKey();
            rows = in.getValue();
        }

        table = new TableTop(rows, rows);
        table.setRows(rows);
        table.setColumns(rows);
        mov = new Movement(table);

        textHeaders.getIt().get(12).stream().forEach(System.out::println);
        System.out.print("x: ");
        int x= sc.nextInt();
        System.out.print("y: ");
        int y = sc.nextInt();

        int[] zero = new int[2];
        zero[0]=x;
        zero[1]=y;

        System.out.print("#Shuffle: ");
        int sMoves = sc.nextInt();

        game = new Game(table, mov, username);

        table.initialTable(zero);

        mov.setInitialCustomShuffle(sMoves);

        for(int i=0;i<sMoves;i++){
            Map<Integer, int[]> movesToPlay = mov.possibleMoves(table.getZero());
            ArrayList<Integer> index = new ArrayList<>();
            for (Integer in: movesToPlay.keySet()){
                index.add(in);
            }
            mov.move(movesToPlay.get(index.get(utils.pickRandomOption(movesToPlay)-1)));
        }
        time = new Timer();
        time.setMinutes(minutes);
        time.start();
        start();
    }

    static void start(){

        indicators = new ComponentsFormat(time, Dlevels, mov, game);
        Indicators gameOptions = new GameOptionsFormat();
        HelpWindow hWindow = new HelpWindow(mov);

        int optionGame =0;
        while (optionGame != 6){
            textHeaders.getIt().get(13).stream().forEach(System.out::println);
            System.out.println(indicators.print());

            table.consoleTable();

            System.out.println(gameOptions.print());

            optionGame= sc.nextInt();
            if(optionGame>0 && optionGame<=4){
                go(optionGame);
            }else if(optionGame==5){
                hWindow.hWindow();
            }
        }
    }

    static void go(int go){

        Map<Integer, int[]> theMove = mov.possibleMoves(table.getZero());
        if(theMove.keySet().contains(go)){
            mov.move(theMove.get(go));
        }else {
            System.out.println("movement not possible");
        }

    }


}
