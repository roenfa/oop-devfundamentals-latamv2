package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Puzzle {

    static int[][] puzzle;
    static int size, x, y, slv;

    public static int getSize() {
        return size;
    }
    public static void setSize(int size) {
        Puzzle.size = size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        createPuzzle(scanner.nextInt());
        shufflePuzzle(60);
        System.out.println("Game on! Use WASD to move the Hole.\n");
        while(!isSolved()){
            printPuzzle();
            makeMove(getKey());
        }
        printPuzzle();
        System.out.println("Winner! solved in "+slv+" moves." );
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
                case 0 -> success = makeMove('W');
                case 1 -> success = makeMove('A');
                case 2 -> success = makeMove('S');
                case 3 -> success = makeMove('D');
            }
            if(success) moves--;
        }
    }

    public static char getKey() {
        Scanner scanner = new Scanner(System.in);
        char key;
        String tmp;
        System.out.print("> ");
        do{
            tmp = scanner.nextLine().toUpperCase();
            System.out.print(" ");
            if(tmp.length() != 1) {
                key = 'X';
            }
            else key = tmp.charAt(0);
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