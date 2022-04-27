package ThirdApproach;

import static ThirdApproach.Puzzle.*;

public class Movement {

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
