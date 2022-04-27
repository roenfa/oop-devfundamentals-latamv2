package org.fundacionjala.devops.bootcamp.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.App.IInterfaz;
import org.fundacionjala.devops.bootcamp.App.IOptionManager;
import org.fundacionjala.devops.bootcamp.Movement.Command;
import org.fundacionjala.devops.bootcamp.Movement.MenuManager;


import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<Command> commandList;
    private IOptionManager _optionManager;
    private IInterfaz _interfaz;
    private MenuManager _menuManager;
    public CommandManager(IOptionManager movement, IInterfaz interfaz, MenuManager menuManager) {
        _optionManager=movement;
        _interfaz=interfaz;
        _menuManager=menuManager;
        initializeCommands();
    }

    private void initializeCommands() {
        commandList= new ArrayList<>();
        commandList.add(new MainCommand(_interfaz,_optionManager));
        commandList.add(new UpMovement(_optionManager));
        commandList.add(new RightMovement(_optionManager));
        commandList.add(new DownMovement(_optionManager));
        commandList.add(new LeftMovement(_optionManager));
        commandList.add(new DisarmBoard(_optionManager,_interfaz,this));
        commandList.add(new RevertMovement(_optionManager,_interfaz));
        commandList.add(new ExitCommand());

    }
    public Command findByCode(int commandCode){
        return commandList.stream().filter(a->a.getCommandCode()== commandCode).findFirst().orElseThrow(()-> new RuntimeException("Command not found"));
    }
}
