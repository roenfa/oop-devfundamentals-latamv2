package org.fundacionjala.devops.bootcamp.services.impl;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.services.abstraction.IInvoiceDetails;

import java.util.List;

public class InvoiceDetails  implements IInvoiceDetails {
    @Override
    public String createInvoice(List<Item> listOfItems) {
        StringBuilder listOfItemsToPrint = new StringBuilder();
        for (int i = 0; i < listOfItems.size(); i++) {
            listOfItemsToPrint.append(listOfItems.get(i).toString());
        }
        String invoiceToReturn = listOfItemsToPrint.toString();
        return invoiceToReturn;
    }

    @Override
    public void deliveryInvoice(String invoiceToPrint) {
        System.out.println(invoiceToPrint);
    }
}