package ThirdApproach;

import java.util.Scanner;

import static ThirdApproach.Puzzle.*;

public class Movement {

    public static char getKey() {
        Scanner scanner = new Scanner(System.in);
        char key;
        String tmp;
        System.out.print("> ");
        do{
            tmp = scanner.nextLine().toUpperCase();
            if(tmp.length() != 1) {
                key = 'X';
            } else {
                key = tmp.charAt(0);
            }
        }while(key!='W' && key!='A' && key!='S' && key!='D');
        System.out.println();
        return key;
    }

    public static boolean makeMove(char key) {
        int tmp;
        switch (key) {
            case 'W' -> {
                if (y < 1) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y - 1][x];
                puzzle[y - 1][x] = tmp;
                y--;
            }
            case 'A' -> {
                if (x < 1) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y][x - 1];
                puzzle[y][x - 1] = tmp;
                x--;
            }
            case 'S' -> {
                if (y > size - 2) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y + 1][x];
                puzzle[y + 1][x] = tmp;
                y++;
            }
            case 'D' -> {
                if (x > size - 2) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y][x + 1];
                puzzle[y][x + 1] = tmp;
                x++;
            }
        }
        return true;
    }

}
