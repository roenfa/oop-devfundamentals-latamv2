package org.fundacionjala.devops.bootcamp.Basics;

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

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getTable() {
        return table;
    }

    public void initializeTable(){

        int k = 1;

        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){
                if(k != rows*columns) {
                    table[i][j] = k;
                    k++;
                } else {
                    table[i][j]=0;
                }
            }
        }
    }

    public void shuffle(){
        List<Integer> shuffle = new ArrayList<>();
        for(int i=0; i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                shuffle.add(table[i][j]);
            }
        }
        Collections.shuffle(shuffle);

        int k =0;
        for(int i=0; i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                table[i][j]=shuffle.get(k);
                k++;
            }
        }

    }

    public void consoleTable() {
        for(int i=0; i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                    System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}