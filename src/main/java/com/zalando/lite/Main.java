package com.zalando.lite;

import java.util.*;
import java.io.*;

/**
 * Entry point for console-based interaction with the ZalandoLite system.
 *
 * Responsibilities:
 *  - Presents a basic menu-driven interface to interact with the app
 *  - Calls service classes (e.g., InventoryManager, OrderManager) based on user input
 *
 * Usage:
 *  - Allows user to manually explore and test system features via the terminal
 *  - Ideal for demos or manual testing
 */


public class Main {
    public static void main(String[] args) {
        // === Setup ===
        InventoryManager inventoryManager = new InventoryManager();
        OrderManager orderManager = new OrderManager(inventoryManager);
        DeliveryService deliveryService = new DeliveryService();
        DiscountManager discountManager = new DiscountManager();
        ReviewManager reviewManager = new ReviewManager();
        ReportManager reportManager = new ReportManager();

        // === Customer ===
        List<String> favCategories = Arrays.asList("Shoes", "Clothing");
        Customer vipCustomer = new Customer(1, "Lucas", "lucas@mail.com", favCategories, true);

        // === Products ===
        Product shoes = new Product(101, "Running Shoes", "Shoes", 100.0, 5, Arrays.asList("42", "43"));
        Product shirt = new Product(102, "Casual Shirt", "Clothing", 50.0, 10, Arrays.asList("M", "L"));
        inventoryManager.addProduct(shoes);
        inventoryManager.addProduct(shirt);

        // === Order Items ===
        OrderItem item1 = new OrderItem(shoes, 1);
        OrderItem item2 = new OrderItem(shirt, 2);
        List<OrderItem> items = Arrays.asList(item1, item2);

        // === Order Creation ===
        Order order = orderManager.createOrder(vipCustomer.getId(), items);

        // === Apply Discount ===
        double originalTotal = 0;
        double discountedTotal = 0;
        for (OrderItem item : items) {
            double itemTotal = item.getProduct().getPrice() * item.getQuantity();
            originalTotal += itemTotal;
            double discountedItemPrice = discountManager.applyDiscount(vipCustomer, item.getProduct(), item.getProduct().getPrice()) * item.getQuantity();
            discountedTotal += discountedItemPrice;
        }

        System.out.println("🧾 Order Summary:");
        System.out.println("Original total: $" + originalTotal);
        System.out.println("Discounted total: $" + discountedTotal);

        // === Courier Setup ===
        Courier courier1 = new Courier(1, "Lucas", "Bike");
        Courier courier2 = new Courier(2, "Maria", "Car");
        deliveryService.addCourier(courier1);
        deliveryService.addCourier(courier2);

        // === Assign Courier and Update Status ===
        Delivery delivery = deliveryService.assignCourierToOrder(order);
        deliveryService.updateDeliveryStatus(delivery, "Delivered");

        // === Toggle Availability ===
        System.out.println("Courier before toggle: " + courier1);
        courier1.toggleAvailability();
        System.out.println("After toggle: " + courier1);
        courier1.toggleAvailability();
        System.out.println("Restored availability: " + courier1);

        // === Payment Simulation ===
        double amountPaid = discountedTotal;
        Payment payment = new Payment(1, order.getId(), amountPaid, "CARD");
        System.out.println(payment);

        // === Add and Display Reviews ===
        Review review1 = new Review(101, vipCustomer.getId(), 5, "Great running shoes!");
        Review review2 = new Review(102, vipCustomer.getId(), 4, "Nice shirt, fits well.");
        reviewManager.addReview(review1);
        reviewManager.addReview(review2);

        System.out.println("\nProduct Reviews:");
        for (Review r : reviewManager.getReviewsForProduct(101)) {
            System.out.println(r);
        }

        // === Export Delivery Report ===
        String filePath = "delivery_report.txt";
        reportManager.writeToFile(deliveryService.getAllDeliveries(), filePath);

        // === Interactive Console ===
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\n=== Zalando Lite Menu ===");
            System.out.println("1. Show Orders");
            System.out.println("2. Toggle Courier Availability");
            System.out.println("3. Show Product Reviews");
            System.out.println("4. Write Delivery Report");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Orders for customer " + vipCustomer.getId() + ":");
                    for (Order o : orderManager.getOrdersByCustomer(vipCustomer.getId())) {
                        System.out.println(o);
                    }
                    break;
                case 2:
                    courier1.toggleAvailability();
                    System.out.println("Toggled: " + courier1);
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    int pid = scanner.nextInt();
                    scanner.nextLine();
                    List<Review> productReviews = reviewManager.getReviewsForProduct(pid);
                    if (productReviews.isEmpty()) {
                        System.out.println("No reviews for this product.");
                    } else {
                        for (Review r : productReviews) {
                            System.out.println(r);
                        }
                    }
                    break;
                case 4:
                    reportManager.writeToFile(deliveryService.getAllDeliveries(), filePath);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting. Goodbye! 👋");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}