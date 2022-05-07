package org.fundacionjala.devops.bootcamp.services.abstraction;

import org.fundacionjala.devops.bootcamp.model.Item;
import org.fundacionjala.devops.bootcamp.model.Order;

import java.util.List;

public interface IInvoiceDetails {
        String createInvoice(List<Order> listOfItems,int id);
        void deliveryInvoice(String invoiceToPrint);
}
