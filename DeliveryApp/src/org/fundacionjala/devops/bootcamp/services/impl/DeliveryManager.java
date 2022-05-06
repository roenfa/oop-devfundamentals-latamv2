package org.fundacionjala.devops.bootcamp.services.impl;


import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.abstraction.IDeliveryManager;

import java.math.BigDecimal;
import java.util.List;

public class DeliveryManager implements IDeliveryManager {
    private OrderManager orders;

    public DeliveryManager() {
        this.orders = new OrderManager();
    }

    @Override
    public IDeliveryManager addOrder(String name, BigDecimal price, int quantity) {
        orders.addInformation(name, price, quantity);
        return this;
    }

    @Override
    public List<Order> deliverOrder() {
        return orders.getListOfOrders();
    }
}