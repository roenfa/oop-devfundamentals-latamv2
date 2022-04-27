package org.fundacionjala.devops.bootcamp.Movement;

import org.fundacionjala.devops.bootcamp.App.IBoard;
import org.fundacionjala.devops.bootcamp.App.IMovementManager;
import org.fundacionjala.devops.bootcamp.Board.BoardImp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MovementManager implements IMovementManager {
    private Map<Integer,int[]> _nextMoves=new HashMap();
    private IBoard _board;
    private Stack<int[]> _listOfMovementsDone;

    public MovementManager(IBoard board) {
        _board = board;
        _listOfMovementsDone = new Stack();
//        int[] listOfMovements= {_board.getPosition().get_x(),_board.getPosition().get_y()};
//        _listOfMovementsDone.add(listOfMovements);
//        nextMoves();
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

}
