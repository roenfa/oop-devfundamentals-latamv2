package org.fundacionjala.devops.bootcamp.KevinCardenas.App;

import org.fundacionjala.devops.bootcamp.KevinCardenas.Model.Position;

public interface IBoard {
     int[][] getFigure();
     void print();

     void setFigure(int[][] figure);

     Position getPosition();
     void setPosition(Position position);

    void  buildBoard(int n);
    void shuffle();
    void posIni(int i, int j);
    int[][] getFigureCheck();
}
