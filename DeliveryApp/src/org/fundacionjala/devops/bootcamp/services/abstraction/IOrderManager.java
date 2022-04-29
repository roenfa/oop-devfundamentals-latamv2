package org.fundacionjala.devops.bootcamp.services.abstraction;

import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.impl.OrderManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface IOrderManager {

    List<Order> getListOfOrders();
    OrderManager addInformation(String name, BigDecimal price, int quantity);
    List<Order> build();
}
