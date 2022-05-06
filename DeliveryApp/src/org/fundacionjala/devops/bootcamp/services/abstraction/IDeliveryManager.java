package org.fundacionjala.devops.bootcamp.services.abstraction;

import org.fundacionjala.devops.bootcamp.model.Order;

import java.math.BigDecimal;
import java.util.List;

public interface IDeliveryManager {
    IDeliveryManager addOrder(String name, BigDecimal price, int quantity);
    List<Order> deliverOrder();
}
