package controllers;

import services.chargeWater.abstraction.IUserChargeWaterDecisions;
import services.chargeWater.abstraction.IWater;
import services.chargeWater.impl.UserChargeWaterDecisions;
import services.chargeWater.impl.WaterImpl;

public class ChargeWaterController {

    IUserChargeWaterDecisions userChargeWaterDecisions = new UserChargeWaterDecisions();
    IWater water = new WaterImpl();

    public void chargeCoffeeDecisionsController(int cupsOfCoffee){
        userChargeWaterDecisions.poursCupsOfWater(cupsOfCoffee);
        userChargeWaterDecisions.pressBrewButton();
        water.spraysOverCoffeeGrounds();
    }
}
