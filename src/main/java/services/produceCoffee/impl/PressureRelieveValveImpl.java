package services.produceCoffee.impl;

import services.produceCoffee.abstraction.IPressureRelieveValve;

public class PressureRelieveValveImpl implements IPressureRelieveValve {
    @Override
    public boolean opensToReducePressure() {
        return false;
    }
}
