package org.fundacionjala.devops.bootcamp.model;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Order {
    private String name;
    private int quantity;

    public Order(Builder builder) {
        this.name = builder.name;
        this.quantity = builder.quantity;
    }

    public static class Builder{
        private String name;
        private int quantity;

        public Builder name(final String name){
            this.name=name;
            return this;
        }

        public Builder quantity(final int quantity){
            this.quantity=quantity;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }


}
