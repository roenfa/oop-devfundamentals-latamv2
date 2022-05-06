package org.fundacionjala.devops.bootcamp.scanner.impl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.scanner.ScannerClass;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ScannerClassItemImpl extends ScannerClass {
    private Map<String, Map<String, BigDecimal>> menuSet = new HashMap<>();

    public getMenu() {
        return menu;
    }

    public add(String name, String description, BigDecimal price) {
        menuSet.put(name, new HashMap<String, BigDecimal>() {
            {
                put(description, price);
            }
        });
    }


    //public Set<Item> getMenuSet() {
    //    return menuSet;
    //}

    //public ScannerClassItemImpl() {}

    //public void add(Item item){
    //    menuSet.add(item);
    //}
}
