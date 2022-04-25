package scanner;

import interfaces.IGamePlay;

public interface IScanner {
    int askUserForBoardSize(ScannerClass scannerClass);
    int askUserForDecision(ScannerClass scannerClass, IGamePlay gamePlay);
}
