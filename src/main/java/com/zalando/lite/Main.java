package com.zalando.lite;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        OrderManager orderManager = new OrderManager(inventoryManager);

        Product p1 = new Product(1, "Shirt", "Clothing", 25.0, 10, Arrays.asList("S", "M", "L"));
        Product p2 = new Product(2, "Jeans", "Clothing", 50.0, 5, Arrays.asList("M", "L"));


        inventoryManager.addProduct(p1);
        inventoryManager.addProduct(p2);

        OrderItem item1 = new OrderItem(p1, 2);
        OrderItem item2 = new OrderItem(p2, 1);
        int customerId = 101;

        orderManager.createOrder(101, Arrays.asList(item1, item2));

        List<Order> customerOrders = orderManager.getOrdersByCustomer(101);
        System.out.println("Orders for customer 101:");
        for (Order order : customerOrders) {
            System.out.println(order);
        }

        Courier courier1 = new Courier(1, "Lucas", "Bike");
        System.out.println(courier1); // disponible

        System.out.println("Initial state:");
        System.out.println(courier1);

        courier1.toggleAvailability();
        System.out.println("After toggling availability:");
        System.out.println(courier1);

        courier1.toggleAvailability();
        System.out.println("Availability restored:");
        System.out.println(courier1);


        System.out.println("Orders for customer " + customerId + ":");
        for (Order order : customerOrders) {
            System.out.println(order);

            // Simular pago
            double totalAmount = 0.0;
            for (OrderItem item : order.getItems()) {
                totalAmount += item.getProduct().getPrice() * item.getQuantity();
            }

            // Creamos el pago (por ejemplo, con tarjeta)
            Payment payment = new Payment(1, order.getId(), totalAmount, "CARD");

            System.out.println("Payment processed:");
            System.out.println(payment);

            if (!payment.isSuccessful()) {
                System.out.println("⚠️ Payment failed.");
            } else {
                System.out.println("✅ Payment successful.");
            }
        }
    }
}

