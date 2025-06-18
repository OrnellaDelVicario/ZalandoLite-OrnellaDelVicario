package com.zalando.lite;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InventoryManagerTest {

    private InventoryManager inventory;
    private Product product;

    @BeforeEach
    void setUp() {
        inventory = new InventoryManager();
        product = new Product(1, "Sneakers", "Shoes", 79.99, 15, Arrays.asList("42", "43"));
        inventory.addProduct(product);
    }

    @Test
    void testAddProduct() {
        assertEquals(1, inventory.listAllProducts().size());
    }

    @Test
    void testFindProductById() {
        Product found = inventory.findProductById(1);
        assertNotNull(found);
        assertEquals("Sneakers", found.getName());
    }

    @Test
    void testProductNotFound() {
        Product notFound = inventory.findProductById(99);
        assertNull(notFound);
    }
}
