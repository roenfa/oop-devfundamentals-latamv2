package org.fundacionjala.devops.bootcamp.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserOptions {
    Map<Integer, List<String>> userOptions = new HashMap<>();

    public void addOptionToUser (int layer, String option){

        if( userOptions.containsKey(layer)){
            userOptions.get(layer).add(option);
        }else{
            List<String> newList = new ArrayList<>();
            newList.add(option);
            userOptions.put(layer,newList);
        }
    }

    public Map<Integer, List<String>> getUserOptions() {
        return userOptions;
    }
}
