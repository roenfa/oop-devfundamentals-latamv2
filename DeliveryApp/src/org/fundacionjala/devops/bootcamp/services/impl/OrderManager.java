package org.fundacionjala.devops.bootcamp.services.impl;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.abstraction.IOrderManager;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
public class OrderManager implements IOrderManager {
    private List<Order> listOfOrders;
    private int orderID;
    public OrderManager() {
        listOfOrders = new ArrayList<>();
    }
    @Override
    public List<Order> getListOfOrders() {
        return listOfOrders;
    }
    @Override
    public OrderManager addInformation(String name, BigDecimal price, int quantity){
        listOfOrders.add(new Order(name,price,quantity));
        return this;
    }
    @Override
    public List<Order> build(){
        return listOfOrders;
    }
    @Override
    public int getOrderID() {
        return orderID;
    }
    @Override
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    @Override
    public void clearOrder(){
        listOfOrders=new ArrayList<>();
    }
}
