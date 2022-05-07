package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

import java.util.Scanner;

public class MakeOrderCommandImpl implements Commands {

    private UserOptions userOptions;
    private Scanner sc = new Scanner(System.in);


    public MakeOrderCommandImpl (UserOptions userOptions){
        this.userOptions=userOptions;
    }

    @Override
    public void execute() {
        userOptions.getUserOptions().get(1).stream().forEach(System.out::println);



        int option = sc.nextInt();
//        Order newOrder = new Order.Builder().name().quantity().build();

    }

    @Override
    public int getCommandCode() {
        return 2;
    }
}
