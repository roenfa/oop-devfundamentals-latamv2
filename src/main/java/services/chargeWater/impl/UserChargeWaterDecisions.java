package services.chargeWater.impl;

import services.chargeWater.abstraction.IUserChargeWaterDecisions;

import static java.lang.Thread.sleep;

public class UserChargeWaterDecisions implements IUserChargeWaterDecisions {
    @Override
    public void poursCupsOfWater(int cupsOfCoffee){
        System.out.println("Pouring cups of water.");
        try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
    }
    @Override
    public void pressBrewButton(){
        System.out.println("Pressing brew button.");
        try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
