package services.produceCoffee.impl;

import scanner.IScanner;
import scanner.ScannerClass;
import scanner.impl.NumberOfCupsDecisionImpl;
import scanner.impl.PotIsFullDecisionImpl;
import scanner.impl.WarmerPlateIsFullDecisionImpl;
import scanner.impl.WaterIsPresentDecisionImpl;
import services.produceCoffee.abstraction.IUserDecisions;

public class UserFullDecision implements IUserDecisions {
    @Override
    public boolean defineIfPotIsFull(){
        PotIsFullDecisionImpl potIsFullDecision = new PotIsFullDecisionImpl();
        potIsFullDecision.add("Please enter if pot is full. 1 = Full. 2 = Not Full: ");
        potIsFullDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberPotIsFull = scanner.askUserIfPotIsFull(potIsFullDecision);
        if(numberPotIsFull==1){return true;}
        return false;
    }
    @Override
    public boolean defineWarmerPlateIsFull(){
        WarmerPlateIsFullDecisionImpl warmerPlateIsFullDecision = new WarmerPlateIsFullDecisionImpl();
        warmerPlateIsFullDecision.add("Please enter if warmer plate is full. 1 = Full. 2 = Not Full: ");
        warmerPlateIsFullDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberWarmerPlateIsFull = scanner.askUserIfPotIsFull(warmerPlateIsFullDecision);
        if(numberWarmerPlateIsFull==1){return true;}
        return false;
    }
    @Override
    public boolean defineWaterIsPresent(int numberOfCups){
        NumberOfCupsDecisionImpl numberOfCupsDecision = new NumberOfCupsDecisionImpl();
        numberOfCupsDecision.add("Please enter cups of water to pour between 1 and 12: ");
        numberOfCupsDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberOfCupsOfWaterToPour = scanner.askUserForNumberOfCups(numberOfCupsDecision);
        if(numberOfCupsOfWaterToPour < numberOfCups){
            return false;
        }
        return true;
    }
}
