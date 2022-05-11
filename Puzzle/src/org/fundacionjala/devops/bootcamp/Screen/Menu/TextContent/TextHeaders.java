package org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextHeaders implements ConsoleConstants {

    //use access modifiers
    Map<Integer, List<String>> menuHeaders = new HashMap<>();


    @Override
    public void initializeOptions() {
        List<String> one = new ArrayList<>();
        one.add("=================================================================================");
        one.add("                           PUZZElZILLA - THE GAME");
        one.add("=================================================================================");
        one.add("Principal Menu:");
        menuHeaders.put(0, one);

        List<String> two = new ArrayList<>();
        two.add("=================================================================================");
        two.add("                           PUZZElZILLA - THE GAME");
        two.add("=================================================================================");
        two.add("The objective is to sort the table ascending within the time limit. Yo can \n" +
                "choose the difficulty level that suits the challenge your are looking and once\n" +
                "you select your initial position, you will receive a picture of the final result. ");

        menuHeaders.put(1, two);

        List<String> three = new ArrayList<>();
        three.add("=================================================================================\n");
        three.add("                           PUZZElZILLA - THE GAME\n");
        three.add("=================================================================================\n");
        three.add("Please enter your username: ");
        menuHeaders.put(10, three);

        List<String> four = new ArrayList<>();
        four.add("=================================================================================");
        four.add("                           PUZZElZILLA - THE GAME");
        four.add("=================================================================================");
        four.add("Please select a level: ");
        menuHeaders.put(11, four);

        List<String> five = new ArrayList<>();
        five.add("=================================================================================");
        five.add("                           PUZZElZILLA - THE GAME");
        five.add("=================================================================================");
        five.add("Please enter your initial position and the amount of movements to shuffle: ");
        menuHeaders.put(12, five);
        List<String> six = new ArrayList<>();
        six.add("=================================================================================");
        six.add("                                 PUZZElZILLA");
        six.add("=================================================================================");
        menuHeaders.put(13, six);
    }

    @Override
    public void addSubmenu(int layer) {
        List<String> empty = new ArrayList<>();
        if(menuHeaders.containsKey(layer)){
            System.out.println("Cannot create a menu that already exist");
        } else{
            menuHeaders.put(layer, empty);
        }
    }

    //use this.menu...
    @Override
    public void addOption(int layer, String option) {
        menuHeaders.get(layer).add(option);
    }

    @Override
    public void deleteOption(int layer, int option) {
        menuHeaders.get(layer).remove(option);
    }

    @Override
    public Map<Integer, List<String>> getIt() {
        return menuHeaders;
    }
}
