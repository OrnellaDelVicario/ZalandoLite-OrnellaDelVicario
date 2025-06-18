package com.zalando.lite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class OrderManagerTest {

    private OrderManager orderManager;
    private Order sampleOrder;

    @BeforeEach
    void setUp() {
        InventoryManager inventoryManager = new InventoryManager();  // Crear el objeto InventoryManager
        orderManager = new OrderManager(inventoryManager);  // Pasar el objeto al constructor de OrderManager
        Product product = new Product(1, "T-shirt", "Clothing", 20.0, 10, Arrays.asList("M"));
        OrderItem item = new OrderItem(product, 2);
        sampleOrder = new Order(101, 1, Arrays.asList(item));
    }



    @Test
    void testAddAndGetOrder() {
        orderManager.addOrder(sampleOrder);
        Order retrieved = orderManager.getOrderById(101);
        assertNotNull(retrieved);
        assertEquals(101, retrieved.getId());
    }

    @Test
    void testGetOrderById_NotFound() {
        assertNull(orderManager.getOrderById(999));
    }

    @Test
    void testGetAllOrders() {
        orderManager.addOrder(sampleOrder);
        assertEquals(1, orderManager.getAllOrders().size());
    }
}
