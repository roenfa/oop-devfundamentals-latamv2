package org.fundacionjala.devops.bootcamp.services.abstraction;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;

import java.util.List;

public interface IItemProducer {
    List<Item> createItem(List<Order> order);
    void deliverItems();
}
