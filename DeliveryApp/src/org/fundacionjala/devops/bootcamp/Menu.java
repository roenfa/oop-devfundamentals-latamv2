package org.fundacionjala.devops.bootcamp;

import java.util.Set;

public class Menu {

    private Set<Item> items;

    public Menu(Set<Item> items) {
        this.items = items;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void printMenu() {
        for (Item item : items) {
            System.out.println(item);
        }
    }
}
