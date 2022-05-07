package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.scanner.impl.MenuCard;
import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

import java.util.Locale;
import java.util.Scanner;

public class MakeOrderCommandImpl implements Commands {
    private MenuCard menu;
    private UserOptions userOptions;
    private Scanner sc = new Scanner(System.in);


    public MakeOrderCommandImpl (UserOptions userOptions, MenuCard menu){
        this.userOptions=userOptions;
        this.menu=menu;
    }

    @Override
    public void execute() {
        userOptions.getUserOptions().get(1).stream().forEach(System.out::println);
        System.out.println("Do you want a Burger? (Y/n)");

        String answer = sc.nextLine();

        if (answer.toUpperCase().equals("Y")){
            System.out.println("Which one?");
            menu.getMenu().get("HAMBURGERS").stream().forEach(x-> System.out.println(x));

            String option = sc.nextLine();

            Item newItem=menu.getMenu().get("HAMBURGERS").stream().filter(x->x.getName().equals(option)).findFirst().orElseThrow(()-> new RuntimeException("not found"));


        } else {
            System.out.println("not working");
        }


//        Order newOrder = new Order.Builder().name().quantity().build();

    }

    @Override
    public int getCommandCode() {
        return 2;
    }
}
