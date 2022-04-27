package services.command;

import interfaces.IBoardBuilder;
import interfaces.IGamePlay;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuSizeImpl;
import services.BoardBuilder;
import services.GamePlay;
import java.util.*;

public class InitializeMediumDifficultyCommandImpl extends Command {

    private int askUserForPositionForZero(int boardSide){
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            number = scanner.nextInt();

        } while (number < 1 || number > boardSide );

        return number;
    }
    private int askUserForTimesToShuffle(){
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            number = scanner.nextInt();

        } while (number < 1);

        return number;
    }

    private int commandCode = 1;

    public int getCommandCode() {
        return commandCode;
    }

    public void execute(){

        IBoardBuilder boardBuilder = new BoardBuilder();

        MenuSizeImpl menuSizeImpl = new MenuSizeImpl();
            menuSizeImpl.add("Please enter the size of the board: ");
            menuSizeImpl.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int number = scanner.askUserForBoardSize(menuSizeImpl);

        boardBuilder.getBoard().setBoardSize(number);

        int boardSide = (int) Math.sqrt(number);
        Map<Integer, Integer> userDecisionForZero = new HashMap<>();

        System.out.println("Row position for O: ");
        int rowForZero = askUserForPositionForZero(boardSide);
        System.out.println("Column position for O: ");
        int columnForZero = askUserForPositionForZero(boardSide);

        userDecisionForZero.put(rowForZero,columnForZero);

//      Execute 1
        boardBuilder.putIntoValuesPoolWithSpecificZeroPosition(userDecisionForZero);

//      Execute 3
        boardBuilder.buildBoard();

//      Execute 6
        boardBuilder.putValuesIntoBoardMap();

//      Execute 7
        boardBuilder.printBoard();

        IGamePlay gamePlay = new GamePlay(boardBuilder);

        System.out.println("How many times do we shuffle the 0: ");
        int timesToShuffle = askUserForTimesToShuffle();

        List<Integer> decisionsList = new ArrayList<>();

        for(int i = 0; i< timesToShuffle;i ++) {
            int userDecision = gamePlay.callsNextMovementRandom();
            decisionsList.add(userDecision);
        }

        if (decisionsList.size() >= 1){
            System.out.println("Decisions that have been made: " + decisionsList);
        }

        gamePlay.callsNextMovement(decisionsList);
    }
}
