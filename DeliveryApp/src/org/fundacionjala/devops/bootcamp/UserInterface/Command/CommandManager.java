package org.fundacionjala.devops.bootcamp.UserInterface.Command;

import java.util.ArrayList;
import java.util.List;



public class CommandManager {
    private List<MenuCommand> commandList;
    private Menu menu;

    public CommandManager(Menu menu){
        this.menu=menu;
    }


    private void initializeCommands() {
        commandList = new ArrayList<>();
        commandList.add(new ViewMenu(Menu menu));
        commandList.add(new NewOrder(Menu menu));
        commandList.add(new ExitInterface());
    }

    public MenuCommand findByCode(int commandCode){
        return commandList.stream().filter(option -> option.commandCode() == commandCode).findFirst().orElseThrow(()->new RuntimeException("Command not found"));
    }

}