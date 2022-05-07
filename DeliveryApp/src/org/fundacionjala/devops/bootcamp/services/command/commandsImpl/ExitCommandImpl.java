package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.services.command.Commands;

public class ExitCommandImpl implements Commands {
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public int getCommandCode() {
        return 4;
    }
}
