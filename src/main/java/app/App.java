package app;

import controllers.ChargeCoffeeController;
import controllers.ChargeWaterController;
import controllers.ProduceCoffeeController;

public class App {
    public void run() {

        ChargeCoffeeController chargeCoffeeController = new ChargeCoffeeController();
        int numberOfCups = chargeCoffeeController.chargeCoffeeDecisionsController();

        ChargeWaterController chargeWaterController = new ChargeWaterController();
        chargeWaterController.chargeCoffeeDecisionsController(numberOfCups);

        ProduceCoffeeController produceCoffeeController = new ProduceCoffeeController();
        produceCoffeeController.produceCoffeeController(numberOfCups);
    }
}
