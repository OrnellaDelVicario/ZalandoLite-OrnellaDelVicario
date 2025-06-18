package com.zalando.lite;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages order creation and retrieval.
 *
 * Responsibilities:
 *  - Validate stock via InventoryManager
 *  - Create orders
 *  - Keep track of order history per customer
 *
 * Methods:
 *  - createOrder(int customerId, List<OrderItem>)
 *  - getOrdersByCustomer(int customerId)
 */


public class OrderManager {

    private InventoryManager inventoryManager;
    private List<Order> orders;

    public OrderManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.orders = new ArrayList<>();
    }

    public Order createOrder(int customerId, List<OrderItem> items) {
        for (OrderItem item : items) {
            Product product = inventoryManager.findProductById(item.getProduct().getId());
            if (product == null || product.getStock() < item.getQuantity()) {
                System.out.println("Product not found or not enough stock.");
                return null;
            }
        }

        for (OrderItem item : items) {
            Product product = inventoryManager.findProductById(item.getProduct().getId());
            product.setStock(product.getStock() - item.getQuantity());
        }

        int orderId = orders.size() + 1;
        Order order = new Order(orderId, customerId, items);
        orders.add(order);
        System.out.println("Order created: " + order);
        return order;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrderById(int orderId) {
        for (Order o : orders) {
            if (o.getId() == orderId) {
                return o;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }



    public List<Order> getOrdersByCustomer(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }


}
