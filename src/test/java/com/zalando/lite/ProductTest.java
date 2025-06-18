package com.zalando.lite;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "T-Shirt", "Clothing", 29.99, 10, Arrays.asList("S", "M", "L"));
    }

    @Test
    void testProductCreation() {
        assertEquals("T-Shirt", product.getName());
        assertEquals(29.99, product.getPrice());
        assertEquals("Clothing", product.getCategory());
    }

    @Test
    void testStockUpdate() {
        product.setStock(20);
        assertEquals(20, product.getStock());
    }

    @Test
    void testPriceUpdate() {
        product.setPrice(19.99);
        assertEquals(19.99, product.getPrice());
    }
}
