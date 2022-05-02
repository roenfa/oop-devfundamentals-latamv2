package services.chargeWater.impl;

import services.chargeWater.abstraction.IBoilerHeater;

import static java.lang.Thread.sleep;

public class BoilerHeaterImpl implements IBoilerHeater {

    private boolean isOn = true;

    @Override
    public void boilerHeatWater(){
        if (isOn){
            heatWater();
        }
    }

    @Override
    public void heatWater(){
        System.out.println("Heating the water.");
        try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
    }
}
