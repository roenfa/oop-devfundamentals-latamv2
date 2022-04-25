package org.fundacionjala.devops.bootcamp.Registry;

import org.fundacionjala.devops.bootcamp.Movement;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    //method to generate random moves and execute them:
    Map<Integer, Map<Integer,Integer>> randomMoves = new HashMap<>(5);

    private Map<Integer, Map<Integer,Integer>> makeRandomMoves(int [][]board ,int quantity){
        //move the zero to the random position ("N", "S", "E" or "O"):
        Movement movement = new Movement();
        for(int i=0; i<quantity; i++){
            String movementRandom = movement.randomMovement();//"N", "S", "E" or "O"
            movement.moveZero(board, movementRandom);
            randomMoves.put(i, (Map<Integer, Integer>) movement.getPosition());
        }
        return randomMoves;
    }

}
