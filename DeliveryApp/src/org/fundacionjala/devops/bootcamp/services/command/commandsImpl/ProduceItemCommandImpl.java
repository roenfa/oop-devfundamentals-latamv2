package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.abstraction.IItemProducer;
import org.fundacionjala.devops.bootcamp.services.impl.DeliveryManager;
import org.fundacionjala.devops.bootcamp.services.impl.ItemProducer;
import org.fundacionjala.devops.bootcamp.services.impl.OrderManager;

import java.util.List;

public class ProduceItemCommandImpl {
    private int code = 2;
    public int getCode() {
        return code;
    }

    public List<Item> produceItems(DeliveryManager deliveryManager){
        IItemProducer itemProducer = new ItemProducer();
//        List<Order> order = orderManager.getListOfOrders();
        List<Order> order = deliveryManager.deliverOrder();
        List<Item> listOfItems = itemProducer.createItem(order);
        return listOfItems;
    }
}
