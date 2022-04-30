package org.fundacionjala.devops.bootcamp.UserInterface.Command;

public class ExitInterface implements MenuCommand{
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public int commandCode() {
        return 0;
    }
}
