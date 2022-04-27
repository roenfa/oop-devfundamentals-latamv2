package org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IBoard;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IInterfaz;
import org.fundacionjala.devops.bootcamp.KevinCardenas.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;

public class DisarmBoard implements Command {
    private IOptionManager _optionManager;
    private IInterfaz _interfaz;
    private CommandManager _commandManager;

    public DisarmBoard(IOptionManager optionManager, IInterfaz interfaz, CommandManager commandManager){
        _optionManager =optionManager;
        _interfaz=interfaz;
        _commandManager= commandManager;
    }
    @Override
    public void execute() {
        System.out.println("Please insert the number of movements");
        int numberOfMovements=_interfaz.getReader().nextInt();
        System.out.println("Please insert the index x and y");
        int x=_interfaz.getReader().nextInt();
        int y=_interfaz.getReader().nextInt();
        IBoard board= _optionManager.getBoard();
        int var=board.getFigure()[x][y];
        board.getFigure()[board.getPosition().get_x()][board.getPosition().get_y()]=var;
        board.posIni(x,y);
        board.print();
        _optionManager.nextMoves();
        int range = _optionManager.getNextMoves().size();
        for (int i = 0; i < numberOfMovements ; i++) {
            int random = (int)(Math.random()*range)+1;
            int count=1;
            for (var entry : _optionManager.getNextMoves().entrySet()) {
                if(count==random){

                    _optionManager.move(entry.getKey());
                    break;
                }
                count++;
            }
        }
    }

    @Override
    public int getCommandCode() {
        return 5;
    }
}
