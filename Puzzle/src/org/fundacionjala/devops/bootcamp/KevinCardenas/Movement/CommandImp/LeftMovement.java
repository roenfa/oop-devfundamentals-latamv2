package org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;

public class LeftMovement implements Command {
    private IOptionManager _optionManager;
    public LeftMovement(IOptionManager movement){
        _optionManager =movement;
    }
    @Override
    public void execute() {
        System.out.println("Going Right!");
        _optionManager.move(getCommandCode());
        System.out.println("This are the next moves you can make");
        _optionManager.printNextMoves();
        _optionManager.printOtherOptions();
    }

    @Override
    public int getCommandCode() {
        return 4;
    }
}
