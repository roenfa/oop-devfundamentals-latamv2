package org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IInterfaz;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;

public class MainCommand implements Command {
    private IInterfaz _interfaz;
    private IOptionManager _optionManager;
    public MainCommand(IInterfaz interfaz, IOptionManager movementManager){
        _interfaz=interfaz;
        _optionManager=movementManager;
    }
    @Override
    public void execute() {
        System.out.println("---WELCOME TO THE PUZZLE GAME!!! ");
        System.out.println("---Set the size of the board please: ");
        int size=_interfaz.getReader().nextInt();
        _optionManager.getBoard().buildBoard(size);
        System.out.println("Set the initial position");
        System.out.println("From 0 to " + (_optionManager.getBoard().getFigure().length-1));
        System.out.println("Row = ");
        int x=_interfaz.getReader().nextInt();
        System.out.println("From 0 to " + (_optionManager.getBoard().getFigure()[0].length-1));
        System.out.println("Column = ");
        int y=_interfaz.getReader().nextInt();
        int varSwap = _optionManager.getBoard().getFigure()[x][y];
        _optionManager.getBoard().getFigure()[0][0]=varSwap;
        _optionManager.getBoard().posIni(x,y);
        _optionManager.getBoard().print();
        _optionManager.nextMoves();
        _optionManager.printNextMoves();
        _optionManager.printOtherOptions();
    }

    @Override
    public int getCommandCode() {
        return 0;
    }
}
