package org.fundacionjala.devops.bootcamp;

import org.fundacionjala.devops.bootcamp.Move.MoveEast;
import org.fundacionjala.devops.bootcamp.Move.MoveNorth;
import org.fundacionjala.devops.bootcamp.Move.MoveSouth;
import org.fundacionjala.devops.bootcamp.Move.MoveWest;

public class Movement {

    private Position position;
    private String direction;
    private String movementStorage;

    public Movement(Position position, String direction) {
        this.position = position;
        this.direction = direction;
    }

    public Movement() {

    }

    public Position getPosition() {
        return position;
    }

    public String getDirection() {
        return direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    //Method to check if the movement is valid:
    public boolean isValidMovement(String position, String direction) {
        String[] positionArray = position.split(",");
        int row = Integer.parseInt(positionArray[0]);
        int column = Integer.parseInt(positionArray[1]);
        if (direction.equals("N")){
            if(row == 0) {
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                System.out.println("You can't go up!");
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                return false;
            }
        }else if(direction.equals("S")){
            if(row == 3) {
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                System.out.println("You can't go down!");
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                return false;
            }
        }else if(direction.equals("E")){
            if(column == 3) {
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                System.out.println("You can't go right!");
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                return false;
            }
        }else if(direction.equals("O")){
            if(column == 0) {
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                System.out.println("You can't go left!");
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                return false;
            }
        }
        return true;
    }
    //Method that receive the position of zero in the board, and return a String with the possible movements:
    public String posibleMovements(int[][] board) {
        String movements = "You can go to: ";
        Position newPosition= new Position();
        String zeroPosition= String.valueOf(newPosition.getHolePosition());
        int boardSize = board.length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    System.out.println("The position of the zero is: " + (i+1) + "," + (j+1));
                    if (i == 0) {
                        movements += "S ";
                    }else if (i == boardSize - 1) {
                        movements += "N ";
                    }else{
                        movements += "N, S ";
                    }
                    if (j == 0) {
                        movements += ", E ";
                    }else if (j == boardSize - 1) {
                        movements += ", O ";
                    }else{
                        movements += ", O, E ";
                    }
                }
            }
        }
        System.out.println(movements);
        return movements;
    }
    //Method to move the zero, that receive the board and the movement("N", "S", "E" or "O"):
    public int moveZero(int[][] board, String movement) {
        String holePosition = findZero(board);
        if(isValidMovement(holePosition, movement)) {
            if(movement.equals("N")){
                MoveNorth N = new MoveNorth();
                N.execute(board);
            }else if(movement.equals("S")){
                MoveSouth S = new MoveSouth();
                S.execute(board);
            }else if(movement.equals("E")){
                MoveEast E = new MoveEast();
                E.execute(board);
            }else if(movement.equals("O")){
                MoveWest O = new MoveWest();
                O.execute(board);
            }
        }
        return 0;
    }

    //Check which is the position of the 0 in the board:
    public String findZero(int[][] board) {
        String position = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    position+=i+","+j;
                }
            }
        }
        //System.out.println("position of Zero is: "+position);
        return position;

    }

    public String toString() {
        return "Movement: " + position.toString() + " " + direction;
    }

    public String randomMovement() {
        String[] movements = {"N", "S", "E", "O"};
        int random = (int) (Math.random() * movements.length);
        return movements[random];
    }

    public void setMovementStorage(String userChoice) {
        movementStorage += ","+ userChoice;
    }

    public String getMovementStorage() {
        return movementStorage;
    }

}

