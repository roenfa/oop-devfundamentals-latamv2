package org.fundacionjala.devops.bootcamp.services.command;

import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.scanner.impl.MenuCard;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.MakeOrderCommandImpl;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.PrincipalMenuCommandImpl;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.PrintMenuCommandImpl;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private List<Commands> commandsList = new ArrayList<>();
    private MenuCard menu;
//    private Order order;



    private UserOptions userOptions;

    public CommandManager(MenuCard menu, UserOptions userOptions){
        this.menu=menu;
        this.userOptions=userOptions;
//        this.order=order;
    }

    public void addCommand(){
        commandsList.add(new PrincipalMenuCommandImpl(userOptions));
        commandsList.add(new PrintMenuCommandImpl(menu));
        commandsList.add(new MakeOrderCommandImpl(userOptions));

    }

    public List<Commands> getCommandsList() {
        return commandsList;
    }

    public Commands findByCode(int code){
        return commandsList.stream().filter(a->a.getCommandCode() == code).findFirst().orElseThrow(()-> new RuntimeException("Command not found"));
    }

}
