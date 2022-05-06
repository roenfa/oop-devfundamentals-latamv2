package org.fundacionjala.devops.bootcamp.scanner;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;

import java.util.Set;
import java.util.TreeSet;

public class ScannerClass implements IScanner {

    private Set<String> menuSet = new TreeSet<>();

    public Set<Item> getMenuSet() {
        return menuSet;
    }

//    public Order askForOrder(){
//        Order order = new Order();
//    }

    @Override
    public Order askUserForOrder(ScannerClass scannerClass) {
        ScannerClass scanner = new ScannerClass(System.in);

        int number;
        do {
            String zeroPosition = (String) scannerClass.getMenuSet().toArray()[0];
            System.out.print(zeroPosition);

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }

            number = scanner.nextInt();

        } while (number < 1 || number > 12);

        String firstPosition = (String) scannerClass.getMenuSet().toArray()[1];
        System.out.print(firstPosition + number + "\n\n");

        return number;
    }

    @Override
    public void printMenu(ScannerClass scannerClass) {

    }
}