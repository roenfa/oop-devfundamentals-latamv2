package org.fundacionjala.devops.bootcamp.services.abstraction;

import org.fundacionjala.devops.bootcamp.model.Item;

import java.util.List;

public interface IInvoiceDetails {
        String createInvoice(List<Item> listOfItems);
        void deliveryInvoice(String invoiceToPrint);
}
