package org.fundacionjala.devops.bootcamp.cesarillanes.game;

import java.util.Random;
import java.util.Stack;

public class ConcreteBoard implements Board{

    private final Random randomizer = new Random();
    private final int size;
    private final int blocks;
    private int holePosition;
    private int holePositionOriginal;
    private final int[] arrayOfBlocks;
    private final String[] moves = {"up ^", "down v", "left <", "right >"};
    private final Stack<int[]> stack = new Stack<>();

    private ConcreteBoard(int size){
        this.size = size;
        this.blocks = size*size-1;
        arrayOfBlocks = new int[size*size];
    }

    public static ConcreteBoard of(int size){
        return new ConcreteBoard(size);
    }

    public void resetBoard(int holePosition){
        int value = 1;
        for(int i = 0; i < arrayOfBlocks.length; i++){
            arrayOfBlocks[i] = value++;
        }
        if(holePosition != -1) {
            arrayOfBlocks[holePosition] = 0;
            this.holePosition = holePosition;
            this.holePositionOriginal = holePosition;
        }
    }

    public boolean[] checkMoves(){
        boolean[] indexes = new boolean[4];
        //up
        indexes[0] = holePosition - size >= 0;
        //down
        indexes[1] = holePosition + size < size*size;
        //left
        indexes[2] = holePosition % size - 1 >= 0;
        //right
        indexes[3] = holePosition % size + 1 < size;
        return indexes;
    }

    public void printOptions(){
        StringBuilder response = new StringBuilder();
        boolean[] indexes = checkMoves();
        for(int i = 0; i < indexes.length; i ++){
            if(indexes[i]){
                response.append("It can go ").append(moves[i]).append("\n");
            }
        }
        System.out.println(response.toString());
    }

    public int[] move(int direction){
        if(!checkMoves()[direction]){
            //System.out.println("This move can't be done.");
            return null;
        }
        int[] exchange = new int[2];
        int tmp;
        int newHolePosition = 0;
        if(direction == 0){ //Up
            newHolePosition = holePosition-size;
            tmp = arrayOfBlocks[newHolePosition];
            arrayOfBlocks[newHolePosition] = 0;
            arrayOfBlocks[holePosition] = tmp;
        } else if (direction == 1){//Down
            newHolePosition = holePosition+size;
            tmp = arrayOfBlocks[newHolePosition];
            arrayOfBlocks[newHolePosition] = 0;
            arrayOfBlocks[holePosition] = tmp;
        } else if (direction == 2){//Left
            newHolePosition = holePosition-1;
            tmp = arrayOfBlocks[newHolePosition];
            arrayOfBlocks[newHolePosition] = 0;
            arrayOfBlocks[holePosition] = tmp;
        } else if(direction == 3) {//Right
            newHolePosition = holePosition+1;
            tmp = arrayOfBlocks[newHolePosition];
            arrayOfBlocks[newHolePosition] = 0;
            arrayOfBlocks[holePosition] = tmp;
        }
        exchange[0] = holePosition;
        exchange[1] = newHolePosition;
        holePosition = newHolePosition;
        stack.push(exchange);
        return exchange;
    }

    public void shuffleBoard(int quantity, int holePosition){
        resetBoard(holePosition);
        int i = 0;
        while(i < quantity){
            int rand = randomizer.nextInt(4);
            if(move(rand) != null) i++;
        }
    }

    public void undo(int quantity){
        if(quantity > stack.size()){
            System.out.println("You can't undo too many steps.");
            return;
        }
        for(int i = 0; i < quantity; i++){
            int[] tuple = stack.pop();
            int tmp = arrayOfBlocks[tuple[0]];
            arrayOfBlocks[tuple[0]] = arrayOfBlocks[tuple[1]];
            arrayOfBlocks[tuple[1]] = tmp;
            holePosition = tuple[0];
            printBoard();
        }
    }

    public int numbersToUndo(){
        return stack.size();
    }

    public boolean solved(){
        if(holePositionOriginal != holePosition){
            return false;
        }
        for (int i = blocks - 1; i >= 0; i--){
            if(arrayOfBlocks[i] != i+1 && i != holePosition){
                return false;
            }
        }
        return true;
    }

    public void printBoard(){
        for(int i = 0; i < size*size; i++){
            if(i % size == 0){
                System.out.println();
            }
            System.out.print(arrayOfBlocks[i] + "\t");
        }
        System.out.println();
    }

}
