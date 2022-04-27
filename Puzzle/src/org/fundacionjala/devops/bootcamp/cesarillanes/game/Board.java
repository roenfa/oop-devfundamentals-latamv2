package org.fundacionjala.devops.bootcamp.cesarillanes.game;

public interface Board {
    void resetBoard(int holePosition);
    boolean[] checkMoves();
    int[] move(int direction);
    void shuffleBoard(int quantity, int holePosition);
    void undo(int quantity);
    boolean solved();
    void printOptions();
    void printBoard();
    int numbersToUndo();
    static Board of(int size) {
        return ConcreteBoard.of(size);
    }
}
