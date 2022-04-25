package org.fundacionjala.devops.bootcamp;

import java.util.HashMap;
import java.util.Map;

public class Movement {
    private Map<Integer,int[]> _nextMoves=new HashMap();
    private Board _board;

    public Movement(Board _board) {
        this._board = _board;
        nextMoves();
    }

    public void nextMoves(){
        int _i=_board.getPosition().get_x();
        int _j=_board.getPosition().get_y();
        if(_board.getPosition().get_x()>0){
            int[] var={_i-1,_j};
            _nextMoves.put(1,var);
        }else{
            _nextMoves.put(1,null);
        }
        if(_j>0){
            int[] var={_i,_j-1};
            _nextMoves.put(2,var);
        }
        else{
            _nextMoves.put(2,null);
        }
        if(_i<_board.getFigure().length-1){
            int[] var={_i+1,_j};
            _nextMoves.put(3,var);
        }
        else{
            _nextMoves.put(3,null);
        }
        if(_j<_board.getFigure()[0].length-1){
            int[] var={_i,_j+1};
            _nextMoves.put(4,var);
        } else{
            _nextMoves.put(4,null);
        }

    }
    public void move(int key){
        int var=_board.getFigure()[_nextMoves.get(key)[0]][_nextMoves.get(key)[1]];
        _board.getFigure()[_board.getPosition().get_x()][_board.getPosition().get_y()]=var;
        _board.posIni(_nextMoves.get(key)[0],_nextMoves.get(key)[1]);
        nextMoves();
    }
    public void printNextMoves(){
        for (Map.Entry<Integer, int[]> var:_nextMoves.entrySet()) {
            if(var.getValue()!=null){
                System.out.println(var.getKey()+": fila "+var.getValue()[0]+", columna "+var.getValue()[1]);
            }
        }
    }
}
