package services.produceCoffee.impl;

import scanner.IScanner;
import scanner.ScannerClass;
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
    public boolean defineWaterIsPresent(){
        WaterIsPresentDecisionImpl waterIsPresentDecision = new WaterIsPresentDecisionImpl();
        waterIsPresentDecision.add("Please enter if there is enough water present. 1 = Present. 2 = Not Present: ");
        waterIsPresentDecision.add("You have entered the number: ");
        IScanner scanner = new ScannerClass();
        int numberWaterIsPresent = scanner.askUserIfPotIsFull(waterIsPresentDecision);
        if(numberWaterIsPresent==1){return true;}
        return false;
    }
}
