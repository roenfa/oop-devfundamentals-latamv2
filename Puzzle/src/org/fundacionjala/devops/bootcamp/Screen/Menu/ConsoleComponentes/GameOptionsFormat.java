package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

public class GameOptionsFormat extends GameOptions{
    @Override
    protected String printSpace() {
        return "        ";
    }

    @Override
    protected String printUp() {
        return "1. Up";
    }

    @Override
    protected String printDown() {
        return "2. Down";
    }

    @Override
    protected String printLeft() {
        return "3. Left";
    }

    @Override
    protected String printRight() {
        return "4. Right";
    }

    @Override
    protected String printHelp() {
        return "5. Help";
    }

    @Override
    protected String printExit() {
        return "6. Exit";
    }
}
