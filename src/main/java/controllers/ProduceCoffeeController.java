package controllers;

import sensor.IPotSensor;
import sensor.ISensor;
import sensor.PressureSensorImpl;
import services.chargeWater.abstraction.IBoilerHeater;
import services.chargeWater.impl.BoilerHeaterImpl;
import services.produceCoffee.abstraction.*;
import services.produceCoffee.impl.*;

import static java.lang.Thread.sleep;

public class ProduceCoffeeController {

    IDeliveryPipe deliveryPipe = new DeliveryPipeImpl();
    ILightIndicator lightIndicator = new LightIndicatorImpl();
    IPlateHeater plateHeater = new PlateHeaterImpl();
    IPlateSensor plateSensor = new PlateSensorImpl();
    IPot pot = new PotImpl();
    IPressureRelieveValve pressureRelieveValve = new PressureRelieveValveImpl();
    IPotSensor potSensor = new PressureSensorImpl();
    ISensor sensor = new PressureSensorImpl();
    ISensor boilerSensor = new PressureSensorImpl();
    IUserDecisions userDecisions = new UserFullDecision();
    IBoilerHeater boilerHeater = new BoilerHeaterImpl();

    public void produceCoffeeController(){
        exitsIfFailsPot();

        exitsIfFailsBoiler();

        boilerHeater.boilerHeatWater();

        deliveryPipe.transportsWaterToPot();

        plateHeater.plateHeater();
        pot.getWarm();

        pressureRelieveValve.opensToReducePressure();
        lightIndicator.lightsUpWhenCoffeeIsReady();
    }

    public void exitsIfFailsBoiler(){
        boolean waterIsPresent = userDecisions.defineWaterIsPresent();
        if(!boilerSensor.isFull(waterIsPresent)){
            System.out.println("The water is discouraged missing.");
            try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            System.exit(0);
        }
    }

    public void exitsIfFailsPot(){
        boolean potIsFull = userDecisions.defineIfPotIsFull();
        boolean warmerPlateIsFull = userDecisions.defineWarmerPlateIsFull();

        potSensor.setWarmerPlateFull(warmerPlateIsFull);

        if(!potSensor.isWarmerPlateFull()){
            System.out.println("The pot is sadly missing.");
            try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            System.exit(0);
        }
        if(sensor.isFull(potIsFull)){
            System.out.println("The pot is fatally full.");
            try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
            System.exit(0);
        }
    }
}
