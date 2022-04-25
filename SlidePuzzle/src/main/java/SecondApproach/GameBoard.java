package SecondApproach;

import java.util.*;

public class GameBoard {
    Scanner sc = new Scanner(System.in);
    public static int[][] board;
    public static int size;
    static int hole = 0;
    int cnt = 1;

    public void createBoard(){
        System.out.println("Board Creation: Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        size = Integer.parseInt(sc.nextLine());
//        int size = sel * sel;
        board = new int[size][size];
        System.out.println("\nGrid size selected: " + size + " x " + size);
        System.out.println(printBoard()); // LEO CAPO
//        shuffleBoard(2);
    }

    public void shuffleBoard(int moves) {
        Random rand = new Random();
        int[] tileOffsets = { -size, +size, -1, +1 };
        while (moves-- > 0) {
//            int tile;
//            do {
//                tile = hole + tileOffsets[rand.nextInt(4)];
//            } while (!Position.canMove(tile));
            Position.move(6);
        }
    }

    //Approach Joaco
//    public static void shuffleBoard(int[][] board) {
//        List<Integer> list = new ArrayList<>();
//        for (int i : board) {
//            list.add(i);
//        }
//        Collections.shuffle(list);
//        for (int i = 0; i < list.size(); i++) {
//            board[i] = list.get(i);
//        }
//    }

    public String printBoard(){
        StringBuilder sb = new StringBuilder(size * size * 4);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = cnt;
                board[size-1][size-1] = 0; //Always return 0 on last index from array.
                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
                cnt++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void resetBoard(){
        createBoard();
    }
}
