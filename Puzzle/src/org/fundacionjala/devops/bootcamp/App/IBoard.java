package org.fundacionjala.devops.bootcamp.App;

import org.fundacionjala.devops.bootcamp.Model.Position;

import java.util.Arrays;
import java.util.Collections;

public interface IBoard {
     int[][] getFigure();
     void print();

     void setFigure(int[][] figure);

     Position getPosition();
     void setPosition(Position position);

    void  buildBoard(int n);
    void suffle();
    void posIni(int i, int j);
    int[][] getFigureCheck();
}
