package model;

import java.util.ArrayList;
import java.util.List;


public class Order {
    String id;
    Customer customer;
    List<CartItem> items;
    String status;

    public Order(String id, Customer customer) {

        if (id.isEmpty()) throw new IllegalArgumentException("Order's id can not be empty!");

        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.status = "PENDING";
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items)
            total += item.getTotal();

        return total;
    }

    public void confirm() {
        if (status.equals("PENDING")) status = "CONFIRMED";
    }

    public void cancel() {
        if (status.equals("PENDING")) status = "CANCELLED";
    }
}
