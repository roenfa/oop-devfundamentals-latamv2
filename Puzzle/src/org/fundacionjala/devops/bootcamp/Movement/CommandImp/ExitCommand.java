package org.fundacionjala.devops.bootcamp.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.Movement.Command;

public class ExitCommand implements Command {

    @Override
    public void execute() {

        System.exit(0);
    }

    @Override
    public int getCommandCode() {
        return 7;
    }
}
