package org.fundacionjala.devops.bootcamp.Screen.Menu;



public class HomeScreenFormatI extends ScreenSecImpl {
    @Override
    protected String printLines() {
        return "============================================================================\n";
    }

    @Override
    protected String printTitle() {
        return "                           PUZZElZILLA - THE GAME \n";
    }

    @Override
    protected String printSpace() {
        return "\n";
    }
}
