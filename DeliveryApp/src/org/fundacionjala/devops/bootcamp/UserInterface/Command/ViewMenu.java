package org.fundacionjala.devops.bootcamp.UserInterface.Command;

public class ViewMenu implements MenuCommand {

    public ViewMenu( Menu menu){
        this.menu=menu;
    }

    @Override
    public void execute() {

    }

    @Override
    public int commandCode() {
        return 1;
    }
}
