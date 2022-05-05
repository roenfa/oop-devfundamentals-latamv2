package controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sensor.IPotSensor;
import sensor.ISensor;
import sensor.PressureSensorImpl;
import sensor.WaterSensorImpl;
import services.chargeWater.abstraction.IBoilerHeater;
import services.chargeWater.impl.BoilerHeaterImpl;
import services.produceCoffee.abstraction.*;
import services.produceCoffee.impl.*;

import static java.lang.Thread.sleep;

public class ProduceCoffeeController {

    final Logger ROOT_LOG = Logger.getRootLogger();

    IDeliveryPipe deliveryPipe = new DeliveryPipeImpl();
    ILightIndicator lightIndicator = new LightIndicatorImpl();
    IPlateHeater plateHeater = new PlateHeaterImpl();
    IPot pot = new PotImpl();
    IPressureRelieveValve pressureRelieveValve = new PressureRelieveValveImpl();
    IPotSensor potSensor = new PressureSensorImpl();
    ISensor waterSensorImpl = new WaterSensorImpl();
    IUserDecisions userDecisions = new UserFullDecision();
    IBoilerHeater boilerHeater = new BoilerHeaterImpl();

    public void produceCoffeeController(int numberOfCups){
        exitsIfFailsPot();

        exitsIfFailsBoiler(numberOfCups);

        boilerHeater.boilerHeatWater();

        deliveryPipe.transportsWaterToPot();

        plateHeater.plateHeater();
        pot.getWarm();

        pressureRelieveValve.opensToReducePressure();
        lightIndicator.lightsUpWhenCoffeeIsReady();
    }

    public void exitsIfFailsBoiler(int numberOfCups){
        int amountOfWater = userDecisions.defineWaterIsPresent();
        if(!waterSensorImpl.isFull(amountOfWater,numberOfCups)){
            System.out.println("The water is discouraged missing.");
            try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

            PropertyConfigurator.configure("log4j.properties");
            ROOT_LOG.debug("exitsIfFailsBoiler(int numberOfCups): " + "The water is discouraged missing.");

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

            PropertyConfigurator.configure("log4j.properties");
            ROOT_LOG.debug("exitsIfFailsPot(): " + "The pot is sadly missing.");

            System.exit(0);
        }
        if(potSensor.isPotFull(potIsFull)){
            System.out.println("The pot is fatally full.");
            try {sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}

            PropertyConfigurator.configure("log4j.properties");
            ROOT_LOG.debug("exitsIfFailsPot(): " + "The pot is fatally full.");

            System.exit(0);
        }
    }
}
