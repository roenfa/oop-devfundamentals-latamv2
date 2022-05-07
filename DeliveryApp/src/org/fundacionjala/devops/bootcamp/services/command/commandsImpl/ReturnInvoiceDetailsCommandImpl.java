package org.fundacionjala.devops.bootcamp.services.command.commandsImpl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.services.abstraction.IInvoiceDetails;
import org.fundacionjala.devops.bootcamp.services.impl.InvoiceDetails;

import java.util.List;

public class ReturnInvoiceDetailsCommandImpl {
    private int code = 3;

    public int getCode() {
        return code;
    }

    IInvoiceDetails invoiceDetails = new InvoiceDetails();
    public void printInvoiceDetails(List<Item> listOfItems){
        String invoiceCreate = invoiceDetails.createInvoice(listOfItems);
        invoiceDetails.deliveryInvoice(invoiceCreate);
    }

}
