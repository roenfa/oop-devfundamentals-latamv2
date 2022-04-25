import interfaces.IBoardBuilder;
import interfaces.IGamePlay;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuUserDecisionImpl;

import java.util.*;

public class GamePlay implements IGamePlay {

    private IBoardBuilder boardBuilder;

    public IBoardBuilder getBoardBuilder() {
        return boardBuilder;
    }

    public void setBoardBuilder(BoardBuilder boardBuilder) {
        this.boardBuilder = boardBuilder;
    }

    public GamePlay(IBoardBuilder boardBuilder) {
        this.boardBuilder = boardBuilder;
    }

    public GamePlay() {}

    // Ejecutar 8vo
    @Override
    public Map<Integer, Integer> findZeroPosition(){
        List<Integer> keys = boardBuilder.putBoardKeysInList();
        Map<Integer, Integer> positionOfZero = new HashMap<>();
        int boardSize = (int) Math.round(Math.sqrt(boardBuilder.getBoard().getBoardSize()));

        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < boardSize; j++) {
                if(boardBuilder.getBoard().getBoard().get(i).get(j) == 0){
                    positionOfZero.put(i, j);
                }
            }
        }
        return positionOfZero;
    }

    // Ejecutar 9no
    @Override
    public Map<Integer, Integer> findNorthPosition(){
        Map<Integer, Integer> northPosition = new HashMap<>();
        List<Integer> keys = boardBuilder.putBoardKeysInList();
        int boardSize = (int) Math.round(Math.sqrt(boardBuilder.getBoard().getBoardSize()));

        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < boardSize; j++) {
                if(boardBuilder.getBoard().getBoard().get(i).get(j) == 0){
                    northPosition.put(i-1, j);
                }
            }
        }

        return northPosition;
    }

    // Ejecutar 10mo
    @Override
    public Map<Integer, Integer> findSouthPosition(){
        Map<Integer, Integer> southPosition = new HashMap<>();
        List<Integer> keys = boardBuilder.putBoardKeysInList();
        int boardSize = (int) Math.round(Math.sqrt(boardBuilder.getBoard().getBoardSize()));

        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < boardSize; j++) {
                if(boardBuilder.getBoard().getBoard().get(i).get(j) == 0){
                    southPosition.put(i+1, j);
                }
            }
        }
        return southPosition;
    }

    // Ejecutar 11avo
    @Override
    public Map<Integer, Integer> findEastPosition(){
        Map<Integer, Integer> eastPosition = new HashMap<>();
        List<Integer> keys = boardBuilder.putBoardKeysInList();
        int boardSize = (int) Math.round(Math.sqrt(boardBuilder.getBoard().getBoardSize()));

        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < boardSize; j++) {
                if(boardBuilder.getBoard().getBoard().get(i).get(j) == 0){
                    eastPosition.put(i, j+1);
                }
            }
        }

        return eastPosition;
    }

    // Ejecutar 12avo
    @Override
    public Map<Integer, Integer> findWestPosition(){

        Map<Integer, Integer> westPosition = new HashMap<>();
        List<Integer> keys = boardBuilder.putBoardKeysInList();
        int boardSize = (int) Math.round(Math.sqrt(boardBuilder.getBoard().getBoardSize()));

        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < boardSize; j++) {
                if(boardBuilder.getBoard().getBoard().get(i).get(j) == 0){
                    westPosition.put(i, j-1);
                }
            }
        }

        return westPosition;
    }

    private boolean existsReceivedPosition(Map<Integer, Integer> receivedPosition){
        List<Integer> keys = new ArrayList<>();
        for (Integer integer : receivedPosition.keySet()) {
            keys.add(integer);
        }
        int row = keys.get(0);
        int index = receivedPosition.get(row);

        if(boardBuilder.getBoard().getBoard().containsKey(row)){
            int column;
            try { column = boardBuilder.getBoard().getBoard().get(row).get(index); }
            catch (NullPointerException | IndexOutOfBoundsException e){ return false; }
            if (column > -1)
                return true;
        }
        return false;
    }

    // Ejecutar 13avo
    @Override
    public Map<Integer, Map<Integer, Integer>> possiblePositionsList(){
        Map<Integer, Map<Integer, Integer>> possiblePositionsList = new TreeMap<>();

        Map<Integer, Integer> northPosition =  findNorthPosition();
        Map<Integer, Integer> southPosition =  findSouthPosition();
        Map<Integer, Integer> eastPosition =  findEastPosition();
        Map<Integer, Integer> westPosition =  findWestPosition();

        boolean northPositionBoolean = existsReceivedPosition(northPosition);
        boolean southPositionBoolean = existsReceivedPosition(southPosition);
        boolean eastPositionBoolean = existsReceivedPosition(eastPosition);
        boolean westPositionBoolean = existsReceivedPosition(westPosition);

        if(northPositionBoolean){
            possiblePositionsList.put(1, northPosition);
        }
        if(southPositionBoolean){
            possiblePositionsList.put(2, southPosition);
        }
        if(eastPositionBoolean){
            possiblePositionsList.put(3, eastPosition);
        }
        if(westPositionBoolean){
            possiblePositionsList.put(4, westPosition);
        }

        return possiblePositionsList;
    }

    private int userDecision(){

        MenuUserDecisionImpl menuUserDecision = new MenuUserDecisionImpl();
        menuUserDecision.add("\n1 = North, 2 = South, 3 = East, 4 = West, 5 = Exit");
        menuUserDecision.add("Please enter a number among the options: ");
        menuUserDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int number = scanner.askUserForDecision(menuUserDecision, this);
        return number;

//        Map<Integer, Map<Integer, Integer>> posiblePositionsList = possiblePositionsList();
//
//        List<Integer> posiblesKeysList = new ArrayList<>();
//        for (Integer integer : posiblePositionsList.keySet()) {
//            posiblesKeysList.add(integer);
//        }
//
//        Scanner scanner = new Scanner(System.in);
//
//        int number;
//        do {
//            System.out.println("\n1 = North, 2 = South, 3 = East, 4 = West");
//            System.out.println("Please enter a number among the options: " + posiblesKeysList);
//            System.out.println("Or 5 to exit the game");
//            while (!scanner.hasNextInt()) {
//                String input = scanner.next();
//                System.out.printf("\"%s\" is not a valid number.%n", input);
//            }
//            number = scanner.nextInt();
//
//            if (number == 5){
//                System.exit(0);
//            }
//
//        } while (!posiblesKeysList.contains(number));
//
//        System.out.printf("You have entered the number %d.%n", number);
//        System.out.println();
//
//        return number;
    }

    // Ejecutar 14avo
    @Override
    public void gameMovement(){
        int userDecision = userDecision();
        Map<Integer, Integer> zeroPosition = findZeroPosition();
        Map<Integer, Map<Integer, Integer>> posiblePositionsList = possiblePositionsList();
        Map<Integer, Integer> auxMap = posiblePositionsList.get(userDecision);

        List<Integer> keys = new ArrayList<>();
        for (Integer integer : auxMap.keySet()) {
            keys.add(integer);
        }
        int objectivePositionRow = keys.get(0);
        int objectivePositionColumn = auxMap.get(objectivePositionRow);

        List<Integer> zeroKeys = new ArrayList<>();
        for (Integer integer : zeroPosition.keySet()) {
            zeroKeys.add(integer);
        }
        int zeroPositionRow = zeroKeys.get(0);
        int zeroPositionColumn = zeroPosition.get(zeroPositionRow);

        //valor objetivo en posicion objetivo
        int valorAux = boardBuilder.getBoard().getBoard().get(objectivePositionRow).get(objectivePositionColumn);

        //setea en la posicion de 0 el valorAux
        boardBuilder.getBoard().getBoard().get(zeroPositionRow).set(zeroPositionColumn, valorAux);

        //setea en la posicion de valor objetivo el valor 0
        boardBuilder.getBoard().getBoard().get(objectivePositionRow).set(objectivePositionColumn, 0);

        boardBuilder.printBoard();

        gameMovement();
    }
}
