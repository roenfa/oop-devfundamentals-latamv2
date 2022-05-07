package org.fundacionjala.devops.bootcamp.scanner;

import org.fundacionjala.devops.bootcamp.model.Order;

public interface IScanner {
    Order askUserForOrder(ScannerClass scannerClass);
    void printMenu(ScannerClass scannerClass);
}
