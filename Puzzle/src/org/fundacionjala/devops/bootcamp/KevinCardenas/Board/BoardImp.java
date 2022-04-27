package org.fundacionjala.devops.bootcamp.KevinCardenas.Board;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IBoard;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Model.Position;

import java.util.Arrays;
import java.util.Collections;

public class BoardImp implements IBoard {
    private int[][] _figure;
    private Position _position;
    private int[][] _figureCheck;

    public BoardImp() {

        _position=new Position(0,0);
    }

    public int[][] getFigure() {
        return _figure;
    }
    public void print(){
        for (int i = 0; i <_figure[0].length ; i++) {
            System.out.print("- ");
        }
        System.out.println();
        for (int i = 0; i < _figure.length; i++) {
            for (int j = 0; j <_figure[0].length ; j++) {
                System.out.print(_figure[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i <_figure[0].length ; i++) {
            System.out.print("- ");
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
        _figureCheck=new int[sizevalue][sizevalue];
        int value=0;
        for (int i = 0; i <_figure.length ; i++) {
            for (int j = 0; j < _figure[0].length; j++) {
                _figure[i][j]=value;
                _figureCheck[i][j]=value;
                value++;
            }
        }
        posIni(0,0);
    }
    public void shuffle(){
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

    public int[][] getFigureCheck() {
        return _figureCheck;
    }
}
