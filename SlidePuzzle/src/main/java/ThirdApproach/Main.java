package ThirdApproach;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prompt.print("Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        Puzzle.createPuzzle(scanner.nextInt());
        Prompt.print("Moves to shuffle board? (e.g. 30): ");
        Puzzle.shufflePuzzle(scanner.nextInt());
        Prompt.print("Game on! Use WASD + intro, to move the Hole.\n");
        while(!Puzzle.isSolved()){
            Puzzle.printPuzzle();
            Movement.makeMove(Prompt.getKey());
        }
        Puzzle.printPuzzle();
        Prompt.print("Winner! Puzzle solved in "+Puzzle.slv+" moves." );
    }
}
