package org.fundacionjala.devops.bootcamp.Move;

public class Movement {

    private Position position;
    private String direction;
    int size;

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
    public boolean isValidMovement(String position, String direction,int size) {
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
            if(row == size-1) {
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                System.out.println("You can't go down!");
                System.out.println("XXXXXXXXXXXXXXXXXXX");
                return false;
            }
        }else if(direction.equals("E")){
            if(column == size-1) {
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
        size= board.length;
        if(isValidMovement(holePosition, movement,size)) {
            if(movement.equals("N")){
                NorthMove N = new NorthMove();
                N.execute(board);
                return 1;
            }else if(movement.equals("S")){
                SouthMove S = new SouthMove();
                S.execute(board);
                return 1;
            }else if(movement.equals("E")){
                EastMove E = new EastMove();
                E.execute(board);
                return 1;
            }else if(movement.equals("O")){
                WestMove O = new WestMove();
                O.execute(board);
                return 1;
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
        return position;
    }

    public String randomMovement() {
        String[] movements = {"N", "S", "E", "O"};
        int random = (int) (Math.random() * movements.length);
        return movements[random];
    }

    public void rollBackBoard(int[][] board,String commands) {
        String[] commandsArray = commands.split(" ");
        for (int i = 0; i < commandsArray.length; i++) {
            if(commandsArray[i].equals("N")){
                System.out.println("-------------------------");
                System.out.println("Rolling back N movement, moving South");
                SouthMove S = new SouthMove();
                S.execute(board);
            }else if(commandsArray[i].equals("S")){
                System.out.println("-------------------------");
                System.out.println("Rolling back S movement, moving North");
                NorthMove N = new NorthMove();
                N.execute(board);
            }else if(commandsArray[i].equals("E")){
                System.out.println("-------------------------");
                System.out.println("Rolling back E movement, moving West");
                WestMove W = new WestMove();
                W.execute(board);
            }else if(commandsArray[i].equals("O")){
                System.out.println("-------------------------");
                System.out.println("Rolling back O movement, moving East");
                EastMove E = new EastMove();
                E.execute(board);
            }
        }
    }

    public String toString() {
        return "Movement: " + position.toString() + " " + direction;
    }





}

