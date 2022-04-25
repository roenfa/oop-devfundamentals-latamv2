import interfaces.IBoardBuilder;
import entities.Board;

import java.util.*;

public class BoardBuilder implements IBoardBuilder {
    private Board board = new Board();

    public BoardBuilder(Board board) {
        this.board = board;
    }

    public BoardBuilder() {}

    public Board getBoard() {
        return board;
    }

//paso a ingles, sacar el scanner a otra clase

    // Ejecutar 0
    @Override
    public int askUserForBoardSize(){
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Please enter the size of the board: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            number = scanner.nextInt();

        } while (number < 0);

        System.out.printf("You have entered a positive number %d.%n", number);

        number = number * number;

        return number;
    }

    // Ejectutar 1ero
    @Override
    public void putIntoValuesPool(){
        for (int i = 0; i < board.getBoardSize(); i++) {
            board.getPoolValues().add(i);
        }
    }

    // Ejecutar 2do
    @Override
    public void shuffleValuesPool(){
        Collections.shuffle(board.getPoolValues());
    }

    // Ejectutar 3do
    @Override
    public HashMap buildBoard(){
        int boardSideSize = (int) Math.round(Math.sqrt(board.getBoardSize()));
        for (int i = 0; i <  boardSideSize; i++) {
            board.getBoard().put(i, new ArrayList<>());
        }
        return (HashMap) board.getBoard();
    }

    // Ejectutar 4ero
    @Override
    public ArrayList<Integer> putBoardKeysInList(){
        List<Integer> keys = new ArrayList<>();
        for (Integer integer : board.getBoard().keySet()) {
            keys.add(integer);
        }
        return (ArrayList<Integer>) keys;
    }

    // Ejectutar 5to
    @Override
    public void putZeroInLastPositionWhenUnshuffled(){
        for (int i = 0; i < board.getPoolValues().size(); i++) {
            if(board.getPoolValues().get(i)==0){
                board.getPoolValues().remove(i);
                board.getPoolValues().add(0);
            }
        }
    }

    // Ejectutar 5to
    @Override
    public void putZeroInLastPositionWhenShuffled(){
        int sizePoolValores = board.getPoolValues().size();
        for (int i = 0; i < board.getPoolValues().size(); i++) {
            if(board.getPoolValues().get(i)==0){
                int lastValue = board.getPoolValues().get(sizePoolValores-1);
                board.getPoolValues().set( i, lastValue);
                board.getPoolValues().set(sizePoolValores-1, 0);
            }
        }
    }

    // Ejectutar 6to
    @Override
    public void putValuesIntoBoardMap(){
        int boardSide = board.getBoard().size();
        int poolValuesCounter=0;
        for (int i = 0; i < boardSide; i++) {
            for (int j = 0; j < boardSide; j++) {
                board.getBoard().get(i).add(board.getPoolValues().get(poolValuesCounter));
                poolValuesCounter++;
            }
        }
    }

    // Ejecutar 7to
    @Override
    public void printBoard(){
        for (int i = 0; i < board.getBoard().size(); i++) {
            for (int j = 0; j < board.getBoard().get(i).size(); j++) {
                int actualInList = board.getBoard().get(i).get(j);
                System.out.print(actualInList + "\t");
            }
            System.out.println();
        }
    }
}
