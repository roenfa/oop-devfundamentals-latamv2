package org.fundacionjala.devops.bootcamp.App;

import java.util.Map;
import java.util.Stack;

public interface IMovementManager {
    IBoard getBoard();
    void nextMoves();
    void printNextMoves();
    void printListOfMovementsDone();
    Map<Integer, int[]> getNextMoves();
    Stack<int[]> getListOfMovementsDone();
}
