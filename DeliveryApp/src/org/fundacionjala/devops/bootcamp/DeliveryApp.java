package org.fundacionjala.devops.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class DeliveryApp {
    private List<String> menu;
    private List<String> orderList;

    public DeliveryApp() {
        orderList = new ArrayList<>();
        menu = new ArrayList<>() {{
            add("Pizza");
            add("Chicken");
            add("Hamburger");
            add("Sandwich");
        }};
    }

    public void addOrder() {

    }

    public void showMenu() {
        var count = 1;

        for (String item: this.menu) {
            System.out.println(count + ": " + item);
            count++;
        }
    }

    private List<String> getPizzaDetails() {
        return new ArrayList<>() {{
            add("Big /10pieces - Bs.100");
            add("Medium /8pieces  - Bs.60");
            add("Small /4pieces - Bs.40");
            add("Only 1piece - Bs.20");
        }};
    }

    private void showPizzaDetails() {
        int count = 1;

        for (String detail: this.getPizzaDetails()) {
            System.out.println(count + ": " + detail);
            count++;
        }
    }

    private List<String> getChickenDetails() {
        return new ArrayList<>() {{
            add("Family size /meat only Bs.100");
            add("Family size combo w/french fries&rice Bs.120");
            add("6 pieces chicken w/french fries - Bs.65");
            add("Chicken popcorn - Bs.45");
            add("3 pieces chicken w/french fries - Bs.35");
            add("Cheap Chicken - Only 1piece w/french fries - Bs.25");
        }};
    }

    private void showChickenDetails() {
        int count = 1;

        for (String detail: this.getChickenDetails()) {
            System.out.println(count + ": " + detail);
            count++;
        }
    }

    private List<String> getHamburgerDetails() {
        return new ArrayList<>() {{
            add("Double cheeseburger w/french fries Bs.45");
            add("Double Whopper w/french fries Bs.45");
            add("Whopper w/french fries Bs.35");
            add("Bacon cheeseburger w/french fries Bs.55");
            add("Simple Hamburger w/french fries Bs.25");
        }};
    }

    private void showHamburgerDetails() {
        int count = 1;

        for (String detail: this.getHamburgerDetails()) {
            System.out.println(count + ": " + detail);
            count++;
        }
    }

    private  List<String> getSandwichDetails() {
        return new ArrayList<>() {{
            add("Crispy chicken sandwich w/french fries Bs.55");
            add("Special veg sandwich Bs.35");
            add("Egg sandwich w/french fries Bs.25");
            add("Double egg sandwich w/french fries Bs.35");
        }};
    }

    private void showSandwichDetails() {
        int count = 1;

        for (String detail: this.getSandwichDetails()) {
            System.out.println(count + ": " + detail);
            count++;
        }
    }

    public String getItem(int position) {
        return this.menu.get(position - 1);
    }

    public void showDetails(int option) {
        switch (option) {
            case 1:
                this.showPizzaDetails(); break;
            case 2:
                this.showChickenDetails(); break;
            case 3:
                this.showHamburgerDetails(); break;
            default:
                this.showSandwichDetails(); break;
        }
    }

    public void generateOrder(int option, int optionDetail, int qty) {
        String item = this.getItem(option);
        String detail = "";
        double price = 0;

        switch (item) {
            case "Pizza":
                var detailsList = this.getSandwichDetails();
                detail = detailsList.get(optionDetail - 1);
                var position = detail.indexOf("Bs.");
                price = Double.parseDouble(detail.substring(position + 3));
                break;
            case "Chicken":
                detailsList = this.getChickenDetails();
                detail = detailsList.get(optionDetail - 1);
                position = detail.indexOf("Bs.");
                price = Double.parseDouble(detail.substring(position + 3));
                break;
            case "Hamburger":
                detailsList = this.getHamburgerDetails();
                detail = detailsList.get(optionDetail - 1);
                position = detail.indexOf("Bs.");
                price = Double.parseDouble(detail.substring(position + 3));
                break;
            default:
                detailsList = this.getSandwichDetails();
                detail = detailsList.get(optionDetail - 1);
                position = detail.indexOf("Bs.");
                price = Double.parseDouble(detail.substring(position + 3));
                break;
        }

        this.orderList.add(item + "\n" + "Detail: \n" +  detail + "\nQty:" + qty + "\nTOTAL:" + qty*price);
    }

    public void showOrder() {
        for (String order: this.orderList) {
            System.out.println(order);
        }
    }
}
