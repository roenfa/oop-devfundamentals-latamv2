package org.fundacionjala.devops.bootcamp;

import org.fundacionjala.devops.bootcamp.Move.Movement;
import org.fundacionjala.devops.bootcamp.Move.Position;
import org.fundacionjala.devops.bootcamp.NormalBoard.Board;

import java.util.Scanner;

public class UserMenu {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("Welcome to SLIDE PUZLE!");
        System.out.println("=======================");

        Board puzzle =new Board();
        puzzle.createBoard(4);

        System.out.println("=======================");
        System.out.println("Here is your Board:");
        System.out.println("=======================");
        puzzle.shuffle(); // Mezcla el tablero
        puzzle.print();

        int [][] prueba =puzzle.getShuffled(); // Obtiene el tablero mezclado
        System.out.println("=======================");
        Movement movement = new Movement();
        Position position = new Position();
        position.setHolePosition(movement.findZero(prueba));

        String userChoice="";
        while(!userChoice.equals("q")) {
            System.out.println("=======================");
            movement.posibleMovements(prueba);
            System.out.println("=======================");
            System.out.println("Please enter your move:");
            System.out.println("NORTH: N, SOUTH: S, EAST: E, WEST: W; or press q to quit");
            System.out.println("=======================");
            userChoice = scanner.nextLine();
            movement.moveZero(prueba, userChoice);
            puzzle.print();
            System.out.println("=======================");
        };

    }
}


