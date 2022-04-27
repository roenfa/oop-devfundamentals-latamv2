package org.fundacionjala.devops.bootcamp.GameLogic;


import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;

public class Game {
     TableTop table;
     Movement movement;
     String player;

    public Game(TableTop table, Movement movement, String player){
        this.table=table;
        this.movement = movement;
        this.player = player;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
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

        if (table.getTable()[table.getZero()[0]-1][table.getZero()[1]-1]==0){
            correctLocation = correctLocation +1;
        }

        return correctLocation;
    }
}