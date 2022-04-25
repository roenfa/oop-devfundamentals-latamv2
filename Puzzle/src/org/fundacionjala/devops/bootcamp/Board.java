package org.fundacionjala.devops.bootcamp;

import java.util.Arrays;
import java.util.Collections;

public class Board {
    private int[][] _figure;
    private Position _position;

    public Board() {
        _position=new Position(0,0);
    }

    public int[][] getFigure() {
        return _figure;
    }
    public void print(){
        System.out.println();
        for (int i = 0; i < _figure.length; i++) {
            for (int j = 0; j <_figure[0].length ; j++) {
                System.out.print(_figure[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void setFigure(int[][] figure) {
        this._figure = figure;
    }

    public Position getPosition() {
        return _position;
    }

    public void setPosition(Position position) {
        this._position = position;
    }

    public void  buildBoard(int n){
        Double size=Math.sqrt(n);
        int sizevalue=size.intValue();
        _figure = new int[sizevalue][sizevalue];
        int value=1;
        for (int i = 0; i <_figure.length ; i++) {
            for (int j = 0; j < _figure[0].length; j++) {
                _figure[i][j]=value;
                value++;
            }
        }
    }
    public void suffle(){
        Collections.shuffle(Arrays.asList(_figure));
        for (int i = 0; i < _figure.length; i++) {
            for (int j = 0; j < _figure[0].length; j++) {
                if(_figure[i][j]==0){
                    _position.set_x(i);
                    _position.set_y(j);
                }
            }
        }
    }
    public void posIni(int i, int j){
        _position.set_x(i);
        _position.set_y(j);
        _figure[i][j]=0;

    }
}
