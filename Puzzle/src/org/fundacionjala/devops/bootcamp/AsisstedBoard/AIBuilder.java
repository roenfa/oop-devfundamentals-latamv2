package org.fundacionjala.devops.bootcamp.AsisstedBoard;

import org.fundacionjala.devops.bootcamp.History.MovementsHistory;
import org.fundacionjala.devops.bootcamp.Move.Movement;
import org.fundacionjala.devops.bootcamp.NormalBoard.Board;

import java.util.Map;

public class AIBuilder {
    private int[][] matrix;

    MovementsHistory movementsHistory;

    public AIBuilder(MovementsHistory movementsHistory) {
        this.movementsHistory = movementsHistory;
    }


    public void setUserZero(int[][] matrix,int row, int column) {
        this.matrix = matrix;
        int flag=1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == row && j == column) {
                    int valueToReplace = i*matrix.length+j+1;
                    matrix[i][j]=0;
                    matrix[i][j+1]=valueToReplace;
                    j++;
                    flag=0;
                }else{
                    matrix[i][j] = i*matrix.length+j+flag;
                }
            }
        }
    }

    public void runRandomMovements(int quantity){
        Movement movement = new Movement();
        String nextMovement;
        int isValid=0;
        for (int i = 0; i < quantity; i++) {
            nextMovement = movement.randomMovement();
            isValid=movement.moveZero(matrix,nextMovement);
            if(isValid==1){
                movementsHistory.setMovementsOption(nextMovement);
            }else{
                quantity +=1;
            }

        }
    }




}


