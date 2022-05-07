package org.fundacionjala.devops.bootcamp.scanner.impl;

import org.fundacionjala.devops.bootcamp.model.Item;

import java.util.*;

public class MenuCard {

    private Map<String, ArrayList<Item>> menu = new HashMap<>();

    public Map<String, ArrayList<Item>> getMenu() {
        return menu;
    }

    public void addItem (String collection, Item item){

        String category = collection.toUpperCase();

        if (menu.containsKey(category)){
            menu.get(category).add(item);
        }else{
            ArrayList<Item> newArray = new ArrayList<>();
            newArray.add(item);
            menu.put(category, newArray);
        }
    }



    //public Set<Item> getMenuSet() {
    //    return menuSet;
    //}

    //public ScannerClassItemImpl() {}

    //public void add(Item item){
    //    menuSet.add(item);
    //}
}
