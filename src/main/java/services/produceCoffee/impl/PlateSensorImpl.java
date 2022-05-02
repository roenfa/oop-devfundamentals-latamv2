package services.produceCoffee.impl;

import services.produceCoffee.abstraction.IPlateSensor;

public class PlateSensorImpl implements IPlateSensor {
    @Override
    public boolean checksIFPotHasCoffee() {
        return false;
    }

    @Override
    public boolean checksIFWarmerPlateIsEmpty() {
        return false;
    }
}
