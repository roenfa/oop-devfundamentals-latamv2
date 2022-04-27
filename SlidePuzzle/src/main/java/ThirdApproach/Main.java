package ThirdApproach;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        Puzzle.createPuzzle(scanner.nextInt());
        Puzzle.shufflePuzzle(60);
        System.out.println("Game on! Use WASD to move the Hole.\n");
        while(!Puzzle.isSolved()){
            Puzzle.printPuzzle();
            Movement.makeMove(Movement.getKey());
        }
        Puzzle.printPuzzle();
        System.out.println("Winner! Puzzle solved in "+Puzzle.slv+" moves." );
    }
}
