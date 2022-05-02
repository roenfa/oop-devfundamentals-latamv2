package scanner.impl;

import scanner.ScannerClass;
import java.util.Set;
import java.util.TreeSet;

public class WarmerPlateIsFullDecisionImpl extends ScannerClass {
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }

    public WarmerPlateIsFullDecisionImpl() {}

    public void add(String string){
        menuSet.add(string);
    }
}
