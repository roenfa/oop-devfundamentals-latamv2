package services;

import interfaces.IBoardBuilder;
import interfaces.IFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinderClass implements IFinder {
    @Override
    public Map<Integer, Integer> findZeroPosition(IBoardBuilder boardBuilder) {
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

    @Override
    public Map<Integer, Integer> findNorthPosition(IBoardBuilder boardBuilder) {
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

    @Override
    public Map<Integer, Integer> findSouthPosition(IBoardBuilder boardBuilder) {
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

    @Override
    public Map<Integer, Integer> findEastPosition(IBoardBuilder boardBuilder) {
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

    @Override
    public Map<Integer, Integer> findWestPosition(IBoardBuilder boardBuilder) {

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
}
