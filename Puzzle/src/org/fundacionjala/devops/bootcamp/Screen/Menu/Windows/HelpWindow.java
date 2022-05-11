package org.fundacionjala.devops.bootcamp.Screen.Menu.Windows;

import org.fundacionjala.devops.bootcamp.Basics.Movement;

import java.util.Arrays;
import java.util.Scanner;

// HelperWindow?
public class HelpWindow {
    Movement mov;

    Scanner sc = new Scanner(System.in);

    public HelpWindow (Movement mov){
        this.mov=mov;
    }

    public void undo(int movements) {
        for (int i = 0; i<movements;i++){
            int [] lastMove = mov.getMovementStorage().pop();
            mov.undo(lastMove);
        }
    }

    public void hWindow(){
        System.out.println("=================================================================================");
        System.out.println("                                 PUZZElZILLA");
        System.out.println("=================================================================================");
        System.out.println("This may help you:");
        System.out.println(" ");
        System.out.println("1. Back to the beginning");
        System.out.println("2. Get the correct way to solve the puzzle");
        System.out.println("3. back");

        int option=0;

        while (option != 3){
            option=sc.nextInt();

            if (option==1){
                int initialFigure = (int) (mov.getMovementStorage().stream().count() - mov.getInitialCustomShuffle());
                undo(initialFigure);
                option = 3;
            } else if(option==2){
                System.out.println("These is the path to solve the puzzle: ");
                mov.getMovementStorage().stream().forEach(x-> System.out.println(Arrays.toString(x)));
                option=3;
            }
        }
    }
}
