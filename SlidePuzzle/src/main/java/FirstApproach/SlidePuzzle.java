package FirstApproach;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlidePuzzle {
    // My approach
    Scanner sc = new Scanner(System.in);
    int[][] board;
    int size;
    int cnt = 1;

    void createBoard() {
        System.out.println("Board Creation: Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        size = Integer.parseInt(sc.nextLine());
        board = new int[size][size];

//        System.out.println(board[1][1]);
// Original approach with matrix array
        System.out.println("\nGrid size selected: " + size + " x " + size);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = cnt;
                board[size-1][size-1] = 0; //Always return 0 on last index from array.
                System.out.print(board[i][j] + "\t" );
                cnt++;
            }
            System.out.println();
        }
    }
}