package com.zalando.lite;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles customer registration and retrieval.
 *
 * Responsibilities:
 *  - Register new customers
 *  - Check if a customer exists
 *  - Retrieve customer data by ID
 *
 * Methods:
 *  - registerCustomer(Customer)
 *  - getCustomerById(int id)
 *  - isRegistered(int id)
 */


public class CustomerManager {
    private Map<Integer, Customer> customers;

    public CustomerManager() {
        this.customers = new HashMap<>();
    }

    public void registerCustomer(Customer c) {
        customers.put(c.getId(), c);
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public boolean isRegistered(int id) {
        return customers.containsKey(id);
    }
}