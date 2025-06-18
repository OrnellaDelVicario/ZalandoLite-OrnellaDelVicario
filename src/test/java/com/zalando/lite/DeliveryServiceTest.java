package com.zalando.lite;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryServiceTest {

    private DeliveryService service;
    private Courier courier;
    private Order order;

    @BeforeEach
    void setUp() {
        service = new DeliveryService();
        courier = new Courier(1, "Ana", "Bike");
        service.addCourier(courier);

        Product product = new Product(10, "Shoes", "Shoes", 99.0, 10, Arrays.asList("42", "43"));
        OrderItem item = new OrderItem(product, 1);
        ArrayList<OrderItem> items = new ArrayList<>();
        items.add(item);
        order = new Order(1, 1, items);
    }

    @Test
    void testAssignCourierToOrder() {
        Delivery delivery = service.assignCourierToOrder(order);
        assertNotNull(delivery.getCourier());
        assertEquals("Ana", delivery.getCourier().getName());
    }

    @Test
    void testUpdateDeliveryStatus() {
        Delivery delivery = service.assignCourierToOrder(order);
        service.updateDeliveryStatus(delivery, "Delivered");
        assertEquals("Delivered", delivery.getStatus());
    }
}
