package services.produceCoffee.impl;

import services.produceCoffee.abstraction.IDeliveryPipe;

import static java.lang.Thread.sleep;

public class DeliveryPipeImpl implements IDeliveryPipe {
    @Override
    public void transportsWaterToPot() {
        System.out.println("Delivering water to pot.");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
