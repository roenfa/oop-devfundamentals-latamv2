package org.fundacionjala.devops.bootcamp.services.impl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.abstraction.IItemProducer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemProducer implements IItemProducer {


    public ItemProducer() {

    }

    @Override
    public List<Item> createItem(List<Order> order) {
        List<Item> items=new ArrayList<>();
//        for (Order entry: order) {
//            String name=entry.getName();
//            BigDecimal price= entry.getPrice();
//            for (int i = 0; i <entry.getQuantity() ; i++) {
//                Item item= new Item(name,price);
//                items.add(item);
//            }
//        }
        return items;
    }

    @Override
    public void deliverItems() {

    }
}
