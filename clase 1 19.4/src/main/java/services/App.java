package services;

import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.MenuSizeImpl;
import services.command.Command;
import services.command.InitializeMediumDifficultyCommandImpl;
import services.command.InitializeHardDifficultyCommandImpl;
import java.util.ArrayList;
import java.util.List;

public class App {
    public void run(){

        MenuSizeImpl menuSizeImpl = new MenuSizeImpl();
        menuSizeImpl.add("Please enter the difficulty you want to play with: 1-Medium, 2-Hard: ");
        menuSizeImpl.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberDecided = scanner.askUserForWayOfPlaying(menuSizeImpl);

        List<Command> listOfCommands = new ArrayList<>();
        InitializeMediumDifficultyCommandImpl setZeroPosition = new InitializeMediumDifficultyCommandImpl();
        InitializeHardDifficultyCommandImpl shuffleBoardCommand = new InitializeHardDifficultyCommandImpl();
        listOfCommands.add(setZeroPosition);
        listOfCommands.add(shuffleBoardCommand);

        for (int i = 0; i < listOfCommands.size(); i++) {
            if (listOfCommands.get(i).getCommandCode() == numberDecided){
                listOfCommands.get(i).execute();
            }

        }
    }
}
