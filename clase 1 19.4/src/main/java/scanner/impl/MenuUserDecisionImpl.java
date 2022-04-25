package scanner.impl;

import scanner.ScannerClass;
import java.util.Set;
import java.util.TreeSet;

public class MenuUserDecisionImpl  extends ScannerClass {
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }

    public MenuUserDecisionImpl() {}

    public MenuUserDecisionImpl(Set<String> menuSet) {
        this.menuSet = menuSet;
    }

    public void add(String string){
        menuSet.add(string);
    }
}
