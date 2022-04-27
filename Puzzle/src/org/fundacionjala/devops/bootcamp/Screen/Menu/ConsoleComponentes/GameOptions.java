package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

abstract class GameOptions implements Indicators{

    @Override
    public String print(){

        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append(printUp());
        builder.append(printSpace());
        builder.append(printDown());
        builder.append(printSpace());
        builder.append(printLeft());
        builder.append(printSpace());
        builder.append(printRight());
        builder.append(printSpace());
        builder.append(printHelp());
        builder.append(printSpace());
        builder.append(printExit());
        builder.append("\n");

;

        return builder.toString();
    }

    protected abstract String printSpace();
    protected abstract String printUp();
    protected abstract String printDown();
    protected abstract String printLeft();
    protected abstract String printRight();
    protected abstract String printHelp();
    protected abstract String printExit();
}
