package org.fundacionjala.devops.bootcamp;

import org.fundacionjala.devops.bootcamp.Move.Movement;
import org.fundacionjala.devops.bootcamp.Move.Position;
import org.fundacionjala.devops.bootcamp.NormalBoard.Board;

import java.util.Scanner;

public class UserMenu {

    public void run() {
        Board puzzle = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the size of the Board:");
        int size = scanner.nextInt();
        puzzle.createBoard(size);
        puzzle.shuffle(); // Mezcla el tablero
        int[][] prueba = puzzle.getShuffled(); // Obtiene el tablero mezclado
        Movement movement = new Movement();
        Position position = new Position();
        position.setHolePosition(movement.findZero(prueba));

        String userChoice = "";
        System.out.println("Movements options are:");
        System.out.println("NORTH: N, SOUTH: S, EAST: E, WEST: W; or press q to quit");
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
            movement.moveZero(prueba, userChoice);


       }
    }
}


