package org.fundacionjala.devops.bootcamp.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.App.IBoard;
import org.fundacionjala.devops.bootcamp.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.Movement.Command;

public class RightMovement implements Command {
    private IOptionManager _optionManager;
    public RightMovement(IOptionManager movement){
        _optionManager =movement;
    }
    @Override
    public void execute() {
        System.out.println("Going Left!");
        _optionManager.move(getCommandCode());
        System.out.println("This are the next moves you can make");
        _optionManager.printNextMoves();
        _optionManager.printOtherOptions();
    }

    @Override
    public int getCommandCode() {
        return 2;
    }
}
