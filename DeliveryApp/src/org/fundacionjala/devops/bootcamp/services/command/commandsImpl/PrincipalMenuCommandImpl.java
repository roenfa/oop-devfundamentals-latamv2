package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

public class PrincipalMenuCommandImpl implements Commands {

    private UserOptions userOptions;

    public PrincipalMenuCommandImpl (UserOptions userOptions){
        this.userOptions=userOptions;
    }

    @Override
    public void execute() {
        userOptions.getUserOptions().get(0).stream().forEach(System.out::println);
    }

    @Override
    public int getCommandCode() {
        return 0;
    }
}
