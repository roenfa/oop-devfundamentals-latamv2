package org.fundacionjala.devops.bootcamp.KevinCardenas.App;

import org.fundacionjala.devops.bootcamp.KevinCardenas.Board.BoardImp;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Interfaz.InterfazImp;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp.CommandManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.MenuManager;
import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.OptionManager;

public class Game {
    private MenuManager _menuManager;
    private IBoard _board;
    private IInterfaz _interfaz;
    private CommandManager _commandManager;
    private IOptionManager _optionManager;
    public Game(){
        _menuManager=new MenuManager();
        _board=new BoardImp();
        _optionManager= new OptionManager(_board);
        _interfaz=new InterfazImp(_menuManager);
        _commandManager= new CommandManager(_optionManager,_interfaz,_menuManager);
    }
    public void run(){
        initializeCommands();
        _interfaz.menu();

    }
    public void initializeCommands(){
        _menuManager.add("main",_commandManager.findByCode(0),0)
                .add("UpMovement",_commandManager.findByCode(1),1)
                .add("RightMovement",_commandManager.findByCode(2),2)
                .add("DownMovement",_commandManager.findByCode(3),3)
                .add("LeftMovement",_commandManager.findByCode(4),4)
                .add("DisarmBoard",_commandManager.findByCode(5),5)
                .add("RevertMovement",_commandManager.findByCode(6),6)
                .add("Exit",_commandManager.findByCode(7),7).build();
    }

}
