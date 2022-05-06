package org.fundacionjala.devops.bootcamp.scanner.impl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.scanner.ScannerClass;

import java.util.Set;
import java.util.TreeSet;

public class ScannerClassItemImpl extends ScannerClass {
    private Set<Item> menuSet = new TreeSet<>();

    public Set<Item> getMenuSet() {
        return menuSet;
    }

    public ScannerClassItemImpl() {}

    public void add(Item item){
        menuSet.add(item);
    }
}
