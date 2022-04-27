package ThirdApproach;

public class Puzzle {

    static int[][] puzzle;
    static int size, x, y, slv;

    public static int getSize() {
        return size;
    }
    public static void setSize(int size) {
        Puzzle.size = size;
    }

    public static boolean isSolved() {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(puzzle[j][i] == 0) continue;
                if(puzzle[j][i] != 1 + j*size + i) return false;
                slv++;
            }
        }
        return true;
    }

    public static void shufflePuzzle(int moves) {
        boolean success = true;
        while(moves > 0){
            switch ((int) Math.floor(Math.random() * 4)) {
                case 0 -> success = Movement.makeMove('W');
                case 1 -> success = Movement.makeMove('A');
                case 2 -> success = Movement.makeMove('S');
                case 3 -> success = Movement.makeMove('D');
            }
            if(success) moves--;
        }
    }

    public static void createPuzzle(int size) {
        setSize(size);
        puzzle = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                puzzle[j][i] = 1 + j*size + i;
            }
        }
        x = size-1;
        y = size-1;
        puzzle[x][y] = 0;
    }

    public static void printPuzzle() {
        StringBuilder sb = new StringBuilder(size * size * 4);
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                sb.append(String.format("%s", (puzzle[i][j] == 0) ? "" : puzzle[i][j])).append("\t");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}