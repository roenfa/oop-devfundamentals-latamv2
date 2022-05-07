package org.fundacionjala.devops.bootcamp.controllers;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.scanner.impl.MenuCard;
import org.fundacionjala.devops.bootcamp.services.command.CommandManager;
import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

import java.math.BigDecimal;
import java.util.*;

public class AppController {

     MenuCard menu = new MenuCard();
     UserOptions userOptions= new UserOptions();

     CommandManager manager = new CommandManager(menu, userOptions);
     Scanner in = new Scanner(System.in);

    public void chooseCommand(){
        initialize();
        manager.addCommand();

        int option = 0;

        while (option != (manager.getCommandsList().size()+1)){

            if(option==0){
                    Commands one = manager.findByCode(0);
                    one.execute();
            }

            if(option>0){
                Commands one = manager.findByCode(option);
                one.execute();
                manager.findByCode(0).execute();
            }

            option = in.nextInt();

        }
    }



    //TODO Abstraer del main a una clase
    void initialize(){
        Item burger1 = new Item("Flash", "Burger with cheese", BigDecimal.valueOf(5.00));
        Item burger2 = new Item("Hulk", "Double Burger with cheese and bacon", BigDecimal.valueOf(7.00));
        Item burger3 = new Item("Green Lantern", "Vegetarian meet, Integral breath with tomatoes", BigDecimal.valueOf(6.00));

        Item pizza1 = new Item("Donatelo","small souse", BigDecimal.valueOf(4.00));
        Item pizza2 = new Item("April","medium with 5 vegetals or your choice", BigDecimal.valueOf(4.00));
        Item pizza3 = new Item("Rafael", "Big with peperonni", BigDecimal.valueOf(9.00));

        Item chicken1 = new Item("Claudio", "1 fried chicken", BigDecimal.valueOf(12.00));
        Item chicken2 = new Item("Chicken Little", "2 chicken fired legs", BigDecimal.valueOf(5.30));

        Item dessert1 = new Item("Wonder Woman", "Chocolate light ice cream with cherries", BigDecimal.valueOf(4.50));
        Item dessert2 = new Item("Diabetic comma", "Extra big waffle with 3 ice cream flavors, chocolate sirub, blueberries and condensed milk", BigDecimal.valueOf(15.00));


        menu.addItem("Hamburgers", burger1);
        menu.addItem("Hamburgers", burger2);
        menu.addItem("Hamburgers", burger3);

        menu.addItem("Pizzas", pizza1);
        menu.addItem("Pizzas", pizza2);
        menu.addItem("Pizzas", pizza3);

        menu.addItem("Chicken", chicken1);
        menu.addItem("Chicken", chicken2);

        menu.addItem("Desserts", dessert1);
        menu.addItem("Desserts", dessert2);

        userOptions.addOptionToUser(0, "Welcome to DeliveryApp");
        userOptions.addOptionToUser(0, "1. Check the menu");
        userOptions.addOptionToUser(0, "2. Make an order");
        userOptions.addOptionToUser(0, "3. Exit");

        userOptions.addOptionToUser(1, "Please make an order");
//        userOptions.addOptionToUser(1, "1. Hamburger");
//        userOptions.addOptionToUser(1, "2. Chicken");
//        userOptions.addOptionToUser(1, "3. Pizza");
//        userOptions.addOptionToUser(1, "4. Dessert");

    }
}
