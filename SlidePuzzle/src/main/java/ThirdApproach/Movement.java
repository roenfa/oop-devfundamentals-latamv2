package ThirdApproach;

import static ThirdApproach.Puzzle.*;

public class Movement {
    static int slv = 0;
    public static boolean makeMove(char key) {
        int tmp;

        switch (key) {
            case 'W' -> {
                if (y < 1) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y - 1][x];
                puzzle[y - 1][x] = tmp;
                y--;
                slv++;
            }
            case 'A' -> {
                if (x < 1) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y][x - 1];
                puzzle[y][x - 1] = tmp;
                x--;
                slv++;
            }
            case 'S' -> {
                if (y > size - 2) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y + 1][x];
                puzzle[y + 1][x] = tmp;
                y++;
                slv++;
            }
            case 'D' -> {
                if (x > size - 2) return false;
                tmp = puzzle[y][x];
                puzzle[y][x] = puzzle[y][x + 1];
                puzzle[y][x + 1] = tmp;
                x++;
                slv++;
            }
        }
        return true;
    }
}
