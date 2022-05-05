package services.produceCoffee.impl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.ScannerClassImpl;
import services.produceCoffee.abstraction.IUserDecisions;

public class UserFullDecision implements IUserDecisions {

    final Logger ROOT_LOG = Logger.getRootLogger();

    @Override
    public boolean defineIfPotIsFull(){
        ScannerClassImpl potIsFullDecision = new ScannerClassImpl();
        potIsFullDecision.add("Please enter if pot is full. 1 = Full. 2 = Not Full: ");
        potIsFullDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberPotIsFull = scanner.askUserIfPotIsFull(potIsFullDecision);

        PropertyConfigurator.configure("log4j.properties");
        ROOT_LOG.debug("Decision defineIfPotIsFull(): " + numberPotIsFull);

        if(numberPotIsFull==1){return true;}
        return false;
    }
    @Override
    public boolean defineWarmerPlateIsFull(){
        ScannerClassImpl warmerPlateIsFullDecision = new ScannerClassImpl();
        warmerPlateIsFullDecision.add("Please enter if warmer plate is full. 1 = Full. 2 = Not Full: ");
        warmerPlateIsFullDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberWarmerPlateIsFull = scanner.askUserIfPotIsFull(warmerPlateIsFullDecision);

        PropertyConfigurator.configure("log4j.properties");
        ROOT_LOG.debug("Decision defineWarmerPlateIsFull(): " + numberWarmerPlateIsFull);

        if(numberWarmerPlateIsFull==1){return true;}
        return false;
    }
    @Override
    public int defineWaterIsPresent(){
        ScannerClassImpl numberOfCupsDecision = new ScannerClassImpl();
        numberOfCupsDecision.add("Please enter cups of water to pour between 1 and 12: ");
        numberOfCupsDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberOfCupsOfWaterToPour = scanner.askUserForNumberOfCups(numberOfCupsDecision);

        PropertyConfigurator.configure("log4j.properties");
        ROOT_LOG.debug("Decision defineWaterIsPresent("+ numberOfCupsOfWaterToPour +"): " + numberOfCupsOfWaterToPour);

        return numberOfCupsOfWaterToPour;
    }
}
