package org.fundacionjala.devops.bootcamp.GameLogic;


import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;

public class Game {
     TableTop table;
     Movement movement;

    public Game(TableTop table, Movement movement){
        this.table=table;
        this.movement = movement;
    }

    public int gameStatus(){

        int correctLocation = 0;
        int k = 1;
        for (int i = 0; i< table.getRows();i++){
            for (int j = 0; j< table.getColumns();j++){
                if( table.getTable()[i][j] == k ){
                    correctLocation = correctLocation +1;
                }
                k++;
            }
        }

        if (table.getTable()[table.getRows()-1][table.getColumns()-1]==0){
            correctLocation = correctLocation +1;
        }

        return correctLocation;
    }




}
