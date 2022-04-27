package org.fundacionjala.devops.bootcamp.AsisstedBoard;


import org.fundacionjala.devops.bootcamp.History.MovementsHistory;
import org.fundacionjala.devops.bootcamp.Move.Movement;
import org.fundacionjala.devops.bootcamp.NormalBoard.Board;

import java.util.Scanner;

public class AiMenu {
    public void run() {
        Board puzzle = new Board();
        System.out.println("please enter the size of the board");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        puzzle.createBoard(size);
        Movement movement = new Movement();
        MovementsHistory history = new MovementsHistory();
        AIBuilder aiBuilder = new AIBuilder(history);

        int[][] prueba = puzzle.getShuffled();
        System.out.println("Lets create ZERO position,...");
        System.out.println("Enter the ROW where ZERO will be:");
        int row = scanner.nextInt();
        System.out.println("Now enter the COLUMN where ZERO will be:");
        int column = scanner.nextInt();
        int realRow=row-1;
        int realColumn=column-1;
        aiBuilder.setUserZero(prueba, realRow, realColumn);
        System.out.println("**************************");
        System.out.println("Board created with the Zero at "+row +","+column);
        System.out.println("**************************");
        System.out.println("How many random movements to switch ZERO position?");
        int amount= scanner.nextInt();
        aiBuilder.runRandomMovements(amount);
        System.out.println("**************************");
        System.out.println("Game begins!!");
        System.out.println("**************************");
        System.out.println("Movements randomly made:");
        history.getMovementsOption();
        System.out.println("**************************");
        System.out.println("Movements options are:");
        System.out.println("NORTH: N, SOUTH: S, EAST: E, WEST: W;");
        System.out.println("Press H to help, or press q to quit");
        String userChoice = "";
        scanner.nextLine();
        while (!userChoice.equals("q")) {
            puzzle.print();
            System.out.println("=======================");
            movement.posibleMovements(prueba);
            System.out.println("=======================");
            System.out.println("Please enter your move:");
            userChoice = scanner.nextLine();
            if (userChoice.equals("q")) {
                System.out.println("=======================");
                System.out.println("Game Over!!");
                break;
            }
            if (userChoice.equals("H")) {
                System.out.println("=======================");
                System.out.println("Movements that where made are:");
                history.getMovementsOption();
                System.out.println("How many movements do you want to roll back?");
                int rollBack = scanner.nextInt();
                String rollBackMovement = history.rollBack(rollBack);
                //history.rollBack(rollBack);
                movement.rollBackBoard(prueba, rollBackMovement);
                userChoice = "";
            }

            int isValid = movement.moveZero(prueba, userChoice);
            if(isValid==1){
                history.setMovementsOption(userChoice);
            }
            System.out.println("=======================");
            System.out.println("Movements made:");
            history.getMovementsOption();
            System.out.println("=======================");
        }
    }
}
