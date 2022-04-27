package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entities.Board;


public interface IBoardBuilder {
     int askUserForBoardSize();
     void putIntoValuesPool();
     void shuffleValuesPool();
     HashMap buildBoard();
     ArrayList<Integer> putBoardKeysInList();
     void putZeroInLastPositionWhenUnshuffled();
     void putZeroInLastPositionWhenShuffled();
     void putValuesIntoBoardMap();
     void printBoard();
     Board getBoard();
     void putIntoValuesPoolWithSpecificZeroPosition(Map<Integer, Integer> zeroPositionMap);
}
