package org.fundacionjala.devops.bootcamp.services.impl;
import org.fundacionjala.devops.bootcamp.model.Order;
import org.fundacionjala.devops.bootcamp.services.abstraction.IInvoiceDetails;
import java.math.BigDecimal;
import java.util.List;
public class InvoiceDetails  implements IInvoiceDetails {
    @Override
    public String createInvoice(List<Order> listOfOrders, int id) {
        BigDecimal total = new BigDecimal(0);
        StringBuilder listOfItemsToPrint = new StringBuilder();
        System.out.println("Order number: " + id);
        for (Order order : listOfOrders) {
            listOfItemsToPrint.append(order.toString()).append("\n");
            total = total.add(order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
        }
        listOfItemsToPrint.append("Total: ").append(total).append("\n");
        return listOfItemsToPrint.toString();
    }
    @Override
    public void deliveryInvoice(String invoiceToPrint) {
        System.out.println(invoiceToPrint);
    }
}