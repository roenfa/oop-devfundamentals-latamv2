package org.fundacionjala.devops.bootcamp.Movement;

import org.fundacionjala.devops.bootcamp.App.IBoard;
import org.fundacionjala.devops.bootcamp.App.IOptionManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Stream;

public class OptionManager implements IOptionManager {
    private Map<Integer,int[]> _nextMoves=new HashMap();
    private IBoard _board;
    private Stack<int[]> _listOfMovementsDone;

    public OptionManager(IBoard board) {
        _board = board;
        _listOfMovementsDone = new Stack();
    }
    @Override
    public Map<Integer, int[]> getNextMoves() {
        return _nextMoves;
    }
    @Override
    public IBoard getBoard() {
        return _board;
    }

    @Override
    public Stack<int[]> getListOfMovementsDone() {
        return _listOfMovementsDone;
    }
    @Override
    public void nextMoves(){
        int _i=_board.getPosition().get_x();
        int _j=_board.getPosition().get_y();
        if(_board.getPosition().get_x()>0){
            int[] var={_i-1,_j};
            _nextMoves.put(1,var);
        }else{
            _nextMoves.remove(1);
        }
        if(_j>0){
            int[] var={_i,_j-1};
            _nextMoves.put(2,var);
        }
        else{
            _nextMoves.remove(2);
        }
        if(_i<_board.getFigure().length-1){
            int[] var={_i+1,_j};
            _nextMoves.put(3,var);
        }
        else{
            _nextMoves.remove(3);
        }
        if(_j<_board.getFigure()[0].length-1){
            int[] var={_i,_j+1};
            _nextMoves.put(4,var);
        } else{
            _nextMoves.remove(4);
        }

    }
    @Override
    public void printNextMoves(){
        for (Map.Entry<Integer, int[]> var:_nextMoves.entrySet()) {
            if(var.getValue()!=null){
                System.out.println(var.getKey()+": fila "+var.getValue()[0]+", columna "+var.getValue()[1]);
            }
        }
    }
    @Override
    public void printListOfMovementsDone(){
        for (int[] var:_listOfMovementsDone) {
            System.out.println(var[0]+" "+var[1]);
        }
    }
    @Override
    public void printOtherOptions(){
        System.out.println("5 if you want to shuffle the board");
        System.out.println("6 if you are stuck and want to reset the board");
    }
    @Override
    public void move(int key){
        int var=_board.getFigure()[_nextMoves.get(key)[0]][_nextMoves.get(key)[1]];
        _board.getFigure()[_board.getPosition().get_x()][_board.getPosition().get_y()]=var;
        _board.posIni(_nextMoves.get(key)[0],_nextMoves.get(key)[1]);
        _board.print();
        int[] listofMovements={_nextMoves.get(key)[0],_nextMoves.get(key)[1]};
        _listOfMovementsDone.add(listofMovements);
        nextMoves();
        isGameCompleted();
    }
    public void isGameCompleted(){
        if(Arrays.equals(_board.getFigure(),_board.getFigureCheck())){
            System.out.println("Game is completed you can keep playing or use one of the options!");
        }
        for (int i = 0; i < _board.getFigureCheck().length ; i++) {
            for (int j = 0; j < _board.getFigureCheck()[0].length; j++) {
                System.out.print(_board.getFigureCheck()[i][j]);
            }

        }

    }

}
