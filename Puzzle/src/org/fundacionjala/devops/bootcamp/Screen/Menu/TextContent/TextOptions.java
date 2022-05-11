package org.fundacionjala.devops.bootcamp.Screen.Menu.TextContent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextOptions implements ConsoleConstants {
    //access modifiers
    Map<Integer, List<String>> options = new HashMap<>();

    @Override
    public void initializeOptions(){
        ArrayList<String> list = new ArrayList<>();
        list.add("1. Start");
        list.add("2. Exit");
        options.put(0,list );

        ArrayList<String> start = new ArrayList<>();
        start.add("1. Continue");
        start.add("2. Back");
        options.put(1,start);

    }

    @Override
    public void addSubmenu(int layer){
        List<String> empty = new ArrayList<>();
        if(options.containsKey(layer)){
            System.out.println("Cannot create a menu that already exist");
        } else{
            options.put(layer, empty);
        }
    }

    //use this.
    @Override
    public void addOption (int layer, String option){
        options.get(layer).add(option);
    }
    @Override
    public void deleteOption (int layer, int option){
        options.get(layer).remove(option);
    }
    @Override
    public Map<Integer, List<String>> getIt() {
        return options;
    }
}
