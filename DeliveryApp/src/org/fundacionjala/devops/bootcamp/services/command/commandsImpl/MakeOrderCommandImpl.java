package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.scanner.impl.MenuCard;
import org.fundacionjala.devops.bootcamp.services.abstraction.IInvoiceDetails;
import org.fundacionjala.devops.bootcamp.services.abstraction.IOrderManager;
import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.command.FastReader;
import org.fundacionjala.devops.bootcamp.services.impl.InvoiceDetails;
import org.fundacionjala.devops.bootcamp.services.impl.UserOptions;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class MakeOrderCommandImpl implements Commands {
    private MenuCard menu;
    private UserOptions userOptions;
    private FastReader sc = new FastReader();
    private IOrderManager orderManager;


    public MakeOrderCommandImpl (UserOptions userOptions, MenuCard menu, IOrderManager orderManager){
        this.userOptions=userOptions;
        this.menu=menu;
        this.orderManager=orderManager;
    }

    @Override
    public void execute() {
        String answer="";
        while(!answer.equals("Exit")) {
            userOptions.getUserOptions().get(1).stream().forEach(System.out::println);
            System.out.println("What do you want to add to your order?");
            System.out.println("If you want to close the program type Exit");
            for (Map.Entry<String, ArrayList<Item>> entry : menu.getMenu().entrySet()) {
                System.out.println(entry.getKey());
            }
            answer =sc.nextLine();
            if(!answer.equals("Exit")){
                menu.getMenu().get(answer).stream().forEach(x -> System.out.println(x));

                String option = sc.nextLine();

                Item newItem = menu.getMenu().get(answer).stream().filter(x -> x.getName().equals(option)).findFirst().orElseThrow(() -> new RuntimeException("not found"));
                System.out.println("How many do you want?");
                int quantity = sc.nextInt();
                this.orderManager.addInformation(newItem.getName(), newItem.getPrice(), quantity);


            }

        }
        orderManager.setOrderID(orderManager.getOrderID()+1);







    }

    @Override
    public int getCommandCode() {
        return 2;
    }
}
