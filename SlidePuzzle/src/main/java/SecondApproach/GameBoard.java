package SecondApproach;

import java.util.*;

public class GameBoard {
    Scanner sc = new Scanner(System.in);
    public int[][] board;
    public static int size;
    private Position position;
    static int hole = 0;
    int cnt = 1;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void createBoard(){
        System.out.println("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        size = Integer.parseInt(sc.nextLine());
        board = new int[size][size];
        System.out.println("\nGrid size selected: " + size + " x " + size);

        StringBuilder sb = new StringBuilder(size * size * 4);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = cnt;
                board[size-1][size-1] = hole; //Always return 0 on last index from array.
                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
                cnt++;
            }
            sb.append("\n");
        }
        System.out.println(sb);
        shuffle(board);
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
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = list.get(cnt-1);
                cnt++;
            }
        }
        setBoard(board);
    }







//    public void createBoard(){
//        System.out.println("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
//        size = Integer.parseInt(sc.nextLine());
////        int size = sel * sel;
//        board = new int[size][size];
//        System.out.println("\nGrid size selected: " + size + " x " + size);
//        System.out.println(printBoard());
//    }

//    public String printBoard(){
//        StringBuilder sb = new StringBuilder(size * size * 4);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                board[i][j] = cnt;
//                board[size-1][size-1] = hole; //Always return 0 on last index from array.
//                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
//                cnt++;
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }

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

    public void resetBoard(){

    }
}
