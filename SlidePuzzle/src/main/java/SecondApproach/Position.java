package SecondApproach;

public class Position {
//    public int row;
//    public int col;
//
//    void position() {
//
//    }

    public static boolean canMove(int pos) {
        if (pos < 0 || pos >= GameBoard.size * GameBoard.size) {
            return false;
        }
        int diff = GameBoard.hole - pos;
        if (diff == -1) {
            return pos % GameBoard.size != 0;
        } else if (diff == +1) {
            return GameBoard.hole % GameBoard.size != 0;
        } else {
            return Math.abs(diff) == GameBoard.size;
        }
    }

    /**
     * Move the tile at the specified position into the neighboring hole (i.e.
     * move the hole to the specified position).
     */
    public static void move(int pos) {
        if (!canMove(pos)) {
            throw new IllegalArgumentException("Illegal move");
        }
        GameBoard.board[GameBoard.hole] = GameBoard.board[pos];
        GameBoard.board[GameBoard.hole = pos] = 0;

    }

}
