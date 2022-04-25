package org.fundacionjala.devops.bootcamp.Basics;

public class Position {

    TableTop table;

    public Position(TableTop table){
        this.table=table;
    }

    public int[] getPosition(){

        int[] currPos=new int[2];

        for(int i=0; i<table.getRows();i++){
            for(int j=0;j<table.getColumns();j++){
                if(table.getTable()[i][j]==0) {
                    currPos[0]=i+1;
                    currPos[1]=j+1;
//                    System.out.println("The Huequito is located in the " + (i+1) + " row " + (j+1) + " column.");
                }
            }
        }
        return currPos;
    }

}
