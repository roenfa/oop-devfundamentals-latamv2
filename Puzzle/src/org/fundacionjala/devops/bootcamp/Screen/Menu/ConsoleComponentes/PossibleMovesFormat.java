package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;

import java.util.Map;

public class PossibleMovesFormat extends PossibleMoves {

    Movement mov;
    TableTop table;

    public PossibleMovesFormat (Movement mov, TableTop table){
        this.mov=mov;
        this.table=table;
    }

    @Override
    protected String printSpace() {
        return "      ";
    }

    @Override
    protected String printDefinition() {
        return "Current valid movements: ";
    }

    @Override
    protected String printPossibleMoveOne() {
        for (Map.Entry<Integer, int[]> in : mov.possibleMoves(table.getZero()).entrySet()){
            if(in.getKey()==1){
                return "Up";
            }
        }
        return null;
    }

    @Override
    protected String printPossibleMoveTwo() {
        for (Map.Entry<Integer, int[]> in : mov.possibleMoves(table.getZero()).entrySet()){
            if(in.getKey()==2){
                return "Down";
            }
        }
        return null;
    }

    @Override
    protected String printPossibleMoveThree() {
        for (Map.Entry<Integer, int[]> in : mov.possibleMoves(table.getZero()).entrySet()){
            if(in.getKey()==1){
                return "Left";
            }
        }
        return null;
    }

    @Override
    protected String printPossibleMoveFour() {
        for (Map.Entry<Integer, int[]> in : mov.possibleMoves(table.getZero()).entrySet()){
            if(in.getKey()==1){
                return "Right";
            }
        }
        return null;
    }
}
