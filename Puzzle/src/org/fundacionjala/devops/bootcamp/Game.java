package org.fundacionjala.devops.bootcamp;



import org.fundacionjala.devops.bootcamp.AsisstedBoard.AiMenu;

import java.util.Scanner;

public class  Game {

    public static void main(String[] args) {
        UserMenu menu = new UserMenu();
        AiMenu aiMenu = new AiMenu();
        int level=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Welcome to SLIDE PUZZLE!");
        System.out.println("=======================");

        System.out.println("Please select the difficulty level:");
        System.out.println("1. Easy");
        System.out.println("2. Normal");
        System.out.println("0. Exit Game");
        System.out.println("=======================");
        level = scanner.nextInt();
        if(level ==1){
            aiMenu.run();
        }else if(level ==2){
            menu.run();
        }else if(level ==0){
            System.out.println("=======================");
            System.out.println("Thank you for playing!");
            System.out.println("=======================");
        }
    }
}
