package services;

import interfaces.IBoardBuilder;
import interfaces.IFinder;
import interfaces.IGamePlay;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuUserDecisionImpl;
import java.util.*;

public class GamePlay implements IGamePlay {

    private IBoardBuilder boardBuilder;
    private IFinder finder = new FinderClass();

    public GamePlay(IBoardBuilder boardBuilder) {
        this.boardBuilder = boardBuilder;
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

        Map<Integer, Integer> northPosition =  finder.findNorthPosition(boardBuilder);
        Map<Integer, Integer> southPosition =  finder.findSouthPosition(boardBuilder);
        Map<Integer, Integer> eastPosition =  finder.findEastPosition(boardBuilder);
        Map<Integer, Integer> westPosition =  finder.findWestPosition(boardBuilder);

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
        menuUserDecision.add("\n1 = North, 2 = South, 3 = East, 4 = West, 5 = Decisions list, 6 = Exit");
        menuUserDecision.add("Please enter a number among the options: ");
        menuUserDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int number = scanner.askUserForDecision(menuUserDecision, this);
        return number;
    }

    // Ejecutar 14avo
    @Override
    public void gameMovement(int decision, List<Integer> decisionsList ){
        int userDecision = decision;
        Map<Integer, Integer> zeroPosition = finder.findZeroPosition(boardBuilder);
        Map<Integer, Map<Integer, Integer>> possiblePositionsList = possiblePositionsList();
        Map<Integer, Integer> auxMap = possiblePositionsList.get(userDecision);

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

        callsNextMovement(decisionsList);
    }
    @Override
    public List<Integer> callsNextMovement(List<Integer> decisionsList){
        int userDecision = userDecision();
        if (userDecision < 5){
            decisionsList.add(userDecision);

        }
        if (userDecision == 5){
            printReverseDecisionsList(decisionsList);

            boardBuilder.printBoard();
            userDecision = userDecision();
            if (userDecision == 5){
                callsNextMovement(decisionsList);
            }
            if (userDecision < 5){
                decisionsList.add(userDecision);
            }
        }
        gameMovement(userDecision, decisionsList);
        return decisionsList;
    }

    private void printReverseDecisionsList(List<Integer> decisionsList){
        List<Integer> reversedDecisionsList = new ArrayList<>();
        for (int i = decisionsList.size()-1; i >= 0; i--) {
            reversedDecisionsList.add(decisionsList.get(i));
        }
        System.out.println("Reverse order decision list: " + reversedDecisionsList);
    }

    @Override
    public int callsNextMovementRandom(){
        int userDecision = pickRandomlyNumberFromPossiblesPositionsList();
        gameMovementRandomVersion(userDecision);
        return userDecision;
    }

    private int pickRandomlyNumberFromPossiblesPositionsList(){
        Map<Integer, Map<Integer, Integer>> possiblePositionsList = possiblePositionsList();

        List<Integer> keys = new ArrayList<>();
        for (Integer integer : possiblePositionsList.keySet()) {
            keys.add(integer);
        }

        int index = (int)(Math.random() * keys.size());

        int decisionRandomlyPicked = keys.get(index);

        return decisionRandomlyPicked;
    }

    @Override
    public void gameMovementRandomVersion(int decision){
        int userDecision = decision;
        Map<Integer, Integer> zeroPosition = finder.findZeroPosition(boardBuilder);
        Map<Integer, Map<Integer, Integer>> possiblePositionsList = possiblePositionsList();
        Map<Integer, Integer> auxMap = possiblePositionsList.get(userDecision);

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
        System.out.println();
    }
}
