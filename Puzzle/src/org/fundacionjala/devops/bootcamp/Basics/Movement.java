package org.fundacionjala.devops.bootcamp.Basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Movement {
    TableTop table;
    int initialCustomShuffle;
    Stack<int[]> movementStorage = new Stack<>();

    public Movement(TableTop table){
        this.table=table;
    }

    public Map<Integer, int[]> possibleMoves(int[]currPos){

        Map<Integer, int[]> moves = new HashMap<>();


        if(currPos[0]>1){
            int [] up = new int[2];
            up[0]=currPos[0]-1;
            up[1]=currPos[1];
            moves.put(1, up);
        }

        if(currPos[0]<table.getRows()){
            int [] down = new int[2];
            down[0]=currPos[0]+1;
            down[1]=currPos[1];
            moves.put(2, down);
        }

        if(currPos[1]>1){
            int [] left = new int[2];
            left[0]=currPos[0];
            left[1]=currPos[1]-1;

            moves.put(3, left);

        }
        if(currPos[1]<table.getColumns()){
            int [] right = new int[2];
            right[0]=currPos[0];
            right[1]=currPos[1]+1;

            moves.put(4, right);
        }
        return moves;
    }

    public void move(int[] option) {

        int destiny = table.getTable()[option[0]-1][option[1]-1];
        int [] origin = table.getZero();

        table.getTable()[origin[0]-1][origin[1]-1]=destiny;
        table.getTable()[option[0]-1][option[1]-1]=0;

        movementStorage.add(origin);

    }
    public void undo(int[] option) {

        int destiny = table.getTable()[option[0]-1][option[1]-1];
        int [] origin = table.getZero();

        table.getTable()[origin[0]-1][origin[1]-1]=destiny;
        table.getTable()[option[0]-1][option[1]-1]=0;

    }

    public int getInitialCustomShuffle() {
        return initialCustomShuffle;
    }

    public void setInitialCustomShuffle(int initialCustomShuffle) {
        this.initialCustomShuffle = initialCustomShuffle;
    }

    public Stack<int[]> getMovementStorage() {
        return movementStorage;
    }
}
