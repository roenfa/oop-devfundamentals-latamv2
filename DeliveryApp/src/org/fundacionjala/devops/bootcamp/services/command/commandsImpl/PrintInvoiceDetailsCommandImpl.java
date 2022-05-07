package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.services.abstraction.IInvoiceDetails;
import org.fundacionjala.devops.bootcamp.services.abstraction.IOrderManager;
import org.fundacionjala.devops.bootcamp.services.command.Commands;
import org.fundacionjala.devops.bootcamp.services.impl.InvoiceDetails;

public class PrintInvoiceDetailsCommandImpl implements Commands {
    private IOrderManager orderManager;
    private IInvoiceDetails invoiceDetails;
    public PrintInvoiceDetailsCommandImpl(IOrderManager orderManager){
        this.orderManager=orderManager;
        invoiceDetails=new InvoiceDetails();
    }
    @Override
    public void execute() {
        System.out.println(invoiceDetails.createInvoice(orderManager.getListOfOrders(),orderManager.getOrderID()));
        orderManager.clearOrder();

    }

    @Override
    public int getCommandCode() {
        return 3;
    }
}
