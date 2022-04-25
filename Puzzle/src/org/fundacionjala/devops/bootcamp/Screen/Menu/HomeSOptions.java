package org.fundacionjala.devops.bootcamp.Screen.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeSOptions {
    Map<Integer, List<String>> options = new HashMap<>();

    public void initializeOptions(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Start");
        list.add("Create Custom Level");
        list.add("Exit");
        options.put(0,list );

        ArrayList<String> start = new ArrayList<>();
        start.add("Exit");
        options.put(1,start);
        ArrayList<String> levels = new ArrayList<>();
        levels.add("Easy");
        levels.add("Medium");
        levels.add("Hard");
        options.put(2,levels);
    }

    public Map<Integer, List<String>> getOptions() {
        return options;
    }
}
