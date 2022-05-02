package services.produceCoffee.impl;

import services.produceCoffee.abstraction.IPot;

import static java.lang.Thread.sleep;

public class PotImpl implements IPot {

    @Override
    public void getWarm() {
        System.out.println("Pot getting warm.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
