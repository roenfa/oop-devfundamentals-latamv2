package org.fundacionjala.devops.bootcamp.Model;

public class Position {
    private int _x;
    private int _y;

    public Position(int _x, int _y) {
        this._x = _x;
        this._y = _y;
    }

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }
}
