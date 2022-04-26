package SecondApproach;

import java.util.*;

public class GameBoard {
    Scanner sc = new Scanner(System.in);
    public int[][] board;

    public static int size;
    private Position position;
    static int hole = 0;
    int cnt = 1;

    public void createBoard(){
        System.out.println("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        size = Integer.parseInt(sc.nextLine());
        board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = cnt;
                board[size-1][size-1] = hole; //Always return 0 on last index from array.
                cnt++;
            }
        }
        System.out.println("Shuffling "+ size + " x " + size + " board\n");
        shuffle(board);
        findHole();
    }

    public void shuffle(int [][] board){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                list.add(board[i][j]);
            }
        }
        Collections.shuffle(list);
        cnt = 1;
        StringBuilder sb = new StringBuilder(size * size * 4);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = list.get(cnt-1);
                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
                cnt++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public void findHole() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    System.out.println("Hole position: Row= " + (i+1) + " Col= " + (j+1) +"\n");
                }
            }
        }
    }

    public void resetBoard(){

    }

    public boolean moveTile(int r, int c) {
        return checkEmpty(r, c, -1, 0) || checkEmpty(r, c, 1, 0)
                || checkEmpty(r, c, 0, -1) || checkEmpty(r, c, 0, 1);
    }

    private boolean checkEmpty(int r, int c, int rdelta, int cdelta) {
        int rNeighbor = r + rdelta;
        int cNeighbor = c + cdelta;
        if (isLegalRowCol(rNeighbor, cNeighbor)
                && board[rNeighbor][cNeighbor].isEmpty()) {
            exchangeTiles(r, c, rNeighbor, cNeighbor);
            return true;
        }
        return false;
    }

    public boolean isLegalRowCol(int r, int c) {
        return r>=0 && r<rows && c>=0 && c<cols;
    }

    private void exchangeTiles(int r1, int c1, int r2, int c2) {
        int[][] temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }
}
