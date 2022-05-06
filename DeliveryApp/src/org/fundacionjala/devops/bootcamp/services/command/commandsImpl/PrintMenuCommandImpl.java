package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.scanner.ScannerClass;
import org.fundacionjala.devops.bootcamp.scanner.impl.ScannerClassImpl;
import org.fundacionjala.devops.bootcamp.scanner.impl.ScannerClassItemImpl;

import java.math.BigDecimal;

public class PrintMenuCommandImpl {
    ScannerClassItemImpl scannerClass = new ScannerClassItemImpl();
    public void addFoodToMenu(){
        scannerClass.add(new Item("Pizza", BigDecimal.valueOf(1.1)));
        scannerClass.add(new Item("Chicken", BigDecimal.valueOf(1.2)));
        scannerClass.add(new Item("Hamburger", BigDecimal.valueOf(1.3)));
        scannerClass.add(new Item("Sandwich", BigDecimal.valueOf(1.4)));
    }

}