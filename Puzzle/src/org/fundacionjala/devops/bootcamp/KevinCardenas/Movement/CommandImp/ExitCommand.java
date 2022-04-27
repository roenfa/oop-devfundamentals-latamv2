package org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.CommandImp;

import org.fundacionjala.devops.bootcamp.KevinCardenas.Movement.Command;

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
