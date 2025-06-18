package com.zalando.lite;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomerManagerTest {

    private CustomerManager cm;
    private Customer customer;

    @BeforeEach
    void setUp() {
        cm = new CustomerManager();
        customer = new Customer(1, "Lucas", "lucas@mail.com", Arrays.asList("Shoes"), true);
        cm.registerCustomer(customer);
    }

    @Test
    void testRegisterCustomer() {
        assertTrue(cm.isRegistered(1));
    }

    @Test
    void testGetCustomerById() {
        Customer result = cm.getCustomerById(1);
        assertEquals("Lucas", result.getName());
    }

    @Test
    void testUnregisteredCustomer() {
        assertFalse(cm.isRegistered(2));
    }
}
