package org.fundacionjala.devops.bootcamp.model;

import java.math.BigDecimal;

public class Item {
    private String name;
    private String detail;
    private BigDecimal price;

    public Item(String name, String detail, BigDecimal price) {
        this.name=name;
        this.detail = detail;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
                name + ": " + detail + ", price = $" + price ;
    }
}
