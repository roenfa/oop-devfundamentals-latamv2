package org.fundacionjala.devops.bootcamp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Game {

    public void run(){
        Board board = new Board();
        FastReader fastReader = new FastReader();
        System.out.println("Set the size of the board");
        int var=fastReader.nextInt();

        board.buildBoard(var);
        System.out.println("Set the initial position");
        int x=fastReader.nextInt();
        int y=fastReader.nextInt();
        board.posIni(x,y);
        Movement movement = new Movement(board);
        while(true){
            board.print();
            movement.printNextMoves();
            int move=fastReader.nextInt();
            movement.move(move);
        }
//        board.suffle();
//        movement.nextMoves();
//        board.print();
//        movement.printNextMoves();

    }

}
