package com.zalando.lite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Launches the ZalandoLite application with sample data and simulates core system operations.
 *
 * Responsibilities:
 *  - Creates sample products, customers, orders, reviews, and deliveries
 *  - Demonstrates and tests all major components of the system in an integrated flow
 *  - Simulates discount application and delivery report generation
 *
 * Usage:
 *  - Acts as a full demo of system capabilities
 *  - Useful for testing business logic without user input
 */


public class ZalandoLiteApp {
    public static void main(String[] args) {
        // Crear productos
        Product shoes = new Product(101, "Running Shoes", "Shoes", 100.0, 5, Arrays.asList("42", "43"));
        Product shirt = new Product(102, "Casual Shirt", "Clothing", 50.0, 10, Arrays.asList("M", "L"));

        // Crear clientes (VIP y normal)
        Customer vipCustomer = new Customer(1, "Lucas", "lucas@mail.com", Arrays.asList("Shoes", "Clothing"), true);
        Customer normalCustomer = new Customer(2, "Ana", "ana@mail.com", Arrays.asList("Clothing"), false);

        // Crear ítems para la orden
        OrderItem item1 = new OrderItem(shoes, 1); // 1 par zapatos
        OrderItem item2 = new OrderItem(shirt, 2); // 2 camisas

        List<OrderItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        // Crear orden para VIP customer
        Order vipOrder = new Order(201, vipCustomer.getId(), items);

        // Instanciar DiscountManager
        DiscountManager discountManager = new DiscountManager();

        // Calcular total original y total con descuento para VIP
        double originalTotal = 0;
        double discountedTotal = 0;
        for (OrderItem item : vipOrder.getItems()) {
            double itemPrice = item.getProduct().getPrice() * item.getQuantity();
            originalTotal += itemPrice;

            double discountedItemPrice = discountManager.applyDiscount(
                    vipCustomer,
                    item.getProduct(),
                    item.getProduct().getPrice()
            ) * item.getQuantity();

            discountedTotal += discountedItemPrice;
        }

        System.out.printf("Original total: $%.2f\n", originalTotal);
        System.out.printf("Discounted total (VIP): $%.2f\n\n", discountedTotal);

        // Crear DeliveryService sin couriers inicialmente
        DeliveryService deliveryService = new DeliveryService();

        // Agregar couriers con addCourier()
        Courier courier1 = new Courier(1, "Maria", "Bike");
        Courier courier2 = new Courier(2, "Jose", "Van");
        deliveryService.addCourier(courier1);
        deliveryService.addCourier(courier2);

        // Asignar courier al pedido
        Delivery delivery = deliveryService.assignCourierToOrder(vipOrder);
        System.out.println("Assigned delivery: " + delivery);

        // Actualizar estado de la entrega
        deliveryService.updateDeliveryStatus(delivery, "Delivered");

        // Revisar disponibilidad del courier tras entrega
        System.out.println("Courier availability after delivery:");
        System.out.println(courier1);
        System.out.println(courier2);

        // Reviews
        ReviewManager reviewManager = new ReviewManager();
        Review r1 = new Review(shoes.getId(), vipCustomer.getId(), 5, "Great quality!");
        Review r2 = new Review(shoes.getId(), normalCustomer.getId(), 4, "Comfortable shoes.");
        Review r3 = new Review(shirt.getId(), vipCustomer.getId(), 3, "Nice shirt but colors fade.");

        reviewManager.addReview(r1);
        reviewManager.addReview(r2);
        reviewManager.addReview(r3);

        System.out.println("\nReviews for product " + shoes.getName() + ":");
        for (Review r : reviewManager.getReviewsForProduct(shoes.getId())) {
            System.out.println(r);
        }

        // Generar reporte de entregas
        ReportManager reportManager = new ReportManager();
        reportManager.writeToFile(deliveryService.getAllDeliveries(), "delivery_report.txt");

        System.out.println("\nDelivery report generated: delivery_report.txt");
    }
}
