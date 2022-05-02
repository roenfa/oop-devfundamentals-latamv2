package services.produceCoffee.impl;

import services.produceCoffee.abstraction.IPlateHeater;

import static java.lang.Thread.sleep;

public class PlateHeaterImpl implements IPlateHeater {
    private boolean isOn;

    @Override
    public void plateHeater(){
        if (isOn){
            warmsThePot();
        }
        System.out.println("Heating the coffee in pot.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void warmsThePot() {
        System.out.println("Warming the pot.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
