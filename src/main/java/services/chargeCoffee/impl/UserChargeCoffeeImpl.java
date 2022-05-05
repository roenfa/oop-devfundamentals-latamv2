package services.chargeCoffee.impl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.ScannerClassImpl;
import services.chargeCoffee.abstraction.IUserChargeCoffeeDecisions;

import static java.lang.Thread.sleep;

public class UserChargeCoffeeImpl implements IUserChargeCoffeeDecisions {

    final Logger ROOT_LOG = Logger.getRootLogger();

    @Override
    public int defineNumberOfCups(){
        ScannerClassImpl numberOfCupsDecision = new ScannerClassImpl();
        numberOfCupsDecision.add("Please enter the number of cups between 1 and 12: ");
        numberOfCupsDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberOfCups = scanner.askUserForNumberOfCups(numberOfCupsDecision);

        PropertyConfigurator.configure("log4j.properties");
        ROOT_LOG.debug("Decision defineNumberOfCups(): " + numberOfCups);

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
