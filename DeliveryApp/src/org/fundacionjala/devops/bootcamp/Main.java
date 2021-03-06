package org.fundacionjala.devops.bootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        DeliveryApp app = new DeliveryApp();
        app.showMenu();

        System.out.println("Please, select an option ");
        int option = in.nextInt();

        app.showDetails(option);
        System.out.println("Please, select the detail");
        int optionDetail = in.nextInt();

        System.out.println("Please, select the quantity");
        int qty = in.nextInt();
        if (qty > 20) {
            System.out.println("You can not select more than 20 " + app.getItem(option));
            System.out.println("Please, select the quantity");
            qty = in.nextInt();
        }

        app.generateOrder(option, optionDetail, qty);
        app.showOrder();
    }
}
