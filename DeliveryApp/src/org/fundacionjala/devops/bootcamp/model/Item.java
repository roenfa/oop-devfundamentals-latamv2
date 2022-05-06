package org.fundacionjala.devops.bootcamp.model;

import java.math.BigDecimal;

public class Item {

    private String name;
    private BigDecimal price;

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name = '" + name + '\'' +
                ", price = " + price +
                '}';
    }
}
