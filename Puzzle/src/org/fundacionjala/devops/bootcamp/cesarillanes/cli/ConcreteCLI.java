package org.fundacionjala.devops.bootcamp.cesarillanes.cli;

import org.fundacionjala.devops.bootcamp.cesarillanes.game.Board;

import java.util.Scanner;

public class ConcreteCLI implements CLI{
    private Scanner sc = new Scanner(System.in);

    @Override
    public void startApp() {
        while(true){
            System.out.println("Puzzles!");
            System.out.println("Which will the size of the board be? (between 2-31)");
            int size = 0;
            while (size < 2 || size > 31) {
                try{
                    size = sc.nextInt();
                    if (size < 2 || size > 31) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Something went wrong, please try again.");
                    sc.next();
                }
            }
            Board board = Board.of(size);
            board.resetBoard(-1);
            board.printBoard();
            System.out.println("Where is going to be the position of the hole? (number between 1 and " + size*size + ")");
            int holePosition = 0;
            while (holePosition < 1 || holePosition > size*size) {
                try{
                    holePosition = sc.nextInt();
                    if (holePosition < 1 || holePosition > size*size) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Something went wrong, please try again.");
                    sc.next();
                }
            }
            board.resetBoard(holePosition-1);
            board.printBoard();
            System.out.println("Lastly, how many shuffle movements would you like me to do before we start?\n(I'll shuffle it at least one time)");
            int shuffle = 1;
            try{
                shuffle = sc.nextInt();
                if (shuffle <= 0) shuffle = 1;
            } catch (Exception e) {
                System.out.println("I'll start with one movement.");
            }
            board.shuffleBoard(shuffle, holePosition-1);
            board.printBoard();
            while(!board.solved()){
                board.printOptions();
                System.out.println("What would you like to do?\n1. Up  2. Down  3. Left  4. Right  5. Undo  6. Exit");
                int action = 0;
                try{
                    action = sc.nextInt();
                    if (action < 1 || action > 6) throw new Exception();
                    if (action <= 4){
                        board.move(action-1);
                        board.printBoard();
                    } else if (action == 5) {
                        System.out.println("How many movements would you want to undo? You can undo " + board.numbersToUndo() + " moves");
                        try{
                            int movements = sc.nextInt();
                            board.undo(movements);
                        } catch (Exception e) {
                            System.out.println("Something went wrong, couldn't undo.");
                        }
                    } else {
                        System.out.println("Bye!");
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.out.println("PLease choose a valid option");
                    sc.next();
                }
            }
            System.out.println("You solved it! Congratulations!\nWould you like to start again?\n1. Yes  2. No");
            try{
                int repeat = sc.nextInt();
                if (repeat != 1 || repeat != 2) throw new Exception();
                if(repeat == 2){
                    System.out.println("Bye!");
                    System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Bye!");
                System.exit(0);
            }
        }
    }
}
