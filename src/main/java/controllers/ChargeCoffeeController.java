package controllers;

import services.chargeCoffee.abstraction.IUserChargeCoffeeDecisions;
import services.chargeCoffee.impl.UserChargeCoffeeImpl;

public class ChargeCoffeeController {

    IUserChargeCoffeeDecisions userChargeCoffeeDecisions = new UserChargeCoffeeImpl();

    public int chargeCoffeeDecisionsController(){
        int numberOfCups = userChargeCoffeeDecisions.defineNumberOfCups();
        chargeFilter();
        return numberOfCups;
    }

    public void chargeFilter(){
        userChargeCoffeeDecisions.placeFilterInFilterHolder();
        userChargeCoffeeDecisions.fillFilterWithCoffeeGrounds();
        userChargeCoffeeDecisions.slidesFilterHolderIntoReceptacle();
    }
}
