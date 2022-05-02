package services.chargeCoffee.impl;

import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.NumberOfCupsDecisionImpl;
import services.chargeCoffee.abstraction.IUserChargeCoffeeDecisions;

import static java.lang.Thread.sleep;

public class UserChargeCoffeeImpl implements IUserChargeCoffeeDecisions {
    @Override
    public int defineNumberOfCups(){
        NumberOfCupsDecisionImpl numberOfCupsDecision = new NumberOfCupsDecisionImpl();
        numberOfCupsDecision.add("Please enter the number of cups between 1 and 12: ");
        numberOfCupsDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberOfCups = scanner.askUserForNumberOfCups(numberOfCupsDecision);
        return numberOfCups;
    }
    @Override
    public void placeFilterInFilterHolder(){
        System.out.println("Placing filter into filter holder.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void fillFilterWithCoffeeGrounds(){
        System.out.println("Filling filter with coffee grounds.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void slidesFilterHolderIntoReceptacle(){
        System.out.println("Sliding filer holder into receptacle.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
