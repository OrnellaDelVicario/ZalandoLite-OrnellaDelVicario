package com.zalando.lite;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private InventoryManager inventoryManager;
    private List<Order> orders;

    public OrderManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.orders = new ArrayList<>();
    }

    public void createOrder(int customerId, List<OrderItem> items) {
        for (OrderItem item : items) {
            Product product = inventoryManager.findProductById(item.getProduct().getId());
            if (product == null || product.getStock() < item.getQuantity()) {
                System.out.println("Product not found or not enough stock.");
                return;
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
    }

    // 💡 Este es el nuevo método que buscás:
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
