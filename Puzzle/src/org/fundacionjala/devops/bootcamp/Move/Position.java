package org.fundacionjala.devops.bootcamp.Move;

import java.util.HashMap;
import java.util.Map;

public class Position {

    private int row;
    private int column;
    private Map<Integer,Integer> holePosition = new HashMap<>();

    public Position() {
    }

    public void Movement(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setHolePosition(String position) {
        //Position cames in a string with the format "row,column"
        String[] positionArray = position.split(",");
        int row = Integer.parseInt(positionArray[0]);
        int column = Integer.parseInt(positionArray[1]);
        holePosition.put(row, column);
    }

    public Map<Integer, Integer> getHolePosition() {
        return holePosition;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}

