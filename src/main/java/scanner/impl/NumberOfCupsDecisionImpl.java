package scanner.impl;

import scanner.ScannerClass;

import java.util.Set;
import java.util.TreeSet;

public class NumberOfCupsDecisionImpl extends ScannerClass {
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }

    public NumberOfCupsDecisionImpl() {}

    public void add(String string){
        menuSet.add(string);
    }
}
