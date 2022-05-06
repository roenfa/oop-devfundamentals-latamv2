package org.fundacionjala.devops.bootcamp.controllers;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.services.abstraction.IDeliveryManager;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.CreateOrderCommandImpl;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.ProduceItemCommandImpl;
import org.fundacionjala.devops.bootcamp.services.command.commandsImpl.ReturnInvoiceDetailsCommandImpl;
import org.fundacionjala.devops.bootcamp.services.impl.DeliveryManager;

import java.util.List;
import java.util.Scanner;

public class AppController {
    public void chooseCommand(){
        System.out.println("press 2");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if(option == 2){

            CreateOrderCommandImpl createOrderCommand = new CreateOrderCommandImpl();

            IDeliveryManager deliveryManager = createOrderCommand.createOrders();

            ProduceItemCommandImpl produceItemCommand = new ProduceItemCommandImpl();

            List<Item> listOfItems= produceItemCommand.produceItems((DeliveryManager) deliveryManager);

            ReturnInvoiceDetailsCommandImpl returnInvoiceDetailsCommand = new ReturnInvoiceDetailsCommandImpl();
            returnInvoiceDetailsCommand.printInvoiceDetails(listOfItems);
        }
    }
}
