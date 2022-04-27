package org.fundacionjala.devops.bootcamp.Screen.Menu.ConsoleComponentes;

import org.fundacionjala.devops.bootcamp.Basics.Movement;
import org.fundacionjala.devops.bootcamp.Basics.TableTop;

abstract class PossibleMoves implements Indicators{


    @Override
    public String print() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append(printDefinition());
        builder.append(printSpace());
        builder.append(printPossibleMoveOne());
        builder.append(printSpace());
        builder.append(printPossibleMoveTwo());
        builder.append(printSpace());
        builder.append(printPossibleMoveThree());
        builder.append(printSpace());
        builder.append(printPossibleMoveFour());
        builder.append(printSpace());

        builder.append("\n");


        return builder.toString();
    }

    protected abstract String printSpace();
    protected abstract String printDefinition();
    protected abstract String printPossibleMoveOne();
    protected abstract String printPossibleMoveTwo();
    protected abstract String printPossibleMoveThree();
    protected abstract String printPossibleMoveFour();
}
