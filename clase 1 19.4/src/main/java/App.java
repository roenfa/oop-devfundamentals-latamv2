import interfaces.IBoardBuilder;
import interfaces.IGamePlay;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuSizeImpl;

public class App {
    public void run(){
        IBoardBuilder boardBuilder = new BoardBuilder();

        MenuSizeImpl menuSizeImpl = new MenuSizeImpl();
        menuSizeImpl.add("Please enter the size of the board: ");
        menuSizeImpl.add("You have entered a positive number: ");
        IScanner scanner = new ScannerClass();
        int number = scanner.askUserForBoardSize(menuSizeImpl);

//          Execute 0
//        int number = boardBuilder.askUserForBoardSize();

        boardBuilder.getBoard().setBoardSize(number);

//          Execute 1
        boardBuilder.putIntoValuesPool();

//          Execute 2
        boardBuilder.shuffleValuesPool();

//          Execute 3
        boardBuilder.buildBoard();

//          Execute 5
//        generaTablero.poneCeroUltimoNoMezclado();

//          Execute 5
        boardBuilder.putZeroInLastPositionWhenShuffled();

//          Execute 6
        boardBuilder.putValuesIntoBoardMap();

//         Execute 7
        boardBuilder.printBoard();

        IGamePlay gamePlay = new GamePlay(boardBuilder);

        gamePlay.gameMovement();
    }
}
