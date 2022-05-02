package services.produceCoffee.impl;

import services.produceCoffee.abstraction.ILightIndicator;

import static java.lang.Thread.sleep;

public class LightIndicatorImpl implements ILightIndicator {
    @Override
    public void lightsUpWhenCoffeeIsReady() {
        System.out.println("Lights up - Coffee is ready.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
