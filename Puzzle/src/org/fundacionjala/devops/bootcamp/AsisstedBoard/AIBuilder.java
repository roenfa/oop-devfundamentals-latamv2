package org.fundacionjala.devops.bootcamp.AsisstedBoard;

import org.fundacionjala.devops.bootcamp.History.MovementsHistory;
import org.fundacionjala.devops.bootcamp.Move.Movement;

import java.util.Map;

public class AIBuilder {
    private int[][] matrix;

    public AIBuilder() {
    }

    public void setUserZero(int[][] matrix,int row, int column) {
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == row && j == column) {
                    int valueToReplace = matrix[i][j];
                    matrix[i][j] = 0;
                    matrix[3][3] = valueToReplace;
                }
            }
        }

    }

    public void runRandomMovements(int quantity){
        Movement movement = new Movement();
        MovementsHistory movementsHistory;
        String nextMovement;
        int isValid=0;
        for (int i = 0; i < quantity; i++) {
            nextMovement = movement.randomMovement();
            System.out.println("New random movement: " + nextMovement);
            movementsHistory = new MovementsHistory();
            isValid=movement.moveZero(matrix,nextMovement);
            if(isValid==1){
                movementsHistory.setMovementsOption(nextMovement);
            }else{
                quantity +=1;
            }

        }
    }




}


