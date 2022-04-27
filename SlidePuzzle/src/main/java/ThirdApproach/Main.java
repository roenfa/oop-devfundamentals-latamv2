package ThirdApproach;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prompt.print("Welcome to the Slide Puzzle Game! \nDesired tile grid size (4 = 4x4 grid): ");
        Puzzle.createPuzzle(scanner.nextInt());
        Prompt.print("Moves to shuffle board? (30): ");
        int initMv = scanner.nextInt();
        Puzzle.shufflePuzzle(initMv);
        Prompt.print("Game on! Use WASD + intro, to move the Hole.\n");
        while(!Puzzle.isSolved()){
            Puzzle.printPuzzle();
            Movement.makeMove(Prompt.getKey());
        }
        Puzzle.printPuzzle();
        Prompt.print("Winner! Puzzle solved in "+(Movement.slv-initMv)+" moves." );
    }
}
