package com.zalando.lite;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a purchase order made by a customer.
 *
 * Fields:
 *  - int id
 *  - int customerId
 *  - List<OrderItem> items
 *  - LocalDateTime timestamp
 *
 * Used in:
 *  - OrderManager
 *  - DeliveryService
 *  - DiscountManager (for total cost calculation)
 */


public class Order {
    private int id;
    private int customerId;
    private LocalDateTime timestamp;
    private List<OrderItem> items;

    public Order(int id, int customerId, List<OrderItem> items) {
        this.id = id;
        this.customerId = customerId;
        this.items = items;
        this.timestamp = LocalDateTime.now(); // Guarda el momento exacto del pedido
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", items=" + items +
                ", date=" + timestamp +
                '}';
    }

}
