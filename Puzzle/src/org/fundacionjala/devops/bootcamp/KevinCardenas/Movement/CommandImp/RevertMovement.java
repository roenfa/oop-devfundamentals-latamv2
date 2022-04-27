package org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IBoard;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IInterfaz;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;

public class RevertMovement implements Command {
    private IOptionManager _optionManager;
    private IInterfaz _interfaz;
    public RevertMovement(IOptionManager movement, IInterfaz interfaz){
        _optionManager =movement;
        _interfaz=interfaz;
    }
    @Override
    public void execute() {
        System.out.println("You have this many movements back" + _optionManager.getListOfMovementsDone().size());
        System.out.println("How many movements back? ");
        int numberOfMovements=_interfaz.getReader().nextInt();
        IBoard board= _optionManager.getBoard();
        for (int i = 0; i <numberOfMovements ; i++) {
            int currentVar=board.getFigure()[board.getPosition().get_x()][board.getPosition().get_y()];
            board.getFigure()[_optionManager.getListOfMovementsDone().peek()[0]][_optionManager.getListOfMovementsDone().peek()[1]]=currentVar;
            board.posIni(_optionManager.getListOfMovementsDone().peek()[0], _optionManager.getListOfMovementsDone().peek()[1]);
            _optionManager.getListOfMovementsDone().pop();
        }
        _optionManager.nextMoves();
        _optionManager.getBoard().print();
        _optionManager.printNextMoves();
    }

    @Override
    public int getCommandCode() {
        return 6;
    }
}
