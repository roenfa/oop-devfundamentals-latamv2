package org.fundacionjala.devops.bootcamp;

import org.fundacionjala.devops.bootcamp.AsisstedBoard.AIBuilder;
import org.fundacionjala.devops.bootcamp.History.MovementsHistory;
import org.fundacionjala.devops.bootcamp.NormalBoard.Board;

public class  Game {

    public static void main(String[] args) {
        Board board = new Board();
        AIBuilder aiBuilder = new AIBuilder();
        int [][] prueba = board.createBoard(4);
        aiBuilder.setUserZero(prueba,2,2);
        System.out.println("**************************");
        System.out.println("Board created with the Zero at 3,3:");
        System.out.println("**************************");
        board.print();
        System.out.println("**************************");
        aiBuilder.runRandomMovements(5);
        System.out.println("Movements randomly made:");
        MovementsHistory history = new MovementsHistory();
        history.getMovementsOption();
        board.print();

    }
}
