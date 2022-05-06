package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.services.abstraction.IDeliveryManager;
import org.fundacionjala.devops.bootcamp.services.impl.DeliveryManager;

import java.math.BigDecimal;

public class CreateOrderCommandImpl {
    private int code = 1;
    public int getCode() {
        return code;
    }

    public IDeliveryManager createOrders(){
        IDeliveryManager deliveryManager = new DeliveryManager();
        deliveryManager.addOrder("Pizza", BigDecimal.valueOf(1),1);
        return deliveryManager;
    }
}
