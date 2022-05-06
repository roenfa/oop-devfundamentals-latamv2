package services.command;

import interfaces.IBoardBuilder;
import interfaces.IGamePlay;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuUserDecisionImpl;
import services.BoardBuilder;
import services.GamePlay;

import java.util.ArrayList;
import java.util.List;

public class InitializeHardDifficultyCommandImpl extends Command {
    private int commandCode = 2;

    public int getCommandCode() {
        return commandCode;
    }

    public void execute() {
        IBoardBuilder boardBuilder = new BoardBuilder();

        MenuUserDecisionImpl menuSizeImpl = new MenuUserDecisionImpl();
        menuSizeImpl.add("Please enter the size of the board (bigger than 1): ");
        menuSizeImpl.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int number = scanner.askUserForBoardSize(menuSizeImpl);

        boardBuilder.getBoard().setBoardSize(number);

//      Execute 1
        boardBuilder.putIntoValuesPool();

//      Execute 2
        boardBuilder.shuffleValuesPool();

//      Execute 3
        boardBuilder.buildBoard();

//          Execute 5
//        generaTablero.poneCeroUltimoNoMezclado();

//      Execute 5
        boardBuilder.putZeroInLastPositionWhenShuffled();

//      Execute 6
        boardBuilder.putValuesIntoBoardMap();

//      Execute 7
        boardBuilder.printBoard();

        IGamePlay gamePlay = new GamePlay(boardBuilder);
        List<Integer> decisionsList = new ArrayList<>();
        gamePlay.callsNextMovement(decisionsList);
    }
}