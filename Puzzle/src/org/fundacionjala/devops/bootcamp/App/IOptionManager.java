package org.fundacionjala.devops.bootcamp.App;

import java.util.Map;
import java.util.Stack;

public interface IOptionManager {
    IBoard getBoard();
    void nextMoves();
    void printNextMoves();
    void printListOfMovementsDone();
    Map<Integer, int[]> getNextMoves();
    Stack<int[]> getListOfMovementsDone();
    void printOtherOptions();
    void move(int key);
}
