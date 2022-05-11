package org.fundacionjala.devops.bootcamp.Basics;

// please... remove unnecessary imports
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableTop {

    private int rows;
    private int columns;
    private int [][] table;

    public TableTop(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.table = new int[rows][columns];
    }

    // use this.rows, is much better
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getTable() {
        return table;
    }

    // I saw the same function name in your folks code, so, I will prefer to change this name...
    // positionHole?? or initializeHolePosition?? idk
    public int[] getZero(){

        int[] currPos=new int[2];

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(table[i][j]==0) {
                    currPos[0]=i+1;
                    currPos[1]=j+1;
//                    System.out.println("The Huequito is located in the " + (i+1) + " row " + (j+1) + " column.");
                }
            }
        }
        return currPos;
    }

    public Boolean initialTable(int[] theZero ){
        int x = theZero[0];
        int y = theZero[1];

        int k = 1;

        for(int i=0; i<rows;i++){
            for(int j=0;j< columns;j++){
                    table[i][j]=k;
                    k++;
            }
        }

        table[x-1][y-1]=0;
        return true;
    }

    public void consoleTable() {
        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){
                    System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}