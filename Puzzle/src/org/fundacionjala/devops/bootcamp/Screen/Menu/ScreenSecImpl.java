package org.fundacionjala.devops.bootcamp.Screen.Menu;


import org.fundacionjala.devops.bootcamp.Screen.ScreenSections;

abstract class ScreenSecImpl implements ScreenSections {

    @Override
    public String print(){

        StringBuilder builder=new StringBuilder();
        builder.append(printLines());
        builder.append(printTitle());
        builder.append(printLines());
        builder.append(printSpace());

        return builder.toString();
    }

    protected abstract String printLines();
    protected abstract String printTitle();
    protected abstract String printSpace();

}
