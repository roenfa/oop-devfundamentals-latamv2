package entities;

import java.util.*;

public class Board {

    public List<Integer> getPoolValues() {
        return poolValues;
    }

    public Map<Integer, ArrayList<Integer>> getBoard() {
        return board;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public Board(){}

    private Map<Integer, ArrayList<Integer>> board = new HashMap<>();
    private List<Integer> poolValues = new ArrayList<>();
    private int boardSize;

}
