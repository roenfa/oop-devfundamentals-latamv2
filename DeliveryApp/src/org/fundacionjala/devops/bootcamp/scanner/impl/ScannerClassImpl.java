package org.fundacionjala.devops.bootcamp.scanner.impl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.scanner.ScannerClass;

import java.util.Set;
import java.util.TreeSet;

public class ScannerClassImpl extends ScannerClass {
    private Set<String> menuSet = new TreeSet<>();

    public Set<Item> getMenuSet() {
        return menuSet;
    }

    public ScannerClassImpl() {}

    public void add(String string){
        menuSet.add(string);
    }
}
